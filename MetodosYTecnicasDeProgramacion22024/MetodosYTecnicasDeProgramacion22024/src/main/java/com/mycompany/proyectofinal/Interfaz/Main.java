/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal.Interfaz;

import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.InicioyRegistro.UsuarioManager;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        // Inicializar todos los gestores
        GestorDeInventario gestorDeInventario = new GestorDeInventario();
        GestorDeVentas gestorDeVentas = new GestorDeVentas(gestorDeInventario);
        GestorDeContabilidad gestorDeContabilidad = new GestorDeContabilidad(gestorDeInventario, gestorDeVentas);
        UsuarioManager usuarioManager = new UsuarioManager();

        // Usa EventQueue para inicializar la GUI en el hilo adecuado
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar la ventana de inicio de sesión, pasándole UsuarioManager
                InicioDeSesion loginFrame = new InicioDeSesion(usuarioManager);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginFrame.setSize(1000, 700);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setVisible(true);
            }
        });
    }
}