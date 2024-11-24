package com.mycompany.proyectofinal.Ventas;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import com.mycompany.proyectofinal.Contabilidad.GestorDeContabilidad;
import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
public class GestorDeVentas {
    // Atributos de la clase GestorDeVentas
    
    private ArrayList<Vaso> pedidoActual;
    private GestorDeInventario gestorInventario;
    private HashMap<String, Pedido> ventasHistoricas;
    private ArrayList<Pedido> ventasDiarias;
    private Queue<Vaso> colaPedidos;
    private Pedido pedidoTemporal;
    private GeneradorArchivosVentas generadorArchivosVentas;
    private GestorDeContabilidad gestorContabilidad; 
    
    // Constructor
    public GestorDeVentas(GestorDeInventario gestorInventario, GestorDeContabilidad gestorContabilidad) {
        
        this.pedidoActual = new ArrayList<>();
        this.gestorInventario=gestorInventario;
        this.gestorContabilidad = gestorContabilidad;
        generadorArchivosVentas = new GeneradorArchivosVentas();
        this.ventasHistoricas = generadorArchivosVentas.getVentasHistoricas();
        this.ventasDiarias = new ArrayList<>();
        this.colaPedidos = new LinkedList<>();
        this.pedidoTemporal= null;
        
    }
    
    public void generarTicket() {
        generadorArchivosVentas.generarTicket(pedidoTemporal); // Pasar el pedido
    }

    public void generarFactura() {
        generadorArchivosVentas.generarFactura(pedidoTemporal); // Pasar el pedido
    }

    // Métodos
    public HashMap<String, Pedido> getVentasHistoricas(){
        return ventasHistoricas;
    }
    public Pedido getPedidoTemporal(){
        return pedidoTemporal;
    }
    public boolean existeVaso(String numVaso) {
        for (Vaso vaso : pedidoActual) {
            if (vaso.getNumVaso().equals(numVaso)) {
                return true; 
            }
        }
        return false; 
    }
    
    private Vaso buscarVasoEnPedido(String numVaso){
        Vaso res = null;
        if(pedidoTemporal==null){
            System.out.println("No existen vasos en su pedido");
        }else{
            boolean encontrado = false;
            ArrayList<Vaso> vasos = pedidoTemporal.getVasos();
            int i=0;
            while(!encontrado && i<=vasos.size()-1){
                if(numVaso.equals(vasos.get(i).getNumVaso())){
                    encontrado=true;
                    res=vasos.get(i);
                }
                i++;
            }
        }
        return res;
    }
    private boolean eliminarVasoEnPedido(String numVaso){
        boolean res = false;
        if(pedidoTemporal==null){
            System.out.println("No existen vasos en su pedido");
        }else{
            ArrayList<Vaso> vasos = pedidoTemporal.getVasos();
            int i=0;
            while(!res && i<=vasos.size()-1){
                if(numVaso.equals(vasos.get(i).getNumVaso())){
                    res=true;
                    vasos.remove(i);
                }
                i++;
            }
            recalcularnums();
        }
        return res;
    }
    public void registrarCliente(String nomb, String nit) {
        int numPedido;
        pedidoTemporal = new Pedido(nomb,nit);
        if(!ventasDiarias.isEmpty()){
            numPedido = ventasDiarias.size()+1;
        }else{
            numPedido = 1;
        }
        pedidoTemporal.setNumPedido(numPedido);
        
    }

    public void agregarVaso(Vaso vaso) {
        pedidoTemporal.añadir(vaso);
        
    }
    public void editarInfoVaso(String numVaso,String infoN,String parametro) {
        Vaso vasoEditado=buscarVasoEnPedido(numVaso);
        if (vasoEditado==null){
            System.out.println("Numero de vaso no existente");
        }else{
            switch(parametro){
              case "Tamaño" -> {vasoEditado.setTamVaso(infoN);
                                vasoEditado.setPrecio(15);}
              case "Base" -> vasoEditado.setBase(infoN);
              case "Tipo Boba" -> vasoEditado.setTipoBoba(infoN);
              case "Sabor 1" -> vasoEditado.setSabor1(infoN);
              case "Sabor 2" -> vasoEditado.setSabor2(infoN);
              default -> System.out.println("No existe tal caracteritica del vaso");
          }   
        }       
        // Metodo que recibe un objeto de tipo vaso , y lo añade a un objeto de tipo pedido 
        // mientras cliente no sea nulo
    }
    public boolean eliminarVaso(String numVaso) {
         
        if (eliminarVasoEnPedido(numVaso)){
          System.out.println("El vaso "+numVaso+" ha sido eliminado");
          return true;
        }else{
          System.out.println("El vaso "+numVaso+" no existe en el pedido"); 
          return false;
        }
    }

    public void confirmarPedido() {
        if (pedidoTemporal != null) {
        ArrayList<Vaso> vasos = pedidoTemporal.getVasos();
        
        if (vasos.isEmpty()) {
            System.out.println("No hay vasos en el pedido para confirmar.");
            return;
        }
        for(Vaso vaso :vasos){
            vaso.setNumPedido(pedidoTemporal.getNumPedido());
            vaso.setNombreCliente(pedidoTemporal.getNombre());
            colaPedidos.add(vaso);
        }
        generadorArchivosVentas.generarTicket(pedidoTemporal);
        generadorArchivosVentas.generarFactura(pedidoTemporal);
        ventasDiarias.add(pedidoTemporal);

        System.out.println("Pedido confirmado para: " + pedidoTemporal.getNombre());
        System.out.println("Número de NIT: " + pedidoTemporal.getNit());
        System.out.println("Número de Pedido: " + pedidoTemporal.getNumPedido());
        System.out.println("Vasos en el pedido: " + vasos.size());
        pedidoTemporal = null;
    } else {
        System.out.println("No hay un pedido temporal para confirmar.");
    }
       
    }

    public void marcarPedidoCompletado() {
        if(!colaPedidos.isEmpty()){
            Vaso vasoCompletado=colaPedidos.poll();
            //actualizarinfo(vasoCompletado);
            System.out.print("El vaso Nro: " + vasoCompletado.getVaso().getNumVaso());
            System.out.print("Del cliente: " + vasoCompletado.getNombreCliente());
            System.out.println(" esta listo");
        }else{
            System.out.println("No existen vasos pendientes");
        }
    }
    private void agregarVentasAHistoricas() {
        for(Pedido pedidoProcesado : ventasDiarias){
            String codigoIdentificador = pedidoProcesado.generarCodigoIdentificador();
            ventasHistoricas.put(codigoIdentificador,pedidoProcesado);
        }
         generadorArchivosVentas.generarReporte(ventasHistoricas);
    }
    public double calcularIngresosTotales() {
        double ingresosTotales = 0;
        
        for (Pedido pedido : ventasHistoricas.values()) {
            ingresosTotales += pedido.calcularTotal(); // Sumando el total de cada pedido
        }
        
        return ingresosTotales;
    }

    public void generarReporteIngresos() {
        double totalIngresos = calcularIngresosTotales();
        System.out.println("Total de ingresos: " + totalIngresos);
    }


    public void volverMenu() {
        agregarVentasAHistoricas();
    }
    public void terminarDia(){
        agregarVentasAHistoricas();
        ventasDiarias = null;
    }


    public void generarReporteVentas() {
        generadorArchivosVentas.generarReporte(ventasHistoricas);
    }

    /*private void actualizarinfo(VasoEnCola vasoCompletado) {
        String sabor1 =vasoCompletado.getVaso().getSabor1();
        String sabor2 =vasoCompletado.getVaso().getSabor2();
        String tamaño =vasoCompletado.getVaso().getTamVaso();
        String perlas =vasoCompletado.getVaso().getTipoBoba();
        String base =vasoCompletado.getVaso().getBase();
        inventario.editarCantidadInsumo(sabor1, "0.2",false);
        inventario.editarCantidadInsumo(sabor2, "0.2",false);
        if("Grande".equals(tamaño)){
            inventario.editarCantidadInsumo(tamaño, "20",false);  
        }else{
            inventario.editarCantidadInsumo(tamaño, "15",false);
        }
        inventario.editarCantidadInsumo(base, "0.2",false);
        inventario.editarCantidadInsumo(perlas, "0.2",false);  
    }
   */

    private void recalcularnums() {
        ArrayList<Vaso> recorrido=pedidoTemporal.getVasos();
        int lim = recorrido.size();
        for(int i=0;i<lim;i++){
            recorrido.get(i).setNumVaso(i+1+"");
        }
    }

}