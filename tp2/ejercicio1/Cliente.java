package tp2.ejercicio1;

import utils.UtilsConcu;

public class Cliente extends Thread {
    private Recurso miRecurso;

    public Cliente(Recurso miRecurso){
        this.miRecurso = miRecurso;
    }

    public void run() {
        // previamente... System.out.println("Soy "+Thread.currentThread().getName());
        System.out.println("Soy " + Thread.currentThread().getName() + " | ran at = [" + UtilsConcu.obtenerTimestamp() + "]");
        this.miRecurso.uso();
        
        try {
            Thread.sleep(2000);
        } catch(InterruptedException e){
            System.out.println("Error");
        }
    }
}
