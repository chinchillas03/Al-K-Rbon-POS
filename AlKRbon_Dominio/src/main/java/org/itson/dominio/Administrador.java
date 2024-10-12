package org.itson.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Administrador  extends Usuario {

    public Administrador() {
    }

    public Administrador(String nombre, String contrasena) {
        super(nombre, contrasena);
    }
}
