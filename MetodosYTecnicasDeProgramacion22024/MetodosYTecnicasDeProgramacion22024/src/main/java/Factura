import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Factura {
    private String nombre;
    private String nit;
    private LocalDate fecha;
    private List<ItemFactura> items = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    public Factura(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.fecha = LocalDate.now();
    }
    public void agregarItem(String producto, int cantidad, double precioUnitario) {
        ItemFactura item = new ItemFactura(producto, cantidad, precioUnitario);
        items.add(item);
    }
    public double calcularTotal() {
        return items.stream().mapToDouble(ItemFactura::getSubtotal).sum();
    }
    public void agregarTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public void imprimirFactura() {
        System.out.println("Nombre: " + nombre);
        System.out.println("NIT: " + nit);
        System.out.println("Fecha: " + fecha); 
        System.out.println("---------------------------------");
        for (ItemFactura item : items) {
            System.out.println(item.toString());
        }
        System.out.println("---------------------------------");
        System.out.println("Total: " + calcularTotal());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
    private class ItemFactura {
        private String producto;
        private int cantidad;
        private double precioUnitario;
        public ItemFactura(String producto, int cantidad, double precioUnitario) {
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
        }
        public double getSubtotal() {
            return cantidad * precioUnitario;
        }
        @Override
        public String toString() {
            return producto + " - Cantidad: " + cantidad + " - Precio Unitario: " + precioUnitario + " - Subtotal: " + getSubtotal();
        }
    }
}
