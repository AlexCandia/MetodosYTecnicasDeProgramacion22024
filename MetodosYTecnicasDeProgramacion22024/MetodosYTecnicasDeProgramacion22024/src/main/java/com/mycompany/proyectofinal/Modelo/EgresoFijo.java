package com.mycompany.proyectofinal.Modelo;

public class EgresoFijo {
    private String fecha;
    private String detalle;
    private double valor;

    public EgresoFijo(String fecha, String detalle, double valor) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.valor = valor;
    }

    public String getFecha(){
        return fecha;
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
    
    public void setDetalle(String det){
        detalle = det;
    }
    
    public void setValor(double val){
        valor = val;
    }
}
