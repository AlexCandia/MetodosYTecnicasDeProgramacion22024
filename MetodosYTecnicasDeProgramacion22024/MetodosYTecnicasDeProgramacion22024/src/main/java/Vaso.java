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

    // Atributos
    private String numVaso; // Número de vaso en la venta
    private Date fecha; // Fecha en la que se realizó la venta
    private String tamVaso; // Tamaño del vaso (ej. pequeño, mediano, grande)
    private String base; // Base del vaso (ej. leche, té)
    private String tipoBoba; // Tipo de boba (ej. perlas de tapioca, gelatina)
    private String sabor1; // Primer sabor
    private String sabor2; // Segundo sabor (opcional)
    private int precio;

    // Constructor
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
    // Métodos getter y setter
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
}