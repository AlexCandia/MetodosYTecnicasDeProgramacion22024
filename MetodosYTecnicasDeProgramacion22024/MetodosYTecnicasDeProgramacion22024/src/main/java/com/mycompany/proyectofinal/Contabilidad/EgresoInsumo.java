package com.mycompany.proyectofinal.Contabilidad;

public class EgresoInsumo {
    private String fecha;
    private String nombre;
    private int cantidad;
    private double valor;

    public EgresoInsumo(String fecha, String nombre,int cantidad, double valor) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getFecha(){
        return fecha;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
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

    public void setCantidad(int cant) {
        cantidad = cant;
    }

    public void setValor(double val) {
        valor = val;
    }
    
    
    
}
