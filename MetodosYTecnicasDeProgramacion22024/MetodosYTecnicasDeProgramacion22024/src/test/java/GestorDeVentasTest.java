/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.metodostecnicas.Ventas;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Camila
 */
public class GestorDeVentasTest {
    
    private GestorDeVentas gestorVenta;
    private Vaso vaso1;
    private Vaso vaso2;
    private ArrayList<Vaso>vasos;
    
    public GestorDeVentasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        gestorVenta = new GestorDeVentas();
        vaso1 = new Vaso("Grande","Leche","Explosiva","Frutilla","Mora");
        vaso2= new Vaso("Mediano","Agua","Tapioca","Chocolate","Oreo");
        vasos = new ArrayList<Vaso>();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testRegistrarCliente(){
        gestorVenta.registrarCliente("Candy", "13525846");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        assertEquals("Candy",pedidoTem.getNombre());    
    }
    
    @Test
    public void testAgregarVaso(){
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals(2,vasos.size());
    }
    
    @Test
    public void TestEditarInfoVaso(){
        gestorVenta.editarInfoVaso("1","Menta","sabor1");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals("Menta",vasos.get(0).getSabor1());
    }
    
    @Test
    public void TestEliminarVaso(){
        gestorVenta.eliminarVaso("1");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals(1,vasos.size());
    }
    
}
