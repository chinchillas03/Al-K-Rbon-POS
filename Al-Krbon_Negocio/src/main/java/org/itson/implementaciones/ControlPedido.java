/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.time.LocalDate;
import java.util.Date;
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
        return fachada.registrarPedido(pedido);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return fachada.actualizarPedido(pedido);
    }

    @Override
    public Pedido eliminarPedido(Pedido pedido) {
        return fachada.eliminarPedido(pedido);
    }

    @Override
    public List<Pedido> consultarPedidos() {
        return fachada.consultarPedidos();
    }
    
    @Override
    public List<Pedido> consultarPedidosPorEstadoYFechas(String estado, Date fechaInicio, Date fechaFinal) {
        return fachada.consultarPedidosPorEstadoYFechas(estado, fechaInicio, fechaFinal);
    }
    
}
