/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.interfaces.IControlCategoria;
import org.itson.interfaces.IControlPedido;
import org.itson.interfaces.IControlProducto;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class FactoryNegocio {
    
    public static IControlCategoria crearControlCategoria(IFachada fachada){
        return new ControlCategoria(fachada);
    }
    
    public static IControlPedido crearControlPedido(IFachada fachada){
        return new ControlPedido(fachada);
    }
    
    public static IControlProducto crearControlProducto(IFachada fachada){
        return new ControlProducto(fachada);
    }
    
    
}
