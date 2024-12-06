/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Pedido;
import org.itson.implementaciones.FachadaNegocio;

/**
 *
 * @author icedo
 */
public class AdministrarPedidosFrm extends javax.swing.JFrame {
    
    private JTable tablaPedidos;
    private DefaultTableModel modelo;
    private FachadaNegocio fachada;
    /**
     * Creates new form AdministrarPedidosFrm
     */
    public AdministrarPedidosFrm() {
        initComponents();
        fachada = new FachadaNegocio();
        setTitle("Administrar Pedidos");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{"ID", "Cliente", "Estado", "Total"}, 0);
        tablaPedidos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaPedidos);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnPagar = new JButton("Pagar");
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaPedidos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Long idPedido = (Long) modelo.getValueAt(filaSeleccionada, 0);
                    new RealizarPagoFrm(idPedido).setVisible(true);
                    dispose(); // Cerrar el formulario actual
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un pedido.");
                }
            }
        });
        add(btnPagar, BorderLayout.SOUTH);

        cargarPedidos();
    }
    private void cargarPedidos() {
        List<Pedido> pedidos = fachada.getControlPedido().consultarPedidos();
        for (Pedido pedido : pedidos) {
            modelo.addRow(new Object[]{pedido.getId(), pedido.getCliente().getNombre(), pedido.getEstado(), pedido.getTotal()});
        }
    }
    
    public void mostrarAdministrarPedidos(){
        this.setVisible(true);
    }
    
    public void ocultarAdministrarPedidos(){
        this.setVisible(false);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
