/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Producto;

/**
 *
 * @author icedo
 */
public interface IControlProducto {
    Producto registrarProducto(Producto producto);
    Producto eliminarProducto(Producto producto);
    Producto actualizarProducto(Producto producto);
    List<Producto> consultarProductos();
    List<Producto> consultarProductosPorCategoria(Long categoria);
    Producto consultarProductoPorNombre(String nombre);
}
