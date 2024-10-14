/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.ProductoExtra;
import org.itson.interfaces.IProductoExtra;

/**
 *
 * @author Usuario
 */
public class ProductoExtraDAO implements IProductoExtra{

    private final EntityManagerFactory manager;

    public ProductoExtraDAO() {
        manager = ConexionBD.getConection();

    }

    @Override
    public ProductoExtra registrarProductoExtra(ProductoExtra producto) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
            return producto;
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
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.remove(producto);
            em.getTransaction().commit();
            return producto;
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
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.merge(producto);
            em.getTransaction().commit();
            return producto;
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
    public List<ProductoExtra> consultarProductoExtras() {
        EntityManager em = null;
        List<ProductoExtra> productosExtras = null;
        try {
            em = manager.createEntityManager();
            productosExtras = em.createQuery("SELECT c FROM ProductoExtra c", ProductoExtra.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productosExtras;
    }

}