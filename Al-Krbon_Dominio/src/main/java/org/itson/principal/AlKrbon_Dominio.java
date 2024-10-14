/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.principal;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Manuel Flores
 */
public class AlKrbon_Dominio {

    public static void main(String[] args) {
        try{
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("org.itson_Al-Krbon_Dominio");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
