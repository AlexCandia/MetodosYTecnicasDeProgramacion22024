package com.mycompany.proyectofinal.Contabilidad;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vale
 */
import java.util.*;
import com.mycompany.proyectofinal.Ventas.GestorDeVentas;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import com.mycompany.proyectofinal.Ventas.Pedido;
import com.mycompany.proyectofinal.Ventas.Vaso;
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
    private GestorDeVentas gestorDeVentas;
    private GestorDeInventario gestorDeInventario;
    private HashMap<String, Pedido> ventasHistoricas;

    public GestorDeContabilidad(GestorDeInventario gestorDeInventario,GestorDeVentas gestorDeVentas) {
        egresosFijos = new ArrayList<>();
        egresosInsumos = new ArrayList<>();
        egresosOtros = new ArrayList<>();
        this.gestorDeInventario = gestorDeInventario;
        this.gestorDeVentas = gestorDeVentas;
        ventasHistoricas = gestorDeVentas.getVentasHistoricas();
    }
    public double getIngresosBoba() {
        return ingresosBoba;
    }
    public ArrayList<EgresoFijo> getEgresosFijos() {
        return egresosFijos;
    }
    public ArrayList<EgresoVariableInsumo> getEgresosInsumos() {
        return egresosInsumos;
    }
    public ArrayList<EgresoVariableOtro> getEgresosOtros() {
        return egresosOtros;
    }
    public void calcularIngreso () {
        ingresosBoba=gestorDeVentas.calcularIngresosTotales();
    }

    public void registrarEgresoFijo(EgresoFijo egreso) {
        egresosFijos.add(egreso);
    }

    public void eliminarEgresoFijo(int fila){
        egresosFijos.remove(fila);
    }
    
    public void editarEgresoFijo(int fila, String nom, double val){
        EgresoFijo egr = egresosFijos.get(fila);
        if(!"".equals(nom)){
            egr.setNombreEgreso(nom);
        }
        if(!"".equals(val)){
            egr.setValor(val);
        }
        
        egresosFijos.set(fila, egr);
    }
    
    public void registrarEgresoInsumo(EgresoVariableInsumo egreso) {
        gestorDeInventario.recibirNuevoInsumo(egreso.getNombre(), egreso.getCantidad()+"");
        egresosInsumos.add(egreso);
    }

    public void registrarEgresoOtro(EgresoVariableOtro egreso) {
        egresosOtros.add(egreso);
    }
    
    // Método para calcular el total de egresos fijos
    public double calcularTotalEgresosFijos() {
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
    public double calcularBalance() {
        double totalEgresos = calcularTotalEgresosFijos() + calcularTotalEgresosInsumos() + calcularTotalEgresosOtros();
        return ingresosBoba - totalEgresos;
    }
    public ArrayList<String> obtenerSaboresMasVendidos() {
        HashMap<String, Integer> conteoSabores = new HashMap<>();
        for (Pedido pedido : ventasHistoricas.values()) {
            for (Vaso vaso : pedido.getVasos()) {
                agregarUnidadesDeSabor(conteoSabores, vaso.getSabor1());
                if (vaso.getSabor2() != null && !vaso.getSabor2().isEmpty()) {
                    agregarUnidadesDeSabor(conteoSabores, vaso.getSabor2());
                }
            }
        }
        List<Map.Entry<String, Integer>> listaSabores = new ArrayList<>(conteoSabores.entrySet());
        Collections.sort(listaSabores, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue(); // Ordenar de mayor a menor
            }
        });
        ArrayList<String> saboresMasVendidos = new ArrayList<>();
        for (Map.Entry<String, Integer> entrada : listaSabores) {
            saboresMasVendidos.add(entrada.getKey());
        }

        return saboresMasVendidos;
    }
    private void agregarUnidadesDeSabor(HashMap<String, Integer> conteoSabores, String sabor) {
        if (conteoSabores.containsKey(sabor)) {
            conteoSabores.put(sabor, conteoSabores.get(sabor) + 1);
        } else {
            conteoSabores.put(sabor, 1);
        }
    }
    
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
    public void guardarReporteHistorico() {
        String fecha = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ruta = "C:\\Proyectos\\MetodosYTecnicasDeProgramacion22024\\ProyectoFinal\\src\\main\\java\\Contabilidad\\historicoContabilidad.txt"; // Ruta donde se guardará el archivo

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
