/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Administrador;
import org.itson.dominio.Cajero;
import org.itson.dominio.Usuario;

/**
 *
 * @author icedo
 */
public interface IControlUsuario {
    
    Usuario registrarCajero(Cajero cajero);
    Usuario registrarAdministrador(Administrador cajero);
    Usuario consultarUsuarioParaLogin(String id, String password);
    Usuario consultarUsuarioPorId(Long id);
    
}
