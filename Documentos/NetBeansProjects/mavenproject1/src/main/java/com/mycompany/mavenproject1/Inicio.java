package com.mycompany.mavenproject1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import java.util.HashMap;
import java.util.Map;


public class Inicio{
    private Map<String, Usuario> usuariosRegistrados;
    public Inicio() {
        usuariosRegistrados = new HashMap<>();
    }

    public String registrar(String nombre, String contrasena, String rol) {
        if (usuariosRegistrados.containsKey(nombre)) {
            return "Usuario ya registrado.";
        }
        Usuario nuevoUsuario = new Usuario(nombre, contrasena, rol);
        usuariosRegistrados.put(nombre, nuevoUsuario);
        return "Usuario registrado exitosamente.";
    }

  
    public String acceder(String nombre, String contrasena) {
        Usuario usuario = usuariosRegistrados.get(nombre);
        if (usuario != null && usuario.getContrasena().equals(contrasena)) {
            return "Inicio de sesión exitoso. Rol: " + usuario.getRol();
        }
        return "Nombre de usuario o contraseña incorrectos.";
    }

  
    public boolean esAdministrador(String nombre) {
        Usuario usuario = usuariosRegistrados.get(nombre);
        return usuario != null && usuario.getRol().equals("administrador");
    }
}



