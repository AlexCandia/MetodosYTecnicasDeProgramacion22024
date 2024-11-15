package com.mycompany.proyectofinal.Inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import java.util.*;
import com.mycompany.proyectofinal.Contabilidad.EgresoInsumo;
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorDeInventario {
    private ArrayList<Insumo> insumos;
    private GeneradorArchivosInventario productsfile;
    private GestorDeVentas gestorDeVentas;
    private GestorDeContabilidad gestorDeContabilidad;


    public GestorDeInventario(GestorDeContabilidad gestorDeContabilidad, GestorDeVentas gestorDeVentas) {
        insumos= new ArrayList<>();
        this.gestorDeContabilidad = gestorDeContabilidad;
        this.gestorDeVentas = gestorDeVentas;       
    }

    public GestorDeInventario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public ArrayList<Insumo> getInsumos(){
        return insumos;
    }
    public void agregarInsumo(Insumo insum) {
        insumos.add(insum);
    }
    public void eliminarInsumo(int fila){
        insumos.remove(fila);
    }
    public void editarInsumo(int fila, String nom, String uni, int can){
        Insumo in = insumos.get(fila);
        if(!"".equals(nom)){
            in.setNombre(nom);
        }
        
        if(!"".equals(uni)){
            in.setUnidad(uni);
        }
        
        if(can != -1){
            in.setCantidad(can);
        }
    }
    public void ordenarPorNombre() {
        insumos.sort(Comparator.comparing(Insumo::getNombre));
    }
    public void ordenarPorCantidadDescendente() {
        insumos.sort((i1, i2) -> Integer.compare(i2.getCantidad(), i1.getCantidad()));
    }
    
  
    
    
    // Método para guardar el inventario actual en un archivo
    /*public void guardarInventario() {
        productsfile = new GeneradorArchivosInventario(insumos);
        productsfile.añadirAlarchivo();
    }
   
    public void recibirNuevoInsumo(String nombreInsumo, String cantidadStr) {
        // Convertimos el String cantidadStr a un entero
        int cantidad = Integer.parseInt(cantidadStr);

        // Verificamos si el insumo ya existe en el inventario
        if (inventarioInsumos.containsKey(nombreInsumo)) {
            // Si ya existe, actualizamos la cantidad sumando la nueva cantidad
            int cantidadActual = inventarioInsumos.get(nombreInsumo);
            inventarioInsumos.put(nombreInsumo, cantidadActual + cantidad);
        } else {
            // Si no existe, lo agregamos como un nuevo insumo
            inventarioInsumos.put(nombreInsumo, cantidad);
        }
    }*/

}