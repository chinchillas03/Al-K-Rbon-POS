/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.itson.dominio.Categoria;
import org.itson.dominio.Producto;
import org.itson.implementaciones.FachadaNegocio;

/**
 *
 * @author Manuel Flores
 */
public class AgregarProductosFrm extends javax.swing.JFrame {

    Map<String, Long> categoriaMap = new HashMap<>(); 
    FachadaNegocio fachada = new FachadaNegocio();
    Producto productoAgregar = new Producto();
    List<Categoria> categorias = new LinkedList<>();
    
    /**
     * Creates new form AgregarProductos
     */
    public AgregarProductosFrm() {
        initComponents();
        this.llenarComboxCategorias();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void llenarComboxCategorias() {
        try {
            categorias = new LinkedList<>();
            categorias = fachada.getControlCategoria().consultarCategorias();
            for (Categoria categoria : categorias) {
                categoriaMap.put(categoria.getDescripcion(), categoria.getId());
                comboCategorias.addItem(categoria.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarAgregarProducto() {
        this.setVisible(true);
    }
    
    public void ocultarAgregarProducto(){
        this.setVisible(false);
    }
    
    private void mostrarAdministrarProductos(){
        AdministrarProductosFrm admin = new AdministrarProductosFrm();
        admin.mostrarPantallaAdminProductos();
        this.ocultarAgregarProducto();
    }
    
    private void agregarProducto() {
        try {
            if (tfNombre.getText().isEmpty() || tfNombre.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "\nNombre vacio o en blanco", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (txaDesc.getText().isEmpty() || txaDesc.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "\nDescripcion vacia o en blanco", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (tfPrecio.getText().isEmpty() || tfPrecio.getText().isBlank() || !esNumeroValido(tfPrecio.getText())) {
                JOptionPane.showMessageDialog(null, "\nPrecio no valido", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            productoAgregar.setNombre(tfNombre.getText());
            productoAgregar.setDescripcion(txaDesc.getText());
            productoAgregar.setPrecio(Double.parseDouble(tfPrecio.getText()));
            String categoriaSeleccionada = (String) comboCategorias.getSelectedItem();
            productoAgregar.setActivo(true);
            Long categoriaId = categoriaMap.get(categoriaSeleccionada);
            productoAgregar.setCategoria(consultarCategoriaSeleccionada(categoriaId));
            fachada.getControlProducto().registrarProducto(productoAgregar);
            JOptionPane.showMessageDialog(null, "\nProducto agregado correctamente", "Producto agregado", JOptionPane.INFORMATION_MESSAGE);      
            this.mostrarAdministrarProductos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\nError al agregar en la base de datos", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private Categoria consultarCategoriaSeleccionada(Long categoriaId) {
        try {
            return fachada.getControlCategoria().consultarCategoriaPorId(categoriaId);
        } catch (Exception e) {
            System.out.println("Error al consultar la categoría: " + e.getMessage());
            return null; // Devuelve null en caso de error
        }
    }

    public boolean esNumeroValido(String texto) {
        try {
            Double.parseDouble(texto); 
            return true;
        } catch (NumberFormatException e) {
            return false;
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

        lblTitulo = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        spDesc = new javax.swing.JScrollPane();
        txaDesc = new javax.swing.JTextArea();
        btnRegresarAdminProductos = new javax.swing.JButton();
        comboCategorias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        lblTitulo.setFont(new java.awt.Font("Arial Black", 1, 64)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agregar producto");

        lblDesc.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDesc.setText("Descripción del producto");

        lblPrecio.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPrecio.setText("Precio");

        lblNombre.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Nombre del producto");

        tfPrecio.setBackground(new java.awt.Color(255, 255, 255));
        tfPrecio.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tfPrecio.setForeground(new java.awt.Color(0, 0, 0));
        tfPrecio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tfNombre.setBackground(new java.awt.Color(255, 255, 255));
        tfNombre.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(0, 0, 0));
        tfNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAgregarProducto.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        txaDesc.setBackground(new java.awt.Color(255, 255, 255));
        txaDesc.setColumns(20);
        txaDesc.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txaDesc.setForeground(new java.awt.Color(0, 0, 0));
        txaDesc.setRows(5);
        txaDesc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        spDesc.setViewportView(txaDesc);

        btnRegresarAdminProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresarAdminProductos.setFont(new java.awt.Font("Segoe UI", 1, 80)); // NOI18N
        btnRegresarAdminProductos.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresarAdminProductos.setText("<");
        btnRegresarAdminProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarAdminProductosActionPerformed(evt);
            }
        });

        comboCategorias.setBackground(new java.awt.Color(255, 255, 255));
        comboCategorias.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        comboCategorias.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnRegresarAdminProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNombre)
                            .addGap(739, 739, 739))
                        .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spDesc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
                                .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarAdminProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo))
                .addGap(29, 29, 29)
                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrecio)
                .addGap(18, 18, 18)
                .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarAdminProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarAdminProductosActionPerformed
        // TODO add your handling code here:
        this.mostrarAdministrarProductos();
    }//GEN-LAST:event_btnRegresarAdminProductosActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        this.agregarProducto();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnRegresarAdminProductos;
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane spDesc;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPrecio;
    private javax.swing.JTextArea txaDesc;
    // End of variables declaration//GEN-END:variables
}
