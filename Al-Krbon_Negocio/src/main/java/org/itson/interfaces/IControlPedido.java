/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Pedido;

/**
 *
 * @author icedo
 */
public interface IControlPedido {
    Pedido registrarPedido(Pedido pedido);
    Pedido actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    List<Pedido> consultarPedidos();
}
