/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ProductoPedido;

/**
 *
 * @author Usuario
 */
public interface IProductoPedido {
    
    public ProductoPedido registrarProductoPedido(ProductoPedido pedido);
    
    public ProductoPedido eliminarProductoPedido(ProductoPedido pedido);
    
    public ProductoPedido actualizarProductoPedido(ProductoPedido pedido);
    
    public List<ProductoPedido> consultarProductosPedidos();
    
}