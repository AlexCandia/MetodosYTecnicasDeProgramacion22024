/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
/**
 *
 * @author israe
 *//*
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Clase que representa un producto
class Producto {
    private String nombre;
    private int cantidad;
    private double precio;
    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    @Override
    public String toString() {
        return nombre + "," + cantidad + "," + precio;
    }
}
public class GuardarArchivosInventario {
    private List<Producto> inventario = new ArrayList<>();
    // Método para agregar un producto al inventario
    public void agregarProducto(String nombre, int cantidad, double precio) {
        Producto producto = new Producto(nombre, cantidad, precio);
        inventario.add(producto);
    }
    // Método para guardar el inventario en un archivo CSV
    public void guardarInventarioCSV(String nombreArchivo) throws IOException {
        FileWriter archivo = new FileWriter(nombreArchivo);
        BufferedWriter bw = new BufferedWriter(archivo);

        for (Producto producto : inventario) {
            bw.write(producto.toString() + "\n");
        }
        bw.close();
        archivo.close();
    }
    // Método para solicitar y agregar productos dinámicamente
    public void gestionarInventario() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            System.out.print("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();
            agregarProducto(nombre, cantidad, precio);
            System.out.print("¿Desea agregar otro producto? (s/n): ");
            String respuesta = scanner.next();
            scanner.nextLine();  // Limpiar el buffer del scanner

            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        scanner.close();
    }
    public static void main(String[] args) {
        GuardarArchivosInventario gestor = new GuardarArchivosInventario();
        // Llamada al método que gestiona la entrada dinámica de productos
        gestor.gestionarInventario();
        try {
            gestor.guardarInventarioCSV("inventario.csv");
            System.out.println("Inventario guardado en 'inventario.csv'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/