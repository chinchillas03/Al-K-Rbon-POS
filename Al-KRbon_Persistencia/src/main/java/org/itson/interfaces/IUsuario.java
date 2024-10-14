/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Administrador;
import org.itson.dominio.Cajero;
import org.itson.dominio.Usuario;

/**
 *
 * @author IUsuario
 */
public interface IUsuario {
    
    public Usuario registrarCajero(Cajero cajero);
    
    public Usuario registrarAdministrador(Administrador cajero);
    
    public Usuario consultarUsuarioParaLogin(String id, String password);
    
    public Usuario consultarUsuarioPorId(Long id);
    
}