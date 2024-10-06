package Ventas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import Inventario.GestorDeInventario;
import Ventas.GeneradorArchivosVentas;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
public class GestorDeVentas {
    // Atributos de la clase GestorDeVentas
    private GestorDeInventario inventario;
    private HashMap<String, Pedido> ventasHistoricas;
    private ArrayList<Pedido> ventasDiarias;
    private Queue<VasoEnCola> colaPedidos;
    private Pedido pedidoTemporal;
    private GeneradorArchivosVentas generadorArchivosVentas;

    // Constructor
    public GestorDeVentas(GestorDeInventario inventario) {
        this.inventario=inventario;
        generadorArchivosVentas = new GeneradorArchivosVentas();
        this.ventasHistoricas = generadorArchivosVentas.cargarVentasHistoricasDesdeArchivo();
        this.ventasDiarias = new ArrayList<>();
        this.colaPedidos = new LinkedList<>();
        this.pedidoTemporal= null;
    }
    // Métodos
    public HashMap<String, Pedido> getVentasHistoricas(){
        return ventasHistoricas;
    }
    public Pedido getPedidoTemporal(){
        return pedidoTemporal;
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
        // Recibe la informacion de un cliente (nombre,nit) para que todos los pedidos(vasos) sean 
        // registrados a dicho nombre.
    }

    public void agregarVaso(Vaso vaso) {
        pedidoTemporal.añadir(vaso);
        // Metodo que recibe un objeto de tipo vaso , y lo añade a un objeto de tipo pedido 
        // mientras cliente no sea nulo
    }
    public void editarInfoVaso(String numVaso,String infoN,String parametro) {
        Vaso vasoEditado=buscarVasoEnPedido(numVaso);
        if (vasoEditado==null){
            System.out.println("Numero de vaso no existente");
        }else{
            switch(parametro){
              case "tamaño" -> {vasoEditado.setTamVaso(infoN);
                                vasoEditado.setPrecio(15);}
              case "base" -> vasoEditado.setBase(infoN);
              case "tipoperlas" -> vasoEditado.setTipoBoba(infoN);
              case "sabor1" -> vasoEditado.setSabor1(infoN);
              case "sabor2" -> vasoEditado.setSabor2(infoN);
              default -> System.out.println("No existe tal caracteritica del vaso");
          }   
        }       
        // Metodo que recibe un objeto de tipo vaso , y lo añade a un objeto de tipo pedido 
        // mientras cliente no sea nulo
    }
    public void eliminarVaso(String numVaso) {
         
        if (eliminarVasoEnPedido(numVaso)){
          System.out.println("El vaso "+numVaso+" ha sido eliminado");
        }else{
          System.out.println("El vaso "+numVaso+" no existe en el pedido"); 
        }
        // Metodo que recibe un objeto de tipo vaso , y lo añade a un objeto de tipo pedido 
        // mientras cliente no sea nulo
    }

    public void confirmarPedido() {
        if (pedidoTemporal != null) {
        ArrayList<Vaso> vasos = pedidoTemporal.getVasos();
        
        if (vasos.isEmpty()) {
            System.out.println("No hay vasos en el pedido para confirmar.");
            return;
        }
        for(Vaso vaso :vasos){
            VasoEnCola pedidoEnCola = new VasoEnCola(
                pedidoTemporal.getNumPedido(),
                pedidoTemporal.getNombre(),
                vaso
            );
            colaPedidos.add(pedidoEnCola);
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
            VasoEnCola vasoCompletado=colaPedidos.poll();
            actualizarinfo(vasoCompletado);
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

    private void actualizarinfo(VasoEnCola vasoCompletado) {
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

}


