/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.dominio.Administrador;
import org.itson.dominio.Cajero;
import org.itson.dominio.Usuario;
import org.itson.interfaces.IControlUsuario;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlUsuario implements IControlUsuario{
    
    private final IFachada fachada;

    public ControlUsuario(IFachada fachada) {
        this.fachada = fachada;
    }

    @Override
    public Usuario registrarCajero(Cajero cajero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario registrarAdministrador(Administrador cajero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String id, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
