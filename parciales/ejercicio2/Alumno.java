package parciales.ejercicio2;
import java.util.concurrent.ThreadLocalRandom;

public class Alumno implements Runnable {
    private String nombre;
    private Pizarra pizarra;

    public Alumno(String nombre, Pizarra pizarra) {
        this.nombre = nombre;
        this.pizarra = pizarra;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 1. cooldown inicial para evitar que entren todos al mismo instante
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5001));
                
                // 2. la uso...
                pizarra.usarPizarra(nombre);

                // 3. un usuario particular usa la pizarra por un tiempo aleatorio
                // entre 3 a 6 segundos... para reusarla espera unos 15 segundos...
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 6001));

                // 4. la libero...
                pizarra.liberarPizarra(nombre);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
