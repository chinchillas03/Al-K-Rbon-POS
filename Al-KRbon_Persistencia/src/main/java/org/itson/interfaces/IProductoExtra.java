/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ProductoExtra;

/**
 *
 * @author Usuario
 */
public interface IProductoExtra {
    
    public ProductoExtra registrarProductoExtra(ProductoExtra producto);
    
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto);
    
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto);
    
    public List<ProductoExtra> consultarProductoExtras();
    
}