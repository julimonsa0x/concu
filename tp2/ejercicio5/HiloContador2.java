package tp2.ejercicio5;
import utils.UtilsConcu;

public class HiloContador2 extends Thread {
    //String nombreHilo; 
    // en lugar de nombreHilo usamos this.getName()

    
    public HiloContador2(String nombre) {
        super(nombre);
    }

    // Punto de entrada del hilo
    // Los hilos comienzan a ejecutarse aqui
    public void run() {
        System.out.println();
        System.out.println("Comenzando " + this.getName());

        try {
            for (int contar = 0; contar < 10; contar++) {
                Thread.sleep(200);
                System.out.println("En "+ this.getName() + ", el recuento " + contar + UtilsConcu.obtenerTimestamp());
            }
        } catch (InterruptedException e) {
            System.out.println(this.getName() + " Interrumpido");
        }

        /* // Quitamos el try y el catch por completo
        for (int contar = 0; contar < 10; contar++) {
            System.out.println("En "+ nombreHilo + ", el recuento " + contar + UtilsConcu.obtenerTimestamp());
        }*/
        
        System.out.println("Terminando " + this.getName() + UtilsConcu.obtenerTimestamp());
    }
}
