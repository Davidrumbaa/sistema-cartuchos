/**
 * Representa una línea individual dentro de una venta.
 *
 * Cada línea contiene información sobre un cartucho específico,
 * la cantidad vendida y el precio unitario aplicado en el momento
 * de la venta.
 *
 * @author Davidrumbaa
 * @version 1.0
 */

public class LineaVenta {
    private Cartucho cartucho;
    private int unidades;
    private double precioUnitario;

    /**
     * Calcula el subtotal de esta línea de venta.
     *
     * @return el resultado de multiplicar unidades por precio unitario
     */

    public LineaVenta(Cartucho cartucho,
                           int unidades,
                           double precioUnitario) {
        this.cartucho = cartucho;
        this.unidades = unidades;
        this.precioUnitario = precioUnitario;
    }

    public double subtotal() {
        return unidades*precioUnitario;
    }

    public Cartucho getCartucho(){
        return cartucho;
    }
    public void setCartucho(Cartucho cartucho) {
        this.cartucho = cartucho;
    }

    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
