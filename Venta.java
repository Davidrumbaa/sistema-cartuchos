import java.util.ArrayList;

public class Venta {
    private Cliente cliente;
    private ArrayList<LineaVenta> lineas;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        lineas = new ArrayList<>();
    }

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
}

