/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Interfaz.PantallaPrincipalVentas;
import com.mycompany.proyectofinal.Interfaz.JFramePrincipal;

/**
 *
 * @author Usuario
 */
public class MenuBoba extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuBoba() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        ContabilidadBoton = new javax.swing.JButton();
        InventarioBoton = new javax.swing.JButton();
        VentasBoton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 50, 50));

        ContabilidadBoton.setBackground(new java.awt.Color(204, 204, 255));
        ContabilidadBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ContabilidadBoton.setForeground(new java.awt.Color(255, 255, 255));
        ContabilidadBoton.setText("Contabilidad");
        ContabilidadBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContabilidadBotonActionPerformed(evt);
            }
        });
        getContentPane().add(ContabilidadBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 180, 60));

        InventarioBoton.setBackground(new java.awt.Color(204, 204, 255));
        InventarioBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        InventarioBoton.setForeground(new java.awt.Color(255, 255, 255));
        InventarioBoton.setText("Inventario");
        InventarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioBotonActionPerformed(evt);
            }
        });
        getContentPane().add(InventarioBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 180, 60));

        VentasBoton.setBackground(new java.awt.Color(204, 204, 255));
        VentasBoton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VentasBoton.setForeground(new java.awt.Color(255, 255, 255));
        VentasBoton.setText("Ventas");
        VentasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasBotonActionPerformed(evt);
            }
        });
        getContentPane().add(VentasBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 160, 60));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        jLabel3.setText("Menu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 130, 60));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioBotonActionPerformed
        // TODO add your handling code here:
        
        JFramePrincipal inv = new JFramePrincipal();
        inv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InventarioBotonActionPerformed

    private void ContabilidadBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContabilidadBotonActionPerformed
        // TODO add your handling code here:
        Conta cont = new Conta();
        cont.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_ContabilidadBotonActionPerformed

    private void VentasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasBotonActionPerformed
        // TODO add your handling code here:
        
        PantallaPrincipalVentas vent = new PantallaPrincipalVentas();
        vent.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VentasBotonActionPerformed

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
            java.util.logging.Logger.getLogger(MenuBoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBoba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBoba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ContabilidadBoton;
    private javax.swing.JButton InventarioBoton;
    private javax.swing.JButton VentasBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
