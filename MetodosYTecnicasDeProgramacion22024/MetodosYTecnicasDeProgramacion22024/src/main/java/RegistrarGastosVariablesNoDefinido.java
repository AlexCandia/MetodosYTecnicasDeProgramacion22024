import java.util.ArrayList;
import java.util.List;
class Gasto {
    private String causa;
    private double cantidad;
    public Gasto(String causa, double cantidad) {
        this.causa = causa;
        this.cantidad = cantidad;
    }
    public String getCausa() {
        return causa;
    }
    public double getCantidad() {
        return cantidad;
    }
    @Override
    public String toString() {
        return "Causa: " + causa + ", Cantidad: " + cantidad;
    }
}
class RegistroGastos {
    private List<Gasto> listaGastos;
    public RegistroGastos() {
        listaGastos = new ArrayList<>();
    }
    public void agregarGasto(String causa, double cantidad) {
        Gasto nuevoGasto = new Gasto(causa, cantidad);
        listaGastos.add(nuevoGasto);
        System.out.println("Gasto registrado: " + nuevoGasto);
    }
    public void mostrarGastos() {
        if (listaGastos.isEmpty()) {
            System.out.println("No hay gastos registrados.");
        } else {
            System.out.println("Lista de gastos:");
            for (Gasto gasto : listaGastos) {
                System.out.println(gasto);
            }
        }
    }
}
public class RegistrarGastosVariables {
    public static void main(String[] args) {
        RegistroGastos registro = new RegistroGastos();
        registro.agregarGasto("Compra de materiales basicos", 100); // focos, servilletas,etc
        registro.agregarGasto("Pago de horas extras a trabajadores", 150);
        registro.mostrarGastos();
    }
}
