package Contabilidad;


import Ventas.Vaso;
import Ventas.GestorDeVentas;
import Inventario.Insumo;
import Inventario.GestorDeInventario;

public class MenuContabilidad {
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
        Insumo teverde = new Insumo("Té Verde","bolsa","real","6893213");
        gestorInventario.agregar(teverde);
        gestorContabilidad.calcularIngreso();
        // Egresos
        gestorContabilidad.registrarEgresoFijo(new EgresoFijo("Alquiler", 1200));
        gestorContabilidad.registrarEgresoInsumo(new EgresoVariableInsumo("Té Verde", 50, 200.0));
        gestorContabilidad.registrarEgresoOtro(new EgresoVariableOtro("Publicidad", "Facebook Ads", 300));
        
        // Imprimir reporte mensual
        System.out.println(gestorContabilidad.imprimirReporteMensual());
        
        // Guardar reporte en el archivo histórico
        gestorContabilidad.guardarReporteHistorico();
    }
}
