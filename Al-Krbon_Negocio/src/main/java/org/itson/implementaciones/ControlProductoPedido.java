/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.ProductoPedido;
import org.itson.interfaces.IControlProductoPedido;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlProductoPedido implements IControlProductoPedido{
    
    private final IFachada fachada;

    public ControlProductoPedido(IFachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public ProductoPedido registrarProductoPedido(ProductoPedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoPedido eliminarProductoPedido(ProductoPedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoPedido actualizarProductoPedido(ProductoPedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoPedido> consultarProductosPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
