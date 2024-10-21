/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.dominio.Cliente;
import org.itson.interfaces.IControlCliente;
import org.itson.interfaces.IFachada;

/**
 *
 * @author icedo
 */
public class ControlCliente implements IControlCliente{

    private final IFachada fachada;

    public ControlCliente(IFachada fachada) {
        this.fachada = fachada;
    }
    
    
    
    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return fachada.registrarCliente(cliente);
    }

    @Override
    public Cliente eliminarCliente(Cliente cliente) {
        return fachada.eliminarCliente(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return fachada.actualizarCliente(cliente);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return fachada.consultarClientes();
    }
    
}
