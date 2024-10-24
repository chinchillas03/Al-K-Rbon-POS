/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

/**
 *
 * @author icedo
 */
public interface IFachadaNegocio {
    
    IControlPedido getControlPedido();
    IControlCategoria getControlCategoria();
    IControlProducto getControlProducto();
    IControlCliente getControlCliente();
    IControlExtra getControlExtra();
    IControlProductoExtra getControlProductoExtra();
    IControlProductoPedido getControlProductoPedido();
    IControlUsuario getControlUsuario();
}
