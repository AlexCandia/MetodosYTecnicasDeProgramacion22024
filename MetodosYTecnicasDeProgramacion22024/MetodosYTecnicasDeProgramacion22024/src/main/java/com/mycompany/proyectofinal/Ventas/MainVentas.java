package com.mycompany.proyectofinal.Ventas;

import com.mycompany.proyectofinal.Inventario.GestorDeInventario;
import java.util.Scanner;

public class MainVentas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        GestorDeInventario inventario = new GestorDeInventario();
        GestorDeVentas gestorVentas = new GestorDeVentas(inventario);

        while (!salir) {
            System.out.println("===== Menú de Ventas =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Agregar vaso al pedido");
            System.out.println("3. Editar información de un vaso");
            System.out.println("4. Eliminar un vaso del pedido");
            System.out.println("5. Confirmar pedido");
            System.out.println("6. Generar ticket y factura");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1 -> registrarCliente(scanner, gestorVentas);
                case 2 -> agregarVaso(scanner, gestorVentas);
                case 3 -> editarVaso(scanner, gestorVentas);
                case 4 -> eliminarVaso(scanner, gestorVentas);
                case 5 -> {
                    gestorVentas.confirmarPedido();
                    System.out.println("Pedido confirmado.");
                }
                case 6 -> generarDocumento(scanner, gestorVentas);
                case 7 -> {
                    salir = true;
                    System.out.println("Gracias por usar el sistema de ventas.");
                }
                default -> System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 7) {
                    return opcion;
                } else {
                    System.out.println("Por favor, ingrese un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
            }
        }
    }

    private static void registrarCliente(Scanner scanner, GestorDeVentas gestorVentas) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el NIT del cliente: ");
        String nit = scanner.nextLine();
        gestorVentas.registrarCliente(nombre, nit);
        System.out.println("Cliente registrado exitosamente.");
    }

    private static void agregarVaso(Scanner scanner, GestorDeVentas gestorVentas) {
        System.out.print("Ingrese el número de vaso: ");
        String numVaso = scanner.nextLine();
        System.out.print("Ingrese el sabor 1: ");
        String sabor1 = scanner.nextLine();
        System.out.print("Ingrese el sabor 2: ");
        String sabor2 = scanner.nextLine();
        System.out.print("Ingrese el tamaño del vaso: ");
        String tamVaso = scanner.nextLine();
        System.out.print("Ingrese la base: ");
        String base = scanner.nextLine();
        System.out.print("Ingrese el tipo de perlas: ");
        String tipoBoba = scanner.nextLine();

        Vaso vaso = new Vaso(tamVaso, base, tipoBoba, sabor1, sabor2);
        gestorVentas.agregarVaso(vaso);
        System.out.println("Vaso agregado exitosamente.");
    }

    private static void editarVaso(Scanner scanner, GestorDeVentas gestorVentas) {
        System.out.print("Ingrese el número de vaso a editar: ");
        String numVasoEditar = scanner.nextLine();

        if (!gestorVentas.existeVaso(numVasoEditar)) {
            System.out.println("El vaso con el número ingresado no existe.");
            return; // Regresar al menú sin editar
        }

        System.out.print("Ingrese el parámetro a editar (tamaño, base, tipoperlas, sabor1, sabor2): ");
        String parametro = scanner.nextLine();
        System.out.print("Ingrese el nuevo valor: ");
        String nuevoValor = scanner.nextLine();

        // Aquí puedes agregar validaciones adicionales para el nuevo valor
        gestorVentas.editarInfoVaso(numVasoEditar, nuevoValor, parametro);
        System.out.println("Vaso editado exitosamente.");
    }

    private static void eliminarVaso(Scanner scanner, GestorDeVentas gestorVentas) {
        System.out.print("Ingrese el número de vaso a eliminar: ");
        String numVasoEliminar = scanner.nextLine();
        
        if (!gestorVentas.existeVaso(numVasoEliminar)) {
            System.out.println("El vaso con el número ingresado no existe.");
            return; // Regresar al menú sin eliminar
        }

        gestorVentas.eliminarVaso(numVasoEliminar);
        System.out.println("Vaso eliminado exitosamente.");
    }

    private static void generarDocumento(Scanner scanner, GestorDeVentas gestorVentas) {
        System.out.print("¿Desea generar un ticket o una factura? (ticket/factura): ");
        String opcionGenerar = scanner.nextLine();
        
        if (opcionGenerar.equalsIgnoreCase("ticket")) {
            gestorVentas.generarTicket();
            System.out.println("Ticket generado exitosamente.");
        } else if (opcionGenerar.equalsIgnoreCase("factura")) {
            gestorVentas.generarFactura();
            System.out.println("Factura generada exitosamente.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
