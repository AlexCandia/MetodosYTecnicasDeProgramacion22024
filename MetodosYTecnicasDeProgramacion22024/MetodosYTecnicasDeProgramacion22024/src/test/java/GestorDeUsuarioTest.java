
import com.mycompany.proyectofinal.Controlador.GestorDeUsuario;
import com.mycompany.proyectofinal.Modelo.Usuario;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
public class GestorDeUsuarioTest {
    
    public GestorDeUsuarioTest() {
    }
     GestorDeUsuario gestor;
     private final String TEST_FILE = "Archivos/ArchivosUsuarios/ListaUsuariosTest.txt";

  @Before
    public void setUp() throws IOException {
        Files.createDirectories(Paths.get("Archivos/ArchivosUsuarios"));
        Files.write(Paths.get(TEST_FILE), List.of(
            "admin;admin123;Administrador",
            "user1;pass1;Empleado"
        ));
        gestor = new GestorDeUsuario();
    }

    @Test
    public void testRegistrarUsuarioNuevo() {
        Usuario nuevoUsuario = new Usuario("user2", "pass2", "Empleado");
        assertTrue(gestor.registrarUsuario(nuevoUsuario));
    }

    @Test
    public void testRegistrarUsuarioExistente() {
        Usuario usuarioExistente = new Usuario("admin", "admin123", "Administrador");
        assertFalse(gestor.registrarUsuario(usuarioExistente));
    }

    @Test
    public void testIniciarSesionCorrecto() {
        assertTrue(gestor.iniciarSesion("admin", "admin123"));
    }

    @Test
    public void testIniciarSesionIncorrecto() {
        assertFalse(gestor.iniciarSesion("admin", "wrongpassword"));
    }

    @Test
    public void testObtenerCargoExistente() {
        assertEquals("Administrador", gestor.obtenerCargo("admin"));
    }

    @Test
    public void testObtenerCargoNoExistente() {
        assertNull(gestor.obtenerCargo("noExiste"));
    }

}