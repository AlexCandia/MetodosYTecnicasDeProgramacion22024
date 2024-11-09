package com.mycompany.proyectofinal.Ventas;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class VasoEnCola {
    private String numPedido;
    private String nombreCliente;
    private Vaso vaso;

    // Constructor
    public VasoEnCola(String numPedido, String nombreCliente, Vaso vaso) {
        this.numPedido = numPedido;
        this.nombreCliente = nombreCliente;
        this.vaso = vaso;
    }

    // Getters
    public String getNumPedido() {
        return numPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Vaso getVaso() {
        return vaso;
    }
}
