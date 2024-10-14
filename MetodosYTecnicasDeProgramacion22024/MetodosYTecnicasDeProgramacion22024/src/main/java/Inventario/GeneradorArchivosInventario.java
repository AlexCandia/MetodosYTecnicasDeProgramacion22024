package Inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */

import java.io.*;
import java.util.ArrayList;
public class GeneradorArchivosInventario {
    public ArrayList<Insumo> productos = new ArrayList<>();
    public ArrayList<Insumo> getProductos(){
        return productos;
    }
  public GeneradorArchivosInventario(ArrayList<Insumo> productos){
     this.productos=productos; 
    }
  public GeneradorArchivosInventario(){
        cargarProductos();
    }
  private static final String FILE_PATH = "C:\\Users\\developerweb\\Documents\\NetBeansProjects\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\insumos.txt";
  public void añadirAlarchivo(){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Insumo producto : productos) {
                writer.write(producto.getNombre() + "/" + producto.getUnidad()+ "/" + producto.getCantidad()+ "/" + producto.getProveedor()+ "/" + producto.getTelefono());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
  }
  private ArrayList<Insumo> cargarProductos(){
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length == 5){
                    String nombre = parts[0];
                    String unidad = parts[1];
                    String cantidad = parts[2];
                    String proveedor = parts[3];
                    String telefono = parts[4];
                    double cantidadProd = Double.parseDouble(cantidad);
                    Insumo producto =new Insumo(nombre, unidad,cantidadProd,proveedor,telefono);
                    productos.add(producto);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de productos no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al cargar productos desde el archivo: " + e.getMessage());
        }
      return productos;
    }
  //Generar archivos para el inventario
} 
