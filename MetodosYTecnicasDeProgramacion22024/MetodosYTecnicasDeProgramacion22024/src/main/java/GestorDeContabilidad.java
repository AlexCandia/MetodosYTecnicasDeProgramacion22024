/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vale
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorDeContabilidad {

    private double ingresosBoba;
    private ArrayList<EgresoFijo> egresosFijos;
    private ArrayList<EgresoVariableInsumo> egresosInsumos;
    private ArrayList<EgresoVariableOtro> egresosOtros;

    public GestorDeContabilidad() {
        ingresosBoba = 0;
        egresosFijos = new ArrayList<>();
        egresosInsumos = new ArrayList<>();
        egresosOtros = new ArrayList<>();
    }

    public void registrarIngreso(double ingreso) {
        ingresosBoba += ingreso;
    }

    public void registrarEgresoFijo(EgresoFijo egreso) {
        egresosFijos.add(egreso);
    }

    public void registrarEgresoInsumo(EgresoVariableInsumo egreso) {
        egresosInsumos.add(egreso);
    }

    public void registrarEgresoOtro(EgresoVariableOtro egreso) {
        egresosOtros.add(egreso);
    }

    // Método para calcular el total de egresos fijos
    private double calcularTotalEgresosFijos() {
        return egresosFijos.stream().mapToDouble(EgresoFijo::getValor).sum();
    }

    // Método para calcular el total de egresos de insumos
    private double calcularTotalEgresosInsumos() {
        return egresosInsumos.stream().mapToDouble(EgresoVariableInsumo::getValor).sum();
    }

    // Método para calcular el total de egresos varios
    private double calcularTotalEgresosOtros() {
        return egresosOtros.stream().mapToDouble(EgresoVariableOtro::getValor).sum();
    }

    // Método para calcular el balance (ganancias o pérdidas)
    private double calcularBalance() {
        double totalEgresos = calcularTotalEgresosFijos() + calcularTotalEgresosInsumos() + calcularTotalEgresosOtros();
        return ingresosBoba - totalEgresos;
    }

    // Método para generar el reporte mensual
    public String imprimirReporteMensual() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte Mensual\n");
        reporte.append("Ingresos totales: ").append(ingresosBoba).append("\n");
        reporte.append("Egresos Fijos: ").append(calcularTotalEgresosFijos()).append("\n");
        reporte.append("Egresos Insumos: ").append(calcularTotalEgresosInsumos()).append("\n");
        reporte.append("Egresos Otros: ").append(calcularTotalEgresosOtros()).append("\n");
        reporte.append("Balance: ").append(calcularBalance()).append("\n");
        return reporte.toString();
    }

    // Método para guardar el reporte histórico en un archivo
    public void guardarReporteHistorico() {
        String fecha = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ruta = "C:\\Proyectos\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion2\\src\\test\\java\\historicoContabilidad.txt"; // Ruta donde se guardará el archivo

        // Verifica si la carpeta existe, si no la crea
        Path path = Paths.get("C://");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                System.out.println("Error al crear la carpeta: " + e.getMessage());
            }
        }

        try (FileWriter writer = new FileWriter(ruta, true)) { // El true añade el contenido sin borrar el archivo anterior
            writer.write("Historial Contable - Fecha: " + fecha + "\n");
            writer.write(imprimirReporteMensual());
            writer.write("\n-------------------------\n");
            System.out.println("Reporte histórico guardado en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar el reporte histórico: " + e.getMessage());
        }
    }
    
    public void imprimirReporteHistorico() {
        guardarReporteHistorico();
    }
}
