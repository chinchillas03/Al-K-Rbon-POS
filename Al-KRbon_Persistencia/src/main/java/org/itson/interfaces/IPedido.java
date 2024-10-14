/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Pedido;

/**
 *
 * @author Usuario
 */
public interface IPedido {
 
    public Pedido registrarPedido(Pedido pedido);
    
    public Pedido eliminarPedido(Pedido pedido);
    
    public Pedido actualizarPedido(Pedido pedido);
    
    public List<Pedido> consultarPedidos();
    
}