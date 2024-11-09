package com.mycompany.proyectofinal.Contabilidad;

public class EgresoFijo {
    private String fecha;
    private String nombreEgreso;
    private double valor;

    public EgresoFijo(String fecha, String nombreEgreso, double valor) {
        this.fecha = fecha;
        this.nombreEgreso = nombreEgreso;
        this.valor = valor;
    }

    public String getFecha(){
        return fecha;
    }
    
    public String getNombreEgreso() {
        return nombreEgreso;
    }

    public double getValor() {
        return valor;
    }
    
    public void setFecha(String fec){
        fecha = fec;
    }
    
    public void setNombreEgreso(String nomb){
        nombreEgreso = nomb;
    }
    
    public void setValor(double val){
        valor = val;
    }
}
