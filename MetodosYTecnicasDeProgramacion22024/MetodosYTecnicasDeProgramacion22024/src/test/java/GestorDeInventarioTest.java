/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
//package com.mycompany.metodostecnicas.Inventario;

import Inventario.GestorDeInventario;
import Inventario.Insumo;
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
    private GestorDeInventario gestorInven;
    private ArrayList<Insumo> productos;
    private Insumo producto1;
    private Insumo producto2;
    
    
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
        gestorInven = new GestorDeInventario();
        productos = new ArrayList<>();
        producto1 = new Insumo("Leche","Litro","Pil","69452070");
        producto2 = new Insumo("Chocolate","kilo","Celinda","69440058");
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test 
    public void agregarProducto(){
        
        gestorInven.agregar(producto1);
        gestorInven.agregar(producto2);
        productos = gestorInven.getProductos();
        assertEquals(2,productos.size());
    }
    
    @Test 
    public void eliminarProductoExistente(){
        gestorInven.agregar(producto1);
        gestorInven.agregar(producto2);
        gestorInven.eliminarProducto("Leche");
        productos = gestorInven.getProductos();
        assertEquals(1,productos.size());
    }
    @Test 
    public void eliminarProductoInexistente(){
        gestorInven.agregar(producto1);
        gestorInven.agregar(producto2);
        gestorInven.eliminarProducto("Azucar");
        productos = gestorInven.getProductos();
        assertEquals(2,productos.size());
    }
    
    @Test
    public void editarInfoProductoExistente(){
        gestorInven.agregar(producto2);
        gestorInven.editarInfoProducto("Chocolate","nombre","Azucar");
        productos = gestorInven.getProductos();
        Insumo editado = productos.get(0);
        assertEquals("Azucar",editado.getNombre());
    }
    @Test
    public void editarInfoProductoInexistente(){
        gestorInven.agregar(producto2);
        gestorInven.editarInfoProducto("Oreo","unidad","bolsa");
        productos = gestorInven.getProductos();
        Insumo editado = productos.get(0);
        assertEquals("Chocolate",editado.getNombre());
    }
    @Test
    public void ordenarPorNombre(){
        gestorInven.agregar(producto1);
        gestorInven.agregar(producto2);
        gestorInven.ordenarPorNombre();
        productos = gestorInven.getProductos();
        Insumo ordenado = productos.get(1);
        assertEquals("Leche",ordenado.getNombre());
        
    }
   
}
  
