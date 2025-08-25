import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests para GestorClientes")
class GestorClientesTest {
    
    private GestorClientes gestor;
    private Cliente cliente1;
    
    @BeforeEach
    void setUp() {
        gestor = new GestorClientes();
        cliente1 = new Cliente("Juan Pérez", "12345678A", "666123456", "juan@email.com");
    }
    
    @Test
    @DisplayName("Alta de cliente exitosa")
    void testAltaClienteExitosa() {
        boolean resultado = gestor.altaCliente(cliente1);
        
        assertTrue(resultado, "El alta debería ser exitosa");
        assertNotNull(gestor.buscarCliente("12345678A"));
    }
    
    @Test
    @DisplayName("No permite clientes duplicados")
    void testClienteDuplicado() {
        gestor.altaCliente(cliente1);
        Cliente duplicado = new Cliente("Otro Nombre", "12345678A", "777", "otro@email.com");
        
        boolean resultado = gestor.altaCliente(duplicado);
        
        assertFalse(resultado, "No debería permitir DNI duplicados");
    }
    
    @Test
    @DisplayName("Buscar cliente existente")
    void testBuscarClienteExistente() {
        gestor.altaCliente(cliente1);
        
        Cliente encontrado = gestor.buscarCliente("12345678A");
        
        assertNotNull(encontrado);
        assertEquals("Juan Pérez", encontrado.getNombre());
    }
    
    @Test
    @DisplayName("Buscar cliente inexistente")
    void testBuscarClienteInexistente() {
        Cliente resultado = gestor.buscarCliente("99999999Z");
        
        assertNull(resultado);
    }
    
    @Test
    @DisplayName("Baja de cliente exitosa")
    void testBajaCliente() {
        gestor.altaCliente(cliente1);
        
        boolean resultado = gestor.bajaCliente("12345678A");
        
        assertTrue(resultado);
        assertNull(gestor.buscarCliente("12345678A"));
    }
    
    @Test
    @DisplayName("Listar clientes")
    void testListarClientes() {
        gestor.altaCliente(cliente1);
        
        ArrayList<Cliente> lista = gestor.listarClientes();
        
        assertEquals(1, lista.size());
    }
}