/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.Administrador;
import org.itson.dominio.Cajero;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO implements IUsuario {

    private final EntityManagerFactory manager;

    public UsuarioDAO() {
        manager = ConexionBD.getConection();
    }

    @Override
    public Usuario registrarCajero(Cajero cajero) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(cajero);
            em.getTransaction().commit();
            return cajero;
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
    public Usuario registrarAdministrador(Administrador administrador) {
        EntityManager em = null;
        try {
            em = manager.createEntityManager();
            em.getTransaction().begin();
            em.persist(administrador);
            em.getTransaction().commit();
            return administrador;
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
    public Usuario consultarUsuarioParaLogin(String id, String password) {
        EntityManager em = null;
        Usuario usuario = null;
        try {
            em = manager.createEntityManager();
            String jpql = "SELECT c FROM Usuario c WHERE c.id = :id AND c.password = :password";
            usuario = em.createQuery(jpql, Usuario.class)
                    .setParameter("id", id)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuario;
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) {
        EntityManager em = null;
        Usuario usuario = null;
        try {
            em = manager.createEntityManager();
            usuario = em.find(Usuario.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return usuario;
    }

}
