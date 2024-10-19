/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Extra;

/**
 *
 * @author icedo
 */
public interface IControlExtra {
    
    Extra registrarExtra(Extra extra);
    Extra eliminarExtra(Extra extra);
    Extra actualizarExtra(Extra extra);
    List<Extra> consultarExtras();
    
}
