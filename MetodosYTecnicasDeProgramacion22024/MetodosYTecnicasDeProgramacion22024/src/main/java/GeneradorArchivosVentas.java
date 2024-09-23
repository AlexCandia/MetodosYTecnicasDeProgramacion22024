
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private HashMap<String, Pedido> ventasHistoricas;
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
                        vaso.getTamVaso()+ "Base:"+vaso.getBase()+"Tipo Perlas:" + vaso.getTipoBoba());
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
                writer.write("Pedido:"+pedido.getNumPedido()+"Cliente:"+pedido.getNombre()+"NIT:"+pedido.getNit());
                writer.newLine();
                int total=0;
                    for (Vaso vaso : pedido.getVasos()) {
                    total+=vaso.getPrecio();
                    writer.write("Nro Vaso:"+vaso.getNumVaso()+ "Sabor 1 :" +vaso.getSabor1()+ "Sabor 2 :" + 
                            vaso.getSabor2()+ "Tamaño :" + vaso.getTamVaso()+ "Base:" +vaso.getBase() + "Tipo Perlas:" + vaso.getTipoBoba()+ 
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
    public HashMap<String, Pedido> cargarVentasHistoricasDesdeArchivo() {
        ventasHistoricas = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH3))) {
        Pedido pedidoActual = null;
        String linea;
        String fechaActual = "";

        while ((linea = reader.readLine()) != null) {
            if (linea.startsWith("Fecha:")) {
                fechaActual = linea.split(":")[1].trim();  // Leer la fecha
            } else if (linea.startsWith("Pedido:")) {
                // Extraer los datos de la línea de "Pedido"
                String numPedido = getValue(linea, "Pedido:", "Cliente:");
                String nombre = getValue(linea, "Cliente:", "NIT:");
                String nit = getValue(linea, "NIT:", null);  // El último valor de la línea

                // Convertir numPedido a entero
                int numPedidoInt = Integer.parseInt(numPedido);

                // Crear el pedido
                Date fecha = parseFecha(fechaActual);
                pedidoActual = new Pedido(nombre, nit);
                pedidoActual.setFecha(fecha);
                pedidoActual.setNumPedido(numPedidoInt);

                // Generar el código identificador para el pedido
                String cod = pedidoActual.generarCodigoIdentificador();
                ventasHistoricas.put(cod, pedidoActual);
            } else if (linea.startsWith("Nro Vaso:")) {
                // Extraer los datos del vaso y añadirlo al pedido actual
                String sabor1 = getValue(linea, "Sabor 1 :", "Sabor 2 :");
                String sabor2 = getValue(linea, "Sabor 2 :", "Tamaño :");
                String tamaño = getValue(linea, "Tamaño :", "Base:");
                String base = getValue(linea, "Base:", "Tipo Perlas:");
                String perlas = getValue(linea, "Tipo Perlas:", null);  // Último campo

                // Crear un nuevo Vaso y agregarlo al pedido actual
                Vaso vaso = new Vaso(tamaño, base, perlas, sabor1, sabor2);
                pedidoActual.añadir(vaso);
            } else if (linea.startsWith("Total:")) {
                // Podrías procesar el total si es necesario
            }
        }
    } catch (IOException e) {
        System.out.println("Error al cargar el archivo de ventas históricas: " + e.getMessage());
    }
    return ventasHistoricas;
}

// Método auxiliar para extraer valores entre dos etiquetas
private String getValue(String line, String startKey, String endKey) {
    int start = line.indexOf(startKey) + startKey.length();
    int end = (endKey != null) ? line.indexOf(endKey, start) : line.length();
    return line.substring(start, end).trim();
}

private Date parseFecha(String fechaStr) {
    // Método para convertir una fecha en formato dd/MM/yy a un objeto Date
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
    try {
        return formatter.parse(fechaStr);
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
    }
}

    
    
}
