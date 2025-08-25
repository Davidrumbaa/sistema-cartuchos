/**
 * Representa un cliente del sistema de gestión de cartuchos.
 * Cada cliente se identifica por su DNI único.
 *
 * @author Davidrumbaa
 * @version 1.0
 */


public class Cliente {
    private String nombre;
    private String dni;
    private String telefono;
    private String email;

    /**
     * Constructor para crear un cliente con todos los datos.
     *
     * @param nombre el nombre del cliente
     * @param dni el DNI único del cliente
     * @param telefono el teléfono de contacto
     * @param email el email del cliente
     */

    //Constructor
    public Cliente(String nombre,
                   String dni,
                   String telefono,
                   String email) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}