/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal.Contabilidad;

import com.mycompany.proyectofinal.Inventario.Insumo;
import com.mycompany.proyectofinal.Inventario.Proveedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author developerweb
 */
public class GeneradorArchivosContabilidad {
    private ArrayList<EgresoFijo> egresosFijos;
    private ArrayList<EgresoInsumo> egresosInsumos;
    private ArrayList<EgresoVariable> egresosVariables;
    public GeneradorArchivosContabilidad(){
         cargarEgresosFijos();
         cargarEgresosVariables();
         cargarEgresosInsumos();
    }
    public ArrayList<EgresoFijo> getEgresosFijos(){
        return egresosFijos;
    }
    public ArrayList<EgresoInsumo> getEgresosInsumos(){
        return egresosInsumos;
    }
    public ArrayList<EgresoVariable> getEgresosVariables(){
        return egresosVariables;
    }
    public void setEgresosFijos(ArrayList<EgresoFijo> egresosFijos){
        this.egresosFijos=egresosFijos;              
    }
    public void setEgresosInsumos(ArrayList<EgresoInsumo> egresosInsumos){
        this.egresosInsumos=egresosInsumos;              
    }
    public void setEgresosVariables(ArrayList<EgresoVariable> egresosVariables){
        this.egresosVariables=egresosVariables;              
    }
    private static final String FILE_PATH = "C:\\Users\\developerweb\\Desktop\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\com\\mycompany\\proyectofinal\\Contabilidad\\EgresosFijos.txt";
    private static final String FILE_PATH2 = "C:\\Users\\developerweb\\Desktop\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\com\\mycompany\\proyectofinal\\Contabilidad\\EgresosInsumos.txt";
    private static final String FILE_PATH3 = "C:\\Users\\developerweb\\Desktop\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\com\\mycompany\\proyectofinal\\Contabilidad\\EgresosVariables.txt";
    
    public void añadirAlarchivoEgresosFijos(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
              for (EgresoFijo egresoFijo : egresosFijos) {
                  writer.write(egresoFijo.getFecha()+ "!" + egresoFijo.getDetalle()+ "!" + egresoFijo.getValor()+"");
                  writer.newLine();
              }
          } catch (IOException e) {
              System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
          }
    }
    
    public void añadirAlarchivoEgresosInsumos(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH2))) {
              for (EgresoInsumo egresoInsumo : egresosInsumos) {
                  writer.write(egresoInsumo.getFecha()+ "!" + egresoInsumo.getNombre()+ "!" + egresoInsumo.getCantidad()+"" + "!" + egresoInsumo.getValor()+"");
                  writer.newLine();
              }
          } catch (IOException e) {
              System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
          }
    }
    
    public void añadirAlarchivoEgresosVariables(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH3))) {
              for (EgresoVariable egresoVariable : egresosVariables) {
                  writer.write(egresoVariable.getFecha()+ "!" + egresoVariable.getNombre()+ "!" + egresoVariable.getDetalle()+"" + "!" + egresoVariable.getValor()+"");
                  writer.newLine();
              }
          } catch (IOException e) {
              System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
          }
    }
    
    private ArrayList<EgresoFijo> cargarEgresosFijos() {
      egresosFijos = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("!");
                if (parts.length == 3){
                    String fecha = parts[0];
                    String detalle = parts[1];
                    String valor = parts[2];
                    Double value = Double.valueOf(valor);
                    EgresoFijo egresoFijo =new EgresoFijo(fecha,detalle,value);
                    egresosFijos.add(egresoFijo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de egresos no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al cargar egresos desde el archivo: " + e.getMessage());
        }
      return egresosFijos;  
    }

    private ArrayList<EgresoVariable> cargarEgresosVariables() {
       egresosVariables = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH2))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("!");
                if (parts.length == 4){
                    String fecha = parts[0];
                    String nombre = parts[1];
                    String detalle = parts[2];
                    String valor = parts[3];
                    Double value = Double.valueOf(valor);
                    EgresoVariable egresoVariable =new EgresoVariable(fecha,nombre,detalle,value);
                    egresosVariables.add(egresoVariable);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de egresos no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al cargar egresos desde el archivo: " + e.getMessage());
        }
      return egresosVariables;
    }

    private ArrayList<EgresoInsumo> cargarEgresosInsumos() {
       egresosInsumos = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH3))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("!");
                if (parts.length == 4){
                    String fecha = parts[0];
                    String nombre = parts[1];
                    String cantidad = parts[2];
                    String valor = parts[3];
                    Integer cantidadI = Integer.valueOf(cantidad);
                    Double value = Double.valueOf(valor);
                    EgresoInsumo egresoInsumo =new EgresoInsumo(fecha,nombre,cantidadI,value);
                    egresosInsumos.add(egresoInsumo);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de egresos no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al cargar egresos desde el archivo: " + e.getMessage());
        }
      return egresosInsumos; 
    }
}
