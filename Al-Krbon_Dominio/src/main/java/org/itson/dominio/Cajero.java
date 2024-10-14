package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAJERO")
public class Cajero extends Usuario implements Serializable{

    public Cajero() {
    }

    public Cajero(String nombre, String contrasena) {
        super(nombre, contrasena);
    }
}
