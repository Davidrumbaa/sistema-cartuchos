import java.util.ArrayList;

/**
 * Representa una transacción de venta completa con múltiples líneas de productos.
 *
 * Una venta está asociada a un cliente específico y puede contener múltiples
 * líneas de productos. Gestiona automáticamente el cálculo de totales y la
 * actualización del stock de los cartuchos vendidos.
 *
 * @author Davidrumbaa
 * @version 1.0
 */

public class Venta {
    private Cliente cliente;
    private ArrayList<LineaVenta> lineas;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        lineas = new ArrayList<>();
    }

    /**
     * Añade una línea de venta con el cartucho y cantidad especificados.
     * Actualiza automáticamente el stock del cartucho si hay suficientes unidades.
     *
     * @param c el cartucho a vender
     * @param unidades la cantidad a vender
     * @return true si se añadió la línea correctamente, false si no hay stock suficiente
     */

    public boolean addLinea(Cartucho c, int unidades) {
        if (unidades <= 0)
            return false;
        if (c.getStock() < unidades)
            return false;
        LineaVenta lv = new LineaVenta(c, unidades, c.getPrecioCompra());
        lineas.add(lv);
        c.setStock(c.getStock() - unidades);
        return true;
    }

    public double calcularTotal() {
        double total = 0;
        for (LineaVenta lv : lineas) {
            total += lv.subtotal();
        }
        return total;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getNumLineas() {
        return lineas.size();
    }

    public ArrayList<LineaVenta> getLineas() {
        return new ArrayList<>(lineas);

    }
}

