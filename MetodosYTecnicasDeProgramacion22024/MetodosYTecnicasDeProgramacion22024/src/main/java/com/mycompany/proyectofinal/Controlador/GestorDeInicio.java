package com.mycompany.proyectofinal.Controlador;

import com.mycompany.proyectofinal.Controlador.GeneradorArchivosUsuarios;
import com.mycompany.proyectofinal.Modelo.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class GestorDeInicio {
    private GeneradorArchivosUsuarios fileUser;
    public GestorDeInicio(GeneradorArchivosUsuarios generadorArchivo){
        fileUser=generadorArchivo;
    }
    public boolean registrarUsuario(Usuario usuario){
        if(fileUser.buscarUsuario(usuario.getCargo())!= null){
            System.out.println("El usuario ya existe.");
            return false;
        }else if(usuario.getContraseña().length()<6){
            System.out.println("Contraseña muy corta.");
            return false;
        }
        return fileUser.registrar(usuario);
    }
    
    public boolean login(String codigoE, String contraseña) {
        Usuario user = fileUser.buscarUsuario(codigoE);
        if (user != null) {
            System.out.println("Bienvenido");
            return true; 
        }else{
            System.out.println("Codigo o contrasenia incorrectos");
            return false;
        }  
    }
}
