/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Administrador;
import org.itson.dominio.Cajero;
import org.itson.dominio.Categoria;
import org.itson.dominio.Cliente;
import org.itson.dominio.Extra;
import org.itson.dominio.Pedido;
import org.itson.dominio.Producto;
import org.itson.dominio.ProductoExtra;
import org.itson.dominio.ProductoPedido;
import org.itson.dominio.Usuario;

/**
 *
 * @author Usuario
 */
public interface IFachada {
    
    public Categoria registrarCategoria(Categoria producto);
    
    public Categoria eliminarCategoria(Categoria producto);
    
    public Categoria actualizarCategoria(Categoria producto);
    
    public List<Categoria> consultarCategorias();
    
    public Cliente registrarCliente(Cliente cliente);
    
    public Cliente eliminarCliente(Cliente cliente);
    
    public Cliente actualizarCliente(Cliente cliente);
    
    public List<Cliente> consultarClientes();
    
    public Extra registrarExtra(Extra extra);
    
    public Extra eliminarExtra(Extra extra);
    
    public Extra actualizarExtra(Extra extra);
    
    public List<Extra> consultarExtras();
    
    public Producto registrarProducto(Producto producto);
    
    public Producto eliminarProducto(Producto producto);
    
    public Producto actualizarProducto(Producto producto);
    
    public List<Producto> consultarProductos();
    
    public ProductoExtra registrarProductoExtra(ProductoExtra producto);
    
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto);
    
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto);
    
    public List<ProductoExtra> consultarProductoExtras();
    
    public Usuario registrarCajero(Cajero cajero);
    
    public Usuario registrarAdministrador(Administrador cajero);
    
    public Usuario consultarUsuarioParaLogin(String id, String password);
    
    public Usuario consultarUsuarioPorId(Long id);
    
    public Pedido registrarPedido(Pedido producto);
    
    public Pedido eliminarPedido(Pedido producto);
    
    public Pedido actualizarPedido(Pedido producto);
    
    public List<Pedido> consultarPedidos();
    
    public ProductoPedido registrarProductoPedido(ProductoPedido producto);
    
    public ProductoPedido eliminarProductoPedido(ProductoPedido producto);
    
    public ProductoPedido actualizarProductoPedido(ProductoPedido producto);
    
    public List<ProductoPedido> consultarProductosPedidos();
    
}