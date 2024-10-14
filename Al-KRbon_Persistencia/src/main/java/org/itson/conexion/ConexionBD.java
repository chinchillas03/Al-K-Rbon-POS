/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 *
 * @author Usuario
 */
public class ConexionBD {
    
    /**
     * Direccion para la conexión a la base de datos
     */
    private String direccion = "org.itson_Al-Krbon_Dominio";
    
    private static EntityManagerFactory factory;
    
    private static ConexionBD conexion;

    private ConexionBD() {
        try {
            factory = Persistence.createEntityManagerFactory(direccion);
        } catch (Exception e) {
            throw new PersistenceException("Ocurrió un error al conectarse con la base de datos");
        }
    }
    
    public static EntityManagerFactory getConection() {
        if (conexion == null) {
            ConexionBD.conexion = new ConexionBD();
        }
        return factory;
    }
    
}