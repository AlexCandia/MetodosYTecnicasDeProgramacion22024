package Inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
public class Producto {
    private String nombre;
    private String unidad;
    private double cantidad;
    private double limiteMinimo;
    private String proveedor;
    private String telefono;

    // Constructor
    public Producto(String nombre, String unidad, String proveedor, String telefono) {
        this.nombre = nombre;
        this.unidad = unidad;
        cantidad = 0;
        this.proveedor = proveedor;
        this.telefono = telefono;
    }
    public Producto(String nombre, String unidad,double cantidad, String proveedor, String telefono) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.telefono = telefono;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public double getLimiteMinimo(){
        return limiteMinimo;
    }
    public void recalcularLimite(){
        limiteMinimo=0.2*cantidad;
    }
    @Override
    //nuevo
    public String toString() {
        return "Nombre: " + nombre +
               ", Unidad: " + unidad +
               ", Cantidad: " + cantidad +
               ", Proveedor: " + proveedor +
               ", Teléfono: " + telefono;
    }

}


