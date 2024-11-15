/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;

import javax.swing.JOptionPane;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import com.mycompany.proyectofinal.Ventas.Pedido;
import com.mycompany.proyectofinal.Ventas.Vaso;
import com.mycompany.proyectofinal.Ventas.VasoEnCola;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camila
 */
public class MenuVentas extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipalVentas
     */
    String tamaño="";
    String base="";
    String tipoBoba="";
    String sabor1="";
    String sabor2="";
    String nombreCliente;
    String nit;
    private Object [] o = new Object[8];
    GestorDeVentas gestorVentas;
    GestorDeInventario inventario;
    PedidoTemporalDialog temp;
    HistorialVentasFrame histo;
    private DefaultTableModel dtm;
    public MenuVentas() {
        initComponents();
        inventario = new GestorDeInventario();
        gestorVentas = new GestorDeVentas(inventario);
        temp = new PedidoTemporalDialog(this,true);
        histo = new HistorialVentasFrame();
        histo.rellenarVentas();
        dtm=(DefaultTableModel)ColaDePedidos.getModel();
        mandargestor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        MenuButton = new javax.swing.JButton();
        HistorialButton = new javax.swing.JButton();
        terminarDiaButton = new javax.swing.JButton();
        VasoTerminadoButton = new javax.swing.JButton();
        InformacionLabel = new javax.swing.JLabel();
        NombreClienteDetalleLabel = new javax.swing.JLabel();
        NroPedidoDetalleLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NombreLabel = new javax.swing.JLabel();
        NitLabel = new javax.swing.JLabel();
        NameField = new javax.swing.JFormattedTextField();
        NitField = new javax.swing.JFormattedTextField();
        ConfirmarDatosButton = new javax.swing.JButton();
        NuevoClienteButton = new javax.swing.JButton();
        DetallesPanel = new javax.swing.JPanel();
        NroVasoLabel = new javax.swing.JLabel();
        TamVasoLabel = new javax.swing.JLabel();
        BaseLabel = new javax.swing.JLabel();
        TipoBobaLabel = new javax.swing.JLabel();
        Sabor1Label = new javax.swing.JLabel();
        Sabor2Label = new javax.swing.JLabel();
        Sabor2Box = new javax.swing.JComboBox<>();
        BaseBox = new javax.swing.JComboBox<>();
        TipoBobaBox = new javax.swing.JComboBox<>();
        TamañoBox = new javax.swing.JComboBox<>();
        Sabor1Box = new javax.swing.JComboBox<>();
        NroVasoContador = new javax.swing.JLabel();
        VerPedidoButton = new javax.swing.JButton();
        AgregarVasoButton = new javax.swing.JButton();
        DetallesLabel = new javax.swing.JLabel();
        NombreClienteDetalle = new javax.swing.JLabel();
        NroPedidoDetalle = new javax.swing.JLabel();
        gestorDeVentasLabel = new javax.swing.JLabel();
        colaDePedidosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ColaDePedidos = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuButton.setBackground(new java.awt.Color(204, 204, 255));
        MenuButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MenuButton.setForeground(new java.awt.Color(255, 255, 255));
        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(MenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 360, 70));

        HistorialButton.setBackground(new java.awt.Color(204, 204, 255));
        HistorialButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HistorialButton.setForeground(new java.awt.Color(255, 255, 255));
        HistorialButton.setText("Historial de \nventas");
        HistorialButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        HistorialButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HistorialButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 400, 70));

        terminarDiaButton.setBackground(new java.awt.Color(204, 204, 255));
        terminarDiaButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        terminarDiaButton.setForeground(new java.awt.Color(255, 255, 255));
        terminarDiaButton.setText("Terminar Dia");
        terminarDiaButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        terminarDiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarDiaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(terminarDiaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 630, 420, 70));

        VasoTerminadoButton.setBackground(new java.awt.Color(204, 204, 255));
        VasoTerminadoButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VasoTerminadoButton.setForeground(new java.awt.Color(255, 255, 255));
        VasoTerminadoButton.setText("Vaso Terminado"); // NOI18N
        VasoTerminadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VasoTerminadoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VasoTerminadoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 260, 40));

        InformacionLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InformacionLabel.setText("INFORMACION CIENTE:");
        getContentPane().add(InformacionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        NombreClienteDetalleLabel.setBackground(new java.awt.Color(204, 204, 255));
        NombreClienteDetalleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombreClienteDetalleLabel.setText("Cliente :");
        getContentPane().add(NombreClienteDetalleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        NroPedidoDetalleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NroPedidoDetalleLabel.setText("Nro Pedido:");
        getContentPane().add(NroPedidoDetalleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NombreLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NombreLabel.setForeground(new java.awt.Color(102, 102, 102));
        NombreLabel.setText("Nombre:");

        NitLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NitLabel.setForeground(new java.awt.Color(102, 102, 102));
        NitLabel.setText("Nit:");

        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        NitField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NitFieldActionPerformed(evt);
            }
        });

        ConfirmarDatosButton.setBackground(new java.awt.Color(204, 204, 255));
        ConfirmarDatosButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ConfirmarDatosButton.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmarDatosButton.setText("CONFIRMAR DATOS");
        ConfirmarDatosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarDatosButtonActionPerformed(evt);
            }
        });

        NuevoClienteButton.setBackground(new java.awt.Color(204, 204, 255));
        NuevoClienteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NuevoClienteButton.setForeground(new java.awt.Color(255, 255, 255));
        NuevoClienteButton.setText("NUEVO CLIENTE");
        NuevoClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoClienteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NombreLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NitField, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NuevoClienteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConfirmarDatosButton)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NitLabel)
                    .addComponent(NitField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmarDatosButton)
                    .addComponent(NuevoClienteButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 410, 140));

        DetallesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        DetallesPanel.setForeground(new java.awt.Color(204, 153, 255));

        NroVasoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NroVasoLabel.setForeground(new java.awt.Color(102, 102, 102));
        NroVasoLabel.setText("Numero de Vaso:");

        TamVasoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TamVasoLabel.setForeground(new java.awt.Color(102, 102, 102));
        TamVasoLabel.setText("Tamaño Vaso:");

        BaseLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BaseLabel.setForeground(new java.awt.Color(102, 102, 102));
        BaseLabel.setText("Base:");

        TipoBobaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TipoBobaLabel.setForeground(new java.awt.Color(102, 102, 102));
        TipoBobaLabel.setText("Tipo de Boba:");

        Sabor1Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sabor1Label.setForeground(new java.awt.Color(102, 102, 102));
        Sabor1Label.setText("Sabor 1:");

        Sabor2Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Sabor2Label.setForeground(new java.awt.Color(102, 102, 102));
        Sabor2Label.setText("Sabor 2:");

        Sabor2Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione sabor--", "Chocolate", "Oreo", "Limon", "Maracuya", "Ninguno" }));
        Sabor2Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sabor2BoxActionPerformed(evt);
            }
        });

        BaseBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione Base--", "Agua", "Leche" }));
        BaseBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseBoxActionPerformed(evt);
            }
        });

        TipoBobaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione Tipo Boba--", "Regular", "Explosivo" }));
        TipoBobaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoBobaBoxActionPerformed(evt);
            }
        });

        TamañoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione Tamaño--", "Grande", "Mediano" }));
        TamañoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TamañoBoxActionPerformed(evt);
            }
        });

        Sabor1Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione sabor--", "Chocolate", "Menta", "Oreo" }));
        Sabor1Box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sabor1BoxActionPerformed(evt);
            }
        });

        NroVasoContador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NroVasoContador.setText("-----");

        javax.swing.GroupLayout DetallesPanelLayout = new javax.swing.GroupLayout(DetallesPanel);
        DetallesPanel.setLayout(DetallesPanelLayout);
        DetallesPanelLayout.setHorizontalGroup(
            DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetallesPanelLayout.createSequentialGroup()
                        .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Sabor1Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TamVasoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BaseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TipoBobaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Sabor2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sabor2Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DetallesPanelLayout.createSequentialGroup()
                                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Sabor1Box, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TipoBobaBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 201, Short.MAX_VALUE)
                                    .addComponent(BaseBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TamañoBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(41, 41, 41))
                    .addGroup(DetallesPanelLayout.createSequentialGroup()
                        .addComponent(NroVasoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(NroVasoContador)
                        .addGap(0, 185, Short.MAX_VALUE))))
        );
        DetallesPanelLayout.setVerticalGroup(
            DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetallesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NroVasoLabel)
                    .addComponent(NroVasoContador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TamañoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TamVasoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BaseBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BaseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoBobaBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoBobaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sabor1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sabor1Label))
                .addGroup(DetallesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetallesPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Sabor2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .addGroup(DetallesPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sabor2Label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(DetallesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 410, 240));

        VerPedidoButton.setBackground(new java.awt.Color(204, 204, 255));
        VerPedidoButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        VerPedidoButton.setForeground(new java.awt.Color(255, 255, 255));
        VerPedidoButton.setText("Ver Pedido");
        VerPedidoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerPedidoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(VerPedidoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 190, 40));

        AgregarVasoButton.setBackground(new java.awt.Color(204, 204, 255));
        AgregarVasoButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AgregarVasoButton.setForeground(new java.awt.Color(255, 255, 255));
        AgregarVasoButton.setText("Agregar Vaso");
        AgregarVasoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarVasoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarVasoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, -1));

        DetallesLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DetallesLabel.setText("DETALLES DE PEDIDO ");
        getContentPane().add(DetallesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 350, 20));

        NombreClienteDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NombreClienteDetalle.setText("----");
        getContentPane().add(NombreClienteDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        NroPedidoDetalle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NroPedidoDetalle.setText("----");
        getContentPane().add(NroPedidoDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        gestorDeVentasLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        gestorDeVentasLabel.setText("GESTOR DE VENTAS");
        getContentPane().add(gestorDeVentasLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        colaDePedidosLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        colaDePedidosLabel.setText("COLA DE PEDIDOS :");
        getContentPane().add(colaDePedidosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        ColaDePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Pedido", "Nombre", "Nro Vaso", "Tamaño", "Base", "Tipo Boba", "Sabor 1", "Sabor 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ColaDePedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 590, -1));

        Fondo.setBackground(new java.awt.Color(204, 204, 255));
        Fondo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 30, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HistorialButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialButtonActionPerformed
         histo.setVisible(true);
    }//GEN-LAST:event_HistorialButtonActionPerformed

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed

    }//GEN-LAST:event_NameFieldActionPerformed

    private void Sabor1BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sabor1BoxActionPerformed
        sabor1=Sabor1Box.getSelectedItem().toString();     
    }//GEN-LAST:event_Sabor1BoxActionPerformed

    private void TipoBobaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoBobaBoxActionPerformed
        tipoBoba=TipoBobaBox.getSelectedItem().toString();
    }//GEN-LAST:event_TipoBobaBoxActionPerformed

    private void TamañoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TamañoBoxActionPerformed
        tamaño=TamañoBox.getSelectedItem().toString(); 
    }//GEN-LAST:event_TamañoBoxActionPerformed

    private void BaseBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseBoxActionPerformed
        base=BaseBox.getSelectedItem().toString();
    }//GEN-LAST:event_BaseBoxActionPerformed

    private void NitFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NitFieldActionPerformed
        
    }//GEN-LAST:event_NitFieldActionPerformed

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuButtonActionPerformed

    private void NuevoClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoClienteButtonActionPerformed
        NameField.setText("");
        NitField.setText("");
        NombreClienteDetalle.setText("----");
        NroPedidoDetalle.setText(gestorVentas.getPedidoTemporal().getNumPedido());
    }//GEN-LAST:event_NuevoClienteButtonActionPerformed

    private void ConfirmarDatosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarDatosButtonActionPerformed
      
        nombreCliente = NameField.getText();
        nit = NitField.getText();
        if(nombreCliente.isEmpty()){
            JOptionPane.showMessageDialog(
            null,
            "Por favor, ingrese un nombre.",
            "Error: Nombre no ingresado",
            JOptionPane.WARNING_MESSAGE
            );
            return; 
        }
        if (nit.isEmpty()){
            JOptionPane.showMessageDialog(
            null,
            "Por favor, ingrese un nit.",
            "Error: Nit no ingresado",
            JOptionPane.WARNING_MESSAGE
            );
            return; 
        }
        gestorVentas.registrarCliente(nombreCliente,nit);
        NombreClienteDetalle.setText(nombreCliente);
        NroPedidoDetalle.setText(gestorVentas.getPedidoTemporal().getNumPedido());
        NroVasoContador.setText(gestorVentas.getPedidoTemporal().getVasos().size()+1+"");
        JOptionPane.showMessageDialog(
            null,
            "REGISTRO CORRECTO",
            "CLIENTE REGISTRADO",
            JOptionPane.INFORMATION_MESSAGE
            );
    }//GEN-LAST:event_ConfirmarDatosButtonActionPerformed

    private void AgregarVasoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarVasoButtonActionPerformed
   
        if (!verificarExistencia(tamaño, "TAMAÑO") ||
        !verificarExistencia(base, "BASE") ||
        !verificarExistencia(tipoBoba, "TIPO BOBA") ||
        !verificarExistencia(sabor1, "SABOR")) {
        return; 
        }
        Vaso vaso = new Vaso(tamaño,base,tipoBoba,sabor1,sabor2);
        boolean hola= gestorVentas.verificarExistencia();
        gestorVentas.getPedidoTemporal().añadir(vaso);
        JOptionPane.showMessageDialog(
            null,
            "Vaso Registrado Correctamente",
            "Registro",
            JOptionPane.INFORMATION_MESSAGE
            );
        modificarNumerodeTexto();
        setOptionsDefault();
        temp.agregarVasoATabla(vaso);
    }//GEN-LAST:event_AgregarVasoButtonActionPerformed

    private void Sabor2BoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sabor2BoxActionPerformed
        sabor2=Sabor2Box.getSelectedItem().toString();
    }//GEN-LAST:event_Sabor2BoxActionPerformed

    private void VerPedidoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerPedidoButtonActionPerformed

        temp.setLocationRelativeTo(this);
        temp.setMensaje(gestorVentas.getPedidoTemporal().getNombre(),"cliente");
        temp.setMensaje(gestorVentas.getPedidoTemporal().getNumPedido(),"nroPedido");
        temp.setVisible(true);
    }//GEN-LAST:event_VerPedidoButtonActionPerformed

    private void terminarDiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarDiaButtonActionPerformed
        if(dtm.getRowCount()>0){
           JOptionPane.showMessageDialog(
            null,
            "Todavia existen vasos en cola",
            "El sistema no se ha cerrado",
            JOptionPane.WARNING_MESSAGE
            );
           return;
        }
        NameField.setText("");
        NitField.setText("");
        NombreClienteDetalle.setText("");
        NroPedidoDetalle.setText("");
        NroVasoContador.setText("");
        setOptionsDefault();
        gestorVentas.terminarDia();
        histo.recibirMap(gestorVentas.getVentasHistoricas());
        histo.rellenarVentas();
    }//GEN-LAST:event_terminarDiaButtonActionPerformed

    private void VasoTerminadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VasoTerminadoButtonActionPerformed
        gestorVentas.marcarPedidoCompletado();
        dtm.removeRow(0);
    }//GEN-LAST:event_VasoTerminadoButtonActionPerformed

    public void setOptionsDefault(){
        TamañoBox.setSelectedIndex(0);
        BaseBox.setSelectedIndex(0);
        TipoBobaBox.setSelectedIndex(0);
        Sabor1Box.setSelectedIndex(0);
        Sabor2Box.setSelectedIndex(0);
    }
    private boolean verificarExistencia(String parametro,String nombre){
        if(parametro.equals("") || parametro.charAt(0)=='-'){
            JOptionPane.showMessageDialog(
            null,
            nombre+" NO SELECCIONADO",
            "INGREDIENTE NO SELECCIONADO",
            JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }
    
    private void mandargestor() {
       temp.mandarGestorParent(gestorVentas,this);
    }
    public void modificarNumerodeTexto(){
       NroVasoContador.setText(gestorVentas.getPedidoTemporal().getVasos().size()+1+"");
    }
    public void llenarColaDePedidos(Pedido pedidoConfirmado){
        ArrayList<Vaso> vasos=pedidoConfirmado.getVasos();
        for(Vaso vaso :vasos){
            VasoEnCola vasoEnCola = new VasoEnCola(
                pedidoConfirmado.getNumPedido(),
                pedidoConfirmado.getNombre(),
                vaso
            );
            llenarFilaDeCola(vasoEnCola);
        }
    }
    public void llenarFilaDeCola(VasoEnCola vaso){
        o[0]=vaso.getNumPedido();
        o[1]=vaso.getNombreCliente();
        o[2]=vaso.getVaso().getNumVaso();
        o[3]=vaso.getVaso().getTamVaso();
        o[4]=vaso.getVaso().getBase();
        o[5]=vaso.getVaso().getTipoBoba();
        o[6]=vaso.getVaso().getSabor1();
        o[7]=vaso.getVaso().getSabor2();
        dtm.addRow(o);
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
            java.util.logging.Logger.getLogger(MenuVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarVasoButton;
    private javax.swing.JComboBox<String> BaseBox;
    private javax.swing.JLabel BaseLabel;
    private javax.swing.JTable ColaDePedidos;
    private javax.swing.JButton ConfirmarDatosButton;
    private javax.swing.JLabel DetallesLabel;
    private javax.swing.JPanel DetallesPanel;
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton HistorialButton;
    private javax.swing.JLabel InformacionLabel;
    private javax.swing.JButton MenuButton;
    private javax.swing.JFormattedTextField NameField;
    private javax.swing.JFormattedTextField NitField;
    private javax.swing.JLabel NitLabel;
    private javax.swing.JLabel NombreClienteDetalle;
    private javax.swing.JLabel NombreClienteDetalleLabel;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JLabel NroPedidoDetalle;
    private javax.swing.JLabel NroPedidoDetalleLabel;
    private javax.swing.JLabel NroVasoContador;
    private javax.swing.JLabel NroVasoLabel;
    private javax.swing.JButton NuevoClienteButton;
    private javax.swing.JComboBox<String> Sabor1Box;
    private javax.swing.JLabel Sabor1Label;
    private javax.swing.JComboBox<String> Sabor2Box;
    private javax.swing.JLabel Sabor2Label;
    private javax.swing.JLabel TamVasoLabel;
    private javax.swing.JComboBox<String> TamañoBox;
    private javax.swing.JComboBox<String> TipoBobaBox;
    private javax.swing.JLabel TipoBobaLabel;
    private javax.swing.JButton VasoTerminadoButton;
    private javax.swing.JButton VerPedidoButton;
    private javax.swing.JLabel colaDePedidosLabel;
    private javax.swing.JLabel gestorDeVentasLabel;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton terminarDiaButton;
    // End of variables declaration//GEN-END:variables

}
