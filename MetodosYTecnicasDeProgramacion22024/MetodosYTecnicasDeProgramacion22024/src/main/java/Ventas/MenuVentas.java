package Ventas;


import Inventario.GestorDeInventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class MenuVentas {
    public static void main (String args[]){
       GestorDeInventario gestorInven = new GestorDeInventario();
       GestorDeVentas gestor = new GestorDeVentas(gestorInven);
       gestor.registrarCliente("sadad", "675712");
       Vaso vaso1 = new Vaso("Grande","Leche","perlas","mora","durazno");
       Vaso vaso2 = new Vaso("Mediano","Agua","perlas","choco","fruti");
       Vaso vaso3 = new Vaso("Grande","Agua","explosive","macha","ninguno");
       gestor.agregarVaso(vaso1);
       gestor.agregarVaso(vaso2);
       gestor.agregarVaso(vaso3);
       gestor.confirmarPedido();
       gestor.registrarCliente("afqrfgr", "12873178");
       Vaso vaso4 = new Vaso("Mediano","Agua","perlas","limon","oreo");
       Vaso vaso5 = new Vaso("Grande","Leche","explosive","te","vainilla");
       Vaso vaso6 = new Vaso("Mediano","Agua","explosive","canela","churrasco");
       gestor.agregarVaso(vaso4);
       gestor.agregarVaso(vaso5);
       gestor.agregarVaso(vaso6);
       gestor.confirmarPedido();
       gestor.terminarDia();
       gestor.generarReporteVentas();
    }
}
