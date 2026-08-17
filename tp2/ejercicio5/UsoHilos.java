package tp2.ejercicio5;

import utils.UtilsConcu;

public class UsoHilos {
    public static void main(String[]args) {
        System.out.println("Hilo main iniciando.");

        // usando Runnable
        // instanciamos
        HiloContador hc = new HiloContador("#1");
        // Luego, construye un hilo con ese objeto.
        Thread  nuevoHilo = new Thread(hc);
        // Finalmente, comienza la ejecución del hilo.
        nuevoHilo.start();

        // usando Thread (el metodo ya es hilo y tiene el .start()... )
        HiloContador2 hc2 = new HiloContador2("#2");
        hc2.start();

        for(int i=0; i<20; i++){
            System.out.print(" .");
        }

        try{
            Thread.sleep(100);
        } catch(InterruptedException e){
            System.out.println("Hilo main interrumpido");
        }


        
        System.out.println("Hilo main finalizado" + UtilsConcu.obtenerTimestamp());
    }
 }
