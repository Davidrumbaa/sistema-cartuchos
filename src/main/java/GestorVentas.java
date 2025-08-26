import java.util.ArrayList;

/**
 * Gestor para operaciones de ventas y procesamiento de transacciones.
 *
 * Mantiene un registro de todas las ventas realizadas y proporciona
 * funcionalidades para crear ventas, gestionarlas y generar reportes
 * por cliente específico.
 *
 * @author Davidrumbaa
 * @version 1.0
 */

public class GestorVentas {
    private ArrayList<Venta> ventas;

    public  GestorVentas() {
        ventas = new ArrayList<>();
    }

    /**
     * Crea una nueva venta asociada a un cliente específico.
     *
     * @param cliente el cliente para quien se crea la venta
     * @return la nueva venta creada y añadida al registro
     */

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


