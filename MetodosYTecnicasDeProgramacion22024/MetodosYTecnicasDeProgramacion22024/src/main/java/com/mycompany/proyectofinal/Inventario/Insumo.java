package com.mycompany.proyectofinal.Inventario;


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


    // Constructor
    public Insumo(String nombre, String unidad, int cantidad) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
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

    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setUnidad(String uni) {
        unidad = uni;
    }

    public void setCantidad(int can) {
        cantidad = can;
    }
}


