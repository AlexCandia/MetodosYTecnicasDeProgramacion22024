package com.mycompany.proyectofinal.Modelo;

public class EgresoVariable {
    private String fecha;
    private String nombre;
    private String detalle;
    private double valor;

    public EgresoVariable(String fecha, String nombre, String detalle, double valor) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.detalle = detalle;
        this.valor = valor;
    }

    public String getFecha(){
        return fecha;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getValor() {
        return valor;
    }
    
    public void setFecha(String fec){
        fecha = fec;
    }
    
    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setDetalle(String det) {
        detalle = det;
    }

    public void setValor(double val) {
        valor = val;
    }
}
