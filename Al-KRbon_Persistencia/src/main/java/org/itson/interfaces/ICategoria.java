/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Categoria;

/**
 *
 * @author Usuario
 */
public interface ICategoria {
    
    public Categoria registrarCategoria(Categoria producto);
    
    public Categoria eliminarCategoria(Categoria producto);
    
    public Categoria actualizarCategoria(Categoria producto);
    
    public List<Categoria> consultarCategorias();
    
}
