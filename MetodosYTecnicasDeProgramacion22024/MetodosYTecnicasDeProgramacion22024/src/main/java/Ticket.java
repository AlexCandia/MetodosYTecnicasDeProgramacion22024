import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Ticket {
    private static int contadorTickets = 0;
    private int numeroTicket;
    private LocalDate fecha;
    private String nombreCliente;
    private List<Producto> productos;
    public Ticket(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.fecha = LocalDate.now();
        this.productos = new ArrayList<>();
        contadorTickets++;
        this.numeroTicket = contadorTickets;
    }
    public void agregarProducto(String tamañoVaso, String base, String tipoBoba, String sabor1, String sabor2) {
        Producto producto = new Producto(tamañoVaso, base, tipoBoba, sabor1, sabor2);
        productos.add(producto);
    }
    @Override
    public String toString() {
        StringBuilder ticketString = new StringBuilder();
        ticketString.append("Ticket #").append(numeroTicket)
                    .append(" - Fecha: ").append(fecha)
                    .append(", Cliente: ").append(nombreCliente)
                    .append("\nProductos:\n");
        for (Producto producto : productos) {
            ticketString.append(producto.toString()).append("\n");
        }
        return ticketString.toString();
    }
    private static class Producto {
        private String tamañoVaso;
        private String base;
        private String tipoBoba;
        private String sabor1;
        private String sabor2;
        public Producto(String tamañoVaso, String base, String tipoBoba, String sabor1, String sabor2) {
            this.tamañoVaso = tamañoVaso;
            this.base = base;
            this.tipoBoba = tipoBoba;
            this.sabor1 = sabor1;
            this.sabor2 = sabor2;
        }
        @Override
        public String toString() {
            return "Tamaño del vaso: " + tamañoVaso +
                   ", Base: " + base +
                   ", Tipo de boba: " + tipoBoba +
                   ", Sabor 1: " + sabor1 +
                   ", Sabor 2: " + sabor2;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuarSistema = true;
        while (continuarSistema) {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombreCliente = scanner.nextLine();
            Ticket ticket = new Ticket(nombreCliente);
            boolean continuarPedido = true;
            while (continuarPedido) {
                System.out.println("Ingrese los datos del producto:");
                System.out.print("Tamaño del vaso: ");
                String tamañoVaso = scanner.nextLine();
                System.out.print("Base (leche, agua, etc.): ");
                String base = scanner.nextLine();
                System.out.print("Tipo de boba (tapioca, popping boba, etc.): ");
                String tipoBoba = scanner.nextLine();
                System.out.print("Sabor 1: ");
                String sabor1 = scanner.nextLine();
                System.out.print("Sabor 2: ");
                String sabor2 = scanner.nextLine();
                ticket.agregarProducto(tamañoVaso, base, tipoBoba, sabor1, sabor2);
                System.out.print("¿Desea añadir otro producto al pedido? (sí/no): ");
                String respuesta = scanner.nextLine().toLowerCase();
                if (respuesta.equals("no")) {
                    continuarPedido = false;
                }
            }
            System.out.println("\nTicket completo generado:");
            System.out.println(ticket.toString());
            System.out.print("¿Desea atender a otro cliente? (sí/no): ");
            String respuestaSistema = scanner.nextLine().toLowerCase();
            if (respuestaSistema.equals("no")) {
                continuarSistema = false;
            }
        }
        System.out.println("Sistema cerrado. Gracias.");
    }
}
