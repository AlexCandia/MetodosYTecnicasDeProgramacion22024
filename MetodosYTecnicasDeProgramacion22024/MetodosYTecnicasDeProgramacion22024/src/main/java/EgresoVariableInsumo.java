public class EgresoVariableInsumo {
    private String nombre;
    private int cantidad;
    private double valor;

    public EgresoVariableInsumo(String nombre,int cantidad, double valor) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getValor() {
        return valor;
    }
}
