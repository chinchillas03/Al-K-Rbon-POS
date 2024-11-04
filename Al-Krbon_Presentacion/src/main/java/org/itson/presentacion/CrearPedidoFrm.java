/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
    private JTextArea txtComentarios;
    private JLabel lblTotalConDescuento;

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

        // PANEL IZQUIERDO
        JPanel panelProductos = new JPanel(new BorderLayout());

        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel lblTituloProductos = new JLabel("Productos", SwingConstants.CENTER);
        lblTituloProductos.setFont(new Font("Arial", Font.BOLD, 14));
        panelSuperior.add(lblTituloProductos, BorderLayout.NORTH);

        JPanel panelCategorias = new JPanel(new GridLayout(2, 2));
        JButton btnHamburguesas = new JButton("Hamburguesas");
        JButton btnBebidas = new JButton("Bebidas");
        JButton btnEntradas = new JButton("Entradas");
        JButton btnPaquetes = new JButton("Paquetes");
        panelCategorias.add(btnHamburguesas);
        panelCategorias.add(btnBebidas);
        panelCategorias.add(btnEntradas);
        panelCategorias.add(btnPaquetes);

        panelSuperior.add(panelCategorias, BorderLayout.SOUTH);
        panelProductos.add(panelSuperior, BorderLayout.NORTH);

        modeloProductos = new DefaultListModel<>();
        listaProductos = new JList<>(modeloProductos);
        JScrollPane scrollProductos = new JScrollPane(listaProductos);
        panelProductos.add(scrollProductos, BorderLayout.CENTER);

        JButton btnAnadirProducto = new JButton("Añadir");
        panelProductos.add(btnAnadirProducto, BorderLayout.SOUTH);
        add(panelProductos, BorderLayout.WEST);

        // PANEL CENTRAL
        JPanel panelPedido = new JPanel(new BorderLayout());
        JLabel lblTituloPedido = new JLabel("Pedido Actual", SwingConstants.CENTER);
        lblTituloPedido.setFont(new Font("Arial", Font.BOLD, 14));
        panelPedido.add(lblTituloPedido, BorderLayout.NORTH);

        modeloPedido = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Comentarios"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };

        JTable tablaPedido = new JTable(modeloPedido);
        tablaPedido.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaPedido.setRowSelectionAllowed(true);
        tablaPedido.getColumnModel().getColumn(2).setCellRenderer(new FormatoComentarios());
        JScrollPane scrollPedido = new JScrollPane(tablaPedido);
        panelPedido.add(scrollPedido, BorderLayout.CENTER);

        JPanel panelModificacion = new JPanel(new FlowLayout());
        JButton btnIncrementar = new JButton("+");
        JButton btnDecrementar = new JButton("-");
        JButton btnBorrar = new JButton("Borrar");
        panelModificacion.add(btnIncrementar);
        panelModificacion.add(btnDecrementar);
        panelModificacion.add(btnBorrar);
        panelPedido.add(panelModificacion, BorderLayout.SOUTH);

        add(panelPedido, BorderLayout.CENTER);

        // PANEL DERECHO
        JPanel panelTotal = new JPanel(new BorderLayout());
        lblTotalPedido = new JLabel("Total: $0.00", SwingConstants.RIGHT);
        lblTotalPedido.setFont(new Font("Arial", Font.BOLD, 18));
//        JLabel lblDescuento = new JLabel("Descuento (%):");
//        JTextField txtDescuento = new JTextField(5);
//        lblTotalConDescuento = new JLabel("Total con descuento: $0.00", SwingConstants.RIGHT);
//        lblTotalConDescuento.setFont(new Font("Arial", Font.BOLD, 18));
//        JButton btnAplicarDescuento = new JButton("Aplicar descuento");
//        JButton btnGuardarConDescuento = new JButton("Guardar con descuento");
//
//        panelTotal.add(lblDescuento, BorderLayout.WEST);
//        panelTotal.add(txtDescuento, BorderLayout.CENTER);
//        panelTotal.add(lblTotalConDescuento, BorderLayout.WEST);
//        panelTotal.add(btnAplicarDescuento, BorderLayout.EAST);
//        panelTotal.add(btnGuardarConDescuento, BorderLayout.SOUTH);
        panelTotal.add(lblTotalPedido, BorderLayout.NORTH);
        add(panelTotal, BorderLayout.EAST);

        // PANEL INFERIOR
        JPanel panelInferior = new JPanel(new BorderLayout());

        JPanel panelBotonesGuardar = new JPanel(new FlowLayout());
        JButton btnGuardarTarde = new JButton("Guardar para más tarde");
        JButton btnGuardar = new JButton("Guardar");

        panelBotonesGuardar.add(btnGuardarTarde);
        panelBotonesGuardar.add(btnGuardar);
        panelInferior.add(panelBotonesGuardar, BorderLayout.SOUTH);

        add(panelInferior, BorderLayout.SOUTH);

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
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto de la lista");
                }
            }
        });

        btnIncrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] filasSeleccionadas = tablaPedido.getSelectedRows();
                if (filasSeleccionadas.length > 0) {
                    for (int fila : filasSeleccionadas) {
                        String nombreProducto = (String) modeloPedido.getValueAt(fila, 0);
                        int cantidadActual = (int) modeloPedido.getValueAt(fila, 1);

                        modeloPedido.setValueAt(cantidadActual + 1, fila, 1);

                        Producto producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);
                        if (producto != null) {
                            totalPedido += producto.getPrecio();
                        }
                    }
                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona uno o más productos del pedido.");
                }
            }
        });

        btnDecrementar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] filasSeleccionadas = tablaPedido.getSelectedRows();
                if (filasSeleccionadas.length > 0) {
                    for (int fila : filasSeleccionadas) {
                        String nombreProducto = (String) modeloPedido.getValueAt(fila, 0);
                        int cantidadActual = (int) modeloPedido.getValueAt(fila, 1);

                        if (cantidadActual > 1) {
                            modeloPedido.setValueAt(cantidadActual - 1, fila, 1);

                            Producto producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);
                            if (producto != null) {
                                totalPedido -= producto.getPrecio();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se puede reducir más la cantidad de " + nombreProducto);
                        }
                    }
                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona uno o más productos del pedido.");
                }
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] filasSeleccionadas = tablaPedido.getSelectedRows();
                if (filasSeleccionadas.length > 0) {
                    for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                        int fila = filasSeleccionadas[i];
                        String nombreProducto = (String) modeloPedido.getValueAt(fila, 0);
                        int cantidad = (int) modeloPedido.getValueAt(fila, 1);

                        Producto producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);
                        if (producto != null) {
                            totalPedido -= producto.getPrecio() * cantidad;
                        }

                        modeloPedido.removeRow(fila);
                    }
                    actualizarTotalPedido();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona uno o más productos del pedido.");
                }
            }
        });

//        btnAplicarDescuento.addActionListener(e -> {
//            try {
//                // Obtiene el valor del porcentaje de descuento del JTextField
//                int descuento = Integer.parseInt(txtDescuento.getText());
//
//                // Verifica que el descuento esté entre 1 y 100
//                if (descuento < 1 || descuento > 100) {
//                    JOptionPane.showMessageDialog(null, "El descuento debe ser entre 1% y 100%");
//                    return;
//                }
//
//                // Calcula el precio con descuento
//                double precioConDescuento = totalPedido - (totalPedido * descuento / 100.0);
//
//                // Muestra el precio con descuento en lblTotalConDescuento
//                lblTotalConDescuento.setText("Total con descuento: $" + String.format("%.2f", precioConDescuento));
//
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null, "Ingresa un valor numérico para el descuento");
//            }
//        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modeloPedido.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(
                            CrearPedidoFrm.this,
                            "No se puede guardar el pedido. Agrega al menos un producto.",
                            "Advertencia",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

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
                    String comentarioProducto = (String) modeloPedido.getValueAt(i, 2);

                    if (comentarioProducto == null || comentarioProducto.trim().isBlank() || comentarioProducto.trim().isEmpty()) {
                        comentarioProducto = null;
                    }

                    Producto producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);

                    if (producto != null) {
                        ProductoPedido productoPedido = new ProductoPedido();
                        productoPedido.setProducto(producto);
                        productoPedido.setCantidad(cantidad);
                        productoPedido.setPrecio(producto.getPrecio());
                        productoPedido.setComentarios(comentarioProducto);

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

//        btnGuardarConDescuento.addActionListener(e -> {
//            if (modeloPedido.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(CrearPedidoFrm.this, "No se puede guardar el pedido. Agrega al menos un producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
//                return;
//            }
//
//            double precioConDescuento;
//            try {
//                // Extrae el valor del lblTotalConDescuento
//                String textoDescuento = lblTotalConDescuento.getText().replace("Total con descuento: $", "");
//                precioConDescuento = Double.parseDouble(textoDescuento);
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null, "Error al obtener el precio con descuento");
//                return;
//            }
//
//            // Configuración de pedido con descuento
//            FachadaDAO persis = new FachadaDAO();
//            Cliente cliente = new Cliente();
//            cliente.setNombre("Jorge");
//            cliente.setApellidoPaterno("Campos");
//            cliente.setApellidoMaterno("Blanco");
//            cliente.setDireccion("Calle Falsa 123");
//            cliente.setNumero("6441234567");
//
//            Cajero cajero = new Cajero();
//            cajero.setNombre("Pedro Cajero");
//            cajero.setContrasena("securepassword");
//
//            Pedido pedido = new Pedido();
//            pedido.setCliente(cliente);
//            pedido.setCajero(cajero);
//            pedido.setFechaHoraPedido(new java.util.Date());
//            pedido.setFormaEntrega("Entrega a domicilio");
//            pedido.setEstado("Pendiente");
//            pedido.setOpinion("Por favor, no demoren.");
//            pedido.setCalificacion(9.99);
//            pedido.setTotal(precioConDescuento);
//
//            for (int i = 0; i < modeloPedido.getRowCount(); i++) {
//                String nombreProducto = (String) modeloPedido.getValueAt(i, 0);
//                int cantidad = (int) modeloPedido.getValueAt(i, 1);
//                String comentarioProducto = (String) modeloPedido.getValueAt(i, 2);
//
//                if (comentarioProducto == null || comentarioProducto.trim().isBlank() || comentarioProducto.trim().isEmpty()) {
//                    comentarioProducto = null;
//                }
//
//                Producto producto = fachada.getControlProducto().consultarProductoPorNombre(nombreProducto);
//
//                if (producto != null) {
//                    ProductoPedido productoPedido = new ProductoPedido();
//                    productoPedido.setProducto(producto);
//                    productoPedido.setCantidad(cantidad);
//                    productoPedido.setPrecio(producto.getPrecio());
//                    productoPedido.setComentarios(comentarioProducto);
//
//                    pedido.agregarProductoPedido(productoPedido);
//                }
//            }
//
//            try {
//                persis.registrarCliente(cliente);
//                persis.registrarCajero(cajero);
//                persis.registrarPedido(pedido);
//
//                JOptionPane.showMessageDialog(null, "Pedido guardado con éxito con descuento aplicado.");
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Error al guardar el pedido: " + ex.getMessage());
//            }
//        });

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

    private void actualizarTotalPedido() {
        lblTotalPedido.setText("Total: $" + String.format("%.2f", totalPedido));
        //lblTotalConDescuento.setText("Total con descuento: $0.00");
    }

    private void cargarProductosPorCategoria(String categoria) {
        modeloProductos.clear();

        List<Producto> productos = fachada.getControlProducto().consultarProductos();

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
