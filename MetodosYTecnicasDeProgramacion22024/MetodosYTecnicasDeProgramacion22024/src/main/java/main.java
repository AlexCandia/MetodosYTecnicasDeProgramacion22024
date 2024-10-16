/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author developerweb
 */
public class main {
  public static void main(String [] args){
       Scanner scanner = new Scanner(System.in);
        GeneradorArchivo userDatabase = new GeneradorArchivo();
        RegistroUsuario authService = new RegistroUsuario(userDatabase);

        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (choice){
                case 1:
                System.out.print("Ingrese nombre de usuario: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese contraseña: ");
                String contraseña = scanner.nextLine();
                System.out.print("Ingrese codigo de empleado: ");
                String codigoE = scanner.nextLine();
                if (authService.registrarUsuario(nombre, contraseña,codigoE)) {
                    System.out.println("Registro exitoso.");
                }
                break;
                case 2:
                // Inicio de sesión
                System.out.print("Ingrese codigo de Empleado: ");
                String codigoE2 = scanner.nextLine();
                System.out.print("Ingrese contraseña: ");
                String password = scanner.nextLine();

                if (authService.login(codigoE2, password)) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Codigo o contraseña incorrectos.");
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
}
