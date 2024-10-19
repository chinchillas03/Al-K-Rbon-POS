/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Categoria;

/**
 *
 * @author icedo
 */
public interface IControlCategoria {
    Categoria registrarCategoria (Categoria producto);
    Categoria eliminarCategoria(Categoria producto); 
    Categoria actualizarCategoria(Categoria producto);
    List<Categoria> consultarCategorias();
}
