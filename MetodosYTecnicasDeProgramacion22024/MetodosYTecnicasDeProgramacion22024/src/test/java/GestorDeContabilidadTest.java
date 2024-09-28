/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.metodostecnicas.Contabilidad;

import com.mycompany.metodostecnicas.Ventas.GestorDeVentas;
import com.mycompany.metodostecnicas.Ventas.Vaso;
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
    private Vaso vaso1;
    private Vaso vaso2;
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
        gestorConta = new GestorDeContabilidad();
        vaso1 = new Vaso("Grande","Leche","Explosiva","Frutilla","Mora");
        vaso2= new Vaso("Mediano","Agua","Tapioca","Chocolate","Oreo");
        vasos = new ArrayList<Vaso>();
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void TestCalcularIngreso(){
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorConta.calcularIngreso();
        assertEquals(35,gestorConta.getIngresosBoba());
    }
    
    @Test
    public void TestRegistroEgresoFijo(){
        gestorConta.registrarEgresoFijo(egresoFijo);
        assertEquals(1,gestorConta.getEgresosFijos.size());
    }
    @Test
        public void TestRegistroEgresoInsumo(){
        gestorConta.registrarEgresoInsumo(egresoVariable);
        assertEquals(1,gestorConta.getEgresoInsumo.size());
    }
    
    @Test
    public void TestRegistroEgresoOtro(){
        gestorConta.registrarEgresoOtro(egresoOtro);
        assertEquals(1,gestorConta.getEgresosOtro.size());
    }


}
