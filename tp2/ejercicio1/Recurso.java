package tp2.ejercicio1;

import utils.UtilsConcu;

public class Recurso {
    public Recurso(){}

    public void uso() {
        Thread t = Thread.currentThread();
        // System.out.println("en Recurso: Soy" + t.getName()); originalmente... 
        System.out.println("en Recurso: Soy '" + t.getName() + UtilsConcu.obtenerTimestamp());
    }
}