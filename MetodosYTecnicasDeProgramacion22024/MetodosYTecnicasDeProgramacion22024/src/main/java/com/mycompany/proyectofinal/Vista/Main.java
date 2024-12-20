/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal.Vista;

import com.mycompany.proyectofinal.Controlador.GestorDeContabilidad;
import com.mycompany.proyectofinal.Controlador.GestorDeUsuario;
import com.mycompany.proyectofinal.Controlador.GestorDeInventario;
import com.mycompany.proyectofinal.Controlador.GestorDeVentas;
import javax.swing.JFrame;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        // Inicializar todos los gestores
        GestorDeUsuario usuarioManager = new GestorDeUsuario();

        // Usa EventQueue para inicializar la GUI en el hilo adecuado
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar la ventana de inicio de sesión, pasándole UsuarioManager
                InicioDeSesion loginFrame = new InicioDeSesion(usuarioManager);
                loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //loginFrame.setSize(1000, 700);
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setVisible(true);
            }
        });
    }
}