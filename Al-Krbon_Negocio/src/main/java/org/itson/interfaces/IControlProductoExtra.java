/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ProductoExtra;

/**
 *
 * @author icedo
 */
public interface IControlProductoExtra {
    
    ProductoExtra registrarProductoExtra(ProductoExtra producto);
    ProductoExtra eliminarProductoExtra(ProductoExtra producto);
    ProductoExtra actualizarProductoExtra(ProductoExtra producto);
    List<ProductoExtra> consultarProductoExtras();
}
