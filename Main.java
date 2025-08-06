import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();
        GestorCartuchos gestorCartuchos = new GestorCartuchos();

        boolean salir = false;
        while (!salir) {
            // 1. Mostrar menú principal
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de cartuchos");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            // 2. Procesar la opción
            switch (opcion) {
                case 1:
                    menuClientes(sc, gestorClientes);
                    break;
                case 2:
                    menuCartuchos(sc, gestorCartuchos);
                    default:
                        System.out.println("Opción inválida");
            }
        }
    }

    private static void menuClientes(Scanner sc, GestorClientes g) {
        boolean volver = false;
        while (!volver) {
            //1. Mostrar submenú de clientes
            System.out.println("=== GESTIÓN DE CLIENTES ===");
            System.out.println("1. Alta de cliente");
            System.out.println("2. Baja de cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Listar clientes");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            //2. Procesar la elección
            switch (opcion) {
                case 1:
                    //1. Pedir los datos al usuario
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("DNI: ");
                    String dni = sc.nextLine();
                    System.out.println("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();
                    //2. Crear el objeto Cliente
                    Cliente nuevo = new Cliente(nombre, dni, telefono, email);
                    //3. Llamar al gestor
                    boolean exito =  g.altaCliente(nuevo);
                    //4. Mostrar resultado
                    if (exito) {
                        System.out.println("Cliente dado de alta correctamente.");
                    } else {
                        System.out.println("Ya existe un cliente con ese DNI");
                    }
                    break;
                case 2:
                    //1. Pedir datos
                    System.out.println("DNI del cliente a dar de baja: ");
                    String dniBaja = sc.nextLine();
                    //2. Llamar al gestor
                    boolean bajaOk = g.bajaCliente(dniBaja);
                    //3. Mostrar resultado
                    if (bajaOk) {
                        System.out.println("Cliente dado de baja correctamente.");
                    } else {
                        System.out.println("No existe ningún cliente con ese DNI.");
                    }
                    break;
                case 3:
                    //1. Pedir datos
                    System.out.println("DNI del cliente a modificar: ");
                    String dniMod = sc.nextLine();
                    System.out.println("Nuevo nombre: ");
                    String nombreMod = sc.nextLine();
                    System.out.println("Nuevo teléfono: ");
                    String telefonoMod = sc.nextLine();
                    System.out.println("Nuevo email: ");
                    String emailMod = sc.nextLine();
                    //2. Llamar al gestor
                    boolean modOk = g.modificarCliente(dniMod, nombreMod, telefonoMod, emailMod);
                    //3. Mostrar resultado
                    if (modOk) {
                        System.out.println("Cliente modificado correctamente.");
                    } else {
                        System.out.println("No existe ningún cliente con ese DNI");
                    }
                    break;
                case 4:
                    //1. Pedir datos
                    System.out.println("DNI del cliente a buscar: ");
                    String dniBus = sc.nextLine();
                    //2. Llamar al gestor
                    Cliente c = g.buscarCliente(dniBus);
                    //3. Mostrar resultado
                    if (c != null) {
                        System.out.println("Datos del cliente:");
                        System.out.println(" Nombre: " + c.getNombre());
                        System.out.println(" DNI: " + c.getDni());
                        System.out.println(" Teléfono: " + c.getTelefono());
                        System.out.println(" Email: " + c.getEmail());
                    } else {
                        System.out.println("No existe ningún cliente con ese DNI.");
                    }
                    break;
                case 5:
                    ArrayList<Cliente> lista = g.listarClientes();
                    if (lista.isEmpty()) {
                        System.out.println("No hay clientes en el sistema.");
                    } else {
                        System.out.println("Clientes registrados:");
                        for (Cliente cli : lista){
                            System.out.println("  - " + cli.getNombre()+" (" + cli.getDni() + ")");
                        }
                    }
                    break;
                case 6:
                    volver = true;
                    break;

                    default:
                        System.out.println("Opción inválida");
            }
        }
    }

    private static void menuCartuchos (Scanner sc, GestorCartuchos g) {
        boolean volver = false;
        while (!volver) {
            System.out.println("=== GESTIÓN DE CARTUCHOS ===");
            System.out.println("1. Alta de cartucho");
            System.out.println("2. Listar catálogo");
            System.out.println("3. Búsqueda por plataforma");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige opción: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
