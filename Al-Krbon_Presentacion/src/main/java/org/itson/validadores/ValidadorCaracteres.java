/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.validadores;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Manuel Flores
 */
public class ValidadorCaracteres extends DefaultCellEditor {

    private JTextField textField;

    public ValidadorCaracteres() {
        super(new JTextField());
        textField = (JTextField) getComponent();
        textField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null) {
                    String forbiddenChars = "<>!@#$'\"";
                    boolean containsForbidden = str.chars().anyMatch(c -> forbiddenChars.indexOf(c) >= 0);

                    // Separar las condiciones de validación
                    if (getLength() + str.length() > 200) {
                        // Mensaje de error por exceder el límite de caracteres
                        JOptionPane.showMessageDialog(null, "Los comentarios no pueden exceder los 200 caracteres.");
                    } else if (containsForbidden) {
                        // Mensaje de error por incluir caracteres no permitidos
                        JOptionPane.showMessageDialog(null, "Los caracteres <>!@#$'\" no están permitidos en los comentarios.");
                    } else {
                        // Insertar si pasa ambas validaciones
                        super.insertString(offs, str, a);
                    }
                }
            }
        });
    }

}
