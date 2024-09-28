/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Ventas.Vaso;
import Ventas.GestorDeVentas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author developerweb
 */
public class GestorDeVentasTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registrarCliente method, of class GestorDeVentas.
     */
    @Test
    public void testRegistrarCliente() {
        System.out.println("registrarCliente");
        String nomb = "";
        String nit = "";
        GestorDeVentas instance = new GestorDeVentas();
        instance.registrarCliente(nomb, nit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarVaso method, of class GestorDeVentas.
     */
    @Test
    public void testAgregarVaso() {
        System.out.println("agregarVaso");
        Vaso vaso = null;
        GestorDeVentas instance = new GestorDeVentas();
        instance.agregarVaso(vaso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarInfoVaso method, of class GestorDeVentas.
     */
    @Test
    public void testEditarInfoVaso() {
        System.out.println("editarInfoVaso");
        String numVaso = "";
        String infoN = "";
        String parametro = "";
        GestorDeVentas instance = new GestorDeVentas();
        instance.editarInfoVaso(numVaso, infoN, parametro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarVaso method, of class GestorDeVentas.
     */
    @Test
    public void testEliminarVaso() {
        System.out.println("eliminarVaso");
        String numVaso = "";
        GestorDeVentas instance = new GestorDeVentas();
        instance.eliminarVaso(numVaso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarPedido method, of class GestorDeVentas.
     */
    @Test
    public void testConfirmarPedido() {
        System.out.println("confirmarPedido");
        GestorDeVentas instance = new GestorDeVentas();
        instance.confirmarPedido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of marcarPedidoCompletado method, of class GestorDeVentas.
     */
    @Test
    public void testMarcarPedidoCompletado() {
        System.out.println("marcarPedidoCompletado");
        GestorDeVentas instance = new GestorDeVentas();
        instance.marcarPedidoCompletado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularIngresosTotales method, of class GestorDeVentas.
     */
    @Test
    public void testCalcularIngresosTotales() {
        System.out.println("calcularIngresosTotales");
        GestorDeVentas instance = new GestorDeVentas();
        double expResult = 0.0;
        double result = instance.calcularIngresosTotales();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarReporteIngresos method, of class GestorDeVentas.
     */
    @Test
    public void testGenerarReporteIngresos() {
        System.out.println("generarReporteIngresos");
        GestorDeVentas instance = new GestorDeVentas();
        instance.generarReporteIngresos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverMenu method, of class GestorDeVentas.
     */
    @Test
    public void testVolverMenu() {
        System.out.println("volverMenu");
        GestorDeVentas instance = new GestorDeVentas();
        instance.volverMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of terminarDia method, of class GestorDeVentas.
     */
    @Test
    public void testTerminarDia() {
        System.out.println("terminarDia");
        GestorDeVentas instance = new GestorDeVentas();
        instance.terminarDia();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarReporteVentas method, of class GestorDeVentas.
     */
    @Test
    public void testGenerarReporteVentas() {
        System.out.println("generarReporteVentas");
        GestorDeVentas instance = new GestorDeVentas();
        instance.generarReporteVentas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
