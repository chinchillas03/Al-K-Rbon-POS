/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Producto;

/**
 *
 * @author Usuario
 */
public interface IProducto {
    
    public Producto registrarProducto(Producto producto);
    
    public Producto eliminarProducto(Long producto);
    
    public Producto actualizarProducto(Producto producto);
    
    public List<Producto> consultarProductos();
    
    public List<Producto> consultarProductosPorCategoria(Long categoria);
    
    public Producto consultarProductoPorNombre(String nombre);
   
    public Producto consultarProductoPorId(Long id);
    
}