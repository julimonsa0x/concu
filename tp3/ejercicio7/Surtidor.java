package tp3.ejercicio7;

public class Surtidor {
    private int cantMax;
    private int cantActual;

    private boolean recargando = false; // ej9 para el Camion


    public Surtidor(int capacidad) {
        this.cantMax = capacidad;
        this.cantActual = capacidad;
    }

    public synchronized boolean surtir(int cantidad) {
        boolean res = false;
        try {
            Thread.sleep(3000); // supongamos tarda 3 seg en cargar nafta
            if (cantidad <= cantActual) {
                cantActual -= cantidad;
                res = true;
                System.out.println("[:D] Surtidor: Suministrando " + cantidad + " litros. | Estacion: " + (int)((double)cantActual / cantMax * 100) + "%.");
            } else {
                System.out.println(" [!] Surtidor: No hay suficiente combustible en la estacion... | Estacion: " + (int)((double)cantActual / cantMax * 100) + "%.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    
    
    
}
