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
    public ArrayList<Insumo> productos = new ArrayList<>();
    public ArrayList<Insumo> getProductos(){
        return productos;
    }
  public GeneradorArchivosInventario(ArrayList<Insumo> productos){
     this.productos=productos; 
    }
  private static final String FILE_PATH = "C:\\Users\\Camila\\OneDrive\\Escritorio\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\com\\mycompany\\proyectofinal\\Inventario\\productos.txt";
  public void añadirAlarchivo(){
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Insumo producto : productos) {
                writer.write(producto.getNombre() + "/" + producto.getUnidad()+ "/" + producto.getCantidad());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
  }
  
  //Generar archivos para el inventario
} 
