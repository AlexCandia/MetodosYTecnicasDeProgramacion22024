/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Contabilidad.*;
import Inventario.GestorDeInventario;
import Ventas.*;
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
public class GestorDeContabilidadTest {
     private GestorDeVentas gestorVenta;
     private GestorDeInventario gestorInven;
     private Vaso vaso1;
     private Vaso vaso2;
     private Vaso vaso3;
     private ArrayList<Vaso>vasos;
     private GestorDeContabilidad gestorConta;
     private EgresoFijo egresoFijo;
     private EgresoVariableInsumo egresoVariable;
     private EgresoVariableOtro egresoOtro;
    
    
    public GestorDeContabilidadTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        egresoFijo = new EgresoFijo("Alquiler",3000);
        egresoVariable = new EgresoVariableInsumo("Leche",5,30);
        egresoOtro = new EgresoVariableOtro("Marketing","Post",300);
        gestorVenta = new GestorDeVentas();
        gestorInven = new GestorDeInventario();
        gestorConta = new GestorDeContabilidad(gestorInven,gestorVenta);
        vaso1 = new Vaso("Grande","Leche","Explosiva","Frutilla","Chocolate");
        vaso2= new Vaso("Mediano","Agua","Tapioca","Chocolate","Oreo");
        vaso3= new Vaso("Mediano","Agua","Tapioca","Chocolate","Menta");
        vasos = new ArrayList<Vaso>();
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testCalcularIngreso(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.confirmarPedido();
        gestorVenta.terminarDia();
        gestorConta.calcularIngreso();
        assertEquals(195.0,gestorConta.getIngresosBoba(),0.0001);
    }
    
    @Test
    public void testRegistroEgresoFijo(){
        gestorConta.registrarEgresoFijo(egresoFijo);
        assertEquals(1,gestorConta.getEgresosFijos().size());
    }
    @Test
    public void testRegistroEgresoInsumo(){
        gestorConta.registrarEgresoInsumo(egresoVariable);
        assertEquals(1,gestorConta.getEgresosInsumos().size());
    }
    
    @Test
    public void testRegistroEgresoOtro(){
        gestorConta.registrarEgresoOtro(egresoOtro);
        assertEquals(1,gestorConta.getEgresosOtros().size());
    }
    @Test
    public void testCalcularBalance(){
        double balance;
        gestorConta.registrarEgresoFijo(egresoFijo);
        gestorConta.registrarEgresoInsumo(egresoVariable);
        gestorConta.registrarEgresoOtro(egresoOtro);
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.confirmarPedido();
        gestorVenta.terminarDia();
        gestorConta.calcularIngreso();
        balance = gestorConta.calcularBalance();
        assertEquals(-3135,balance,0.0001);
    }
    @Test
    public void testSaborMasVendidoChocolate(){
        ArrayList<String> sabores;
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.agregarVaso(vaso3);
        gestorVenta.confirmarPedido();
        gestorVenta.terminarDia();
        sabores=gestorConta.obtenerSaboresMasVendidos();
        assertEquals("Chocolate",sabores.get(0));
    }
    


}
