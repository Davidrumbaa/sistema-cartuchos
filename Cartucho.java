public class Cartucho {
    private String titulo;
    private Plataforma plataforma;
    private int anoPublicacion;
    private Estado estado;
    private double precioCompra;
    private int stock;

    //Constructor
    public Cartucho(String titulo,
                    Plataforma plataforma,
                    int anoPublicacion,
                    Estado estado,
                    double precioCompra,
                    int stock) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.anoPublicacion = anoPublicacion;
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

    public int getAnoPublicacion() {
        return anoPublicacion;
    }
    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
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
