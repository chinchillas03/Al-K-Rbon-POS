/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.BorderLayout;
import java.awt.Font;
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
import org.itson.dominio.Producto;
import org.itson.implementaciones.FachadaNegocio;

/**
 *
 * @author Manuel Flores
 */
public class CrearPedidoFrm extends javax.swing.JFrame {

    private JList<String> listaProductos;
    private DefaultListModel<String> modeloProductos;
    private DefaultTableModel modeloPedido;  // Cambiado a una tabla con modelo de dos columnas
    private FachadaNegocio fachada;
    private JLabel lblTotalPedido;  // Nuevo label para mostrar el total del pedido
    private double totalPedido;  // Variable para llevar el total del pedido

    /**
     * Creates new form CrearPedidoFrm
     */
    public CrearPedidoFrm() {
        initComponents();
        setTitle("Sistema de Órdenes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        fachada = new FachadaNegocio();
        totalPedido = 0.0;

        // Sección izquierda (productos)
        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BorderLayout());

        // Añadir título "Productos" sobre la lista de productos
        JLabel lblTituloProductos = new JLabel("Productos");
        lblTituloProductos.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloProductos.setFont(new Font("Arial", Font.BOLD, 14));
        panelProductos.add(lblTituloProductos, BorderLayout.NORTH);

        // Crear modelo para la lista de productos
        modeloProductos = new DefaultListModel<>();
        listaProductos = new JList<>(modeloProductos);
        JScrollPane scrollProductos = new JScrollPane(listaProductos);

        // Añadir botón para añadir producto
        JButton btnAnadirProducto = new JButton("Añadir");
        JPanel panelBotonProducto = new JPanel(new BorderLayout());
        panelBotonProducto.add(btnAnadirProducto, BorderLayout.SOUTH);

        panelProductos.add(scrollProductos, BorderLayout.CENTER);
        panelProductos.add(panelBotonProducto, BorderLayout.SOUTH);

        // Añadir panel de productos a la izquierda (WEST)
        add(panelProductos, BorderLayout.WEST);

        // Llamar método para cargar productos desde la base de datos
        cargarProductos();

        // Sección derecha (pedido)
        JPanel panelPedido = new JPanel();
        panelPedido.setLayout(new BorderLayout());

        // Añadir título "Agregado al pedido" sobre la tabla de pedido
        JLabel lblTituloPedido = new JLabel("Agregado al pedido");
        lblTituloPedido.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloPedido.setFont(new Font("Arial", Font.BOLD, 14));
        panelPedido.add(lblTituloPedido, BorderLayout.NORTH);

        // Crear modelo para la tabla de pedidos con dos columnas: Nombre y Cantidad
        modeloPedido = new DefaultTableModel(new Object[]{"Producto", "Cantidad"}, 0);
        JTable tablaPedido = new JTable(modeloPedido);
        JScrollPane scrollPedido = new JScrollPane(tablaPedido);

        // Añadir botones para modificar productos en el pedido
        JButton btnIncrementar = new JButton("+");
        JButton btnDecrementar = new JButton("-");
        JButton btnBorrar = new JButton("Borrar");
        JPanel panelModificacion = new JPanel();
        panelModificacion.add(btnIncrementar);
        panelModificacion.add(btnDecrementar);
        panelModificacion.add(btnBorrar);

        panelPedido.add(scrollPedido, BorderLayout.CENTER);
        panelPedido.add(panelModificacion, BorderLayout.SOUTH);

        // Añadir panel del pedido al centro (CENTER)
        add(panelPedido, BorderLayout.CENTER);

        // Crear panel derecho para el total del pedido
        JPanel panelTotal = new JPanel(new BorderLayout());

        // Label para mostrar el total del pedido
        lblTotalPedido = new JLabel("Total: $0.00");
        lblTotalPedido.setFont(new Font("Arial", Font.BOLD, 18));  // Cambiar tamaño del texto
        lblTotalPedido.setHorizontalAlignment(SwingConstants.RIGHT);  // Alinear a la derecha

        // Añadir el label del total al panel derecho
        panelTotal.add(lblTotalPedido, BorderLayout.NORTH);

        // Añadir el panelTotal al este (EAST)
        add(panelTotal, BorderLayout.EAST);

        // Sección inferior (botones de guardar)
        JPanel panelBotones = new JPanel();
        JButton btnGuardarTarde = new JButton("Guardar para más tarde");
        JButton btnGuardar = new JButton("Guardar");

        panelBotones.add(btnGuardarTarde);
        panelBotones.add(btnGuardar);

        // Añadir panel de botones al sur (SOUTH)
        add(panelBotones, BorderLayout.SOUTH);

        // Añadir funcionalidad al botón "Añadir"
        btnAnadirProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productoSeleccionado = listaProductos.getSelectedValue();
                if (productoSeleccionado != null) {
                    // Extraer el precio del producto del formato "Nombre - Precio"
                    String[] partes = productoSeleccionado.split(" - ");
                    String nombreProducto = partes[0];
                    double precioProducto = Double.parseDouble(partes[1].replace("$", ""));

                    // Verificar si el producto ya está en el pedido
                    boolean productoExistente = false;
                    for (int i = 0; i < modeloPedido.getRowCount(); i++) {
                        String nombreExistente = (String) modeloPedido.getValueAt(i, 0);
                        if (nombreExistente.equals(nombreProducto)) {
                            int cantidadExistente = (int) modeloPedido.getValueAt(i, 1);
                            modeloPedido.setValueAt(cantidadExistente + 1, i, 1);  // Incrementar cantidad
                            productoExistente = true;
                            break;
                        }
                    }

                    if (!productoExistente) {
                        // Añadir el producto seleccionado al pedido con cantidad inicial de 1
                        modeloPedido.addRow(new Object[]{nombreProducto, 1});
                    }

                    // Actualizar el total del pedido
                    totalPedido += precioProducto;
                    actualizarTotalPedido();
                } else {
                    // Mostrar un mensaje si no se seleccionó ningún producto
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto de la lista.");
                }
            }
        });

        // Funcionalidad para el botón de borrar
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPedido.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String nombreProducto = (String) modeloPedido.getValueAt(filaSeleccionada, 0);
                    int cantidad = (int) modeloPedido.getValueAt(filaSeleccionada, 1);

                    // Buscar el precio del producto original
                    for (int i = 0; i < modeloProductos.size(); i++) {
                        String producto = modeloProductos.get(i);
                        if (producto.contains(nombreProducto)) {
                            double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                            totalPedido -= precioProducto * cantidad;
                            break;
                        }
                    }

                    // Eliminar el producto del pedido
                    modeloPedido.removeRow(filaSeleccionada);

                    // Actualizar el total del pedido
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

                    // Incrementar la cantidad
                    modeloPedido.setValueAt(cantidadActual + 1, filaSeleccionada, 1);

                    // Buscar el precio del producto original
                    for (int i = 0; i < modeloProductos.size(); i++) {
                        String producto = modeloProductos.get(i);
                        if (producto.contains(nombreProducto)) {
                            double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                            totalPedido += precioProducto;  // Incrementar el total
                            break;
                        }
                    }

                    actualizarTotalPedido();  // Actualizar el total
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
                        // Decrementar la cantidad
                        modeloPedido.setValueAt(cantidadActual - 1, filaSeleccionada, 1);

                        // Buscar el precio del producto original
                        for (int i = 0; i < modeloProductos.size(); i++) {
                            String producto = modeloProductos.get(i);
                            if (producto.contains(nombreProducto)) {
                                double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                                totalPedido -= precioProducto;  // Decrementar el total
                                break;
                            }
                        }
                    } else {
                        // Si la cantidad es 1 y se presiona "-", eliminar el producto del pedido
                        modeloPedido.removeRow(filaSeleccionada);

                        // Buscar el precio del producto original
                        for (int i = 0; i < modeloProductos.size(); i++) {
                            String producto = modeloProductos.get(i);
                            if (producto.contains(nombreProducto)) {
                                double precioProducto = Double.parseDouble(producto.split(" - ")[1].replace("$", ""));
                                totalPedido -= precioProducto;  // Eliminar el precio del total
                                break;
                            }
                        }
                    }

                    actualizarTotalPedido();  // Actualizar el total
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un producto del pedido.");
                }
            }
        });

    }

    private void cargarProductos() {
        // Obtener los productos desde la base de datos usando la fachada
        List<Producto> productos = fachada.getControlProducto().consultarProductos();

        // Limpiar la lista de productos existente
        modeloProductos.clear();

        // Añadir los productos obtenidos al modelo de la lista (nombre y precio)
        for (Producto producto : productos) {
            modeloProductos.addElement(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }

    // Método para actualizar el label del total del pedido
    private void actualizarTotalPedido() {
        lblTotalPedido.setText(String.format("Total:\n$%.2f", totalPedido));
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
