/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.al.krbon_persistencia;

import java.util.ArrayList;
import java.util.List;

import org.itson.dominio.Cajero;
import org.itson.dominio.Categoria;
import org.itson.dominio.Cliente;
import org.itson.dominio.Extra;
import org.itson.dominio.Pedido;
import org.itson.dominio.Producto;
import org.itson.dominio.ProductoPedido;
import org.itson.implementaciones.FachadaDAO;

/**
 *
 * @author Usuario
 */
public class AlKrbon_Persistencia {

    public static void main(String[] args) {
        
        FachadaDAO persis = new FachadaDAO();

        try {
            List<Producto> listaProductos = new ArrayList<>();
            Categoria categoria = new Categoria();
            categoria.setDescripcion("Bebida");

            Producto hamburguesa = new Producto();
            listaProductos.add(hamburguesa);
            hamburguesa.setNombre("Coca");
            hamburguesa.setDescripcion("Coca cola 500");
            hamburguesa.setPrecio(20.0);
            hamburguesa.setCategoria(categoria);
            persis.registrarProducto(hamburguesa);

            Extra salsaBBQ = new Extra();
            salsaBBQ.setDescripcion("");
            salsaBBQ.setPrecioExtra(10.0);
            persis.registrarExtra(salsaBBQ);

            Cliente cliente = new Cliente();
            cliente.setNombre("Jorge");
            cliente.setApellidoPaterno("Campos");
            cliente.setApellidoMaterno("Blanco");
            cliente.setDireccion("Calle Falsa 123");
            cliente.setNumero("6441234567");
            persis.registrarCliente(cliente);

            Cajero cajero = new Cajero();
            cajero.setNombre("Pedro Cajero");
            cajero.setContrasena("securepassword");
            persis.registrarCajero(cajero);

            Pedido pedido = new Pedido();
            pedido.setCliente(cliente);
            pedido.setCajero(cajero);
            pedido.setFechaHoraPedido(new java.util.Date());
            pedido.setFormaEntrega("Entrega a domicilio");
            pedido.setEstado("Pendiente");
            pedido.setOpinion("Por favor, no demoren."); 
            pedido.setCalificacion(9.99);
            pedido.setTotal(70.0);

            ProductoPedido productoPedido = new ProductoPedido();
            productoPedido.setProducto(hamburguesa);
            productoPedido.setCantidad(1);
            productoPedido.setComentarios("Agregar extra de Salsa BBQ");
            productoPedido.setPrecio(hamburguesa.getPrecio());

            pedido.agregarProductoPedido(productoPedido);

            persis.registrarPedido(pedido);

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }
}