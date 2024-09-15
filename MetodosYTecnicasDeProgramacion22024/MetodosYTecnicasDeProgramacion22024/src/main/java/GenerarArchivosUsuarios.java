/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author developerweb
 */
public class GenerarArchivosUsuarios {
  private Map<String,Usuario> usuarios = new HashMap<>();
  public GenerarArchivosUsuarios(){
    cargarUsuarios();  
    }
  private static final String FILE_PATH = "C:\\Users\\developerweb\\Documents\\NetBeansProjects\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\users.txt";
  public Usuario buscarUsuario(String codigoE) {
      return usuarios.get(codigoE);  
    }
  public boolean registrar(Usuario nuevoUsuario){
        usuarios.put(nuevoUsuario.getCodigoE(), nuevoUsuario);
        añadirAlarchivo();  
        return true;  
  }
  public void añadirAlarchivo(){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Usuario usuario : usuarios.values()) {
                writer.write(usuario.getNombre() + "/" + usuario.getContraseña()+ "/" + usuario.getCodigoE());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
  }
  private void cargarUsuarios(){
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String nombre = parts[0];
                    String contraseña = parts[1];
                    String codigoE = parts[2];
                    usuarios.put(codigoE, new Usuario(nombre, contraseña, codigoE));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado, iniciando base de datos vacía.");
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
        }
    }
}
