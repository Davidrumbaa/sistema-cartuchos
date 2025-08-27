import java.util.ArrayList;

/**
 * Gestor principal para la administración del catálogo de cartuchos.
 * Proporciona operaciones de alta, búsqueda y listado de cartuchos
 * con validación de duplicados por título y plataforma.
 *
 * @author Davidrumbaa
 * @version 1.0
 */

public class GestorCartuchos {
    private ArrayList<Cartucho> cartuchos;

    //Constructor
    public GestorCartuchos() {
        cartuchos = new ArrayList<>();

    }

    /**
     * Registra un nuevo cartucho en el catálogo si no existe duplicado.
     * Un cartucho se considera duplicado si tiene mismo título y plataforma.
     *
     * @param cartucho el cartucho a añadir al catálogo
     * @return true si se añadió correctamente, false si ya existía
     */

    //1. Alta de cartucho
    public boolean altaCartucho (Cartucho cartucho) {
        for (Cartucho c : cartuchos) {
            if (c.getTitulo().equalsIgnoreCase(cartucho.getTitulo())
                && c.getPlataforma() == cartucho.getPlataforma()) {
                return false;
            }
        }
        cartuchos.add(cartucho);
        return true;
    }

    //2. Listar todos los cartuchos
    public  ArrayList<Cartucho> listarCartuchos() {
        return new ArrayList<>(cartuchos);
    }

    //3. Búsqueda por plataforma
    public ArrayList<Cartucho> buscarPorPlataforma(Plataforma plataforma) {
        ArrayList<Cartucho> resultado = new ArrayList<>();
        for (Cartucho c : cartuchos) {
            if (c.getPlataforma() == plataforma) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Cartucho buscarCartucho(String titulo, Plataforma plataforma) {
        for (Cartucho c: cartuchos) {
            boolean tituloOK = c.getTitulo().trim().equalsIgnoreCase(titulo.trim());
            boolean plataformaOK = (c.getPlataforma() == plataforma);
            if (tituloOK && plataformaOK) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cartucho> buscarPorTitulo (String titulo) {
        ArrayList<Cartucho> resultado = new ArrayList<>();
        for (Cartucho c : cartuchos) {
            if (c.getTitulo().trim().equalsIgnoreCase(titulo.trim())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

}

