/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
import java.util.Date;
import java.util.ArrayList;
public class Pedido {
    private String numPedido;
    private String nombre;
    private String nit;
    private ArrayList<Vaso> vasos;
    private Date fecha;
    public Pedido(String nombre,String nit){
        fecha=new Date();
        this.nombre=nombre;
        this.nit=nit;
        this.numPedido="0";
        vasos = new ArrayList<Vaso>();
    }
    public String getNumPedido(){
        return numPedido;
    }
    public String getNombre(){
        return nombre;
    }
    public String getNit(){
        return nit;
    }
   public Date getFecha(){
       return fecha;
   }
    public void setNumPedido(int numPedido){
        this.numPedido=numPedido+"";
    }
    public ArrayList<Vaso> getVasos(){
        return vasos;
    }
    public void añadir(Vaso vaso){
        if(vasos.isEmpty()){
           vaso.setNumVaso("1"); 
        }else{
           vaso.setNumVaso(vasos.size()+1+"");
        }
        vasos.add(vaso);
    }
    public String generarCodigoIdentificador() {
        String fechaFormateada = String.format("%1$tY%1$tm%1$td", fecha); // AAAAMMDD
        return fechaFormateada + "-" + numPedido; // Ejemplo: 20240921-001
    }
}

