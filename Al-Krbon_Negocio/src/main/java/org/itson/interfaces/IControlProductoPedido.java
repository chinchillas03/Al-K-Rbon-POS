/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.ProductoPedido;

/**
 *
 * @author icedo
 */
public interface IControlProductoPedido {
    
    ProductoPedido registrarProductoPedido(ProductoPedido pedido);
    ProductoPedido eliminarProductoPedido(ProductoPedido pedido);
    ProductoPedido actualizarProductoPedido(ProductoPedido pedido);
    List<ProductoPedido> consultarProductosPedidos();
    
}
