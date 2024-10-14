package InicioyRegistro;

import java.util.Scanner;

public class MenuInicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GeneradorArchivosUsuarios userDatabase = new GeneradorArchivosUsuarios();
        Inicio authService = new Inicio(userDatabase);

        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (choice) {
                case 1:
                    // Registro de usuario
                    System.out.print("Ingrese nombre de usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String contraseña = scanner.nextLine();
                    System.out.print("Ingrese código de empleado: ");
                    String codigoE = scanner.nextLine();
                    Usuario nuevoUs = new Usuario(nombre, contraseña, codigoE);
                    if (authService.registrarUsuario(nuevoUs)) {
                        System.out.println("Registro exitoso.");
                    }
                    break;
                case 2:
                    // Inicio de sesión
                    System.out.print("Ingrese código de empleado: ");
                    String codigoE2 = scanner.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String password = scanner.nextLine();
                    if (authService.login(codigoE2, password)) {
                        System.out.println("Inicio de sesión exitoso.");
                        mostrarMenuPrincipal(scanner);  // Menú principal después de iniciar sesión
                    } else {
                        System.out.println("Código o contraseña incorrectos.");
                    }
                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    // Método para mostrar el menú principal después de iniciar sesión
    public static void mostrarMenuPrincipal(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Inventario");
            System.out.println("2. Contabilidad");
            System.out.println("3. Ventas");
            System.out.println("4. Cerrar sesión");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Lógica de inventario
                    System.out.println("Gestión de inventario seleccionada.");
                    gestionarInventario(scanner);
                    break;
                case 2:
                    // Lógica de contabilidad
                    System.out.println("Gestión de contabilidad seleccionada.");
                    gestionarContabilidad(scanner);
                    break;
                case 3:
                    // Lógica de ventas
                    System.out.println("Gestión de ventas seleccionada.");
                    gestionarVentas(scanner);
                    break;
                case 4:
                    // Cerrar sesión
                    System.out.println("Cerrando sesión...");
                    return;  // Volver al menú principal
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    // Métodos de gestión básicos
    public static void gestionarInventario(Scanner scanner) {
        System.out.println("Aquí se mostraría la gestión del inventario.");
        // Añadir más interacciones según la lógica de tu inventario
    }

    public static void gestionarContabilidad(Scanner scanner) {
        System.out.println("Aquí se mostraría la gestión de la contabilidad.");
        // Añadir más interacciones según la lógica de tu contabilidad
    }

    public static void gestionarVentas(Scanner scanner) {
        System.out.println("Aquí se mostraría la gestión de ventas.");
        // Añadir más interacciones según la lógica de tus ventas
    }
}
