/*import java.util.*;
class Producto {
    private String nombre;
    private int cantidadVendida;
    public Producto(String nombre, int cantidadVendida) {
        this.nombre = nombre;
        this.cantidadVendida = cantidadVendida;
    }
    public String getNombre() {
        return nombre;
    }
    public int getCantidadVendida() {
        return cantidadVendida;
    }
    public void agregarVentas(int cantidad) {
        this.cantidadVendida += cantidad;
    }
    @Override
    public String toString() {
        return "Producto: " + nombre + ", Cantidad Vendida: " + cantidadVendida;
    }
}
class RegistroVentas {
    private Map<String, Producto> ventasPorProducto;
    public RegistroVentas() {
        ventasPorProducto = new HashMap<>();
    }
    public void registrarVenta(String nombreProducto, int cantidad) {
        Producto producto = ventasPorProducto.getOrDefault(nombreProducto, new Producto(nombreProducto, 0));
        producto.agregarVentas(cantidad);
        ventasPorProducto.put(nombreProducto, producto);
        System.out.println("Venta registrada: " + producto);
    }
    public List<Producto> obtenerProductosMasVendidos(int topN) {
        List<Producto> productos = new ArrayList<>(ventasPorProducto.values());
        productos.sort(Comparator.comparingInt(Producto::getCantidadVendida).reversed());
        if (topN > productos.size()) {
            topN = productos.size();
        }
        return productos.subList(0, topN);
    }
    public void mostrarResumenDeVentas() {
        for (Producto producto : ventasPorProducto.values()) {
            System.out.println(producto);
        }
    }
}
public class CalularInfoGrafica {
    public static void main(String[] args) {
        RegistroVentas registro = new RegistroVentas();
        registro.registrarVenta("Chocolate", 150);
        registro.registrarVenta("Mora", 85);
        registro.registrarVenta("Maracuya", 100);
        registro.registrarVenta("Oreo", 50);
        System.out.println("\nResumen general de ventas:");
        registro.mostrarResumenDeVentas();
        System.out.println("\nTop 2 productos más vendidos:");
        List<Producto> topVendidos = registro.obtenerProductosMasVendidos(2);
        for (Producto producto : topVendidos) {
            System.out.println(producto);
        }
    }
}*/
