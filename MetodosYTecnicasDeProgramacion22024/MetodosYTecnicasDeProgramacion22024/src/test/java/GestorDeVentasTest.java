
import com.mycompany.proyectofinal.Controlador.GestorDeContabilidad;
import com.mycompany.proyectofinal.Controlador.GestorDeInventario;
import com.mycompany.proyectofinal.Controlador.GestorDeVentas;
import com.mycompany.proyectofinal.Modelo.Pedido;
import com.mycompany.proyectofinal.Modelo.Vaso;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class GestorDeVentasTest {
    
    private GestorDeVentas gestorVenta;
    private GestorDeInventario gestorInventario;
    private GestorDeContabilidad gestorConta;
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
        gestorInventario = new GestorDeInventario();
        gestorConta = new GestorDeContabilidad(gestorInventario);
        gestorVenta = new GestorDeVentas(gestorInventario,gestorConta);
        vaso1 = new Vaso("Grande","Leche","Explosiva","Frutilla","Mora");
        vaso2= new Vaso("Mediano","Agua","Tapioca","Chocolate","Oreo");
        vasos = new ArrayList<>();
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
    public void testAgregarVasoCorrecto(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals(2,vasos.size());
    }
    
    @Test
    public void testEditarInfoVasoCorrecto(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.editarInfoVaso("1","Menta","Sabor 1");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals("Menta",vasos.get(0).getSabor1());
    }
    @Test
    public void testEditarInfoVasoIncorrecto(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.editarInfoVaso("3","Menta","sabor1");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals("Frutilla",vasos.get(0).getSabor1());
    }
    
    @Test
    public void testEliminarVasoCorrecto(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.eliminarVaso("1");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals(1,vasos.size());
    }
    @Test
    public void testEliminarVasoIncorrecto(){
        gestorVenta.registrarCliente("Candy", "13525846");
        gestorVenta.agregarVaso(vaso1);
        gestorVenta.agregarVaso(vaso2);
        gestorVenta.eliminarVaso("3");
        Pedido pedidoTem= gestorVenta.getPedidoTemporal();
        vasos = pedidoTem.getVasos();
        assertEquals(2,vasos.size());
    }
    
}