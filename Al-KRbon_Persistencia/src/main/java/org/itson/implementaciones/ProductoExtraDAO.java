/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.ConexionBD;
import org.itson.dominio.ProductoExtra;
import org.itson.interfaces.IProductoExtra;

/**
 *
 * @author Usuario
 */
public class ProductoExtraDAO implements IProductoExtra{

    private final EntityManagerFactory manager;
    
    public ProductoExtraDAO() {
        manager = ConexionBD.getConection();
    }
    
    @Override
    public ProductoExtra registrarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoExtra eliminarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoExtra actualizarProductoExtra(ProductoExtra producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProductoExtra> consultarProductoExtras() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
