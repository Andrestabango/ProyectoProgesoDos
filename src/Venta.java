import java.util.ArrayList;
import java.util.Scanner;

class Venta extends Cliente {
    int codigoVenta;
    String fechaCompra;
    ArrayList<Producto> productos;

    public Venta(String nombre, String cedula, String correo) {
        super(nombre, cedula, correo);
        this.productos = new ArrayList<>();
        ingresarCodigoYFecha();
    }

    public void ingresarCodigoYFecha() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el código de venta:");
        this.codigoVenta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese la fecha de compra (formato DD/MM/YYYY):");
        this.fechaCompra = scanner.nextLine();
    }

    @Override
    void imprimirDatos() {
        System.out.println("Nombre del Cliente: " + nombre);
        System.out.println("Cédula: " + cedula);
        System.out.println("Correo: " + correo);
        System.out.println("Código de Venta: " + codigoVenta);
        System.out.println("Fecha de Compra: " + fechaCompra);
        System.out.println("Productos comprados:");
        for (Producto producto : productos) {
            producto.imprimirDatos();
        }

    }

    @Override
    double calcularValorTotal() {
        double valorTotal = 0.0;
        for (Producto producto : productos) {
            valorTotal += producto.precio * producto.cantidad;
        }
        return valorTotal;
    }
}