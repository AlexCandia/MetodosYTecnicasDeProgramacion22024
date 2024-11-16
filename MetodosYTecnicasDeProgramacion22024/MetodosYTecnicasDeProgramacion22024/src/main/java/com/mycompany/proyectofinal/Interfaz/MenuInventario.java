/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;

import com.mycompany.proyectofinal.Contabilidad.EgresoVariable;
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Inventario.Insumo;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


/**
 *
 * @author Usuario
 */
public class MenuInventario extends javax.swing.JFrame {
     DefaultTableModel dtm = new DefaultTableModel();
     private TableRowSorter<DefaultTableModel> sorter; // Para ordenar la tabla
    
    GestorDeInventario gestorInventario = new GestorDeInventario();
    GestorDeVentas gestorVentas = new GestorDeVentas(gestorInventario);
    GestorDeContabilidad gestorContabilidad = new GestorDeContabilidad(gestorInventario,gestorVentas);
    /**
     * Creates new form tabala
     */
    public MenuInventario() {
        initComponents();
        String[] titulo = new String[]{"Nombre", "Unidad", "Cantidad"};
        dtm.setColumnIdentifiers(titulo);
        tblDatos.setModel(dtm);
         // Configurar el TableRowSorter y asociarlo al modelo de la tabla
        
        // Añadir opciones al comboBox directamente en el código o desde el diseño
        comboOrdenar.addItem("Ordenar por Nombre");
        comboOrdenar.addItem("Ordenar por Cantidad");
        
        // Evento para el JComboBox
        comboOrdenar.addActionListener(e -> ordenarTabla());
    }
    // Método para ordenar la tabla según el criterio seleccionado en el JComboBox
    private void ordenarTabla() {
        String seleccion = (String) comboOrdenar.getSelectedItem();
        
        if ("Ordenar por Nombre".equals(seleccion)) {
            // Ordenar por la columna "Nombre" (índice 0)
            sorter.setComparator(0, Comparator.naturalOrder());
            sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(0, SortOrder.ASCENDING)));
        } else if ("Ordenar por Cantidad".equals(seleccion)) {
            // Ordenar por la columna "Cantidad" (índice 2) de menor a mayor
            sorter.setComparator(2, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));
            sorter.setSortKeys(java.util.List.of(new RowSorter.SortKey(2, SortOrder.ASCENDING)));
        }
    }
    void agregar(){
        String nombre = txtNombre.getText().trim();
        String unidad = txtUnidad.getText().trim();
        String cantidad = txtCantidad.getText().trim();
        if(nombre.isEmpty() || unidad.isEmpty() || cantidad.isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
        // Validación para que `nombre` y `unidad` solo contengan letras
        if (!nombre.matches("[a-zA-Z]+") || !unidad.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Los campos 'Nombre' y 'Unidad' deben contener solo letras.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validación para que `cantidad` sea un número entero
            int cantidadInt = Integer.parseInt(cantidad); // Si no es un número, lanzará una excepción
            Insumo insu = new Insumo(nombre, unidad, cantidadInt);
                gestorInventario.agregarInsumo(insu);

                dtm.addRow(new Object[]{
                txtNombre.getText(),
                txtUnidad.getText(), 
                txtCantidad.getText()});
                    
                txtNombre.setText(null);
                txtUnidad.setText(null);
                txtCantidad.setText(null);
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El campo 'Cantidad' debe contener solo números.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    void eliminar(){
        int fila = tblDatos.getSelectedRow();
        if (fila >= 0) {  // Asegurarse de que haya una fila seleccionada
            // Mostrar cuadro de confirmación
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Estás seguro que deseas eliminar esta fila?",
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                // Si elige "Sí", eliminar la fila
                dtm.removeRow(fila);
                gestorInventario.eliminarInsumo(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }
    
    void actualizar(){
        String nombre = txtNombre.getText().trim();
        String unidad = txtUnidad.getText().trim();
        String cantidad = txtCantidad.getText().trim();
        int fila = tblDatos.getSelectedRow();
        
        if(fila < 0){
            JOptionPane.showMessageDialog(this, "Seleccione una fila para actualizar.");
            return;
        }

        if(nombre.isEmpty() && unidad.isEmpty() && cantidad.isEmpty()){
            JOptionPane.showMessageDialog(this, "Debe ingresar el valor que desea cambiar", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas actualizar esta fila?",
                "Confirmar Actualización",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
            
        if (opcion == JOptionPane.YES_OPTION) {
            try{
            int value = Integer.parseInt(cantidad); 
            gestorInventario.editarInsumo(fila, nombre, unidad, value);
            dtm.setValueAt(txtCantidad.getText(), fila, 3);
            if(!nombre.isEmpty()){
                dtm.setValueAt(txtNombre.getText(), fila, 1);
            }
            if(!unidad.isEmpty()){
                dtm.setValueAt(txtUnidad.getText(), fila, 2);
            }
            
            }catch(NumberFormatException ex){        
                if(!nombre.isEmpty()){
                    dtm.setValueAt(txtNombre.getText(), fila, 1);
                }
                if(!unidad.isEmpty()){
                    dtm.setValueAt(txtUnidad.getText(), fila, 2);
                }
                gestorContabilidad.editarEgresoVariable(fila, nombre, unidad, -1);
            }  
        }

        txtNombre.setText(null);
        txtUnidad.setText(null);
        txtCantidad.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUnidad = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        buttonAñadir = new java.awt.Button();
        buttonEliminar = new java.awt.Button();
        buttonActtualizar = new java.awt.Button();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        comboOrdenar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("Nombre");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 130, 30));

        lblUnidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUnidad.setText("Unidad");
        getContentPane().add(lblUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCantidad.setText("Cantidad");
        getContentPane().add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        txtUnidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 130, 30));

        buttonAñadir.setBackground(new java.awt.Color(204, 153, 255));
        buttonAñadir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonAñadir.setForeground(new java.awt.Color(255, 255, 255));
        buttonAñadir.setLabel("Añadir");
        buttonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 570, 190, 50));

        buttonEliminar.setBackground(new java.awt.Color(204, 153, 255));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEliminar.setLabel("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 200, 50));

        buttonActtualizar.setBackground(new java.awt.Color(204, 153, 255));
        buttonActtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonActtualizar.setForeground(new java.awt.Color(255, 255, 255));
        buttonActtualizar.setLabel("Actualizar");
        buttonActtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonActtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 210, 50));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Inventario");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 230, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 690, 290));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 130, 30));

        comboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenarActionPerformed(evt);
            }
        });
        getContentPane().add(comboOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonActtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActtualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_buttonActtualizarActionPerformed

    private void buttonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirActionPerformed
        agregar();
    }//GEN-LAST:event_buttonAñadirActionPerformed

    private void comboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenarActionPerformed
        
    }//GEN-LAST:event_comboOrdenarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            new MenuInventario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buttonActtualizar;
    private java.awt.Button buttonAñadir;
    private java.awt.Button buttonEliminar;
    private javax.swing.JComboBox<String> comboOrdenar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
