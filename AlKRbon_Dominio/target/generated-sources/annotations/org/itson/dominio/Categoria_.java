package org.itson.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Producto;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-12T17:46:58", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile SingularAttribute<Categoria, Long> id;
    public static volatile ListAttribute<Categoria, Producto> productos;

}