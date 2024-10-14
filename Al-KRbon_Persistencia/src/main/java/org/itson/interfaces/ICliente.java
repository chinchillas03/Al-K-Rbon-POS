/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Cliente;

/**
 *
 * @author Usuario
 */
public interface ICliente {
    
    public Cliente registrarCliente(Cliente cliente);
    
    public Cliente eliminarCliente(Cliente cliente);
    
    public Cliente actualizarCliente(Cliente cliente);
    
    public List<Cliente> consultarClientes();
    
}