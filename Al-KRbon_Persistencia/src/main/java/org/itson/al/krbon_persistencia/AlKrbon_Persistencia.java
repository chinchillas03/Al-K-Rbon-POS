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
        
//        List<Producto> listaProductos = new ArrayList<>();
//            List<Categoria> listaCategorias = persis.consultarCategorias();
//            Categoria paquetes = persis.consultarCategorias().get(2);
//            Categoria entradas = persis.consultarCategorias().get(3);
//            
//            for (int i = 0; i < listaCategorias.size(); i++) {
//                System.out.println("Categoria "+(i)+" es igual a: "+listaCategorias.get(i).getDescripcion());
//            }

        try {
            
            Categoria cat = new Categoria();
            cat.setDescripcion("Hamburguesas");
            persis.registrarCategoria(cat);
            
            Categoria cat2 = new Categoria();
            cat2.setDescripcion("Bebidas");
            persis.registrarCategoria(cat2);
            
            Categoria cat3 = new Categoria();
            cat3.setDescripcion("Paquetes");
            persis.registrarCategoria(cat3);
            
            Categoria cat4 = new Categoria();
            cat4.setDescripcion("Entradas");
            persis.registrarCategoria(cat4);
            
//            List<Producto> listaProductos = new ArrayList<>();
//            List<Categoria> listaCategorias = new ArrayList<>();
//            Categoria entradas = persis.consultarCategorias().get(2);
//            Categoria paquetes = persis.consultarCategorias().get(3);
//            
//            Producto PurePapa = new Producto();
//            listaProductos.add(PurePapa);
//            PurePapa.setNombre("Pure Papa");
//            PurePapa.setDescripcion("Plato grande de pure de papa");
//            PurePapa.setPrecio(49.99);
//            PurePapa.setCategoria(persis.consultarCategorias().get(2));
//            persis.registrarProducto(PurePapa);
//            
//            Producto Hamburguesas3 = new Producto();
//            listaProductos.add(Hamburguesas3);
//            Hamburguesas3.setNombre("3 Hamburguesas");
//            Hamburguesas3.setDescripcion("Paquete de 3 hamburguesas sencillas");
//            Hamburguesas3.setPrecio(119.99);
//            Hamburguesas3.setCategoria(persis.consultarCategorias().get(3));
//            persis.registrarProducto(Hamburguesas3);


                System.out.println(cat.getDescripcion());
//            Extra salsaBBQ = new Extra();
//            salsaBBQ.setDescripcion("");
//            salsaBBQ.setPrecioExtra(10.0);
//            persis.registrarExtra(salsaBBQ);
//
//            Cliente cliente = new Cliente();
//            cliente.setNombre("Jorge");
//            cliente.setApellidoPaterno("Campos");
//            cliente.setApellidoMaterno("Blanco");
//            cliente.setDireccion("Calle Falsa 123");
//            cliente.setNumero("6441234567");
//            persis.registrarCliente(cliente);
//
//            Cajero cajero = new Cajero();
//            cajero.setNombre("Pedro Cajero");
//            cajero.setContrasena("securepassword");
//            persis.registrarCajero(cajero);
//
//            Pedido pedido = new Pedido();
//            pedido.setCliente(cliente);
//            pedido.setCajero(cajero);
//            pedido.setFechaHoraPedido(new java.util.Date());
//            pedido.setFormaEntrega("Entrega a domicilio");
//            pedido.setEstado("Pendiente");
//            pedido.setOpinion("Por favor, no demoren."); 
//            pedido.setCalificacion(9.99);
//            pedido.setTotal(70.0);
//
//            ProductoPedido productoPedido = new ProductoPedido();
//            productoPedido.setProducto(hamburguesa);
//            productoPedido.setCantidad(1);
//            productoPedido.setComentarios("Agregar extra de Salsa BBQ");
//            productoPedido.setPrecio(hamburguesa.getPrecio());
//
//            pedido.agregarProductoPedido(productoPedido);
//
//            persis.registrarPedido(pedido);

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }

    }
}