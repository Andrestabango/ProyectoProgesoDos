abstract class Cliente {
    String nombre;
    String cedula;
    String correo;

    public Cliente(String nombre, String cedula, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
    }

    abstract void imprimirDatos();
    abstract double calcularValorTotal();
}
