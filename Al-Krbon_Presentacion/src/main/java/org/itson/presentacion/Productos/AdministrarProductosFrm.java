/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.presentacion.Productos;

import org.itson.presentacion.Productos.AgregarProductosFrm;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.dominio.Categoria;
import org.itson.dominio.Producto;
import org.itson.implementaciones.FachadaNegocio;
import org.itson.presentacion.PantallaPrincipalFrm;

/**
 *
 * @author Manuel Flores
 */
public class AdministrarProductosFrm extends javax.swing.JFrame {

    Map<String, Long> categoriaMap = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(AdministrarProductosFrm.class.getName());
    FachadaNegocio fachada = new FachadaNegocio();
    
    /**
     * Creates new form AdministrarProductosFrm
     */
    public AdministrarProductosFrm() {       
        initComponents();
        this.consultarCategorias();
        this.hacerColumnaInvisible();
        this.llenarTablaProductos();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void consultarCategorias(){
        List<Categoria> categorias = new LinkedList<>();
        categorias = fachada.getControlCategoria().consultarCategorias();
        for (Categoria categoria : categorias) {
            categoriaMap.put(categoria.getDescripcion(), categoria.getId());
            cboxCategoria.addItem(categoria.getDescripcion());
        }
    }

    private void hacerColumnaInvisible() {
        tablaProductos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaProductos.getColumnModel().getColumn(0).setWidth(0);
    }

    private void llenarTablaProductos() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
            String categoriaSeleccionada = cboxCategoria.getSelectedItem().toString();
            Long categoriaId = null;
            if (categoriaSeleccionada != null && categoriaMap.containsKey(categoriaSeleccionada)) {
                categoriaId = categoriaMap.get(categoriaSeleccionada);
                System.out.println("El ID de la categoría seleccionada es: " + categoriaId);
                modeloTabla.setRowCount(0);
            } else {
                System.out.println("Categoría no encontrada en el mapa.");
            }
            List<Producto> listaProductos = fachada.getControlProducto().consultarProductosPorCategoria(categoriaId);
            for (Producto p : listaProductos) {
                String estado = null;
                if (p.isActivo() == true) {
                    estado = "Activo";
                }else{
                    estado = "Inactivo";
                }
                Object[] fila = {
                    p.getId(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getDescripcion(),
                    estado
                };
                modeloTabla.addRow(fila);
            }
            tablaProductos.repaint();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    public void mostrarPantallaAdminProductos(){
        this.setVisible(true);
    }
    
    public void ocultarPantallaAdminProductos(){
        this.setVisible(false);
    }
    
    private void mostrarPantallaPrincipal(){
        PantallaPrincipalFrm principal = new PantallaPrincipalFrm();
        principal.mostrarPantallaPrincipal();
        this.ocultarPantallaAdminProductos();
    }
    
    private void mostrarAgregarProducto(){
        AgregarProductosFrm agregar = new AgregarProductosFrm();
        agregar.mostrarAgregarProducto();
        this.ocultarPantallaAdminProductos();
    }
    
    private void mostrarEditarProducto() {        
        int filaseleccionada;
        try {
            filaseleccionada = tablaProductos.getSelectedRow();
            if (filaseleccionada == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
            } else {
                Long productoId = (Long) tablaProductos.getValueAt(filaseleccionada, 0);
                EditarProductosFrm editar = new EditarProductosFrm(productoId);
                editar.setVisible(true);
                this.ocultarPantallaAdminProductos();
            }
            tablaProductos.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void eliminarProducto() {
        int filaseleccionada;
        try {
            filaseleccionada = tablaProductos.getSelectedRow();
            if (filaseleccionada == -1) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
            } else {
                Long productoId = (Long) tablaProductos.getValueAt(filaseleccionada, 0);
                fachada.getControlProducto().eliminarProducto((Long)productoId);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex + "\nInténtelo nuevamente", "Error En la Operacion.", JOptionPane.ERROR_MESSAGE);
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

        cboxCategoria = new javax.swing.JComboBox<>();
        spProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        lblTItulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrar productos");
        setExtendedState(6);
        setResizable(false);

        cboxCategoria.setBackground(new java.awt.Color(255, 255, 255));
        cboxCategoria.setFont(new java.awt.Font("Arial Black", 1, 32)); // NOI18N
        cboxCategoria.setForeground(new java.awt.Color(0, 0, 0));
        cboxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboxCategoria.setMinimumSize(new java.awt.Dimension(1000, 600));
        cboxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCategoriaActionPerformed(evt);
            }
        });

        spProductos.setToolTipText("");
        spProductos.setFont(new java.awt.Font("Segoe UI", 0, 42));
        spProductos.setInheritsPopupMenu(true);

        tablaProductos.setBorder(new javax.swing.border.MatteBorder(null));
        tablaProductos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Descripción", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setToolTipText("");
        tablaProductos.setAlignmentX(0.0F);
        tablaProductos.setAlignmentY(0.0F);
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaProductos.setAutoscrolls(false);
        tablaProductos.setRowHeight(50);
        spProductos.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setMinWidth(175);
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(175);
            tablaProductos.getColumnModel().getColumn(2).setMinWidth(400);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablaProductos.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        btnAgregarProducto.setBackground(new java.awt.Color(0, 0, 255));
        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("+ Agregar nuevo producto");
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(102, 255, 102));
        btnEditarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setText("Editar");
        btnEditarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        lblTItulo.setFont(new java.awt.Font("Arial Black", 0, 64)); // NOI18N
        lblTItulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTItulo.setText("Administrar productos");

        btnRegresar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 80)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("<");
        btnRegresar.setToolTipText("");
        btnRegresar.setAlignmentY(0.0F);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(lblTItulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(342, 342, 342)
                                .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(spProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTItulo))
                .addGap(19, 19, 19)
                .addComponent(cboxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66)
                .addComponent(spProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCategoriaActionPerformed
        // TODO add your handling code here:
        this.llenarTablaProductos();
    }//GEN-LAST:event_cboxCategoriaActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        // TODO add your handling code here:
        this.mostrarEditarProducto();
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
        this.eliminarProducto();
        this.tablaProductos.repaint();
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.mostrarPantallaPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        this.mostrarAgregarProducto();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cboxCategoria;
    private javax.swing.JLabel lblTItulo;
    private javax.swing.JScrollPane spProductos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
