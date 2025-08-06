import java.util.ArrayList;

public class GestorClientes {
    private ArrayList<Cliente> clientes;

    public GestorClientes() {
        clientes = new ArrayList<>();
    }

    public boolean altaCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(cliente.getDni())) {
                return false;
            }
        }
        clientes.add(cliente);
        return true;
    }

    public boolean bajaCliente(String dni) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getDni().equals(dni)) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean modificarCliente(String dni,
                                    String nuevoNombre,
                                    String nuevoTelefono,
                                    String nuevoEmail) {
        for (Cliente c : clientes){
            if (c.getDni().equals(dni)) {
                c.setNombre(nuevoNombre);
                c.setTelefono(nuevoTelefono);
                c.setEmail(nuevoEmail);
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

}
