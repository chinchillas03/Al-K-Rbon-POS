/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.ProductoExtra;
import org.itson.interfaces.IControlProductoExtra;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlProductoExtra implements IControlProductoExtra {
    
    private final IFachada fachada;

    public ControlProductoExtra(IFachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public ProductoExtra registrarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoExtra> consultarProductoExtras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
