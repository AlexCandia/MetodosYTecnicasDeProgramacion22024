public class EgresoVariableOtro {
    private String nombre;
    private String detalle;
    private double valor;

    public EgresoVariableOtro(String nombre, String detalle, double valor) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getValor() {
        return valor;
    }
}
