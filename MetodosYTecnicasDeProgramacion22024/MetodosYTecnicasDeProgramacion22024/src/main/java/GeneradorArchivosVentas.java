
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class GeneradorArchivosVentas {
     private static final String FILE_PATH1 = "C:\\Users\\developerweb\\Documents\\NetBeansProjects\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\ticket.txt";
     private static final String FILE_PATH2 = "C:\\Users\\developerweb\\Documents\\NetBeansProjects\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\factura.txt";
     private static final String FILE_PATH3 = "C:\\Users\\developerweb\\Documents\\NetBeansProjects\\MetodosYTecnicasDeProgramacion22024\\MetodosYTecnicasDeProgramacion22024\\src\\main\\java\\historico.txt";
     public GeneradorArchivosVentas() {
    }
    public void generarTicket(Pedido pedido){
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH1))) {
            writer.write("Nro Pedido:"+pedido.getNumPedido()+"Nombre:"+pedido.getNombre());
            writer.newLine();
            for (Vaso vaso : pedido.getVasos()) {
                writer.write("Nro Vaso:"+vaso.getNumVaso()+ "Sabor 1 :" +vaso.getSabor1()+ "Sabor 2 :" + vaso.getSabor2()+ "Tamaño :" + 
                        vaso.getTamVaso()+ "Tipo Perlas:" + vaso.getTipoBoba());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al crear ticket: " + e.getMessage());
        } 
    }
    public void generarFactura(Pedido pedido){
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH2))) {
            writer.write("Nombre:"+pedido.getNombre()+"NIT:"+pedido.getNit());
            writer.newLine();
            int total =0;
            for (Vaso vaso : pedido.getVasos()) {
                total+=vaso.getPrecio();
                writer.write("Nro Vaso:"+vaso.getNumVaso()+ "Sabor 1 :" +vaso.getSabor1()+ "Sabor 2 :" + 
                        vaso.getSabor2()+ "Tamaño :" + vaso.getTamVaso()+ "Tipo Perlas:" + vaso.getTipoBoba()+
                        vaso.getPrecio());
                writer.newLine();
            }
            writer.write("Total : "+total);
        } catch (IOException e) {
            System.out.println("Error al crear la factura: " + e.getMessage());
        } 
    }

    public void generarReporte(HashMap<String, Pedido> ventasHistoricas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH3))) {
            writer.write("Ventas Historicas:");
            writer.newLine();
            String fechaAnterior = "";
            for (String clave : ventasHistoricas.keySet()) {
                Pedido pedido = ventasHistoricas.get(clave);
                String fechaFormateada = String.format("%1$td/%1$tm/%1$ty", pedido.getFecha());
                if(!fechaFormateada.equals(fechaAnterior)){
                   writer.write("Fecha:"+fechaFormateada);
                   writer.newLine();
                   fechaAnterior=fechaFormateada;
                }
                writer.write("Pedido:"+pedido.getNumPedido());
                writer.newLine();
                int total=0;
                    for (Vaso vaso : pedido.getVasos()) {
                    total+=vaso.getPrecio();
                    writer.write("Nro Vaso:"+vaso.getNumVaso()+ "Sabor 1 :" +vaso.getSabor1()+ "Sabor 2 :" + 
                            vaso.getSabor2()+ "Tamaño :" + vaso.getTamVaso()+ "Tipo Perlas:" + vaso.getTipoBoba()+ 
                            "SubTotal:"+vaso.getPrecio());
                    writer.newLine();
                }
                String totalToString = total+"";
                writer.write("Total: "+totalToString);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al crear la el reporte: " + e.getMessage());
        } 
    }
    
    
}
