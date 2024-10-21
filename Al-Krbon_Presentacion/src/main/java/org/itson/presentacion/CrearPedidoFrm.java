/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Cajero;
import org.itson.dominio.Cliente;
import org.itson.dominio.Pedido;
import org.itson.dominio.Producto;
import org.itson.dominio.ProductoPedido;
import org.itson.implementaciones.FachadaDAO;
import org.itson.implementaciones.FachadaNegocio;

/**
 *
 * @author Manuel Flores
 */
public class CrearPedidoFrm extends javax.swing.JFrame {

    private JList<String> listaProductos;
    private DefaultListModel<String> modeloProductos;
    private DefaultTableModel modeloPedido;
    private FachadaNegocio fachada;
    private JLabel lblTotalPedido;
    private double totalPedido;

    /**
     * Creates new form CrearPedidoFrm
     */
    public CrearPedidoFrm() {
        initComponents();
        setTitle("Sistema de Órdenes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        fachada = new FachadaNegocio();
        totalPedido = 0.0;

        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BorderLayout());

        // Crear un panel para el título y las categorías
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());

        // Título de productos
        JLabel lblTituloProductos = new JLabel("Productos");
        lblTituloProductos.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloProductos.setFont(new Font("Arial", Font.BOLD, 14));

        // Añadir el título al panel superior
        panelSuperior.add(lblTituloProductos, BorderLayout.NORTH);

        // Crear el panel de categorías y sus botones
        JPanel panelCategorias = new JPanel();
        panelCategorias.setLayout(new GridLayout(2, 2));

        JButton btnHamburguesas = new JButton("Hamburguesas");
        JButton btnBebidas = new JButton("Bebidas");
        JButton btnEntradas = new JButton("Entradas");
        JButton btnPaquetes = new JButton("Paquetes");

        panelCategorias.add(btnHamburguesas);
        panelCategorias.add(btnBebidas);
        panelCategorias.add(btnEntradas);
        panelCategorias.add(btnPaquetes);

        // Añadir el panel de categorías debajo del título en el panel superior
        panelSuperior.add(panelCategorias, BorderLayout.SOUTH);

        // Ahora añadir el panel superior (con título y categorías) al panelProductos en BorderLayout.NORTH
        panelProductos.add(panelSuperior, BorderLayout.NORTH);

        modeloProductos = new DefaultListModel<>();
        listaProductos = new JList<>(modeloProductos);
        JScrollPane scrollProductos = new JScrollPane(listaProductos);

        JButton btnAnadirProducto = new JButton("Añadir");
        JPanel panelBotonProducto = new JPanel(new BorderLayout());
        panelBotonProducto.add(btnAnadirProducto, BorderLayout.SOUTH);

        panelProductos.add(scrollProductos, BorderLayout.CENTER);
        panelProductos.add(panelBotonProducto, BorderLayout.SOUTH);

        add(panelProductos, BorderLayout.WEST);

        cargarProductos(); // Método para cargar los productos

        // Resto de la interfaz gráfica (panelPedido, panelTotal, etc.)
        JPanel panelPedido = new JPanel();
        panelPedido.setLayout(new BorderLayout());

        JLabel lblTituloPedido = new JLabel("Agregado al pedido");
        lblTituloPedido.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloPedido.setFont(new Font("Arial", Font.BOLD, 14));
        panelPedido.add(lblTituloPedido, BorderLayout.NORTH);

        modeloPedido = new DefaultTableModel(new Object[]{"Producto", "Cantidad"}, 0);
        JTable tablaPedido = new JTable(modeloPedido);
        JScrollPane scrollPedido = new JScrollPane(tablaPedido);

        JButton btnIncrementar = new JButton("+");
        JButton btnDecrementar = new JButton("-");
        JButton btnBorrar = new JButton("Borrar");
        JPanel panelModificacion = new JPanel();
        panelModificacion.add(btnIncrementar);
        panelModificacion.add(btnDecrementar);
        panelModificacion.add(btnBorrar);

        panelPedido.add(scrollPedido, BorderLayout.CENTER);
        panelPedido.add(panelModificacion, BorderLayout.SOUTH);

        add(panelPedido, BorderLayout.CENTER);

        JPanel panelTotal = new JPanel(new BorderLayout());

        lblTotalPedido = new JLabel("Total: $0.00");
        lblTotalPedido.setFont(new Font("Arial", Font.BOLD, 18));
        lblTotalPedido.setHorizontalAlignment(SwingConstants.RIGHT);

        panelTotal.add(lblTotalPedido, BorderLayout.NORTH);

        add(panelTotal, BorderLayout.EAST);

        JPanel panelBotones = new JPanel();
        JButton btnGuardarTarde = new JButton("Guardar para más tarde");
        JButton btnGuardar = new JButton("Guardar");

        panelBotones.add(btnGuardarTarde);
        panelBotones.add(btnGuardar);

        add(panelBotones, BorderLayout.SOUTH);

        btnAnadirProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productoSeleccionado = listaProductos.getSelectedValue();
                if (productoSeleccionado != null) {
                    String[] partes = productoSeleccionado.split(" - ");
                    String nombreProducto = partes[0];
                    double precioProducto = Double.parseDouble(partes[1].replace("$", ""));

                    boolean productoExistente = false;
                    for (int i = 0; i < modeloPedido.getRowCount(); i++) {
                        String nombreExistente = (String) modeloPedido.getValueAt(i, 0);
                        if (nombreExistente.equals(nombreProducto)) {
                            int cantidadExistente = (int) modeloPedido.getValueAt(i, 1);
                            modeloPedido.setValueAt(cantidadExistente + 1, i, 1);
                            productoExistente = true;
                            break;
                        }
                    }

                    if (!productoExistente) {
                        modeloPedido.addRow(new Object[]{nombreProducto, 1});
                    }

                    totalPedido += precioProducto;
                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto de la lista.");
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPedido.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String nombreProducto = (String) modeloPedido.getValueAt(filaSeleccionada, 0);
                    int cantidad = (int) modeloPedido.getValueAt(filaSeleccionada, 1);

                    for (int i = 0; i < modeloProductos.size(); i++) {
                        String producto = modeloProductos.get(i);
                        if (producto.contains(nombreProducto)) {
                            double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                            totalPedido -= precioProducto * cantidad;
                            break;
                        }
                    }

                    modeloPedido.removeRow(filaSeleccionada);

                    actualizarTotalPedido();
                }
            }
        });

        btnIncrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPedido.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String nombreProducto = (String) modeloPedido.getValueAt(filaSeleccionada, 0);
                    int cantidadActual = (int) modeloPedido.getValueAt(filaSeleccionada, 1);

                    modeloPedido.setValueAt(cantidadActual + 1, filaSeleccionada, 1);

                    for (int i = 0; i < modeloProductos.size(); i++) {
                        String producto = modeloProductos.get(i);
                        if (producto.contains(nombreProducto)) {
                            double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                            totalPedido += precioProducto;
                            break;
                        }
                    }

                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto del pedido.");
                }
            }
        });

        btnDecrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPedido.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String nombreProducto = (String) modeloPedido.getValueAt(filaSeleccionada, 0);
                    int cantidadActual = (int) modeloPedido.getValueAt(filaSeleccionada, 1);

                    if (cantidadActual > 1) {
                        modeloPedido.setValueAt(cantidadActual - 1, filaSeleccionada, 1);

                        for (int i = 0; i < modeloProductos.size(); i++) {
                            String producto = modeloProductos.get(i);
                            if (producto.contains(nombreProducto)) {
                                double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                                totalPedido -= precioProducto;
                                break;
                            }
                        }
                    } else {
                        modeloPedido.removeRow(filaSeleccionada);

                        for (int i = 0; i < modeloProductos.size(); i++) {
                            String producto = modeloProductos.get(i);
                            if (producto.contains(nombreProducto)) {
                                double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                                totalPedido -= precioProducto;  // Eliminar el precio del total
                                break;
                            }
                        }
                    }

                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto del pedido.");
                }
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FachadaDAO persis = new FachadaDAO();

                Cliente cliente = new Cliente();
                cliente.setNombre("Jorge");
                cliente.setApellidoPaterno("Campos");
                cliente.setApellidoMaterno("Blanco");
                cliente.setDireccion("Calle Falsa 123");
                cliente.setNumero("6441234567");

                Cajero cajero = new Cajero();
                cajero.setNombre("Pedro Cajero");
                cajero.setContrasena("securepassword");

                Pedido pedido = new Pedido();
                pedido.setCliente(cliente);
                pedido.setCajero(cajero);
                pedido.setFechaHoraPedido(new java.util.Date());
                pedido.setFormaEntrega("Entrega a domicilio");
                pedido.setEstado("Pendiente");
                pedido.setOpinion("Por favor, no demoren.");
                pedido.setCalificacion(9.99);
                pedido.setTotal(totalPedido);

                for (int i = 0; i < modeloPedido.getRowCount(); i++) {
                    String nombreProducto = (String) modeloPedido.getValueAt(i, 0);
                    int cantidad = (int) modeloPedido.getValueAt(i, 1);

                    Producto producto = null;
                    for (int j = 0; j < modeloProductos.size(); j++) {
                        String productoInfo = modeloProductos.get(j);
                        if (productoInfo.contains(nombreProducto)) {
                            producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);
                            break;
                        }
                    }

                    if (producto != null) {
                        ProductoPedido productoPedido = new ProductoPedido();
                        productoPedido.setProducto(producto);
                        productoPedido.setCantidad(cantidad);
                        productoPedido.setPrecio(producto.getPrecio());

                        pedido.agregarProductoPedido(productoPedido);
                    }
                }

                try {
                    persis.registrarCliente(cliente);
                    persis.registrarCajero(cajero);
                    persis.registrarPedido(pedido);

                    JOptionPane.showMessageDialog(null, "Pedido guardado con éxito.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al guardar el pedido: " + ex.getMessage());
                }
            }
        });

        btnHamburguesas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductosPorCategoria("Hamburguesa");
            }
        });

        btnBebidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductosPorCategoria("Bebida");
            }
        });

        btnEntradas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductosPorCategoria("Entrada");
            }
        });

        btnPaquetes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductosPorCategoria("Paquete");
            }
        });

    }

    private void cargarProductos() {

        List<Producto> productos = fachada.getControlProducto().consultarProductos();

        modeloProductos.clear();

        for (Producto producto : productos) {
            modeloProductos.addElement(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    private void actualizarTotalPedido() {
        lblTotalPedido.setText(String.format("Total:\n$%.2f", totalPedido));
    }

    private void cargarProductosPorCategoria(String categoria) {
        modeloProductos.clear();  // Limpiar la lista de productos

        // Obtener todos los productos desde la base de datos
        List<Producto> productos = fachada.getControlProducto().consultarProductos();

        // Filtrar productos por la categoría seleccionada
        for (Producto producto : productos) {
            if (producto.getCategoria().getDescripcion().equalsIgnoreCase(categoria)) {
                modeloProductos.addElement(producto.getNombre() + " - $" + producto.getPrecio());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 927, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearPedidoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPedidoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPedidoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPedidoFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPedidoFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
