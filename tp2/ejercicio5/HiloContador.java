package tp2.ejercicio5;
import utils.UtilsConcu;

public class HiloContador implements Runnable {
    String nombreHilo;

    public HiloContador(String nombre) {
        this.nombreHilo = nombre;
    }

    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aqui
    public void run() {
        System.out.println();
        System.out.println("Comenzando " + nombreHilo);

        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(200);
                System.out.println("En "+ nombreHilo + ", el recuento " + contar + UtilsConcu.obtenerTimestamp());
            }
        } catch (InterruptedException e) {
            System.out.println(nombreHilo + " Interrumpido");
        }

        /* // Quitamos el try y el catch por completo
        for (int contar = 0; contar < 10; contar++) {
            System.out.println("En "+ nombreHilo + ", el recuento " + contar + UtilsConcu.obtenerTimestamp());
        }*/
        
        System.out.println("Terminando " + nombreHilo + UtilsConcu.obtenerTimestamp());
    }
}
