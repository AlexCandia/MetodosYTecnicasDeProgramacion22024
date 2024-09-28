/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Inventario.Producto;
import Inventario.GestorDeInventario;
import java.util.ArrayList;
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
public class GestorDeInventarioTest {
    
    public GestorDeInventarioTest() {
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
     * Test of getProductos method, of class GestorDeInventario.
     */
    @Test
    public void testGetProductos() {
        System.out.println("getProductos");
        GestorDeInventario instance = new GestorDeInventario();
        ArrayList<Producto> expResult = null;
        ArrayList<Producto> result = instance.getProductos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregar method, of class GestorDeInventario.
     */
    @Test
    public void testAgregar() {
        System.out.println("agregar");
        Producto producto = null;
        GestorDeInventario instance = new GestorDeInventario();
        instance.agregar(producto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarProducto method, of class GestorDeInventario.
     */
    @Test
    public void testEliminarProducto() {
        System.out.println("eliminarProducto");
        String nombre = "";
        GestorDeInventario instance = new GestorDeInventario();
        boolean expResult = false;
        boolean result = instance.eliminarProducto(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recibirNuevoInsumo method, of class GestorDeInventario.
     */
    @Test
    public void testRecibirNuevoInsumo() {
        System.out.println("recibirNuevoInsumo");
        String nombre = "";
        String nuevoCantidad = "";
        GestorDeInventario instance = new GestorDeInventario();
        instance.recibirNuevoInsumo(nombre, nuevoCantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarInfoProducto method, of class GestorDeInventario.
     */
    @Test
    public void testEditarInfoProducto() {
        System.out.println("editarInfoProducto");
        String nombre = "";
        String atributo = "";
        String nuevoValor = "";
        GestorDeInventario instance = new GestorDeInventario();
        instance.editarInfoProducto(nombre, atributo, nuevoValor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarPorBajoStock method, of class GestorDeInventario.
     */
    @Test
    public void testOrdenarPorBajoStock() {
        System.out.println("ordenarPorBajoStock");
        GestorDeInventario instance = new GestorDeInventario();
        instance.ordenarPorBajoStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarPorNombre method, of class GestorDeInventario.
     */
    @Test
    public void testOrdenarPorNombre() {
        System.out.println("ordenarPorNombre");
        GestorDeInventario instance = new GestorDeInventario();
        instance.ordenarPorNombre();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarInventario method, of class GestorDeInventario.
     */
    @Test
    public void testGuardarInventario() {
        System.out.println("guardarInventario");
        GestorDeInventario instance = new GestorDeInventario();
        instance.guardarInventario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volverMenu method, of class GestorDeInventario.
     */
    @Test
    public void testVolverMenu() {
        System.out.println("volverMenu");
        GestorDeInventario instance = new GestorDeInventario();
        instance.volverMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
