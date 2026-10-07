package tp4.ejercicio3;
import java.util.concurrent.Semaphore;

public class Proceso implements Runnable {
    private String nombre;
    private Semaphore miSemaforo;
    private Semaphore siguienteSemaforo;

    public Proceso(String nombre, Semaphore miSem, Semaphore nextSem) {
        this.nombre = nombre;
        this.miSemaforo = miSem;
        this.siguienteSemaforo = nextSem;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 1. Me bloqueo hasta que alguien me dé una ficha
                miSemaforo.acquire(); 
                
                // 2. Hago mi tarea (Sección Crítica)
                System.out.println("Ejecutando proceso: " + nombre);
                Thread.sleep(1000); // Simulamos que hacer la tarea toma 1 segundo
                
                // 3. Le paso el "testigo" (ficha) al siguiente proceso
                siguienteSemaforo.release(); 
                
            } catch (InterruptedException e) { 
                e.printStackTrace();
            }
        }
    }        
}