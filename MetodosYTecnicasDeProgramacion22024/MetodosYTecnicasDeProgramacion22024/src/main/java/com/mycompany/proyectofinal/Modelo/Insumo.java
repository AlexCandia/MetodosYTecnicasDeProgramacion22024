package com.mycompany.proyectofinal.Modelo;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
public class Insumo {
    private String nombre;
    private String unidad;
    private int cantidad;
    private double porunidad;
    private int minimo;

    // Constructor
    public Insumo(String nombre, String unidad, int cantidad,int minimo) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.minimo = minimo;
        definirlimite();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setUnidad(String uni) {
        unidad = uni;
    }
    public void setCantidad(int cant) {
        cantidad = cant;
    }
    
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public boolean descontarCantidad() {
        int nuevocantidad=cantidad-(int)porunidad;
        if (nuevocantidad<0){
            return false;
        }else{
           setCantidad(nuevocantidad);
           return true;
        }            
    }

    private void definirlimite() {
        if("Grande".equals(nombre) || "Mediano".equals(nombre)){
            porunidad=1;
        }else if("Leche".equals(nombre)||"Explosivo".equals(nombre)||"Regular".equals(nombre)){    
           porunidad=2; 
        }else if ("Agua".equals(nombre)){
           porunidad=1; 
        }else{
           porunidad=1; 
        }
    }
}


