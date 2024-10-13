package org.itson.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Categoria;
import org.itson.dominio.Extra;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-12T17:46:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, Categoria> categoria;
    public static volatile ListAttribute<Producto, Extra> extras;
    public static volatile SingularAttribute<Producto, Long> id;
    public static volatile SingularAttribute<Producto, String> nombre;

}