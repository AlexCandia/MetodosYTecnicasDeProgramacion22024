/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author developerweb
 */
public class Usuario {
  private String nombre;
  private String contraseña;
  private String codigoE;
  public Usuario(String nombre,String contraseña,String codigoE){
      this.nombre=nombre;
      this.contraseña=contraseña;
      this.codigoE=codigoE;
  }
  public String getNombre(){
      return nombre;
  }
  public String getContraseña(){
      return contraseña;
  }
  public String getCodigoE(){
      return codigoE;
  }
  public void setNombre(String nuevoNombre){
      nombre=nuevoNombre;
  }
  public void setContraseña(String nuevaContraseña){
      contraseña=nuevaContraseña;
  }
  public void registrarUsuario(){
      
  }
}
