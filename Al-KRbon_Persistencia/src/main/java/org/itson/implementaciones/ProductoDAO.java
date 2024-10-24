/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Producto;
import org.itson.interfaces.IProducto;

/**
 *
 * @author Usuario
 */
public class ProductoDAO implements IProducto {

    private final EntityManagerFactory manager;

    public ProductoDAO() {
        manager = ConexionBD.getConection();

    }

    @Override
    public Producto registrarProducto(Producto producto) {
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
    public Producto eliminarProducto(Producto producto) {
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
    public Producto actualizarProducto(Producto producto) {
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
    public List<Producto> consultarProductos() {
        EntityManager em = null;
        List<Producto> productos = null;
        try {
            em = manager.createEntityManager();
            productos = em.createQuery("SELECT c FROM Producto c", Producto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return productos;
    }

    @Override
    public Producto consultarProductoPorNombre(String nombre) {
        EntityManager em = null;
        Producto producto = null;
        try {
            em = manager.createEntityManager();

            // Consulta JPQL para obtener el producto por nombre
            producto = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre", Producto.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();  // Asumiendo que el nombre es único
        } catch (NoResultException e) {
            System.out.println("No se encontró un producto con ese nombre.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return producto;
    }

}
