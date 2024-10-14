/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "cajero")
public class Cajero extends Usuario implements Serializable{

    public Cajero() {
    }

    public Cajero(String nombre, String contrasena) {
        super(nombre, contrasena);
    }
}