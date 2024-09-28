/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Contabilidad.GestorDeContabilidad;
import Contabilidad.EgresoVariableOtro;
import Contabilidad.EgresoVariableInsumo;
import Contabilidad.EgresoFijo;
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
public class GestorDeContabilidadTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularIngreso method, of class GestorDeContabilidad.
     */
    @Test
    public void testCalcularIngreso() {
        System.out.println("calcularIngreso");
        GestorDeContabilidad instance = null;
        instance.calcularIngreso();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEgresoFijo method, of class GestorDeContabilidad.
     */
    @Test
    public void testRegistrarEgresoFijo() {
        System.out.println("registrarEgresoFijo");
        EgresoFijo egreso = null;
        GestorDeContabilidad instance = null;
        instance.registrarEgresoFijo(egreso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEgresoInsumo method, of class GestorDeContabilidad.
     */
    @Test
    public void testRegistrarEgresoInsumo() {
        System.out.println("registrarEgresoInsumo");
        EgresoVariableInsumo egreso = null;
        GestorDeContabilidad instance = null;
        instance.registrarEgresoInsumo(egreso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarEgresoOtro method, of class GestorDeContabilidad.
     */
    @Test
    public void testRegistrarEgresoOtro() {
        System.out.println("registrarEgresoOtro");
        EgresoVariableOtro egreso = null;
        GestorDeContabilidad instance = null;
        instance.registrarEgresoOtro(egreso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirReporteMensual method, of class GestorDeContabilidad.
     */
    @Test
    public void testImprimirReporteMensual() {
        System.out.println("imprimirReporteMensual");
        GestorDeContabilidad instance = null;
        String expResult = "";
        String result = instance.imprimirReporteMensual();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarReporteHistorico method, of class GestorDeContabilidad.
     */
    @Test
    public void testGuardarReporteHistorico() {
        System.out.println("guardarReporteHistorico");
        GestorDeContabilidad instance = null;
        instance.guardarReporteHistorico();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirReporteHistorico method, of class GestorDeContabilidad.
     */
    @Test
    public void testImprimirReporteHistorico() {
        System.out.println("imprimirReporteHistorico");
        GestorDeContabilidad instance = null;
        instance.imprimirReporteHistorico();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
