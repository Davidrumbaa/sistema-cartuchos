import java.util.ArrayList;

public class GestorVentas {
    private ArrayList<Venta> ventas;

    public  GestorVentas() {
        ventas = new ArrayList<>();
    }

    public Venta crearVenta(Cliente cliente) {
        //Crear venta
        Venta v = new Venta(cliente);
        //Guardarla en la lista
        ventas.add(v);
        //Devolverla
        return v;
    }

    public ArrayList<Venta> listarVentas() {
        return new ArrayList<>(ventas);
    }

    public void cancelarSiVacia(Venta v) {
        if (v.getNumLineas() == 0) {
            ventas.remove(v);
        }
    }
}


