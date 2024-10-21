/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.Categoria;
import org.itson.interfaces.IControlCategoria;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlCategoria implements IControlCategoria {

    private final IFachada fachada;

    public ControlCategoria(IFachada fachada) {
        this.fachada = fachada;
    }
    
    
    @Override
    public Categoria registrarCategoria(Categoria producto) {
        return fachada.registrarCategoria(producto);
    }

    @Override
    public Categoria eliminarCategoria(Categoria producto) {
        return fachada.eliminarCategoria(producto);
    }

    @Override
    public Categoria actualizarCategoria(Categoria producto) {
        return fachada.actualizarCategoria(producto);
    }

    @Override
    public List<Categoria> consultarCategorias() {
        return fachada.consultarCategorias();
    }
    
}
