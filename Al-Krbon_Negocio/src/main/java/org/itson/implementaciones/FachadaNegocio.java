/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.interfaces.IControlCategoria;
import org.itson.interfaces.IFachada;
import org.itson.interfaces.IFachadaNegocio;
import org.itson.interfaces.IControlPedido;
import org.itson.interfaces.IControlProducto;

/**
 *
 * @author icedo
 */
public class FachadaNegocio implements IFachadaNegocio{

    IFachada fachadaPersistencia;
    IControlPedido controlPedido;
    IControlCategoria controlCategoria;
    IControlProducto controlProducto;

    public FachadaNegocio() {
        fachadaPersistencia = new FachadaDAO();
        controlPedido = FactoryNegocio.crearControlPedido(fachadaPersistencia);
        controlCategoria = FactoryNegocio.crearControlCategoria(fachadaPersistencia);
        controlProducto = FactoryNegocio.crearControlProducto(fachadaPersistencia);
    }
    
    
    @Override
    public IControlPedido getControlPedido() {
        return controlPedido;
    }

    @Override
    public IControlCategoria getControlCategoria() {
        return controlCategoria;
    }

    @Override
    public IControlProducto getControlProducto() {
        return controlProducto;
    }
    
}
