import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorClientes gestorClientes = new GestorClientes();
        GestorCartuchos gestorCartuchos = new GestorCartuchos();
        GestorVentas gestorVentas = new GestorVentas();

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

                case 3:
                    //1. Pedir DNI
                    System.out.println("DNI del cliente: ");
                    String dniVenta = sc.nextLine();
                    //2. Comprobar el cliente
                    Cliente cliente = gestorClientes.buscarCliente(dniVenta);
                    if (cliente == null) {
                        System.out.println("No existe ningún cliente con ese DNI.");
                        break;
                    }
                    //3. Iniciar la venta
                    Venta venta = gestorVentas.crearVenta(cliente);
                    System.out.println("Cliente encontrado: "  + cliente.getNombre() + ". Venta iniciada.");
                    boolean seguir = true;
                            while (seguir) {
                                System.out.println("Título del cartucho: ");
                                String titulo = sc.nextLine();

                                System.out.print("Plataforma (Xbox/PlayStation/Switch): ");
                                String plataformaTexto = sc.nextLine().trim();
                                Plataforma plataforma;
                                try {
                                    plataforma = Plataforma.valueOf(plataformaTexto.toUpperCase());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Plataforma no válida.");
                                    continue;
                                }

                                Cartucho c = gestorCartuchos.buscarCartucho(titulo, plataforma);
                                if (c == null) {
                                    System.out.println("No existe ese cartucho en esa plataforma.");
                                    continue;
                                }

                                System.out.println("Unidades: ");
                                int unidades = Integer.parseInt(sc.nextLine());

                                boolean ok = venta.addLinea(c, unidades);
                                if (ok) {
                                    System.out.println("Línea añadida. Total parcial: " + venta.calcularTotal() + "€");
                                } else {
                                    System.out.println("Stock insuficiente o unidades no válidas");
                                    continue;
                                }

                                System.out.println("¿Añadir otra línea? (sí/no): ");
                                String respuesta = sc.nextLine().trim();
                                if (respuesta.equalsIgnoreCase("no")) {
                                    seguir = false;
                                }
                            }

                    System.out.println("Total de la venta: " + venta.calcularTotal() + "€");
                            break;

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
                        System.out.println("Opción inválida.");
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
                case 1:
                    //Titulo
                    System.out.println("Título: ");
                    String titulo = sc.nextLine();
                    //Plataforma
                    System.out.println("Plataforma (Xbox/Playstation/Switch): ");
                    String plataformaTexto = sc.nextLine().trim();
                    Plataforma plataforma = Plataforma.valueOf(plataformaTexto.toUpperCase());
                    //Año de publicación
                    System.out.println("Año de publicación del título: ");
                    int anioPublicacion = Integer.parseInt(sc.nextLine());
                    //Estado
                    System.out.println("Estado (Nuevo/Usado): ");
                    String estadoTexto = sc.nextLine().trim();
                    Estado estado = Estado.valueOf(estadoTexto.toUpperCase());
                    //Precio de compra
                    System.out.println("Precio de compra: ");
                    double precioCompra = Double.parseDouble(sc.nextLine());
                    //Stock
                    System.out.println("Stock (unidades): ");
                    int stock = Integer.parseInt(sc.nextLine());
                    //Agregar cartucho
                    Cartucho nuevo = new Cartucho(titulo, plataforma, anioPublicacion, estado, precioCompra, stock);
                    boolean ok = g.altaCartucho(nuevo);
                    if (ok) {
                        System.out.println("Cartucho dado de alta correctamente");
                    } else {
                        System.out.println("Ya existe un cartucho con ese título en esa plataforma");
                    }
                    break;
                case 2:
                    //Pedir lista
                    ArrayList<Cartucho> lista = g.listarCartuchos();
                    //Comprobar si está vacía
                    if (lista.isEmpty()) {
                        System.out.println("No hay cartuchos en el catálogo.");
                    } else {
                        System.out.println("Catálogo de cartuchos: ");
                        //Recoger e imprimir los cartuchos
                        for (Cartucho c : lista) {
                            System.out.println("- " + c.getTitulo() + " [" + c.getPlataforma() + "] " + c.getAnioPublicacion() + " • " + c.getEstado() + " • " + c.getPrecioCompra() + "€ • Stock: " + c.getStock());
                        }
                    }
                    break;
                case 3:
                    //Pedir plataforma
                    System.out.println("Plataforma (Xbox/PlayStation/Switch): ");
                    String plataformaUsuario = sc.nextLine().trim();
                    Plataforma p;
                    try {
                        p = Plataforma.valueOf(plataformaUsuario.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Plataforma no válida. Usa Xbox, PlayStation o Switch.");
                        break;
                    }
                    ArrayList<Cartucho> cartuchosFiltrados = g.buscarPorPlataforma(p);
                    if (cartuchosFiltrados.isEmpty()) {
                        System.out.println("No hay juegos para esa plataforma.");
                    } else {
                        System.out.println("Resultados para " + p + ":");
                        for (Cartucho c : cartuchosFiltrados) {
                            System.out.println("- " + c.getTitulo() + " [" + c.getPlataforma() + "] " + c.getAnioPublicacion() + " • " + c.getEstado() + " • " + c.getPrecioCompra() + "€ • Stock: " + c.getStock());
                        }
                    }
                    break;
                case 4:
                    volver = true;
                    break;

                    default:
                        System.out.println("Opción inválida.");
            }
        }
    }
}
