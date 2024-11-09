package com.mycompany.proyectofinal.InicioyRegistro;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {

    private static final String FILE_NAME = "ListaUsuarios.txt";
    private List<Usuario> usuarios = new ArrayList<>();

    // Constructor que carga los usuarios desde el archivo
    public UsuarioManager() {
        cargarUsuarios();
    }

    // Método para registrar un usuario
    public boolean registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(usuario.getNombre())) {
                System.out.println("El usuario ya existe.");
                return false;
            }
        }
        usuarios.add(usuario);
        guardarUsuarios();
        return true;
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String nombre, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    // Cargar usuarios desde el archivo
    private void cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    Usuario usuario = new Usuario(partes[0], partes[1], partes[2]);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
        }
    }

    // Guardar usuarios en el archivo
    private void guardarUsuarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Usuario usuario : usuarios) {
                bw.write(usuario.getNombre() + ";" + usuario.getContraseña() + ";" + usuario.getCodigoE());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de usuarios.");
        }
    }

    // Método opcional para mostrar usuarios (para depuración)
    public void mostrarUsuarios() {
        usuarios.forEach(usuario -> 
            System.out.println("Nombre: " + usuario.getNombre() +
                               ", Contraseña: " + usuario.getContraseña() +
                               ", CódigoE: " + usuario.getCodigoE()));
    }
}
