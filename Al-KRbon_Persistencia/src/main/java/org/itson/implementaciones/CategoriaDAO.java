/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Categoria;
import org.itson.interfaces.ICategoria;

/**
 *
 * @author Usuario
 */
public class CategoriaDAO implements ICategoria{

    private final EntityManagerFactory manager;
    
    
    public CategoriaDAO() {
        manager = ConexionBD.getConection();
        
    }
    
    @Override
    public Categoria registrarCategoria(Categoria producto) {
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
    public Categoria eliminarCategoria(Categoria producto) {
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
    public Categoria actualizarCategoria(Categoria producto) {
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
    public List<Categoria> consultarCategorias() {
        EntityManager em = null;
        List<Categoria> categorias = null;
        try {
            em = manager.createEntityManager();
            categorias = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return categorias;
    }

    @Override
    public Categoria consultarCategoriaPorId(Long categoriaId) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            return em.createQuery("SELECT c FROM Categoria c WHERE c.id = :id", Categoria.class)
                    .setParameter("id", categoriaId)
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la categoría con ID: " + categoriaId, e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
