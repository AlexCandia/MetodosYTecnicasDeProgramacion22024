package com.mycompany.proyectofinal.Inventario;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */

import com.mycompany.proyectofinal.Inventario.Insumo;
import java.io.*;
import java.util.ArrayList;
public class GeneradorArchivosInventario {
    public ArrayList<Insumo> productos;
    public GeneradorArchivosInventario(){
        cargarInsumos();
    }
    public ArrayList<Insumo> getProductos(){
        return productos;
    }
    public void setInsumos(ArrayList<Insumo> nuevo){
        productos=nuevo;
    }
    private static final String FILE_PATH = "C:\\\\Users\\\\developerweb\\\\Desktop\\\\MetodosYTecnicasDeProgramacion22024\\\\MetodosYTecnicasDeProgramacion22024\\\\MetodosYTecnicasDeProgramacion22024\\\\src\\\\main\\\\java\\\\com\\\\mycompany\\\\proyectofinal\\\\Inventario\\\\Insumos.txt";
    public void añadirAlarchivoInsumo(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
              for (Insumo producto : productos) {
                  writer.write(producto.getNombre() + "/" + producto.getUnidad()+ "/" + producto.getCantidad()+ "/" + producto.getMinimo()+"");
                  writer.newLine();
              }
          } catch (IOException e) {
              System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
          }
    }
  
  //Generar archivos para el inventario
    private ArrayList<Insumo> cargarInsumos(){
       productos = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length == 4){
                    String nombre = parts[0];
                    String unidad = parts[1];
                    String cantidad = parts[2];
                    String cantidadMin = parts[3];
                    int cantidadProd = Integer.parseInt(cantidad);
                    int cantidadMinProd = Integer.parseInt(cantidadMin);
                    Insumo producto =new Insumo(nombre, unidad,cantidadProd,cantidadMinProd);
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
} 
