import java.util.ArrayList;

public class GestorCartuchos {
    private ArrayList<Cartucho> cartuchos;

    //Constructor
    public GestorCartuchos() {
        cartuchos = new ArrayList<>();

    }

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
            if (c.getTitulo().equalsIgnoreCase(titulo)
            && c.getPlataforma() == plataforma); {
                return c;
            }
        }
        return null;
    }

}

