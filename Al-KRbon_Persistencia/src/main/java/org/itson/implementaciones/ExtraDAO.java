/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Extra;
import org.itson.interfaces.IExtra;

/**
 *
 * @author Usuario
 */
public class ExtraDAO implements IExtra{

    private final EntityManagerFactory manager;

    public ExtraDAO() {
        manager = ConexionBD.getConection();
    }

    @Override
    public Extra registrarExtra(Extra extra) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(extra);
            em.getTransaction().commit();
            return extra;
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
    public Extra eliminarExtra(Extra extra) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.remove(extra);
            em.getTransaction().commit();
            return extra;
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
    public Extra actualizarExtra(Extra extra) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.merge(extra);
            em.getTransaction().commit();
            return extra;
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
    public List<Extra> consultarExtras() {
        EntityManager em = null;
        List<Extra> extras = null;
        try {
            em = manager.createEntityManager();
            extras = em.createQuery("SELECT c FROM Extra c", Extra.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return extras;
    }
}