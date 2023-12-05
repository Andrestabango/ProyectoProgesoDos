
import java.util.ArrayList;
import java.util.Scanner;
class Menu {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void ingresarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese cédula del cliente:");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese correo del cliente:");
        String correo = scanner.nextLine();

        Venta cliente = new Venta(nombre, cedula, correo);
        clientes.add(cliente);// Llamada al método para ingresar código y fecha
        System.out.println("Cliente ingresado correctamente.");

        ingresarProductos(cliente);
    }

    private void ingresarProductos(Venta cliente) {
        Scanner scanner = new Scanner(System.in);
        char respuesta;
        do {
            System.out.println("Ingrese nombre del producto:");
            String nombreProducto = scanner.nextLine();
            System.out.println("Ingrese precio del producto:");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese cantidad del producto:");
            int cantidad = scanner.nextInt();

            Producto producto = new Producto(nombreProducto, precio, cantidad);
            cliente.productos.add(producto);

            System.out.println("¿Desea ingresar otro producto? (S/N): ");
            scanner.nextLine(); // Consumir el salto de línea pendiente
            respuesta = scanner.nextLine().charAt(0);
        } while (respuesta == 'S' || respuesta == 's');
    }

    public void imprimirDatosClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            cliente.imprimirDatos();
            if (cliente instanceof Venta) {
                Venta venta = (Venta) cliente;
                System.out.println("Valor Total de Productos: $" + venta.calcularValorTotal());
            }
            System.out.println("------------------------");
        }
    }
    public void buscarClientePorCodigoVenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el código de venta:");
        int codigoVenta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        boolean clienteEncontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente instanceof Venta) {
                Venta venta = (Venta) cliente;
                if (venta.codigoVenta == codigoVenta) {
                    venta.imprimirDatos();
                    clienteEncontrado = true;
                    break;
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente no encontrado por el código de venta.");
        }
    }


    public void imprimirMenu() {
        int opcion;

        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("=========================================================");
            System.out.println("[1] INGRESAR EL CLIENTE");
            System.out.println("[2] IMPRIMIR CLIENTES");
            System.out.println("[3] BUSCAR CLIENTE");
            System.out.println("[0] SALIR");
            System.out.println("=========================================================");

            System.out.println("\nINGRESE UNA OPCIÓN");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ingresarCliente();
                    break;
                case 2:
                    imprimirDatosClientes();
                    break;
                case 3:
                    buscarClientePorCodigoVenta();
                    break;
                case 0:
                    System.out.println("GRACIAS POR PREFERIRNOS");
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
                    break;
            }
        } while (opcion != 0);
    }
}
