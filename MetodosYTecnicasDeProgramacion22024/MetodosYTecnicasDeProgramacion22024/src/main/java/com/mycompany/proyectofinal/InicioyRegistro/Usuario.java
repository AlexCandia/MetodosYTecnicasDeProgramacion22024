package com.mycompany.proyectofinal.InicioyRegistro;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class Usuario {
  private String usuario;
  private String contraseña;
  private String cargo;
  
  public Usuario(String usuario,String contraseña,String codigoE){
      this.usuario=usuario;
      this.contraseña=contraseña;
      this.cargo=codigoE;
  }
  
  public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
