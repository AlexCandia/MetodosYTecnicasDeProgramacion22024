/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;//ñaca 

public class MainInventario {
    Inventario.GestorDeInventario gestor = new Inventario.GestorDeInventario();
    private ArrayList<Inventario.Insumo> productos = new ArrayList<>();
    private final String FILE_NAME = "C:\\Users\\Usuario\\Documents\\NetBeansProjects\\InventarioCopia\\src\\main\\java\\Inventario\\productos.txt";  // Nombre del archivo donde guardaremos los productos

    public static void main(String[] args) {
        MainInventario inventario = new MainInventario();
        inventario.cargarProductosDesdeArchivo();  // Cargar los productos desde el archivo al iniciar
        inventario.mostrarMenu();
        inventario.guardarProductosEnArchivo();  // Guardar los productos al salir del programa
    }

    // Método para mostrar el menú (con opción de salir)
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
        System.out.println("\n---- Menú Inventario ----");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Editar producto");
        System.out.println("4. Mostrar productos");
        System.out.println("5. Ordenar productos por cantidad");
        System.out.println("6. Ordenar productos por nombre");
        System.out.println("7. Salir");

        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        switch (opcion) {
            case 1 -> agregarProducto();
            case 2 -> eliminarProducto();
            case 3 -> editarProducto();  // Opción de editar producto
            case 4 -> mostrarProductos();
            case 5 -> ordenarPorCantidad();  // Opción de ordenar por cantidad
            case 6 -> ordenarPorNombre();  // Opción de ordenar por nombre
            case 7 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida.");
        }
    } while (opcion != 7);

    scanner.close();
    }

    // Método para agregar un producto
    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        // Verificar si el producto ya existe
        if (buscarProductoPorNombre(nombre) != null) {
            System.out.println("El producto con este nombre ya existe en el inventario. No se puede agregar.");
            return; // Salir del método si el producto ya existe
        }
        

        System.out.print("Unidad: ");
        String unidad = scanner.nextLine();
        System.out.print("Cantidad: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea
        System.out.print("Proveedor: ");
        String proveedor = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        // Crear el nuevo producto y agregarlo al inventario
        Inventario.Insumo nuevoProducto = new Inventario.Insumo(nombre, unidad, cantidad, proveedor, telefono);
        productos.add(nuevoProducto);
        System.out.println("Producto agregado exitosamente.");
    }
    // Método para guardar los productos en un archivo de texto
    public void guardarProductosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Inventario.Insumo producto : productos) {
                writer.write(producto.getNombre() + "," +
                             producto.getUnidad() + "," +
                             producto.getCantidad() + "," +
                             producto.getProveedor() + "," +
                             producto.getTelefono());
                writer.newLine();
            }
            System.out.println("Productos guardados en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }

    // Método para cargar los productos desde un archivo de texto
    public void cargarProductosDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    String unidad = datos[1];
                    double cantidad = Double.parseDouble(datos[2]);
                    String proveedor = datos[3];
                    String telefono = datos[4];

                    Inventario.Insumo producto = new Inventario.Insumo(nombre, unidad, cantidad, proveedor, telefono);
                    productos.add(producto);
                }
            }
            System.out.println("Productos cargados desde el archivo.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void eliminarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        Inventario.Insumo productoAEliminar = buscarProductoPorNombre(nombre);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public Inventario.Insumo buscarProductoPorNombre(String nombre) {
        for (Inventario.Insumo producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\n--- Productos en el inventario ---");
            for (Inventario.Insumo producto : productos) {
                System.out.println(producto);
            }
        }
    }
    
    public void editarProducto() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el nombre del producto a editar: ");
    String nombre = scanner.nextLine();
    
    Inventario.Insumo producto = buscarProductoPorNombre(nombre);
    
    if (producto == null) {
        System.out.println("No se encontró el producto con ese nombre.");
        return;
    }

    boolean continuar = true;

    while (continuar) {
        System.out.println("Seleccione la opción que desea editar:");
        System.out.println("1. Nombre");
        System.out.println("2. Unidad");
        System.out.println("3. Cantidad");
        System.out.println("4. Proveedor");
        System.out.println("5. Teléfono");
        System.out.println("6. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                producto.setNombre(nuevoNombre);
                System.out.println("Nombre actualizado.");
                break;
            case 2:
                System.out.print("Nueva unidad: ");
                String nuevaUnidad = scanner.nextLine();
                producto.setUnidad(nuevaUnidad);
                System.out.println("Unidad actualizada.");
                break;
            case 3:
                System.out.print("Nueva cantidad: ");
                double nuevaCantidad = scanner.nextDouble();
                producto.setCantidad(nuevaCantidad);
                System.out.println("Cantidad actualizada.");
                break;
            case 4:
                System.out.print("Nuevo proveedor: ");
                String nuevoProveedor = scanner.nextLine();
                producto.setProveedor(nuevoProveedor);
                System.out.println("Proveedor actualizado.");
                break;
            case 5:
                System.out.print("Nuevo teléfono: ");
                String nuevoTelefono = scanner.nextLine();
                producto.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado.");
                break;
            case 6:
                continuar = false; // Salir del bucle
                System.out.println("Saliendo del menú de edición.");
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
    }
    public void ordenarPorCantidad() {
    Collections.sort(productos, new Comparator<Inventario.Insumo>() {
        @Override
        public int compare(Inventario.Insumo p1, Inventario.Insumo p2) {
            return Double.compare(p1.getCantidad(), p2.getCantidad());
        }
    });
    System.out.println("Inventario ordenado por cantidad.");
    mostrarProductos();
    }
    public void ordenarPorNombre() {
    Collections.sort(productos, new Comparator<Inventario.Insumo>() {
        @Override
        public int compare(Inventario.Insumo p1, Inventario.Insumo p2) {
            return p1.getNombre().compareToIgnoreCase(p2.getNombre());
        }
    });
    System.out.println("Inventario ordenado por nombre.");
    mostrarProductos();
    }
    
}
