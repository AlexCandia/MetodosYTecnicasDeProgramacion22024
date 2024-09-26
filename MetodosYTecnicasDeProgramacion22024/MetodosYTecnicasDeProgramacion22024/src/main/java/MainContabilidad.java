public class MainContabilidad {
    public static void main(String[] args) {
        GestorDeContabilidad gestor = new GestorDeContabilidad();
        
        // Simulamos ingresos y egresos
        gestor.registrarIngreso(5000);
        
        // Egresos
        gestor.registrarEgresoFijo(new EgresoFijo("Alquiler", 1200));
        gestor.registrarEgresoInsumo(new EgresoVariableInsumo("Té Verde", 50, 200));
        gestor.registrarEgresoOtro(new EgresoVariableOtro("Publicidad", "Facebook Ads", 300));
        
        // Imprimir reporte mensual
        System.out.println(gestor.imprimirReporteMensual());
        
        // Guardar reporte en el archivo histórico
        gestor.guardarReporteHistorico();
    }
}
