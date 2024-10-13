package org.itson.dominio;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Extra;
import org.itson.dominio.Producto;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-12T18:05:07", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ProductoExtra.class)
public class ProductoExtra_ { 

    public static volatile SingularAttribute<ProductoExtra, Extra> extra;
    public static volatile SingularAttribute<ProductoExtra, Long> id;
    public static volatile SingularAttribute<ProductoExtra, Producto> producto;
    public static volatile SingularAttribute<ProductoExtra, Integer> cantidad;
    public static volatile SingularAttribute<ProductoExtra, Double> precioTotal;

}