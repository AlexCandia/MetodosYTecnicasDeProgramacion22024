/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.metodostecnicas.Inventario;

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
public class GestorDeInventarioTest {
    private GestorDeInventario gestor;
    private ArrayList<Producto> productos;
    private Producto producto1;
    private Producto producto2;
    
    
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
        gestor = new GestorDeInventario();
        productos = new ArrayList<>();
        producto1 = new Producto("Leche","Litro",0,"Pil","69452070");
        producto2 = new Producto("Chocolate","kilo",0,"Celinda","69440058");
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test 
    public void agregarProducto(){
        
        gestor.agregar(producto1);
        gestor.agregar(producto2);
        productos = gestor.getProductos();
        assertEquals(2,productos.size());
    }
    
     @Test 
    public void eliminarProducto(){
        gestor.eliminarProducto("Leche");
        productos = gestor.getProductos();
        assertEquals(1,productos.size());
    }
    
    @Test
    public void editarInfoProducto(){
        gestor.editarInfoProducto("Chocolate","nombre","Azucar");
        Producto editado = productos.get(0);
        assertEquals("Azucar",editado.getNombre());
    }
    @Test
    public void ordenarPorNombre(){
        gestor.agregar(producto1);
        gestor.agregar(producto2);
        gestor.ordenarPorNombre();
        Producto ordenado = productos.get(2);
        assertEquals("Leche",ordenado.getNombre());
        
    }
   
}
    
}
