package com.mycompany.proyectofinal.Inventario;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */

import com.mycompany.proyectofinal.Inventario.Producto;
import java.io.*;
import java.util.ArrayList;
public class GeneradorArchivosInventario {
    public ArrayList<Producto> productos = new ArrayList<>();
    public ArrayList<Producto> getProductos(){
        return productos;
    }
  public GeneradorArchivosInventario(ArrayList<Producto> productos){
     this.productos=productos; 
    }
  public GeneradorArchivosInventario(){
        cargarProductos();
    }
  private static final String FILE_PATH = "C:\\Proyectos\\MetodosYTecnicasDeProgramacion22024\\ProyectoFinal\\src\\main\\java\\productos.txt";
  public void añadirAlarchivo(){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Producto producto : productos) {
                writer.write(producto.getNombre() + "/" + producto.getUnidad()+ "/" + producto.getCantidad()+ "/" + producto.getProveedor()+ "/" + producto.getTelefono());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
  }
  private ArrayList<Producto> cargarProductos(){
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
                    Producto producto =new Producto(nombre, unidad,cantidadProd,proveedor,telefono);
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
