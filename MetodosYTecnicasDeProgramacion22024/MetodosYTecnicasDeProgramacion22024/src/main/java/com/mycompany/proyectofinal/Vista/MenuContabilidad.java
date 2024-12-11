/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Vista;
import com.mycompany.proyectofinal.Controlador.GestorDeContabilidad;
import com.mycompany.proyectofinal.Controlador.GestorDeInventario;
import com.mycompany.proyectofinal.Controlador.GestorDeVentas;
import com.mycompany.proyectofinal.Modelo.Pedido;
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

     private DefaultTableModel modeloTabla;
     String[] masVendidos;
     private GestorDeVentas gestorVentas;
     private GestorDeInventario gestorInventario;
     private GestorDeContabilidad gestorContabilidad;
     FondoPanel fondo = new FondoPanel();
    /**
     * Creates new form Conta
     */
    public MenuContabilidad() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null); 
        this.setSize(1280, 800); 
        this.setResizable(false); 
        gestorInventario = new GestorDeInventario();
        gestorContabilidad = new GestorDeContabilidad(gestorInventario);
        gestorVentas = new GestorDeVentas(gestorInventario,gestorContabilidad);
        fijarParametrosEconomicos();
        fijarSaboresMasVendidos();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonAgregarEgresoFijo = new javax.swing.JButton();
        botonAgregarEgresoVariable = new javax.swing.JButton();
        botonAgregarEgresoInsumo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        sabor1Label = new javax.swing.JLabel();
        sabor2Label = new javax.swing.JLabel();
        sabor3Label = new javax.swing.JLabel();
        sabor2 = new javax.swing.JTextField();
        sabor1 = new javax.swing.JTextField();
        sabor3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        graficarButton = new javax.swing.JButton();
        VolverBoton1 = new javax.swing.JButton();
        generarReporteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setPreferredSize(new java.awt.Dimension(1280, 800));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Ingresos / Egresos");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gestion de");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
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
                .addContainerGap(24, Short.MAX_VALUE))
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel9.setText("Situacion Actual:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblResultado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblResultado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Registar Egresos");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
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

        sabor1Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sabor1Label.setText("Chocolate");

        sabor2Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sabor2Label.setText("Frutilla");

        sabor3Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sabor3Label.setText("Mora");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sabor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sabor2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sabor1Label)
                    .addComponent(sabor1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sabor2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sabor2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sabor3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(sabor3Label))
                .addGap(17, 17, 17))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel13.setText("Sabores mas vendidos");

        graficarButton.setBackground(new java.awt.Color(153, 153, 255));
        graficarButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        graficarButton.setForeground(new java.awt.Color(255, 255, 255));
        graficarButton.setText("Graficar");
        graficarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficarButtonActionPerformed(evt);
            }
        });

        VolverBoton1.setBackground(new java.awt.Color(0, 204, 204));
        VolverBoton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VolverBoton1.setForeground(new java.awt.Color(255, 255, 255));
        VolverBoton1.setText("Menu");
        VolverBoton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverBoton1ActionPerformed(evt);
            }
        });

        generarReporteButton.setBackground(new java.awt.Color(0, 204, 204));
        generarReporteButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        generarReporteButton.setForeground(new java.awt.Color(255, 255, 255));
        generarReporteButton.setText("Generar Reporte");
        generarReporteButton.setMaximumSize(new java.awt.Dimension(96, 39));
        generarReporteButton.setMinimumSize(new java.awt.Dimension(96, 39));
        generarReporteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(botonAgregarEgresoFijo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botonAgregarEgresoInsumo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(botonAgregarEgresoVariable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(279, 279, 279))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(73, 73, 73)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(graficarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(miGrafica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(324, 324, 324))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(generarReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(1056, Short.MAX_VALUE)
                    .addComponent(VolverBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(generarReporteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel5)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(miGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregarEgresoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(botonAgregarEgresoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarEgresoVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graficarButton)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(80, 80, 80))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(VolverBoton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(712, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botonAgregarEgresoVariableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoVariableActionPerformed
        EgresosVariables e = new EgresosVariables(gestorContabilidad,this);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoVariableActionPerformed

    private void botonAgregarEgresoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoInsumoActionPerformed
        EgresosInsumos e = new EgresosInsumos(gestorContabilidad,this);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoInsumoActionPerformed

    private void graficarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficarButtonActionPerformed

        int egresoFijo = Integer.parseInt(sabor1.getText());
        int egresoVariable = Integer.parseInt(sabor2.getText());
        int egresoInsumo = Integer.parseInt(sabor3.getText());
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String primerSabor=masVendidos[0];
        String segundoSabor=masVendidos[1];
        String tercerSabor=masVendidos[2];
        if(primerSabor!=null){
            datos.setValue(egresoFijo,primerSabor.substring(0, primerSabor.length()-1),"0");
        }else{
            datos.setValue(egresoFijo,"-----","0");
        }
        if(segundoSabor!=null){
            datos.setValue(egresoVariable,segundoSabor.substring(0, segundoSabor.length()-1),"0");
        }else{
            datos.setValue(egresoVariable,"-----","0");
        }
        if(tercerSabor!=null){
            datos.setValue(egresoInsumo,tercerSabor.substring(0, tercerSabor.length()-1),"0");
        }else{
            datos.setValue(egresoInsumo,"-----","0");
        }
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
    }//GEN-LAST:event_graficarButtonActionPerformed

    private void botonAgregarEgresoFijoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEgresoFijoActionPerformed
        EgresosFijos e = new EgresosFijos(gestorContabilidad,this);
        e.setVisible(true);
    }//GEN-LAST:event_botonAgregarEgresoFijoActionPerformed

    private void VolverBoton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverBoton1ActionPerformed
        MenuBobaAdmin menu =  new MenuBobaAdmin();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_VolverBoton1ActionPerformed

    private void generarReporteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteButtonActionPerformed
        gestorContabilidad.guardarReporteHistorico(gestorVentas.calcularIngresosTotales());
    }//GEN-LAST:event_generarReporteButtonActionPerformed

    private String cargo;
    public void setCargo(String s){
        cargo = s;
    }
    public void fijarParametrosEconomicos(){
        double ingresos = gestorVentas.calcularIngresosTotales();
        double egresosFijos =gestorContabilidad.calcularTotalEgresosFijos();
        double egresosVariables =gestorContabilidad.calcularTotalEgresosVariables();
        double egresosInsumos =gestorContabilidad.calcularTotalEgresosInsumos();
        
        
        ingresosNumero.setText(ingresos+"");
        egresosFijosNumero.setText(egresosFijos+"");
        egresosVariablesNumero.setText(egresosVariables+"");
        egresosInsumosNumero.setText(egresosInsumos+"");
        
    }
    private void fijarSaboresMasVendidos(){
        sabor1.setText("0");
        sabor2.setText("0");
        sabor3.setText("0");
        masVendidos=gestorVentas.calcularSaboresMasVendidos();
        String primerSabor=masVendidos[0];
        String segundoSabor=masVendidos[1];
        String tercerSabor=masVendidos[2];
        if(primerSabor!=null){
            int l=primerSabor.length()-1;
            sabor1Label.setText(primerSabor.substring(0,l));
            sabor1.setText(primerSabor.charAt(l)+"");
        }
        if(segundoSabor!=null){
            int l=segundoSabor.length()-1;
            sabor2Label.setText(segundoSabor.substring(0,l));
            sabor2.setText(segundoSabor.charAt(l)+"");
        }
        if(tercerSabor!=null){
            int l=tercerSabor.length()-1;
            sabor3Label.setText(tercerSabor.substring(0,l));
            sabor3.setText(tercerSabor.charAt(l)+"");
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
    private javax.swing.JButton VolverBoton1;
    private javax.swing.JButton botonAgregarEgresoFijo;
    private javax.swing.JButton botonAgregarEgresoInsumo;
    private javax.swing.JButton botonAgregarEgresoVariable;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel egresosFijosLabel;
    private javax.swing.JLabel egresosFijosNumero;
    private javax.swing.JLabel egresosInsumosLabel;
    private javax.swing.JLabel egresosInsumosNumero;
    private javax.swing.JLabel egresosVariablesLabel;
    private javax.swing.JLabel egresosVariablesNumero;
    private javax.swing.JButton generarReporteButton;
    private javax.swing.JButton graficarButton;
    private javax.swing.JLabel ingresosLabel;
    private javax.swing.JLabel ingresosNumero;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField sabor1;
    private javax.swing.JLabel sabor1Label;
    private javax.swing.JTextField sabor2;
    private javax.swing.JLabel sabor2Label;
    private javax.swing.JTextField sabor3;
    private javax.swing.JLabel sabor3Label;
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
