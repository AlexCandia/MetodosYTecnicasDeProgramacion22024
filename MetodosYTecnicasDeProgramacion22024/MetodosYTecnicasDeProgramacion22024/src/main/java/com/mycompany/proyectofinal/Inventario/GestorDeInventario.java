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
import com.mycompany.proyectofinal.Ventas.Vaso;
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
import javax.swing.JOptionPane;

public class GestorDeInventario {
    private ArrayList<Insumo> insumos;
    private GeneradorArchivosInventario productsfile;


    public GestorDeInventario() {
        productsfile= new GeneradorArchivosInventario();
        insumos= productsfile.getProductos();    
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
    public void editarInsumo(int fila, String nom, String uni, int can, int min){
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
        if(can != -1){
            in.setMinimo(min);
        }
    }
    
    public void ordenarPorNombre() {
        insumos.sort(Comparator.comparing(Insumo::getNombre));
    }
    public void ordenarPorCantidadDescendente() {
        insumos.sort((i1, i2) -> Integer.compare(i2.getCantidad(), i1.getCantidad()));
    }
    public void verificarNivelMinimo() {
        for (Insumo insumo : insumos) {
            if (insumo.getCantidad() <= insumo.getMinimo()) {
                JOptionPane.showMessageDialog(null,
                        "Advertencia: El insumo \"" + insumo.getNombre() + "\" está por debajo del nivel mínimo (" + insumo.getMinimo() + ").",
                        "Alerta de Stock Bajo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
  
    // Método para guardar el inventario actual en un archivo
    public void guardarInventario() {
        productsfile.setInsumos(insumos);
        productsfile.añadirAlarchivoInsumo();
    }
   
    /*public void recibirNuevoInsumo(String nombreInsumo, String cantidadStr) {
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

    public String verificarInsumos(Vaso vaso) {
        String logrado = "No";
        String tamaño = vaso.getTamVaso();
        String base = vaso.getBase();
        String tipoBoba = vaso.getTipoBoba();
        String sabor1 = vaso.getSabor1();
        String sabor2 = vaso.getSabor2();
        ArrayList<String> carac = new ArrayList<>();
        carac.add(tamaño);
        carac.add(base);
        carac.add(tipoBoba);
        carac.add(sabor1);
        carac.add(sabor2);
        for(String car : carac){
            for (Insumo insumo : insumos) {
                if(insumo.getNombre().equals(car)){
                    boolean posible=insumo.descontarCantidad();
                    if(posible){
                        logrado="Log";
                    }
                    else{
                        logrado= "No se tienen suficientes"+insumo.getNombre();
                    }
                }
            }
           if(logrado.charAt(0)=='N') break; 
        }
        return logrado;
        
    }

}