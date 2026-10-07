package parciales.ejercicio2;

public class Pizarra {
    
    private boolean disponible = true;

    public Pizarra() {
        //...
    }
    
    public synchronized void usarPizarra(String nombre) {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // si sale del while, entonces la hemos agarrado...
        disponible = false;
        System.out.println(nombre + " está usando la pizarra.");
    }
    
    public synchronized void liberarPizarra(String nombre) {
        disponible = true;
        System.out.println(nombre + " ha liberado la pizarra.");
        notifyAll();
    }
    
}
