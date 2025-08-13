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
}


