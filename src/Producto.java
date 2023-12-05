class Producto extends Cliente {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        super("", "", ""); // Los atributos de Cliente no son relevantes para Producto
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    void imprimirDatos() {
        System.out.println("Nombre del Producto: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println();
    }

    @Override
    double calcularValorTotal() {
        return 0;
    }

}