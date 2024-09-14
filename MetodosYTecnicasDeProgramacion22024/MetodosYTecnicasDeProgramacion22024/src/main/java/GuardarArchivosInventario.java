/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author israe
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class GuardarArchivosInventario {
    private List<String> inventario = new ArrayList<>();
    public void agregarProducto(String nombre, int cantidad) {
        inventario.add(nombre + "," + cantidad);
    }
    public void guardarInventarioCSV(String nombreArchivo) throws IOException {
        FileWriter archivo = new FileWriter(nombreArchivo);
        BufferedWriter bw = new BufferedWriter(archivo);
        for (String producto : inventario) {
            bw.write(producto + "\n");
        }
        bw.close();
        archivo.close();
    }
    public static void main(String[] args) {
        GuardarArchivosInventario gestor = new GuardarArchivosInventario();
        gestor.agregarProducto("Manzana", 10);
        gestor.agregarProducto("Banana", 5);
        try {
            gestor.guardarInventarioCSV("inventario.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}