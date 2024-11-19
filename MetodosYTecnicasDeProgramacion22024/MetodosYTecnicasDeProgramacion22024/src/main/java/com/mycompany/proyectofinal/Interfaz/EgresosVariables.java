/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;

import com.mycompany.proyectofinal.Contabilidad.EgresoFijo;
import com.mycompany.proyectofinal.Contabilidad.EgresoVariable;
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class EgresosVariables extends javax.swing.JFrame {
     DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form tabala
     */
     
     //Solo es para las pruebas se debe borrar
    GestorDeInventario gestorInventario = new GestorDeInventario();
    GestorDeVentas gestorVentas = new GestorDeVentas(gestorInventario);
    GestorDeContabilidad gestorContabilidad = new GestorDeContabilidad(gestorInventario,gestorVentas);
     
    public EgresosVariables() {
        initComponents();
        String[] titulo = new String[]{"Fecha","Nombre", "Detalle", "Valor"};
        dtm.setColumnIdentifiers(titulo);
        tblDatos.setModel(dtm);
    }
    
    void agregar(){
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaActual = fecha.format(new Date());
        
        String nombre = txtNombre.getText().trim();
        String detalle = txtDetalle.getText().trim();
        String valor = txtValor.getText().trim();
        
        if(detalle.isEmpty() || valor.isEmpty() || nombre.isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            try{
                Double value = Double.parseDouble(valor);
                
                EgresoVariable egreso = new EgresoVariable(fechaActual, nombre, detalle, value);
                gestorContabilidad.registrarEgresoVariable(egreso);
                calcularTotal();
                    
                dtm.addRow(new Object[]{fechaActual, 
                txtNombre.getText(),
                txtDetalle.getText(), 
                txtValor.getText()});
                    
                txtNombre.setText(null);
                txtValor.setText(null);
                txtDetalle.setText(null);
                
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Ingrese un valor valido", "Error de entrada", JOptionPane.ERROR_MESSAGE);
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
                gestorContabilidad.eliminarEgresoVariable(fila);
                calcularTotal();    
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }
    
    void actualizar(){
        String nombre = txtNombre.getText().trim();
        String detalle = txtDetalle.getText().trim();
        String valor = txtValor.getText().trim();
        int fila = tblDatos.getSelectedRow();
        
        if(fila < 0){
            JOptionPane.showMessageDialog(this, "Seleccione una fila para actualizar.");
            return;
        }

        if(nombre.isEmpty() && detalle.isEmpty() && valor.isEmpty()){
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
            Double value = Double.parseDouble(valor);
            gestorContabilidad.editarEgresoVariable(fila, nombre, detalle, value);
            
            dtm.setValueAt(txtValor.getText(), fila, 3);
            if(!nombre.isEmpty()){
                dtm.setValueAt(txtNombre.getText(), fila, 1);
            }
            if(!detalle.isEmpty()){
                dtm.setValueAt(txtDetalle.getText(), fila, 2);
            }
            
            }catch(NumberFormatException ex){        
                if(!nombre.isEmpty()){
                    dtm.setValueAt(txtNombre.getText(), fila, 1);
                }
                if(!detalle.isEmpty()){
                    dtm.setValueAt(txtDetalle.getText(), fila, 2);
                }
                gestorContabilidad.editarEgresoVariable(fila, nombre, detalle, -1);
            }  
        }
        
        calcularTotal();

        txtNombre.setText(null);
        txtValor.setText(null);
        txtDetalle.setText(null);
    }
    
    public void calcularTotal(){
        String text;
        text = Double.toString(gestorContabilidad.calcularTotalEgresosVariables());
        valorTotal.setText(text);
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
        lblValor = new javax.swing.JLabel();
        lblDetalle = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtDetalle = new javax.swing.JTextField();
        buttonAñadir = new java.awt.Button();
        buttonEliminar = new java.awt.Button();
        buttonActtualizar = new java.awt.Button();
        TituloColor = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        valorTotal = new javax.swing.JLabel();
        VolverBoton = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblValor.setText("Valor");

        lblDetalle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDetalle.setText("Detalle");

        txtValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        buttonAñadir.setBackground(new java.awt.Color(204, 153, 255));
        buttonAñadir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonAñadir.setForeground(new java.awt.Color(255, 255, 255));
        buttonAñadir.setLabel("Añadir");
        buttonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirActionPerformed(evt);
            }
        });

        buttonEliminar.setBackground(new java.awt.Color(204, 153, 255));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEliminar.setLabel("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonActtualizar.setBackground(new java.awt.Color(204, 153, 255));
        buttonActtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonActtualizar.setForeground(new java.awt.Color(255, 255, 255));
        buttonActtualizar.setLabel("Actualizar");
        buttonActtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActtualizarActionPerformed(evt);
            }
        });

        TituloColor.setBackground(new java.awt.Color(204, 153, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Variable");

        javax.swing.GroupLayout TituloColorLayout = new javax.swing.GroupLayout(TituloColor);
        TituloColor.setLayout(TituloColorLayout);
        TituloColorLayout.setHorizontalGroup(
            TituloColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TituloColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        TituloColorLayout.setVerticalGroup(
            TituloColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TituloColorLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Egreso");

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

        jLabel1.setText("Total");

        valorTotal.setText("0");

        VolverBoton.setBackground(new java.awt.Color(204, 153, 255));
        VolverBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VolverBoton.setForeground(new java.awt.Color(255, 255, 255));
        VolverBoton.setLabel("Volver");
        VolverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(valorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(182, 182, 182)
                        .addComponent(lblDetalle)))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonActtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(TituloColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VolverBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TituloColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo)
                    .addComponent(VolverBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblDetalle)
                    .addComponent(lblValor))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(valorTotal))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonActtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

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

    private void VolverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverBotonActionPerformed
        // TODO add your handling code here:
        
        MenuContabilidad men = new MenuContabilidad();
        men.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VolverBotonActionPerformed

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
            java.util.logging.Logger.getLogger(EgresosVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EgresosVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EgresosVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EgresosVariables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(() -> {
            new EgresosVariables().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TituloColor;
    private java.awt.Button VolverBoton;
    private java.awt.Button buttonActtualizar;
    private java.awt.Button buttonAñadir;
    private java.awt.Button buttonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtValor;
    private javax.swing.JLabel valorTotal;
    // End of variables declaration//GEN-END:variables
}
