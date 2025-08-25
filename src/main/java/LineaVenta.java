public class LineaVenta {
    private Cartucho cartucho;
    private int unidades;
    private double precioUnitario;

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
