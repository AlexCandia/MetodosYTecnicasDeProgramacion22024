/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Camila
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventario {
    private ArrayList<Producto> productos;
    private GenerarArchivosInventario productsfile;
    public Inventario() {
        productsfile= new GenerarArchivosInventario();
        productos=productsfile.getProductos();
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
        while (pos < productos.size() && nombre.equals( prod.getNombre())){
            pos++;
            prod = productos.get(pos);
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

    // Método para modificar información de un producto
    public void editarProducto(String nombre, String atributo, String nuevoValor) {
        Producto editado = buscarProd(nombre);
        if(editado==null){
           System.out.println("El producto que trata de buscar no existe"); 
        }else{
            switch (atributo) {
            case "nombre" -> editado.setNombre(nuevoValor);
            case "unidad" -> editado.setUnidad(nuevoValor);
            case "cantidad" -> {
                int cantidadAgregada;
                try {
                    cantidadAgregada = Integer.parseInt(nuevoValor);
                } catch (NumberFormatException e) {
                    System.out.println("Ha ingresado un valor incorrecto");
                    break;
                }
                double cantidadFinal = editado.getCantidad()+ (double)cantidadAgregada;
                editado.setCantidad(cantidadFinal);
                }
            case "proovedor" -> editado.setProveedor(nuevoValor);
            case "telefono" -> editado.setTelefono(nuevoValor);
            default -> System.out.println("No existe el atributo descrito");
        }
        }
    }

    // Método para modificar la cantidad de un producto
    public void modificarCantidad(String nombre, double nuevoValor) {
        // Aquí deberás implementar la lógica para modificar la cantidad de un producto
        //Implementacion de ventas necesaria
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
        productsfile = new GenerarArchivosInventario(productos);
        productsfile.añadirAlarchivo();
    }

    // Método para volver al menú (placeholder, según tu diagrama de clases)
   public void volverMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Mostrar menú de opciones
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Modificar producto");
        System.out.println("4. Ordenar por bajo stock");
        System.out.println("5. Ordenar por nombre");
        System.out.println("6. Guardar inventario");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
        
        // Leer la opción seleccionada por el usuario
        opcion = scanner.nextInt();
        scanner.nextLine();

        // Realizar la acción correspondiente según la opción seleccionada
        switch (opcion) {
            case 1:
                // Llamar al método para registrar nuevo producto
                agregar(new Producto("Nombre", "Unidad", 0.0, "Proveedor", "Teléfono"));
                break;
            case 2:
                // Llamar al método para eliminar producto
                eliminarProducto("Nombre");
                break;
            case 3:
                // Llamar al método para modificar producto
                editarProducto("Nombre", "Atributo", "Nuevo Valor");
                break;
            case 4:
                // Llamar al método para ordenar por bajo stock
                ordenarPorBajoStock();
                break;
            case 5:
                // Llamar al método para ordenar por nombre
                ordenarPorNombre();
                break;
            case 6:
                // Llamar al método para guardar inventario
                guardarInventario();
                break;
            case 7:
                // Salir del programa
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
                break;
        }
    }
}


