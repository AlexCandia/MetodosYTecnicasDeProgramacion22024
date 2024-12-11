
import com.mycompany.proyectofinal.Controlador.GestorDeInventario;
import com.mycompany.proyectofinal.Modelo.Insumo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GestorDeInventarioTest {
    private GestorDeInventario gestor;
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
        gestor = new GestorDeInventario();
        productos = new ArrayList<>();
        producto1 = new Insumo("Leche","Litro",10,1);
        producto2 = new Insumo("Arandano","kilo",20,2);
        
    }
    
    @After
    public void tearDown() {
    }

    
    @Test 
    public void testAgregarInsumo(){
        
        gestor.agregarInsumo(producto1);
        gestor.agregarInsumo(producto2);
        productos = gestor.getInsumos();
        assertEquals(23,productos.size());
    }
    
     @Test 
    public void testEliminarInsumo(){
        gestor.eliminarInsumo(0);
        productos = gestor.getInsumos();
        assertEquals(20,productos.size());
    }
    
    @Test
    public void testEditarInfoInsumo(){
        gestor.editarInsumo(1,"Chocolate","kilo",30,3);
        Insumo editado = gestor.getInsumos().get(1);
        assertEquals("Chocolate",editado.getNombre());
        assertEquals("kilo",editado.getUnidad());
        assertEquals(30,editado.getCantidad());
        assertEquals(3,editado.getMinimo());
    }
    @Test
    public void testOrdenarPorNombre(){
        gestor.agregarInsumo(producto1);
        gestor.agregarInsumo(producto2);
        gestor.ordenarPorNombre();
        productos=gestor.getInsumos();
        Insumo tope = productos.get(0);
        assertEquals("Arandano",tope.getNombre());
        
    }
   
}
   