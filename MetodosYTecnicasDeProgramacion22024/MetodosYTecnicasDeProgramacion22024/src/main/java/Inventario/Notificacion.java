package Inventario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        notificaciones.add(this); // Agregamos la notificación a la lista
    }
    public static void guardarNotificacion(Notificacion notificacion) {
        notificaciones.add(notificacion);
    }
    public static void eliminarNotificacion(Notificacion notificacion) {
        notificaciones.remove(notificacion);
    }
    public static void mostrarNotificacionesPorOrigen(String origen) {
        for (Notificacion notificacion : notificaciones) {
            if (notificacion.origen.equals(origen)) {
                System.out.println("Motivo: " + notificacion.motivo);
                System.out.println("Mensaje: " + notificacion.mensaje);
                System.out.println("Fecha: " + notificacion.fecha);
                System.out.println("Origen: " + notificacion.origen);
                System.out.println("------------------------");
            }
        }
    }
    public static void mostrarTodasLasNotificaciones() {
        for (Notificacion notificacion : notificaciones) {
            System.out.println("Motivo: " + notificacion.motivo);
            System.out.println("Mensaje: " + notificacion.mensaje);
            System.out.println("Fecha: " + notificacion.fecha);
            System.out.println("Origen: " + notificacion.origen);
            System.out.println("------------------------");
        }
    }
}

