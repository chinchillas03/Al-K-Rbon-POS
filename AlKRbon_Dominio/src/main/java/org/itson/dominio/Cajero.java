package org.itson.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAJERO")
public class Cajero extends Usuario{

    public Cajero() {
    }

    public Cajero(String nombre, String contrasena) {
        super(nombre, contrasena);
    }
}
