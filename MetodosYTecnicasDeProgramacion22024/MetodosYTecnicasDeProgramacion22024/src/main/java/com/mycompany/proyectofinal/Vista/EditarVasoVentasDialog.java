/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.proyectofinal.Vista;

import com.mycompany.proyectofinal.Controlador.GestorDeVentas;
import com.mycompany.proyectofinal.Modelo.Vaso;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author developerweb
 */
public class EditarVasoVentasDialog extends javax.swing.JDialog {

    private PedidoTemporalDialog parent;
    private GestorDeVentas gestor;
    String parametro;
    String nuevo;
    String nVaso;
    FondoPanel fondo = new FondoPanel();
    public EditarVasoVentasDialog(java.awt.Dialog parent, boolean modal) {
        
        super(parent, modal);
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setSize(1280, 800); // Establece el tamaño fijo de la ventana más grande
        this.setResizable(false); // Hace que la ventana no sea redimensionable
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
        jPanel2 = new javax.swing.JPanel();
        comboBoxParametro = new javax.swing.JComboBox<>();
        comboBoxNVaso = new javax.swing.JComboBox<>();
        mostrarParametro = new javax.swing.JLabel();
        comboBoxNParametro = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        mostrarParametroLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        seleccioneParametroLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        seleccioneNVasoLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        seleccioneParametroNuevoLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        historialVentasLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        historialVentasLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comboBoxParametro.setBackground(new java.awt.Color(153, 153, 255));
        comboBoxParametro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        comboBoxParametro.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione el parametro a editar--", "Tamaño", "Base", "Tipo Boba", "Sabor 1", "Sabor 2" }));
        comboBoxParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxParametroActionPerformed(evt);
            }
        });

        comboBoxNVaso.setBackground(new java.awt.Color(153, 153, 255));
        comboBoxNVaso.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        comboBoxNVaso.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxNVaso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione el Nro de Vaso--" }));
        comboBoxNVaso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNVasoActionPerformed(evt);
            }
        });

        mostrarParametro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mostrarParametro.setText("--------");

        comboBoxNParametro.setBackground(new java.awt.Color(153, 153, 255));
        comboBoxNParametro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        comboBoxNParametro.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione el parametro nuevo--" }));
        comboBoxNParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNParametroActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mostrarParametroLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mostrarParametroLabel.setText("Parametro actual");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mostrarParametroLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mostrarParametroLabel)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccioneParametroLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        seleccioneParametroLabel2.setText("Seleccione el parametro a editar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneParametroLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneParametroLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccioneNVasoLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        seleccioneNVasoLabel1.setText("Ingrese el numero de vaso");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneNVasoLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneNVasoLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seleccioneParametroNuevoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        seleccioneParametroNuevoLabel.setText("Seleccione el parametro nuevo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneParametroNuevoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seleccioneParametroNuevoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrarParametro)
                    .addComponent(comboBoxNParametro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxNVaso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxParametro, 0, 0, Short.MAX_VALUE))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(comboBoxParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBoxNVaso, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mostrarParametro)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxNParametro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        editButton.setBackground(new java.awt.Color(153, 153, 255));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDITAR");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        historialVentasLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        historialVentasLabel.setForeground(new java.awt.Color(153, 153, 255));
        historialVentasLabel.setText("Vaso");

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));

        historialVentasLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        historialVentasLabel1.setForeground(new java.awt.Color(255, 255, 255));
        historialVentasLabel1.setText("Editar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(historialVentasLabel1)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(historialVentasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historialVentasLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historialVentasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxParametroActionPerformed
        parametro = comboBoxParametro.getSelectedItem().toString();
        agregarOpcionesComboBox(parametro);
    }//GEN-LAST:event_comboBoxParametroActionPerformed

    private void comboBoxNVasoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNVasoActionPerformed
        nVaso = comboBoxNVaso.getSelectedItem().toString();
        parametro = comboBoxParametro.getSelectedItem().toString();
        mostrarParametro(nVaso,parametro);
    }//GEN-LAST:event_comboBoxNVasoActionPerformed

    private void comboBoxNParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNParametroActionPerformed
        nuevo = comboBoxNParametro.getSelectedItem().toString();
    }//GEN-LAST:event_comboBoxNParametroActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        gestor.editarInfoVaso(nVaso, nuevo, parametro);
        parent.actualizarTablaEditar(nVaso, nuevo, parametro);
        mostrarParametro(nVaso,parametro);
    }//GEN-LAST:event_editButtonActionPerformed
    
    public void agregarNumerosComboBox() {
        ArrayList<Vaso> vasos=gestor.getPedidoTemporal().getVasos();
        comboBoxNVaso.addItem("--Seleccione el numero de vaso--");
        for(int i=0;i<vasos.size();i++){
            comboBoxNVaso.addItem(i+1+"");
        }
    }
    
    public void editarvaso(GestorDeVentas gestor, PedidoTemporalDialog aThis) {
       parent=aThis;
       this.gestor=gestor;
    }
    private void mostrarParametro(String nVaso,String parametro) {
       String actual = null;
       ArrayList<Vaso> vasos=gestor.getPedidoTemporal().getVasos();
       switch (parametro) {
           case "Tamaño" -> actual = vasos.get(Integer.parseInt(nVaso)-1).getTamVaso();
           case "Base" -> actual = vasos.get(Integer.parseInt(nVaso)-1).getBase();
           case "Tipo Boba" -> actual = vasos.get(Integer.parseInt(nVaso)-1).getTipoBoba();
           case "Sabor 1" -> actual = vasos.get(Integer.parseInt(nVaso)-1).getSabor1();
           case "Sabor 2" -> actual = vasos.get(Integer.parseInt(nVaso)-1).getSabor2();
           default -> vasos.get(Integer.parseInt(nVaso)-1).getTamVaso();
       }
       mostrarParametro.setText(actual);
    }
    private void agregarOpcionesComboBox(String antiguo) {
       switch (antiguo) {
           case "Tamaño" ->comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione tamaño--", "Grande","Mediano" }));
           case "Base" -> comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione base--", "Agua","Leche" }));
           case "Tipo Boba" -> comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione tipo boba--", "Regular","Explosivo" }));
           case "Sabor 1" ->  comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione sabor--", "Chocolate",
                              "Oreo", "Limon", "Maracuya"}));
           case "Sabor 2" -> comboBoxNParametro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione sabor--", "Chocolate",
                              "Oreo", "Limon", "Maracuya", "Ninguno" }));
       }
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
            java.util.logging.Logger.getLogger(EditarVasoVentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarVasoVentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarVasoVentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarVasoVentasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarVasoVentasDialog dialog = new EditarVasoVentasDialog(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxNParametro;
    private javax.swing.JComboBox<String> comboBoxNVaso;
    private javax.swing.JComboBox<String> comboBoxParametro;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel historialVentasLabel;
    private javax.swing.JLabel historialVentasLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel mostrarParametro;
    private javax.swing.JLabel mostrarParametroLabel;
    private javax.swing.JLabel seleccioneNVasoLabel1;
    private javax.swing.JLabel seleccioneParametroLabel2;
    private javax.swing.JLabel seleccioneParametroNuevoLabel;
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
