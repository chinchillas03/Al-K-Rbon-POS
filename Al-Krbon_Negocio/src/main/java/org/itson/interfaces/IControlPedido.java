/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.itson.dominio.Pedido;

/**
 *
 * @author icedo
 */
public interface IControlPedido {
    Pedido registrarPedido(Pedido pedido);
    Pedido actualizarPedido(Pedido pedido);
    Pedido eliminarPedido(Pedido pedido);
    List<Pedido> consultarPedidos();
    public List<Pedido> consultarPedidosPorEstadoYFechas(String estado, Date fechaInicio, Date fechaFinal);
}
