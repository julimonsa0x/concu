package tp4.ejercicio8;

public class Main {
    
    public static void main(String[] args) {
        // recurso compartido
        Confiteria confiteria = new Confiteria();
        
        // Crear y lanzar el hilo del mozo
        Mozo mozo = new Mozo(confiteria, "Juan");
        Thread hiloMozo = new Thread(mozo);
        hiloMozo.start();
        
        // Crear y lanzar los hilos de los empleados (clientes)
        for (int i = 1; i <= 5; i++) {
            Empleado empleado = new Empleado(confiteria, "Empleado-" + i);
            Thread hiloEmpleado = new Thread(empleado);
            hiloEmpleado.start();
        }
    }
    
}
