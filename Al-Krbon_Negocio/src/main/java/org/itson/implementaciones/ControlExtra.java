/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.Extra;
import org.itson.interfaces.IControlExtra;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlExtra implements IControlExtra {
    
    private final IFachada fachada;

    public ControlExtra(IFachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public Extra registrarExtra(Extra extra) {
        return fachada.registrarExtra(extra);
    }

    @Override
    public Extra eliminarExtra(Extra extra) {
        return fachada.eliminarExtra(extra);
    }

    @Override
    public Extra actualizarExtra(Extra extra) {
        return fachada.actualizarExtra(extra);
    }

    @Override
    public List<Extra> consultarExtras() {
        return fachada.consultarExtras();
    }
    
    
    
    
}
