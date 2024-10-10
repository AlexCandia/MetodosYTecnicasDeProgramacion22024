package Inventario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import PaqueteGeneral.Notificacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import PaqueteGeneral.Notificacion;
import Ventas.GestorDeVentas;

public class GestorDeInventario {
    private GestorDeVentas ventas;
    private final ArrayList<Producto> productos;
    private GeneradorArchivosInventario productsfile;
    public GestorDeInventario() {
        productsfile= new GeneradorArchivosInventario();
        productos=productsfile.getProductos();
    }
    public void vincularVentas(GestorDeVentas ventas){
        this.ventas=ventas;
    }
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    // Método para agregar un producto al inventario
    public void agregar(Producto producto) {
        boolean existe = false;
        for (Producto p : productos) {
            if (p.getNombre().equals(producto.getNombre())) {
                existe = true;
               break;
            }
        }
     if (!existe){
            productos.add(producto);
            System.out.println("Producto agregado correctamente.");
     }else{
            System.out.println("El producto ya existe en el inventario.");
        }
    }
    //metodo para buscar la posicion de un elemento
    private int buscarPos(String nombre){
        int pos = 0;
        Producto prod;
        prod = productos.get(pos);
        while (pos < productos.size() && !nombre.equals( prod.getNombre())){
            prod = productos.get(pos);
            pos++;
        }
        if(!prod.getNombre().equals(nombre)){
            pos = -1;
        }
        return pos;
    }
     private Producto buscarProd(String nombre) {
        Producto producto = null;  

        for (Producto p : productos) {
            if (p.getNombre() != null && p.getNombre().equals(nombre)) {
                producto = p;
                break;  
            }
        }

    return producto; 
}
    
    // Método para eliminar un producto del inventario
    public boolean eliminarProducto(String nombre) {
        boolean res;
        int pos;
        pos = buscarPos(nombre);
        if (pos != -1){
            productos.remove(pos);
            res = true;
        } else {
            res = false;
        }
        return res;
    }
    public void editarCantidadInsumo(String nombre,String nuevoCantidad,Boolean tipoIngreso) {
        Producto editado = buscarProd(nombre);
        if(editado==null){
           System.out.println("El producto que trata de buscar no existe"); 
        }else{
                try {
                    double cantidadFinal;
                    if(tipoIngreso){
                       cantidadFinal = editado.getCantidad()+ Double.parseDouble(nuevoCantidad);
                       editado.recalcularLimite();
                    }else{
                       cantidadFinal = editado.getCantidad()- Double.parseDouble(nuevoCantidad);
                       String mensaje="Poca cantidad de"+editado.getNombre();
                       if(cantidadFinal<=editado.getLimiteMinimo()){
                           Notificacion notificacionLimiteAlcanzado = new Notificacion(
                                   "Producto a punto de agotarse",
                                   mensaje,
                                   "Inventario");
                           ventas.getNotificaciones().add(notificacionLimiteAlcanzado);
                       }
                       
                    }
                    editado.setCantidad(cantidadFinal);
                    System.out.println("Se han ingresado "+nuevoCantidad+" "+ editado.getUnidad()+" de "+nombre+" al inventario");
                } catch (NumberFormatException e) {
                    System.out.println("Ha ingresado un valor incorrecto");
                }
        } 
    }
    // Método para modificar información de un producto
    public void editarInfoProducto(String nombre, String atributo, String nuevoValor) {
        Producto editado = buscarProd(nombre);
        if(editado==null){
           System.out.println("El producto que trata de buscar no existe"); 
        }else{
            switch (atributo) {
                case "nombre" -> editado.setNombre(nuevoValor);
                case "unidad" -> editado.setUnidad(nuevoValor);
                case "cantidad" -> System.out.println("Parametro no editable");  

                case "proovedor" -> editado.setProveedor(nuevoValor);
                case "telefono" -> editado.setTelefono(nuevoValor);
                default -> System.out.println("No existe el atributo descrito");
            }
        }
    }
    // Método para ordenar el inventario por bajo stock
    public void ordenarPorBajoStock() {
        Collections.sort(productos, Comparator.comparingDouble(Producto::getCantidad));
    }

    // Método para ordenar el inventario por nombre
    public void ordenarPorNombre() {
        Collections.sort(productos, Comparator.comparing(Producto::getNombre));
    }

    // Método para guardar el inventario actual en un archivo
    public void guardarInventario() {
        productsfile = new GeneradorArchivosInventario(productos);
        productsfile.añadirAlarchivo();
    }
}

