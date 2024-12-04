/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Pedido;
import org.itson.interfaces.IPedido;

/**
 *
 * @author Usuario
 */
public class PedidoDAO implements IPedido {

    private final EntityManagerFactory manager;

    public PedidoDAO() {
        manager = ConexionBD.getConection();
    }

    @Override
    public Pedido registrarPedido(Pedido pedido) {
        EntityManager em = null;
        try {

            if (pedido == null) {
                System.out.println("Pedido esta vacio");
            }

            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return pedido;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Pedido eliminarPedido(Pedido pedido) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
            return pedido;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
            return pedido;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Pedido> consultarPedidos() {
        EntityManager em = null;
        List<Pedido> pedidos = new ArrayList<>();
        try {
            em = manager.createEntityManager();
            TypedQuery<Pedido> query = em.createQuery("SELECT p FROM Pedido p", Pedido.class);
            pedidos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pedidos;
    }

    @Override
    public List<Pedido> consultarPedidosPorEstadoYFechas(String estado, Date fechaInicio, Date fechaFinal) {
        EntityManager em = manager.createEntityManager();
        List<Pedido> pedidos = new ArrayList<>();
        try {
            TypedQuery<Pedido> query = em.createQuery(
                    "SELECT p FROM Pedido p WHERE p.estado = :estado AND p.fechaHoraPedido BETWEEN :fechaInicio AND :fechaFinal",
                    Pedido.class
            );
            query.setParameter("estado", estado);
            query.setParameter("fechaInicio", fechaInicio, TemporalType.TIMESTAMP);
            query.setParameter("fechaFinal", fechaFinal, TemporalType.TIMESTAMP);
            pedidos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return pedidos;
    }

}
