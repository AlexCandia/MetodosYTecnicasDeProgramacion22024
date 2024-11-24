/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.InicioyRegistro.UsuarioManager;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Interfaz.MenuVentas;
import com.mycompany.proyectofinal.Interfaz.MenuInventario;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class MenuBobaAdmin extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form Menu
     */
    public MenuBobaAdmin() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null); 
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
        InventarioBoton = new javax.swing.JButton();
        ContabilidadBoton = new javax.swing.JButton();
        VentasBoton = new javax.swing.JButton();
        RegistroBoton = new javax.swing.JButton();
        CerrarSesionBoton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1857, 840));

        InventarioBoton.setBackground(new java.awt.Color(153, 153, 255));
        InventarioBoton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        InventarioBoton.setForeground(new java.awt.Color(255, 255, 255));
        InventarioBoton.setText("Inventario");
        InventarioBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioBotonActionPerformed(evt);
            }
        });

        ContabilidadBoton.setBackground(new java.awt.Color(153, 153, 255));
        ContabilidadBoton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ContabilidadBoton.setForeground(new java.awt.Color(255, 255, 255));
        ContabilidadBoton.setText("Contabilidad");
        ContabilidadBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContabilidadBotonActionPerformed(evt);
            }
        });

        VentasBoton.setBackground(new java.awt.Color(153, 153, 255));
        VentasBoton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        VentasBoton.setForeground(new java.awt.Color(255, 255, 255));
        VentasBoton.setText("Ventas");
        VentasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasBotonActionPerformed(evt);
            }
        });

        RegistroBoton.setBackground(new java.awt.Color(0, 204, 204));
        RegistroBoton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        RegistroBoton.setForeground(new java.awt.Color(255, 255, 255));
        RegistroBoton.setText("Registro");
        RegistroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistroBotonActionPerformed(evt);
            }
        });

        CerrarSesionBoton.setBackground(new java.awt.Color(0, 204, 204));
        CerrarSesionBoton.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        CerrarSesionBoton.setForeground(new java.awt.Color(255, 255, 255));
        CerrarSesionBoton.setText("Cerrar Sesión");
        CerrarSesionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarSesionBotonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 90)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Menu");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(InventarioBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(ContabilidadBoton)
                        .addGap(176, 176, 176)
                        .addComponent(VentasBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(RegistroBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(CerrarSesionBoton)
                .addGap(229, 229, 229))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VentasBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContabilidadBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventarioBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(254, 254, 254)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegistroBoton)
                    .addComponent(CerrarSesionBoton))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1256, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InventarioBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioBotonActionPerformed
        // TODO add your handling code here:

        MenuInventario inv = new MenuInventario();
        inv.setCargo("Admin");
        inv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_InventarioBotonActionPerformed

    private void ContabilidadBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContabilidadBotonActionPerformed
        // TODO add your handling code here:
        MenuContabilidad cont = new MenuContabilidad();
        cont.setCargo("Admin");
        cont.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_ContabilidadBotonActionPerformed

    private void VentasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasBotonActionPerformed
        // TODO add your handling code here:

        MenuVentas vent = new MenuVentas();
        vent.setCargo("Admin");
        vent.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VentasBotonActionPerformed

    private void RegistroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistroBotonActionPerformed
        // TODO add your handling code here:

        Registro reg = new Registro(um);
        reg.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_RegistroBotonActionPerformed

    private void CerrarSesionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarSesionBotonActionPerformed
        // TODO add your handling code here:

        InicioDeSesion ini = new InicioDeSesion(um);
        ini.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_CerrarSesionBotonActionPerformed

            UsuarioManager um = new UsuarioManager();

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
            java.util.logging.Logger.getLogger(MenuBobaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuBobaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuBobaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuBobaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuBobaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CerrarSesionBoton;
    private javax.swing.JButton ContabilidadBoton;
    private javax.swing.JButton InventarioBoton;
    private javax.swing.JButton RegistroBoton;
    private javax.swing.JButton VentasBoton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
        private Image imagen;
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/imagen/admin.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
