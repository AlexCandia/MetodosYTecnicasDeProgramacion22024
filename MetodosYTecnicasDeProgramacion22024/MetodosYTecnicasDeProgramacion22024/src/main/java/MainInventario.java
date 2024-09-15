/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class MainInventario {
   public static void main(String[] args) {
        // Crear una instancia del inventario
        Inventario inventario = new Inventario();

        // Crear algunos productos para probar
     //   Producto prod1 = new Producto("Laptop", "unidad", 10.0, "Proveedor1", "123456789");
     //   Producto prod2 = new Producto("Mouse", "unidad", 50.0, "Proveedor2", "987654321");
     //   Producto prod3 = new Producto("Teclado", "unidad", 30.0, "Proveedor3", "111222333");

        // Agregar productos al inventario
        //inventario.agregar(prod1);
       // inventario.agregar(prod2);
        //inventario.agregar(prod3);

        // Mostrar el inventario actual ordenado por nombre
     //   inventario.ordenarPorNombre();
        System.out.println("Inventario ordenado por nombre:");
       for (Producto p : inventario.getProductos()) {
            System.out.println(p.getNombre() + " - " + p.getCantidad() + " - " + p.getProveedor() + " - " + p.getTelefono());
          }

        // Modificar la cantidad de un producto
    //    inventario.modificarCantidad("Mouse", 60.0);

        // Eliminar un producto
      //  if (inventario.eliminarProducto("Teclado")) {
     //       System.out.println("Producto 'Teclado' eliminado.");
     //   } else {
     //       System.out.println("Producto 'Teclado' no encontrado.");
     //   }

        // Guardar el inventario en el archivo
    //    inventario.guardarInventario();
     //   System.out.println("Inventario guardado en el archivo.");

        // Salir del programa (opcional)
        System.out.println("Fin de la prueba.");
    }
}
