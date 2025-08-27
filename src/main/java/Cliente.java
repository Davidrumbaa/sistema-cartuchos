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

    /**
     * Obtiene el nombre del cliente.
     * @return el nombre completo
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI del cliente.
     * @return el DNI completo
     */
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el teléfono del cliente.
     * @return el teléfono completo
     */
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el email del cliente.
     * @return el email completo
     */
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}