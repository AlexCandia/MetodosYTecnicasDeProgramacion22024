package Inventario;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class Notificacion {
    String motivo;
    String mensaje;
    Date fecha;
    String origen;
    
    public Notificacion(String motivo,String mensaje,String origen){
        this.motivo=motivo;
        this.mensaje=mensaje;
        this.origen=origen;
        fecha= new Date();
    }
}
