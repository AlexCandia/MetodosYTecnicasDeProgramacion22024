package com.mycompany.proyectofinal.Contabilidad;


import com.mycompany.proyectofinal.Ventas.Vaso;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import com.mycompany.proyectofinal.Inventario.Producto;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;

public class MainContabilidad {
    public static void main(String[] args) {
        GestorDeInventario gestorInventario = new GestorDeInventario();
        GestorDeVentas gestorVentas = new GestorDeVentas(gestorInventario);
        gestorVentas.registrarCliente("sadad", "675712");
        Vaso vaso1 = new Vaso("Grande","Leche","perlas","mora","durazno");
        Vaso vaso2 = new Vaso("Mediano","Agua","perlas","choco","fruti");
        Vaso vaso3 = new Vaso("Grande","Agua","explosive","macha","ninguno");
        gestorVentas.agregarVaso(vaso1);
        gestorVentas.agregarVaso(vaso2);
        gestorVentas.agregarVaso(vaso3);
        gestorVentas.confirmarPedido();
        gestorVentas.terminarDia();
        gestorVentas.generarReporteVentas();
        GestorDeContabilidad gestorContabilidad = new GestorDeContabilidad(gestorInventario,gestorVentas);
        Producto teverde = new Producto("Té Verde","bolsa","real","6893213");
        gestorInventario.agregar(teverde);
        gestorContabilidad.calcularIngreso();
        // Egresos
        gestorContabilidad.registrarEgresoFijo(new EgresoFijo("30/10/2024","Alquiler", 1200));
        gestorContabilidad.registrarEgresoInsumo(new EgresoVariableInsumo("Té Verde", 50, 200.0));
        gestorContabilidad.registrarEgresoOtro(new EgresoVariableOtro("Publicidad", "Facebook Ads", 300));
        
        // Imprimir reporte mensual
        System.out.println(gestorContabilidad.imprimirReporteMensual());
        
        // Guardar reporte en el archivo histórico
        gestorContabilidad.guardarReporteHistorico();
    }
}