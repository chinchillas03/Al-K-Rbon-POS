/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.itson.al.krbon_persistencia;

import org.itson.dominio.Cajero;
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
        System.out.println("Hello World!");
        
        FachadaDAO persis=  new FachadaDAO();
        
        try {
            Producto hamburguesa = new Producto();
            hamburguesa.setNombre("Sencilla");
            hamburguesa.setDescripcion("Hamburguesa sencilla");
            hamburguesa.setPrecio(60.0);
            persis.registrarProducto(hamburguesa);
            
//            Extra salsaBBQ = new Extra();
//            salsaBBQ.setDescripcion("Salsa BBQ");
//            salsaBBQ.setPrecioExtra(10.0);
//            persis.registrarExtra(salsaBBQ);
//            
//            Cliente cliente = new Cliente();
//            cliente.setNombre("Juan");
//            cliente.setApellidoPaterno("Pérez");
//            cliente.setApellidoMaterno("Gómez");
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
//            pedido.setTotal(70.0);      
//            
//            ProductoPedido productoPedido = new ProductoPedido();
//            productoPedido.setProducto(hamburguesa);
//            productoPedido.setCantidad(1);
//            productoPedido.setComentarios("Agregar extra de Salsa BBQ");
//            productoPedido.setPrecio(hamburguesa.getPrecio());
//            productoPedido.setPedido(pedido);
//            persis.registrarProductoPedido(productoPedido);
//            
//            pedido.agregarProductoPedido(productoPedido);
//            persis.registrarPedido(pedido);

        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
        
    }
}