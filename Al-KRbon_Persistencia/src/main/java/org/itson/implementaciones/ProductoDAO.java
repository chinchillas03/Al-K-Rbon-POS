/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
    public Producto eliminarProducto(Long productoId) {
        EntityManager em = null;
        Producto productoEliminado = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin(); 
            Producto producto = em.find(Producto.class, productoId);
            if (producto != null) {
                productoEliminado = producto; 
                em.remove(producto); 
            } else {
                throw new Exception("Producto no encontrado");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error al eliminar producto", e);
        } finally {
            em.close();
        }
        return productoEliminado;
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
            producto = em.createQuery("SELECT p FROM Producto p WHERE p.nombre = :nombre", Producto.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
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

    @Override
    public List<Producto> consultarProductosPorCategoria(Long categoriaId) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            String jpql = "SELECT p FROM Producto p WHERE p.categoria.id = :categoriaId";
            TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
            query.setParameter("categoriaId", categoriaId);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar productos por categoría", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Producto consultarProductoPorId(Long productoId) {
        EntityManager em = null;
        Producto producto = null;
        try {
            em = manager.createEntityManager();
            producto = em.find(Producto.class, productoId);

            if (producto == null) {
                throw new RuntimeException("Producto no encontrado");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return producto;
    }

}
