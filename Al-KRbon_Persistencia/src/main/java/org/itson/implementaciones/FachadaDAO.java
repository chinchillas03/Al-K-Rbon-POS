/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

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
import org.itson.interfaces.ICategoria;
import org.itson.interfaces.ICliente;
import org.itson.interfaces.IExtra;
import org.itson.interfaces.IFachada;
import org.itson.interfaces.IPedido;
import org.itson.interfaces.IProducto;
import org.itson.interfaces.IProductoExtra;
import org.itson.interfaces.IProductoPedido;
import org.itson.interfaces.IUsuario;

/**
 *
 * @author Usuario
 */
public class FachadaDAO implements IFachada{

    ICategoria categoriaDAO;
    ICliente clienteDAO;
    IExtra extraDAO;
    IProducto productoDAO;
    IProductoExtra productoExtraDAO;
    IUsuario usuarioDAO;
    IPedido pedidoDAO;
    IProductoPedido productoPedidoDAO;

    public FachadaDAO (){
        categoriaDAO = FactoryDAOs.getCategoriaDAO();
        clienteDAO = FactoryDAOs.getClienteDAO();
        extraDAO = FactoryDAOs.getExtraDAO();
        productoDAO = FactoryDAOs.getProductoDAO();
        productoExtraDAO = FactoryDAOs.getProductoExtraDAO();
        usuarioDAO = FactoryDAOs.getUsuarioDAO();
        pedidoDAO = FactoryDAOs.getPedidoDAO();
        productoPedidoDAO = FactoryDAOs.getProductoPedidoDAO();
    }

    @Override
    public Categoria registrarCategoria(Categoria producto) {
        return categoriaDAO.registrarCategoria(producto);
    }

    @Override
    public Categoria eliminarCategoria(Categoria producto) {
        return categoriaDAO.eliminarCategoria(producto);
    }

    @Override
    public Categoria actualizarCategoria(Categoria producto) {
        return categoriaDAO.actualizarCategoria(producto);
    }

    @Override
    public List<Categoria> consultarCategorias() {
        return categoriaDAO.consultarCategorias();
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return clienteDAO.registrarCliente(cliente);
    }

    @Override
    public Cliente eliminarCliente(Cliente cliente) {
        return clienteDAO.eliminarCliente(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return clienteDAO.actualizarCliente(cliente);
    }

    @Override
    public List<Cliente> consultarClientes() {
        return clienteDAO.consultarClientes();
    }

    @Override
    public Extra registrarExtra(Extra extra) {
        return extraDAO.registrarExtra(extra);
    }

    @Override
    public Extra eliminarExtra(Extra extra) {
        return extraDAO.eliminarExtra(extra);
    }

    @Override
    public Extra actualizarExtra(Extra extra) {
        return extraDAO.actualizarExtra(extra);
    }

    @Override
    public List<Extra> consultarExtras() {
        return extraDAO.consultarExtras();
    }

    @Override
    public Producto registrarProducto(Producto producto) {
        return productoDAO.registrarProducto(producto);
    }

    @Override
    public Producto eliminarProducto(Producto producto) {
        return productoDAO.eliminarProducto(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return productoDAO.actualizarProducto(producto);
    }

    @Override
    public List<Producto> consultarProductos() {
        return productoDAO.consultarProductos();
    }

    @Override
    public ProductoExtra registrarProductoExtra(ProductoExtra producto) {
        return productoExtraDAO.registrarProductoExtra(producto);
    }

    @Override
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto) {
        return productoExtraDAO.eliminarProductoExtra(producto);
    }

    @Override
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto) {
        return productoExtraDAO.actualizarProductoExtra(producto);
    }

    @Override
    public List<ProductoExtra> consultarProductoExtras() {
        return productoExtraDAO.consultarProductoExtras();
    }

    @Override
    public Usuario registrarCajero(Cajero cajero) {
        return  usuarioDAO.registrarCajero(cajero);
    }

    @Override
    public Usuario registrarAdministrador(Administrador cajero) {
        return usuarioDAO.registrarAdministrador(cajero);
    }

    @Override
    public Usuario consultarUsuarioParaLogin(String id, String password) {
        return usuarioDAO.consultarUsuarioParaLogin(id, password);
    }

    @Override
    public Usuario consultarUsuarioPorId(Long id) {
        return usuarioDAO.consultarUsuarioPorId(id);
    }

    @Override
    public Pedido registrarPedido(Pedido pedido) {
        return pedidoDAO.registrarPedido(pedido);
    }
    
    @Override
    public Pedido eliminarPedido(Pedido pedido) {
        return pedidoDAO.eliminarPedido(pedido);
    }

    @Override
    public List<Pedido> consultarPedidos() {
        return pedidoDAO.consultarPedidos();
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return pedidoDAO.actualizarPedido(pedido);
    }
    
    @Override
    public ProductoPedido registrarProductoPedido(ProductoPedido pedido) {
        return productoPedidoDAO.registrarProductoPedido(pedido);
    }
    
    @Override
    public ProductoPedido eliminarProductoPedido(ProductoPedido pedido) {
        return productoPedidoDAO.eliminarProductoPedido(pedido);
    }

    @Override
    public List<ProductoPedido> consultarProductosPedidos() {
        return productoPedidoDAO.consultarProductosPedidos();
    }

    @Override
    public ProductoPedido actualizarProductoPedido(ProductoPedido pedido) {
        return productoPedidoDAO.actualizarProductoPedido(pedido);
    }
    
}
