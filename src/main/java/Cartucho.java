/**
 * Representa un cartucho de videojuego en el inventario.
 * Contiene información de título, plataforma, estado, precio y stock.
 * Los cartuchos se identifican únicamente por título y plataforma.
 *
 * @author Davidrumbaa
 * @version 1.0
 */

public class Cartucho {
    private String titulo;
    private Plataforma plataforma;
    private int anioPublicacion;
    private Estado estado;
    private double precioCompra;
    private int stock;

    /**
     * Crea un nuevo cartucho con los datos proporcionados.
     *
     * @param titulo          título del cartucho
     * @param plataforma      consola o sistema al que pertenece
     * @param anioPublicacion año en que se lanzó
     * @param estado          estado físico (p. ej., NUEVO, USADO)
     * @param precioCompra    precio de compra del cartucho
     * @param stock           unidades disponibles en inventario
     */

    //Constructor
    public Cartucho(String titulo,
                    Plataforma plataforma,
                    int anioPublicacion,
                    Estado estado,
                    double precioCompra,
                    int stock) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anioPublicacion = anioPublicacion;
        this.estado = estado;
        this.precioCompra = precioCompra;
        this.stock = stock;
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

}
