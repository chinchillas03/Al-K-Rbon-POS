/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.Pedido;
import org.itson.interfaces.IFachada;
import org.itson.interfaces.IControlPedido;

/**
 *
 * @author icedo
 */
public class ControlPedido implements IControlPedido {
    
    private final IFachada fachada;

    public ControlPedido(IFachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public Pedido registrarPedido(Pedido pedido) {
        // Implementar lógica de negocio, validaciones, etc.
        return fachada.registrarPedido(pedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido eliminarPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedido> consultarPedidos() {
        return fachada.consultarPedidos();
    }
}
