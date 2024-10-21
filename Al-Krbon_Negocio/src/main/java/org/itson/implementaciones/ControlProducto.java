/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.Producto;
import org.itson.interfaces.IControlProducto;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlProducto implements IControlProducto{

    private final IFachada fachada;

    public ControlProducto(IFachada fachada) {
        this.fachada = fachada;
    }
    
    @Override
    public Producto registrarProducto(Producto producto) {
        return fachada.registrarProducto(producto);
    }

    @Override
    public Producto eliminarProducto(Producto producto) {
        return fachada.eliminarProducto(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return fachada.actualizarProducto(producto);
    }

    @Override
    public List<Producto> consultarProductos() {
        return fachada.consultarProductos();
    }
    
    @Override
    public Producto consultarProductoPorNombre(String nombre){
        return fachada.consultarProductoPorNombre(nombre);
    }
    
}
