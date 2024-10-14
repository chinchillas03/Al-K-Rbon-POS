/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.interfaces.ICategoria;
import org.itson.interfaces.ICliente;
import org.itson.interfaces.IExtra;
import org.itson.interfaces.IPedido;
import org.itson.interfaces.IProducto;
import org.itson.interfaces.IProductoExtra;
import org.itson.interfaces.IProductoPedido;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author Usuario
 */
public class FactoryDAOs {
    
    public FactoryDAOs(){
    }
    
    public static ICategoria getCategoriaDAO(){
        return new CategoriaDAO();
    }
    
    public static ICliente getClienteDAO(){
        return new ClienteDAO();
    }
    
    public static IExtra getExtraDAO(){
        return new ExtraDAO();
    }
    
    public static IProducto getProductoDAO(){
        return new ProductoDAO();
    }
    
    public static IProductoExtra getProductoExtraDAO(){
        return new ProductoExtraDAO();
    }
    
    public static IUsuario getUsuarioDAO(){
        return new UsuarioDAO();
    }
    
    public static IPedido getPedidoDAO(){
        return new PedidoDAO();
    }
    
    public static IProductoPedido getProductoPedidoDAO(){
        return new ProductoPedidoDAO();
    }
    
}
