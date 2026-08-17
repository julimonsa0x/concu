package tp2.extra;

class TareaPreparacion implements Runnable {
    private String nombreTarea;

    public TareaPreparacion(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    @Override
    public void run() {
        System.out.println(nombreTarea + " - Iniciando...");
        
        // El bucle comienza desde la fila de datos inicial i = 0
        for (int i = 0; i < 3; i++) {
            System.out.println(nombreTarea + " - Progreso etapa: " + i);
            try {
                // Simulamos que la tarea toma tiempo
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(nombreTarea + " fue interrumpida.");
            }
        }
        System.out.println(nombreTarea + " - Finalizada.");
    }
}

public class MainConcurrencia {
    
    // Método de ejemplo con un único punto de salida
    public static boolean verificarEstadoHilos(Thread hilo1, Thread hilo2) {
        boolean ambosTerminados = false;
        
        if (!hilo1.isAlive() && !hilo2.isAlive()) {
            ambosTerminados = true;
        }
        
        return ambosTerminados; 
    }

    public static void main(String[] args) {
        System.out.println("Hilo Principal (Main) - Iniciando programa.");

        // 1. Crear las instancias Runnable
        Runnable tarea1 = new TareaPreparacion("Preparar Tuco");
        Runnable tarea2 = new TareaPreparacion("Hacer Polenta");

        // 2. Pasarlas a los objetos Thread
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        // 3. Iniciar los hilos (La JVM los ejecutará de forma concurrente)
        hilo1.start();
        hilo2.start();

        System.out.println("Hilo Principal (Main) - Esperando a que terminen las preparaciones...");

        try {
            // 4. Usar .join() para obligar al Main a esperar a hilo1 y hilo2
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
        }

        // Verificamos el estado usando el método auxiliar
        boolean exito = verificarEstadoHilos(hilo1, hilo2);
        
        if (exito) {
            System.out.println("Hilo Principal (Main) - Todas las tareas terminaron. Fin del programa.");
        }
    }
}