/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.interfaces.IControlCategoria;
import org.itson.interfaces.IControlCliente;
import org.itson.interfaces.IControlExtra;
import org.itson.interfaces.IFachada;
import org.itson.interfaces.IFachadaNegocio;
import org.itson.interfaces.IControlPedido;
import org.itson.interfaces.IControlProducto;
import org.itson.interfaces.IControlProductoExtra;
import org.itson.interfaces.IControlProductoPedido;
import org.itson.interfaces.IControlUsuario;

/**
 *
 * @author icedo
 */
public class FachadaNegocio implements IFachadaNegocio{

    IFachada fachadaPersistencia;
    IControlPedido controlPedido;
    IControlCategoria controlCategoria;
    IControlProducto controlProducto;
    IControlCliente controlCliente;
    IControlExtra controlExtra;
    IControlProductoExtra controlProductoExtra;
    IControlProductoPedido controlProductoPedido;
    IControlUsuario controlUsuario;

    public FachadaNegocio() {
        this.fachadaPersistencia = new FachadaDAO();
        this.controlPedido = FactoryNegocio.crearControlPedido(fachadaPersistencia);
        this.controlCategoria = FactoryNegocio.crearControlCategoria(fachadaPersistencia);
        this.controlProducto = FactoryNegocio.crearControlProducto(fachadaPersistencia);
        this.controlCliente = FactoryNegocio.crearControlCliente(fachadaPersistencia);
        this.controlExtra = FactoryNegocio.crearControlExtra(fachadaPersistencia);
        this.controlProductoExtra=FactoryNegocio.crearControlProductoExtra(fachadaPersistencia);
        this.controlProductoPedido=FactoryNegocio.crearControlProductoPedido(fachadaPersistencia);
        this.controlUsuario=FactoryNegocio.crearControlUsuario(fachadaPersistencia);
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

    @Override
    public IControlExtra getControlExtra() {
        return controlExtra;
    }

    @Override
    public IControlCliente getControlCliente() {
        return controlCliente;
    }

    @Override
    public IControlProductoExtra getControlProductoExtra() {
        return controlProductoExtra;
    }

    @Override
    public IControlProductoPedido getControlProductoPedido() {
        return controlProductoPedido;
    }

    @Override
    public IControlUsuario getControlUsuario() {
        return controlUsuario;
    }
    
}
