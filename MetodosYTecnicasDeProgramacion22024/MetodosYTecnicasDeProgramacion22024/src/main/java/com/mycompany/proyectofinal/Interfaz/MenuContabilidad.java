/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import com.mycompany.proyectofinal.Ventas.Pedido;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Camila
 */
public class MenuContabilidad extends javax.swing.JFrame {
    FondoPanel fondo = new FondoPanel();

     private DefaultTableModel modeloTabla;
     private GestorDeVentas gestorVentas;
     private GestorDeInventario gestorInventario;
     private GestorDeContabilidad gestorContabilidad;
     
    /**
     * Creates new form Conta
     */
    public MenuContabilidad() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setSize(1280, 800); // Establece el tamaño fijo de la ventana más grande
        this.setResizable(false); // Hace que la ventana no sea redimensionable
        gestorInventario = new GestorDeInventario();
        gestorContabilidad = new GestorDeContabilidad(gestorInventario);
         gestorVentas = new GestorDeVentas(gestorInventario,gestorContabilidad);
        fijarParametrosEconomicos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new FondoPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        egresosFijosLabel = new javax.swing.JLabel();
        egresosVariablesLabel = new javax.swing.JLabel();
        ingresosLabel = new javax.swing.JLabel();
        ingresosNumero = new javax.swing.JLabel();
        egresosFijosNumero = new javax.swing.JLabel();
        egresosVariablesNumero = new javax.swing.JLabel();
        egresosInsumosLabel = new javax.swing.JLabel();
        egresosInsumosNumero = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblResultado = new javax.swing.JLabel();
        miGrafica = new javax.swing.JPanel();
        Reportes1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        VolverBoton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        botonAgregarEgresoFijo = new javax.swing.JButton();
        botonAgregarEgresoVariable = new javax.swing.JButton();
        botonAgregarEgresoInsumo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        egresoFijoo = new javax.swing.JTextField();
        egresoInsumoo = new javax.swing.JTextField();
        egresoVariableOtro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Ingresos / Egresos");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gestion de");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        egresosFijosLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosFijosLabel.setForeground(new java.awt.Color(102, 102, 102));
        egresosFijosLabel.setText("Egresos Fijos:   ");

        egresosVariablesLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosVariablesLabel.setForeground(new java.awt.Color(102, 102, 102));
        egresosVariablesLabel.setText("Egresos Variables: ");

        ingresosLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ingresosLabel.setForeground(new java.awt.Color(102, 102, 102));
        ingresosLabel.setText("Ingresos:      ");

        ingresosNumero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ingresosNumero.setForeground(new java.awt.Color(102, 102, 102));

        egresosFijosNumero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosFijosNumero.setForeground(new java.awt.Color(102, 102, 102));

        egresosVariablesNumero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosVariablesNumero.setForeground(new java.awt.Color(102, 102, 102));

        egresosInsumosLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosInsumosLabel.setForeground(new java.awt.Color(102, 102, 102));
        egresosInsumosLabel.setText("Egresos Insumos: ");

        egresosInsumosNumero.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        egresosInsumosNumero.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ingresosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(176, 176, 176))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(egresosFijosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(egresosVariablesLabel)
                            .addComponent(egresosInsumosLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(egresosInsumosNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(egresosVariablesNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(egresosFijosNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ingresosNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ingresosNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(egresosFijosNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(egresosFijosLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(egresosVariablesNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(egresosVariablesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(egresosInsumosLabel)
                    .addComponent(egresosInsumosNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btnCalcular.setBackground(new java.awt.Color(153, 153, 255));
        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("Calcular ");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Situacion Actual:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        miGrafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout miGraficaLayout = new javax.swing.GroupLayout(miGrafica);
        miGrafica.setLayout(miGraficaLayout);
        miGraficaLayout.setHorizontalGroup(
            miGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        miGraficaLayout.setVerticalGroup(
            miGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        Reportes1.setBackground(new java.awt.Color(0, 204, 204));
        Reportes1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Reportes1.setForeground(new java.awt.Color(255, 255, 255));
        Reportes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reporte Mensual", "Reporte Historico" }));
        Reportes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reportes1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Registar Egresos");

        VolverBoton.setBackground(new java.awt.Color(0, 204, 204));
        VolverBoton.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        VolverBoton.setForeground(new java.awt.Color(255, 255, 255));
        VolverBoton.setText("Menu");
        VolverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverBotonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 255));
        jLabel11.setText("Contabilidad");

        botonAgregarEgresoFijo.setBackground(new java.awt.Color(153, 153, 255));
        botonAgregarEgresoFijo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        botonAgregarEgresoFijo.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarEgresoFijo.setText("Egreso Fijo");
        botonAgregarEgresoFijo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarEgresoFijoActionPerformed(evt);
            }
        });

        botonAgregarEgresoVariable.setBackground(new java.awt.Color(153, 153, 255));
        botonAgregarEgresoVariable.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        botonAgregarEgresoVariable.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarEgresoVariable.setText("Egreso Variable");
        botonAgregarEgresoVariable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarEgresoVariableActionPerformed(evt);
            }
        });

        botonAgregarEgresoInsumo.setBackground(new java.awt.Color(153, 153, 255));
        botonAgregarEgresoInsumo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        botonAgregarEgresoInsumo.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarEgresoInsumo.setText("Egreso Insumo");
        botonAgregarEgresoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarEgresoInsumoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Graficar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Chocolate");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Frutilla");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Mora");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(egresoInsumoo, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addComponent(egresoVariableOtro))
                    .addComponent(egresoFijoo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(egresoInsumoo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(egresoFijoo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(egresoVariableOtro, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Sabores mas vendidos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonAgregarEgresoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(botonAgregarEgresoFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonAgregarEgresoInsumo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)))
                                .addGap(256, 256, 256)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(miGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(Reportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VolverBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(miGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VolverBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reportes1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAgregarEgresoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarEgresoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarEgresoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        try {
            double numero1 = Double.parseDouble(ingresosNumero.getText());
            double numero2 = Double.parseDouble(egresosFijosNumero.getText());
            double numero3 = Double.parseDouble(egresosVariablesNumero.getText());
            double numero4 = Double.parseDouble(egresosInsumosNumero.getText());
            double resultado = numero1 - numero2 - numero3 - numero4;

            if (resultado == 0.0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Aún no existen ingresos.");
            } else {
                lblResultado.setText(""+resultado);
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Error: valores no válidos en etiquetas.");
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void Reportes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reportes1ActionPerformed
        // TODO add your handling code here:
        //String s = Reportes.getSelectedItem().toString();
    }//GEN-LAST:event_Reportes1ActionPerformed

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

    private void botonAgregarEgresoVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoVariableActionPerformed
        EgresosVariables e = new EgresosVariables(gestorContabilidad);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoVariableActionPerformed

    private void botonAgregarEgresoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoInsumoActionPerformed
        EgresosInsumos e = new EgresosInsumos(gestorContabilidad);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoInsumoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int egresoFijo = Integer.parseInt(egresoFijoo.getText());
        int egresoVariable = Integer.parseInt(egresoVariableOtro.getText());
        int egresoInsumo = Integer.parseInt(egresoInsumoo.getText());
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(egresoFijo,"Sabor1","Chocolate");
        datos.setValue(egresoVariable,"Sabor2","Mora");
        datos.setValue(egresoInsumo,"Sabor3","Frutilla");
        JFreeChart grafico_barras = ChartFactory.createBarChart(
            "Boba Queen",
            "Sabores",
            "Vasos",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        ChartPanel panel = new ChartPanel(grafico_barras);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(400,300));

        miGrafica.setLayout(new BorderLayout());
        miGrafica.add(panel,BorderLayout.NORTH);

        pack();
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonAgregarEgresoFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoFijoActionPerformed
        EgresosFijos e = new EgresosFijos(gestorContabilidad);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoFijoActionPerformed

    private String cargo;
    public void setCargo(String s){
        cargo = s;
    }
    private void fijarParametrosEconomicos(){
        double ingresos = gestorVentas.calcularIngresosTotales();
        double egresosFijos =gestorContabilidad.calcularTotalEgresosFijos();
        double egresosVariables =gestorContabilidad.calcularTotalEgresosVariables();
        double egresosInsumos =gestorContabilidad.calcularTotalEgresosInsumos();
        
        
        ingresosNumero.setText(ingresos+"");
        egresosFijosNumero.setText(egresosFijos+"");
        egresosVariablesNumero.setText(egresosVariables+"");
        egresosInsumosNumero.setText(egresosInsumos+"");
        
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
            java.util.logging.Logger.getLogger(MenuContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuContabilidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Reportes1;
    private javax.swing.JButton VolverBoton;
    private javax.swing.JButton botonAgregarEgresoFijo;
    private javax.swing.JButton botonAgregarEgresoInsumo;
    private javax.swing.JButton botonAgregarEgresoVariable;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JTextField egresoFijoo;
    private javax.swing.JTextField egresoInsumoo;
    private javax.swing.JTextField egresoVariableOtro;
    private javax.swing.JLabel egresosFijosLabel;
    private javax.swing.JLabel egresosFijosNumero;
    private javax.swing.JLabel egresosInsumosLabel;
    private javax.swing.JLabel egresosInsumosNumero;
    private javax.swing.JLabel egresosVariablesLabel;
    private javax.swing.JLabel egresosVariablesNumero;
    private javax.swing.JLabel ingresosLabel;
    private javax.swing.JLabel ingresosNumero;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JPanel miGrafica;
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
