/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class Inicio {
    private GenerarArchivosUsuarios fileUser;
    public Inicio(GenerarArchivosUsuarios generadorArchivo){
        fileUser=generadorArchivo;
    }
    public boolean registrarUsuario(Usuario usuario){
        if(fileUser.buscarUsuario(usuario.getCodigoE())!= null){
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
            return true; 
        }
        return false;  
    }
}
