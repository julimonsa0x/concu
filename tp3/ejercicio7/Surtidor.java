package tp3.ejercicio7;

public class Surtidor {
    private int reservorio;
    private int cantActual;

    public Surtidor(int capacidad) {
        this.reservorio = capacidad;
        this.cantActual = capacidad;
    }

    public void surtir(int cantidad) {
        if (cantidad <= reservorio) {
            reservorio -= cantidad;
            System.out.println("Surtidor: Suministrando " + cantidad + " litros. Reservorio restante: " + reservorio + " litros.");
        } else {
            System.out.println("Surtidor: No hay suficiente combustible. Reservorio restante: " + reservorio + " litros.");
        }
    }
}
