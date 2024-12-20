package com.mycompany.proyectofinal.Controlador;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */

import com.mycompany.proyectofinal.Modelo.Insumo;
import com.mycompany.proyectofinal.Modelo.Proveedor;
import java.io.*;
import java.util.ArrayList;
public class GeneradorArchivosInventario {
    private ArrayList<Insumo> productos;
    private ArrayList<Proveedor> proveedores;
    public GeneradorArchivosInventario(){
        cargarInsumos();
        cargarProveedores();
    }
    public ArrayList<Insumo> getProductos(){
        return productos;
    }
    public ArrayList<Proveedor> getProveedores(){
        return proveedores;
    }
    public void setInsumos(ArrayList<Insumo> nuevo){
        productos=nuevo;
    }
    public void setProveedores(ArrayList<Proveedor> nuevo){
        proveedores=nuevo;
    }
    private static final String FILE_PATH = "Archivos/ArchivosInventario/Insumos.txt";
    private static final String FILE_PATH2 = "Archivos/ArchivosInventario/Proveedores.txt";
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
    public void añadirAlarchivoProveedores(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH2))) {
              for (Proveedor proveedor : proveedores) {
                  writer.write(proveedor.getNombre() + "/" + proveedor.getTelefono()+ "/" + proveedor.getDireccion());
                  writer.newLine();
              }
          } catch (IOException e) {
              System.out.println("Error al guardar proveedores en el archivo: " + e.getMessage());
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
    private ArrayList<Insumo> cargarProveedores(){
       proveedores = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH2))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/");
                if (parts.length == 3){
                    String nombre = parts[0];
                    String telefono = parts[1];
                    String direccion = parts[2];
                    Proveedor proveedor =new Proveedor(nombre,telefono,direccion);
                    proveedores.add(proveedor);
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
