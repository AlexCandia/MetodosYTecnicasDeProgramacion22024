
import com.mycompany.proyectofinal.Controlador.GestorDeContabilidad;
import com.mycompany.proyectofinal.Controlador.GestorDeInventario;
import com.mycompany.proyectofinal.Controlador.GestorDeVentas;
import com.mycompany.proyectofinal.Modelo.EgresoFijo;
import com.mycompany.proyectofinal.Modelo.EgresoInsumo;
import com.mycompany.proyectofinal.Modelo.EgresoVariable;
import com.mycompany.proyectofinal.Modelo.Vaso;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GestorDeContabilidadTest {
     private GestorDeVentas gestorVenta;
     private GestorDeInventario gestorInven;
     private Vaso vaso1;
     private Vaso vaso2;
     private Vaso vaso3;
     private ArrayList<Vaso>vasos;
     private GestorDeContabilidad gestorConta;
     private EgresoFijo egresoFijo;
     private EgresoInsumo egresoInsumo;
     private EgresoVariable egresoVariable;
    
    
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
        egresoFijo = new EgresoFijo("2024/11/30","Alquiler",3000);
        egresoInsumo = new EgresoInsumo("2024/12/09","Coco",123,22.0);
        egresoVariable = new EgresoVariable("2024/11/30","Escoba Rota","se rompio",12.0);
        gestorInven = new GestorDeInventario();
        gestorConta = new GestorDeContabilidad(gestorInven);
        gestorVenta = new GestorDeVentas(gestorInven,gestorConta);
        vaso1 = new Vaso("Grande","Leche","Explosiva","Frutilla","Chocolate");
        vaso2= new Vaso("Mediano","Agua","Tapioca","Chocolate","Oreo");
        vaso3= new Vaso("Mediano","Agua","Tapioca","Chocolate","Menta");
        vasos = new ArrayList<Vaso>();
    }
    
    @After
    public void tearDown() {
    }
  
    
    @Test
    public void testRegistroEgresoFijo(){
        gestorConta.registrarEgresoFijo(egresoFijo);
        assertEquals(3,gestorConta.getEgresosFijos().size());
    }
    @Test
    public void testEliminarEgresoFijo() {
        gestorConta.registrarEgresoFijo(egresoFijo);
        gestorConta.eliminarEgresoFijo(0);
        gestorConta.eliminarEgresoFijo(0);
        gestorConta.eliminarEgresoFijo(0);
        assert(gestorConta.getEgresosFijos().isEmpty());
    }

    @Test
    public void testEditarEgresoFijo() {
        gestorConta.registrarEgresoFijo(egresoFijo);
        gestorConta.editarEgresoFijo(0, "Servicios", 600.0);
        EgresoFijo editado = gestorConta.getEgresosFijos().get(0);
        assertEquals("Servicios", editado.getDetalle());
        assertEquals(600.0, editado.getValor(),0.001);
    }
    @Test
    public void testRegistroEgresoInsumo(){
        gestorConta.registrarEgresoInsumo(egresoInsumo);
        assertEquals(3,gestorConta.getEgresosInsumos().size());
    }
    
     @Test
    public void testEliminarEgresoInsumo() {
        gestorConta.registrarEgresoInsumo(egresoInsumo);
        gestorConta.eliminarEgresoInsumo(0);
        gestorConta.eliminarEgresoInsumo(0);
        gestorConta.eliminarEgresoInsumo(0);
        assertTrue(gestorConta.getEgresosInsumos().isEmpty());
    }

    @Test
    public void testEditarEgresoInsumo() {
        gestorConta.registrarEgresoInsumo(egresoInsumo);
        gestorConta.editarEgresoInsumo(0, "Azúcar", 150, 250.0);
        EgresoInsumo editado = gestorConta.getEgresosInsumos().get(0);
        assertEquals("Azúcar", editado.getNombre());
        assertEquals(150, editado.getCantidad(),0.001);
        assertEquals(250.0, editado.getValor(),0.001);
    }
    
    @Test
    public void testRegistroEgresoVariable(){
        gestorConta.registrarEgresoVariable(egresoVariable);
        assertEquals(2,gestorConta.getEgresosVariables().size());
    }
    @Test
    public void testEliminarEgresoVariable() {
        gestorConta.registrarEgresoVariable(egresoVariable);
        gestorConta.eliminarEgresoVariable(0);
        gestorConta.eliminarEgresoVariable(0);
        assertTrue(gestorConta.getEgresosVariables().isEmpty());
    }

    @Test
    public void testEditarEgresoVariable() {
        gestorConta.registrarEgresoVariable(egresoVariable);
        gestorConta.editarEgresoVariable(0, "Marketing", "Campaña de verano", 300.0);
        EgresoVariable editado = gestorConta.getEgresosVariables().get(0);
        assertEquals("Marketing", editado.getNombre());
        assertEquals("Campaña de verano", editado.getDetalle());
        assertEquals(300.0, editado.getValor(),0.001);
    }
     @Test
    public void testCalcularTotalEgresosFijos() {
        gestorConta.registrarEgresoFijo(new EgresoFijo("2024/11/30","Renta", 1000.0));
        gestorConta.registrarEgresoFijo(new EgresoFijo("2024/11/30","Servicios", 200.0));
        assertEquals(1445.0, gestorConta.calcularTotalEgresosFijos(),0.001);
    }

    @Test
    public void testCalcularBalance() {
        gestorConta.registrarEgresoFijo(new EgresoFijo("2024/11/30","Renta", 500.0));
        gestorConta.registrarEgresoInsumo(new EgresoInsumo("2024/11/30","Tapioca", 100, 200.0));
        gestorConta.registrarEgresoVariable(new EgresoVariable("2024/11/30","Publicidad", "Online", 300.0));
        
        assertEquals(-1314.0, gestorConta.calcularBalance(),0.001);
    }
}
