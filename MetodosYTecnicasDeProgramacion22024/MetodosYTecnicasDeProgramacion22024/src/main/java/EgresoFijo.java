public class EgresoFijo {
    private String nombreEgreso;
    private double valor;

    public EgresoFijo(String nombreEgreso, double valor) {
        this.nombreEgreso = nombreEgreso;
        this.valor = valor;
    }

    public String getNombreEgreso() {
        return nombreEgreso;
    }

    public double getValor() {
        return valor;
    }
    
    public void setNombreEgreso(String nombre){
        nombreEgreso = nombre;
    }
    
    public void setValor (double value){
        valor = value;
    }
}
