/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.itson.al.krbon_presentacion;
import java.util.List;
import org.itson.dominio.Cliente;
import org.itson.dominio.Producto;
import org.itson.implementaciones.FachadaNegocio;

/**
 *
 * @author Usuario
 */
public class AlKrbon_Presentacion {

    public static void main(String[] args) {
        FachadaNegocio fachada = new FachadaNegocio();
        
        List<Producto> productos = fachada.getControlProducto().consultarProductos();
        
        for (int i = 0; i < productos.size(); i++) {
            System.out.println("Producto -> "+i);
            System.out.println(productos.get(i).getId());
            System.out.println(productos.get(i).getNombre());
            System.out.println(productos.get(i).getDescripcion());
            System.out.println(productos.get(i).getExtras());
            System.out.println(productos.get(i).getPrecio());
            System.out.println(productos.get(i).getCategoria().getDescripcion());
        }
    }
}
