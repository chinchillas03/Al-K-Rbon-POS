/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Extra;

/**
 *
 * @author Usuario
 */
public interface IExtra {
    
    public Extra registrarExtra(Extra extra);
    
    public Extra eliminarExtra(Extra extra);
    
    public Extra actualizarExtra(Extra extra);
    
    public List<Extra> consultarExtras();
    
}
