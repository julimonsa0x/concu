package tp3.ejercicio3;

public class Jaula {
    private Object lockRueda = new Object();
    private Object lockPlato = new Object();
    private Object lockHamaca = new Object();

    public void usarRueda() {
        synchronized (lockRueda) {
            try {
                System.out.println(Thread.currentThread().getName()
                    + " -esta usando la rueda 1 seg.-");
                    Thread.sleep(1000);
            } catch (InterruptedException e) {
                // catch e bruh
            }
        }
    }

    public void usarPlato() {
        synchronized (lockPlato) {
            try {
                System.out.println(Thread.currentThread().getName()
                    + " -esta usando el plato 3 seg.-");
                    Thread.sleep(3000);
            } catch (InterruptedException e) {
                // catch e bruh
            }
        }
    }
    
    public void usarHamaca() {
        synchronized (lockHamaca) {
            try {
                System.out.println(Thread.currentThread().getName()
                    + " -esta usando la hamaca 4 seg.-");
                    Thread.sleep(4000);
            } catch (InterruptedException e) {
                // catch e bruh
            }
        }
    }
    
}
