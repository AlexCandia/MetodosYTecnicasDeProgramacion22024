package com.mycompany.proyectofinal.Modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import java.util.Date;

public class Vaso {


    private String numVaso; 
    private Date fecha; 
    private String tamVaso; 
    private String base; 
    private String tipoBoba; 
    private String sabor1;
    private String sabor2;
    private int precio;
    private String numPedido; 
    private String nombreCliente;


    public Vaso(String tamVaso, String base, String tipoBoba, String sabor1, String sabor2) {
        this.numVaso = "0";
        this.fecha = new Date();
        this.tamVaso = tamVaso;
        this.base = base;
        this.tipoBoba = tipoBoba;
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
        precio = revisarTamaño();
    }
    private int revisarTamaño(){
        if("Grande".equals(tamVaso)){
            return 20;
        }else{
            return 15;
        }
    }

    public String getNumVaso() {
        return numVaso;
    }

    public void setNumVaso(String numVaso) {
        this.numVaso = numVaso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTamVaso() {
        return tamVaso;
    }

    public void setTamVaso(String tamVaso) {
        this.tamVaso = tamVaso;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTipoBoba() {
        return tipoBoba;
    }

    public void setTipoBoba(String tipoBoba) {
        this.tipoBoba = tipoBoba;
    }

    public String getSabor1() {
        return sabor1;
    }

    public void setSabor1(String sabor1) {
        this.sabor1 = sabor1;
    }

    public String getSabor2() {
        return sabor2;
    }

    public void setSabor2(String sabor2) {
        this.sabor2 = sabor2;
    }
    
    public int getPrecio(){
        return precio;
    }
    public void setPrecio(int i) {
        precio=i;
    }
    public String getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(String numPedido) {
        this.numPedido = numPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
     public Vaso getVaso() {
        return this;
    }
}
