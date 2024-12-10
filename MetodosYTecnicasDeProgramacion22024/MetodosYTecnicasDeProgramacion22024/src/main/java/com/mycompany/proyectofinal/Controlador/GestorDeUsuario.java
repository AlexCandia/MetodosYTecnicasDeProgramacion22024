package com.mycompany.proyectofinal.Controlador;
import com.mycompany.proyectofinal.Modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDeUsuario {

    private static final String FILE_NAME = "Archivos/ArchivosUsuarios/ListaUsuarios.txt";
    private List<Usuario> listaUsuarios;

    public GestorDeUsuario() {
        this.listaUsuarios = new ArrayList<>();
        cargarUsuarios();
    }

    public boolean registrarUsuario(Usuario nuevoUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(nuevoUsuario.getUsuario())) {
                return false;
            }
        }

        listaUsuarios.add(nuevoUsuario);
        guardarUsuarios();
        return true;
    }
     

    public boolean iniciarSesion(String usuario, String contraseña) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true; 
            }
        }
        return false; 
    }
    public String obtenerCargo(String usuario) {
        for (Usuario u : listaUsuarios) {
            if (u.getUsuario().equals(usuario)) {
                return u.getCargo();
            }
        }
        return null; 
    }

    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    Usuario usuario = new Usuario(partes[0], partes[1], partes[2]);
                    listaUsuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
        }
    }
    private void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Usuario usuario : listaUsuarios) {
                bw.write(usuario.getUsuario() + ";" + usuario.getContraseña() + ";" + usuario.getCargo());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de usuarios.");
        }
    }

    public void mostrarUsuarios() {
        listaUsuarios.forEach(usuario -> 
            System.out.println("Nombre: " + usuario.getUsuario() +
                               ", Contraseña: " + usuario.getContraseña() +
                               ", CódigoE: " + usuario.getCargo()));
    }
}
