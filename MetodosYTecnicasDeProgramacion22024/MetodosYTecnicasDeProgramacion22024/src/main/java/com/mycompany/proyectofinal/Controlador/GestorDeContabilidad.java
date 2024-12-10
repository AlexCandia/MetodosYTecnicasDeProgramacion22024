package com.mycompany.proyectofinal.Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vale
 */
import com.mycompany.proyectofinal.Modelo.EgresoInsumo;
import com.mycompany.proyectofinal.Modelo.EgresoFijo;
import com.mycompany.proyectofinal.Modelo.EgresoVariable;
import java.util.*;
import com.mycompany.proyectofinal.Modelo.Pedido;
import com.mycompany.proyectofinal.Modelo.Vaso;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorDeContabilidad {

    private double ingresosBoba;
    private GeneradorArchivosContabilidad egresosFile;
    private ArrayList<EgresoFijo> egresosFijos;
    private ArrayList<EgresoInsumo> egresosInsumos;
    private ArrayList<EgresoVariable> egresosVariables;
    private GestorDeInventario gestorDeInventario;
    private HashMap<String, Pedido> ventasHistoricas;

    public GestorDeContabilidad(GestorDeInventario gestorDeInventario) {
        egresosFile = new GeneradorArchivosContabilidad(); 
        egresosFijos = egresosFile.getEgresosFijos();
        egresosInsumos = egresosFile.getEgresosInsumos();
        egresosVariables = egresosFile.getEgresosVariables();
        this.gestorDeInventario = gestorDeInventario;
    }
    public double getIngresosBoba() {
        return ingresosBoba;
    }
    public ArrayList<EgresoFijo> getEgresosFijos() {
        return egresosFijos;
    }
    public ArrayList<EgresoInsumo> getEgresosInsumos() {
        return egresosInsumos;
    }
    public ArrayList<EgresoVariable> getEgresosVariables() {
        return egresosVariables;
    }

    public void registrarEgresoFijo(EgresoFijo egreso) {
        egresosFijos.add(egreso);
    }

    public void eliminarEgresoFijo(int fila){
        egresosFijos.remove(fila);
    }
    
    public void editarEgresoFijo(int fila, String det, double val){
        EgresoFijo egr = egresosFijos.get(fila);
        if(!"".equals(det)){
            egr.setDetalle(det);
        }
        if(val != -1){
            egr.setValor(val);
        }
    }
    
    public void registrarEgresoInsumo(EgresoInsumo egreso) {
        egresosInsumos.add(egreso);
    }
    
    public void eliminarEgresoInsumo(int fila){
        egresosInsumos.remove(fila);
    }
    
    public void editarEgresoInsumo(int fila, String nom, int cant, double val){
        EgresoInsumo egr = egresosInsumos.get(fila);
        if(!"".equals(nom)){
            egr.setNombre(nom);
        }
        
        if(cant != -1){
            egr.setCantidad(cant);
        }
        
        if(val != -1){
            egr.setValor(val);
        }
    }

    public void registrarEgresoVariable(EgresoVariable egreso) {
        egresosVariables.add(egreso);
    }
    
    public void eliminarEgresoVariable(int fila){
        egresosVariables.remove(fila);
    }
    
    public void editarEgresoVariable(int fila, String nom, String det, double val){
        EgresoVariable egr = egresosVariables.get(fila);
        if(!"".equals(nom)){
            egr.setNombre(nom);
        }
        
        if(!"".equals(det)){
            egr.setDetalle(det);
        }
        
        if(val != -1){
            egr.setValor(val);
        }
    }
    
    // Método para calcular el total de egresos fijos
    public double calcularTotalEgresosFijos() {
        if (!egresosFijos.isEmpty()){
            return egresosFijos.stream().mapToDouble(EgresoFijo::getValor).sum();
        }else{
            return 0.0;  
        }
    }

    // Método para calcular el total de egresos de insumos
    public double calcularTotalEgresosInsumos() {
        if (!egresosInsumos.isEmpty()){
           return egresosInsumos.stream().mapToDouble(EgresoInsumo::getValor).sum(); 
        }else{
            return 0.0;
        }
    }

    // Método para calcular el total de egresos varios
    public double calcularTotalEgresosVariables() {
        if(!egresosVariables.isEmpty()){
            return egresosVariables.stream().mapToDouble(EgresoVariable::getValor).sum(); 
        }else{
            return 0.0;
        }
    }

    // Método para calcular el balance (ganancias o pérdidas)
    public double calcularBalance() {
        double totalEgresos = calcularTotalEgresosFijos() + calcularTotalEgresosInsumos() + calcularTotalEgresosVariables();
        return ingresosBoba - totalEgresos;
    }
    
    
    private void agregarUnidadesDeSabor(HashMap<String, Integer> conteoSabores, String sabor) {
        if (conteoSabores.containsKey(sabor)) {
            conteoSabores.put(sabor, conteoSabores.get(sabor) + 1);
        } else {
            conteoSabores.put(sabor, 1);
        }
    }
    
    public String imprimirReporteMensual(double ingresos) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte Mensual\n");
        reporte.append("Ingresos totales: ").append(ingresos).append("\n");
        reporte.append("Egresos Fijos: ").append(calcularTotalEgresosFijos()).append("\n");
        reporte.append("Egresos Insumos: ").append(calcularTotalEgresosInsumos()).append("\n");
        reporte.append("Egresos Otros: ").append(calcularTotalEgresosVariables()).append("\n");
        reporte.append("Balance: ").append(calcularBalance()).append("\n");
        return reporte.toString();
    }
    public void guardarReporteHistorico(double ingresos) {
        String fecha = LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String ruta = "target/Archivos/ArchivosContabilidad/historicoContabilidad.txt";
        try (FileWriter writer = new FileWriter(ruta, true)) { // El true añade el contenido sin borrar el archivo anterior
            writer.write("Historial Contable - Fecha: " + fecha + "\n");
            writer.write(imprimirReporteMensual(ingresos));
            writer.write("\n-------------------------\n");
            System.out.println("Reporte histórico guardado en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar el reporte histórico: " + e.getMessage());
        }
    }
    public void guardarEgresosFijos() {
        egresosFile.setEgresosFijos(egresosFijos);
        egresosFile.añadirAlarchivoEgresosFijos();
    }
    public void guardarEgresosInsumos() {
        egresosFile.setEgresosInsumos(egresosInsumos);
        egresosFile.añadirAlarchivoEgresosInsumos();
    }
    public void guardarEgresosVariables() {
        egresosFile.setEgresosVariables(egresosVariables);
        egresosFile.añadirAlarchivoEgresosVariables();
    }
}
