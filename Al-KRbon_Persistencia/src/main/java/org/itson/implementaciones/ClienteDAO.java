/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Cliente;
import org.itson.interfaces.ICliente;

/**
 *
 * @author Usuario
 */
public class ClienteDAO implements  ICliente{

    private final EntityManagerFactory manager;


    public ClienteDAO() {
        manager = ConexionBD.getConection();

    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return cliente;
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
    public Cliente eliminarCliente(Cliente cliente) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
            return cliente;
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
    public Cliente actualizarCliente(Cliente cliente) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            return cliente;
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
    public List<Cliente> consultarClientes() {
        EntityManager em = null;
        List<Cliente> clientes = null;
        try {
            em = manager.createEntityManager();
            clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return clientes;
    }

}
