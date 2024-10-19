/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Cliente;

/**
 *
 * @author icedo
 */
public interface IControlCliente {
    
    Cliente registrarCliente(Cliente cliente);
    Cliente eliminarCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    List<Cliente> consultarClientes();
}
