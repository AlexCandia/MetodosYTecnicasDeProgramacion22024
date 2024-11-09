/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;

import com.mycompany.proyectofinal.Ventas.Pedido;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author developerweb
 */
public class HistorialVentasFrame extends javax.swing.JFrame {

   private HashMap<String, Pedido> ventasHistoricas;
   private DefaultTableModel dtm;
    public HistorialVentasFrame() {
        initComponents();
        dtm=(DefaultTableModel)tablaHistorialVentas.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        historialVentasLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorialVentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        historialVentasLabel.setText("Historial de Ventas");

        tablaHistorialVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo de venta", "Fecha", "Nro Pedido", "Nombre cliente", "Nit Cliente", "Numero de Vasos", "Total cancelado"
            }
        ));
        jScrollPane1.setViewportView(tablaHistorialVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(historialVentasLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(historialVentasLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HistorialVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistorialVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistorialVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistorialVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistorialVentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel historialVentasLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaHistorialVentas;
    // End of variables declaration//GEN-END:variables
    public void recibirMap(HashMap<String,Pedido> ventas){
        ventasHistoricas=ventas;
    }
    public void rellenarVentas() {
        if(ventasHistoricas!=null){
            for (Map.Entry<String, Pedido> entry : ventasHistoricas.entrySet()) {
                String clave = entry.getKey();
                Pedido pedido = entry.getValue();

                // Obtener los atributos de Pedido (suponiendo que tiene métodos get)
                Date fecha = pedido.getFecha();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = formatoFecha.format(fecha);
                String nroPedido = pedido.getNumPedido();
                String nombreCliente = pedido.getNombre();
                String nitCliente = pedido.getNit();
                String nroVasos = pedido.getVasos().size()+"";
                String total = pedido.getTotal();

                // Añadir una fila al modelo de la tabla
                dtm.addRow(new Object[]{clave, fechaFormateada, nroPedido,nombreCliente,nitCliente,nroVasos,total});
            }
        }
    }
}
