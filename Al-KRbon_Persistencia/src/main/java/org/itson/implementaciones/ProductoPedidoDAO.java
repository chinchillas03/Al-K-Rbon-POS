/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.ProductoPedido;
import org.itson.interfaces.IProductoPedido;

/**
 *
 * @author Usuario
 */
public class ProductoPedidoDAO implements IProductoPedido{

    private final EntityManagerFactory manager;

    public ProductoPedidoDAO() {
        manager = ConexionBD.getConection();
    }
    
    @Override
    public ProductoPedido registrarProductoPedido(ProductoPedido pedido) {
        EntityManager em = null;
        try {
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
    public ProductoPedido eliminarProductoPedido(ProductoPedido pedido) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            pedido = em.merge(pedido); // Asegurarse de que el productoPedido esté administrado
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
    public ProductoPedido actualizarProductoPedido(ProductoPedido pedido) {
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
    public List<ProductoPedido> consultarProductosPedidos() {
        EntityManager em = null;
        List<ProductoPedido> productoPedidos = new ArrayList<>();
        try {
            em = manager.createEntityManager();
            TypedQuery<ProductoPedido> query = em.createQuery("SELECT pp FROM ProductoPedido pp", ProductoPedido.class);
            productoPedidos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productoPedidos;
    }
    
}
