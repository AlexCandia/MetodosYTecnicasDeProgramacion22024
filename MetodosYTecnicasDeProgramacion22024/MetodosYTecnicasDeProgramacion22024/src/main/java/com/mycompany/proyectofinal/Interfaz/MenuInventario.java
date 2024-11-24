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
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Usuario
 */
public class MenuInventario extends javax.swing.JFrame {
     DefaultTableModel dtm = new DefaultTableModel();
     private TableRowSorter<DefaultTableModel> sorter; // Para ordenar la tabla
     private GestorDeInventario gestorInventario = new GestorDeInventario();
     FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form tabala
     */
    public MenuInventario() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
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
        String minimo = txtMinimo.getText().trim();
        if(nombre.isEmpty() || unidad.isEmpty() || cantidad.isEmpty() || minimo.isEmpty()){
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
            int minimoInt = Integer.parseInt(minimo); 
            Insumo insu = new Insumo(nombre, unidad, cantidadInt, minimoInt);
                gestorInventario.agregarInsumo(insu);

                dtm.addRow(new Object[]{
                txtNombre.getText(),
                txtUnidad.getText(), 
                txtCantidad.getText()});
                    
                txtNombre.setText(null);
                txtUnidad.setText(null);
                txtCantidad.setText(null);
                txtMinimo.setText(null);
                verificarNivelMinimoInventario() ;
        
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El campo 'Cantidad' y 'Limite de producto' debe contener solo números.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
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
    
    public void verificarNivelMinimoInventario() {
        gestorInventario.verificarNivelMinimo();
    }
    
    void actualizar(){
        String nombre = txtNombre.getText().trim();
        String unidad = txtUnidad.getText().trim();
        String cantidad = txtCantidad.getText().trim();
        String minimo = txtMinimo.getText().trim();

        int fila = tblDatos.getSelectedRow();
        
        if(fila < 0){
            JOptionPane.showMessageDialog(this, "Seleccione una fila para actualizar.");
            return;
        }

        if(nombre.isEmpty() && unidad.isEmpty() && cantidad.isEmpty() && minimo.isEmpty()){
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
            int cant;
            int min;   
            if(!nombre.isEmpty()){
                dtm.setValueAt(nombre, fila, 0);
            }
            if(!unidad.isEmpty()){
                dtm.setValueAt(nombre, fila, 1);
            }
            if(!cantidad.isEmpty()){
                try{
                    cant = Integer.parseInt(cantidad);
                    dtm.setValueAt(cantidad, fila,2);
                }catch(NumberFormatException ex){        
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{
                cant = -1;
            }
            if(!minimo.isEmpty()){
                try{
                    min = Integer.parseInt(minimo);
                    
                }catch(NumberFormatException ex){        
                    JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }else{
                min = -1;
            }
            gestorInventario.editarInsumo(fila, nombre, unidad, cant, min);
        }
        
        
        txtNombre.setText(null);
        txtUnidad.setText(null);
        txtCantidad.setText(null);
        txtMinimo.setText(null);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */                                                                             
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        VolverBoton = new java.awt.Button();
        buttonAñadir = new java.awt.Button();
        buttonEliminar = new java.awt.Button();
        buttonActtualizar = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        comboOrdenar = new javax.swing.JComboBox<>();
        ProveedoresBoton = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUnidad = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblMinimo = new javax.swing.JLabel();
        txtMinimo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1857, 840));

        VolverBoton.setBackground(new java.awt.Color(0, 204, 204));
        VolverBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VolverBoton.setForeground(new java.awt.Color(255, 255, 255));
        VolverBoton.setLabel("Volver");
        VolverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverBotonActionPerformed(evt);
            }
        });

        buttonAñadir.setBackground(new java.awt.Color(153, 153, 255));
        buttonAñadir.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonAñadir.setForeground(new java.awt.Color(255, 255, 255));
        buttonAñadir.setLabel("Añadir");
        buttonAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAñadirActionPerformed(evt);
            }
        });

        buttonEliminar.setBackground(new java.awt.Color(153, 153, 255));
        buttonEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        buttonEliminar.setLabel("Eliminar");
        buttonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarActionPerformed(evt);
            }
        });

        buttonActtualizar.setBackground(new java.awt.Color(153, 153, 255));
        buttonActtualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonActtualizar.setForeground(new java.awt.Color(255, 255, 255));
        buttonActtualizar.setLabel("Actualizar");
        buttonActtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActtualizarActionPerformed(evt);
            }
        });

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

        comboOrdenar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenarActionPerformed(evt);
            }
        });

        ProveedoresBoton.setBackground(new java.awt.Color(153, 153, 255));
        ProveedoresBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ProveedoresBoton.setForeground(new java.awt.Color(255, 255, 255));
        ProveedoresBoton.setLabel("Proveedores");
        ProveedoresBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProveedoresBotonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Inventario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lblUnidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblUnidad.setText("Unidad");

        txtUnidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCantidad.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblMinimo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMinimo.setText("Minimo");

        txtMinimo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUnidad)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCantidad)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMinimo)
                    .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblMinimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombre)
                                .addComponent(lblUnidad))
                            .addComponent(lblCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre))))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(ProveedoresBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttonAñadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonActtualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(VolverBoton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ProveedoresBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(buttonActtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(VolverBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverBotonActionPerformed
        // TODO add your handling code here:
        if(cargo.equals("Admin")){
            MenuBobaAdmin menu =  new MenuBobaAdmin();
            menu.setVisible(true);
            this.setVisible(false);
        }else{
            MenuBoba men =  new MenuBoba();
            men.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_VolverBotonActionPerformed

    private void buttonAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAñadirActionPerformed
        agregar();
    }//GEN-LAST:event_buttonAñadirActionPerformed

    private void buttonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_buttonEliminarActionPerformed

    private void buttonActtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActtualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_buttonActtualizarActionPerformed

    private void comboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenarActionPerformed

    }//GEN-LAST:event_comboOrdenarActionPerformed

    private void ProveedoresBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProveedoresBotonActionPerformed
        // TODO add your handling code here:

        Provedor p = new Provedor();
        p.setVisible(true);
    }//GEN-LAST:event_ProveedoresBotonActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimoActionPerformed
    private String cargo;
    public void setCargo(String s){
        cargo = s;
    }
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
    private java.awt.Button ProveedoresBoton;
    private java.awt.Button VolverBoton;
    private java.awt.Button buttonActtualizar;
    private java.awt.Button buttonAñadir;
    private java.awt.Button buttonEliminar;
    private javax.swing.JComboBox<String> comboOrdenar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblMinimo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMinimo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        private Image imagen;
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagen/fondoBlanco.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
