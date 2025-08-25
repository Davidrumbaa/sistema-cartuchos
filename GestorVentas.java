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

    public ArrayList<Venta> ventasPorCliente(String dni) {
        ArrayList<Venta> resultado = new ArrayList<>();
        for (Venta v : ventas) {
            if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public double totalPorCliente(String dni) {
        double total = 0.0;
        for (Venta v : ventas) {
            if (v.getCliente().getDni().equalsIgnoreCase(dni)) {
                total += v.calcularTotal();
            }
        }
        return total;
    }

}


