import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests para GestorCartuchos")
class GestorCartuchosTest {
    
    private GestorCartuchos gestor;
    private Cartucho cartucho1;
    
    @BeforeEach
    void setUp() {
        gestor = new GestorCartuchos();
        cartucho1 = new Cartucho("Halo", Plataforma.XBOX, 2021, Estado.NUEVO, 59.99, 10);
    }
    
    @Test
    @DisplayName("Alta de cartucho exitosa")
    void testAltaCartucho() {
        boolean resultado = gestor.altaCartucho(cartucho1);
        
        assertTrue(resultado);
        assertEquals(1, gestor.listarCartuchos().size());
    }
    
    @Test
    @DisplayName("No permite cartuchos duplicados")
    void testCartuchoDuplicado() {
        gestor.altaCartucho(cartucho1);
        Cartucho duplicado = new Cartucho("Halo", Plataforma.XBOX, 2022, Estado.USADO, 39.99, 5);
        
        boolean resultado = gestor.altaCartucho(duplicado);
        
        assertFalse(resultado);
    }
    
    @Test
    @DisplayName("Buscar por plataforma")
    void testBuscarPorPlataforma() {
        gestor.altaCartucho(cartucho1);
        
        ArrayList<Cartucho> resultado = gestor.buscarPorPlataforma(Plataforma.XBOX);
        
        assertEquals(1, resultado.size());
        assertEquals("Halo", resultado.get(0).getTitulo());
    }
    
    @Test
    @DisplayName("Buscar por título")
    void testBuscarPorTitulo() {
        gestor.altaCartucho(cartucho1);
        
        ArrayList<Cartucho> resultado = gestor.buscarPorTitulo("Halo");
        
        assertEquals(1, resultado.size());
    }
}