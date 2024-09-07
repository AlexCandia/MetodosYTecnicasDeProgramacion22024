/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class RegistroUsuario {
    private GeneradorArchivo fileUser;
    public RegistroUsuario(GeneradorArchivo generadorArchivo){
        fileUser=generadorArchivo;
    }
    public boolean registrarUsuario(String nombre,String contraseña,String codigoE){
        if(fileUser.buscarUsuario(codigoE)!= null){
            System.out.println("El usuario ya existe.");
            return false;
        }else if(contraseña.length()<6){
            System.out.println("Contraseña muy corta.");
            return false;
        }
        Usuario usuarioNuevo = new Usuario(nombre,contraseña,codigoE);
        return fileUser.registrar(usuarioNuevo);
    }
    public boolean login(String codigoE, String contraseña) {
        Usuario user = fileUser.buscarUsuario(codigoE);
        if (user != null) {
            return true; 
        }
        return false;  
    }
}
