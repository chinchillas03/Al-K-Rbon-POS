/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.validadores;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Manuel Flores
 */
public class FormatoComentarios extends JTextArea implements TableCellRenderer {
    public FormatoComentarios() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        
        setText((value == null) ? "" : value.toString());  // Asigna el texto del comentario

        int preferredHeight = getPreferredSize().height;
        int currentRowHeight = table.getRowHeight(row);
        int maxHeight = 100;
        if (preferredHeight != currentRowHeight) {
            table.setRowHeight(row, Math.min(preferredHeight, maxHeight));
        }

        return this;
    }
}
