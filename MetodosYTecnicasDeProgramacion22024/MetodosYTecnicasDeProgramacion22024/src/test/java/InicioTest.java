/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import InicioyRegistro.Usuario;
import InicioyRegistro.GeneradorArchivosUsuarios;
import InicioyRegistro.Inicio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 *
 * @author developerweb
 */
public class InicioTest {
    
    public InicioTest() {
    }
     GeneradorArchivosUsuarios generador;
     Inicio inicio;
     Usuario usuario1;
     Usuario usuario2;
     Usuario usuario3;
     private final ByteArrayOutputStream mensajeSalida = new ByteArrayOutputStream();
     private final PrintStream RecuperarSalida = System.out; 
    @Before
    public void setUp() {
        generador = new GeneradorArchivosUsuarios();
        inicio = new Inicio(generador);
        usuario1 = new Usuario("Alex","Parry","0001");
        usuario2 = new Usuario("Jose","Sukuna","0002");
        usuario3 = new Usuario("Choso","Abismal","0003");
        System.setOut(new PrintStream(mensajeSalida));
    }
    
    @After
    public void tearDown() {
        System.setOut(RecuperarSalida);
    }


    @Test
    public void testRegistrarUsuarioExitoso() {
        boolean registrado = inicio.registrarUsuario(usuario2);
        assertTrue(registrado);
    }
    @Test
    public void testRegistrarUsuarioContraseniaCorta() {
        boolean registrado = inicio.registrarUsuario(usuario1);
        assertFalse(registrado);
        assertTrue(mensajeSalida.toString().contains("Contraseña muy corta."));
    }
    @Test
    public void testRegistrarUsuarioExistente() {
        boolean registrado = inicio.registrarUsuario(usuario2);
        assertFalse(registrado);
        assertTrue(mensajeSalida.toString().contains("El usuario ya existe."));
    }
    @Test
    public void testIniciarSesionExito() {
        String codigoE ="0002";
        String contraseña ="Sukuna";
        boolean exito=inicio.login(codigoE, contraseña);
        assertTrue(exito);
        assertTrue(mensajeSalida.toString().contains("Bienvenido"));
    }
    @Test
    public void testIniciarSesionFracaso() {
        String codigoE ="0004";
        String contraseña ="Sukuna";
        boolean exito=inicio.login(codigoE, contraseña);
        assertFalse(exito);
        assertTrue(mensajeSalida.toString().contains("Codigo o contrasenia incorrectos"));
    }   
}
