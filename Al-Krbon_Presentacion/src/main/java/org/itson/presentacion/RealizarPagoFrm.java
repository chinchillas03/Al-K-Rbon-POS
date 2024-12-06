/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

/**
 *
 * @author icedo
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.itson.dominio.Pedido;
import org.itson.dominio.ProductoPedido;
import org.itson.implementaciones.FachadaNegocio;

public class RealizarPagoFrm extends javax.swing.JFrame {

    private Long idPedido;
    private JTextField txtPago;
    private JLabel lblSubtotal;
    private JLabel lblTotal;

    public RealizarPagoFrm(Long idPedido) {
        this.idPedido = idPedido;
        setTitle("Realizar Pago");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        FachadaNegocio fachada = new FachadaNegocio();
        Pedido pedido = fachada.getControlPedido().consultarPedidos().stream()
                .filter(p -> p.getId().equals(idPedido))
                .findFirst()
                .orElse(null);

        JButton btnRegresar = new JButton("<");
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 80)); // Ajusta el tamaño de la fuente
        btnRegresar.setPreferredSize(new java.awt.Dimension(100, 100)); // Establece el tamaño del botón

// Crear un JPanel para contener el botón
        JPanel panelRegresar = new JPanel();
        panelRegresar.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alinear a la izquierda
        panelRegresar.add(btnRegresar); // Agregar el botón al panel

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdministrarPedidosFrm adminPedidos = new AdministrarPedidosFrm();
                adminPedidos.mostrarAdministrarPedidos();
                dispose(); // Cierra la ventana actual
            }
        });

        add(panelRegresar, BorderLayout.NORTH);

        if (pedido != null) {
            // Panel para el nombre del cliente
            JPanel panelCliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelCliente.add(new JLabel("Cliente: " + pedido.getCliente().getNombre()));
            add(panelCliente, BorderLayout.NORTH);

            // Panel para la forma de entrega
            JPanel panelEntrega = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelEntrega.add(new JLabel("Forma de Entrega:"));
            String[] formasEntrega = {"Entrega a domicilio", "Local"};
            JComboBox<String> comboFormaEntrega = new JComboBox<>(formasEntrega);
            panelEntrega.add(comboFormaEntrega);
            add(panelEntrega, BorderLayout.NORTH);

            // Panel para la tabla de productos
            JPanel panelProductos = new JPanel(new BorderLayout());
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"Nombre", "Descripción", "Precio", "Cantidad", "Comentarios"}, 0);
            JTable tablaProductos = new JTable(modelo);
            for (ProductoPedido productoPedido : pedido.getProductos()) {
                modelo.addRow(new Object[]{
                    productoPedido.getProducto().getNombre(),
                    productoPedido.getProducto().getDescripcion(),
                    productoPedido.getPrecio(),
                    productoPedido.getCantidad(),
                    productoPedido.getComentarios()
                });
            }
            JScrollPane scrollPane = new JScrollPane(tablaProductos);
            panelProductos.add(scrollPane, BorderLayout.CENTER);
            add(panelProductos, BorderLayout.CENTER);

            // Panel para el subtotal y total
            JPanel panelTotal = new JPanel(new GridLayout(2, 1));
            lblSubtotal = new JLabel("Subtotal: $" + pedido.getTotal());
            lblTotal = new JLabel("Total: $" + pedido.getTotal());
            panelTotal.add(lblSubtotal);
            panelTotal.add(lblTotal);
            JPanel panelTotalContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelTotalContainer.add(panelTotal);
            add(panelTotalContainer, BorderLayout.SOUTH);

            // Panel para el pago
            JPanel panelPago = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelPago.add(new JLabel("Pago:"));
            txtPago = new JTextField(10);
            panelPago.add(txtPago);
            add(panelPago, BorderLayout.SOUTH);

            // Botón para confirmar el pago
            JButton btnConfirmarPago = new JButton("Confirmar Pago");
            btnConfirmarPago.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double pago = Double.parseDouble(txtPago.getText());
                    if (pago >= pedido.getTotal()) {
                        // Cambiar el estado del pedido a "Pagado"
                        pedido.setEstado("Pagado");
                        fachada.getControlPedido().actualizarPedido(pedido); // Actualizar el pedido en la base de datos

                        JOptionPane.showMessageDialog(null, "Pago realizado con éxito.");
                        dispose(); // Cerrar el formulario
                    } else {
                        JOptionPane.showMessageDialog(null, "El pago debe ser igual o mayor al total.");
                    }
                }
            });
            panelPago.add(btnConfirmarPago);
            add(panelPago, BorderLayout.SOUTH);
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
