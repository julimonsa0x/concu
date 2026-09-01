package tp3.ejercicio4;

public class CajaHerramienta {
    Object lockCuchara = new Object();
    Object lockBuscapolos = new Object();
    Object lockLlave = new Object();
    Object lockNivel = new Object();
    Object lockCinta = new Object();
    
    public void usarCuchara() {
        synchronized (lockCuchara) {
            try {
                System.out.println(Thread.currentThread().getName() 
                    + ": usa la cuchara 5 segs.");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // cachai o cachai po 🗣️
            }
        }
    }
    public void usarBuscapolos() {
        synchronized (lockBuscapolos) {
            try {
                System.out.println(Thread.currentThread().getName() 
                    + ": usa la buscapolos 2 segs.");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // cachai o cachai po 🗣️
            }
        }
    }
    public void usarLlave() {
        synchronized (lockLlave) {
            try {
                System.out.println(Thread.currentThread().getName() 
                    + ": usa la Llave 3 segs.");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // cachai o cachai po 🗣️
            }
        }
    }
    public void usarNivel() {
        synchronized (lockNivel) {
            try {
                System.out.println(Thread.currentThread().getName() 
                    + ": usa la Nivel 5 segs.");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // cachai o cachai po 🗣️
            }
        }
    }
    public void usarCinta() {
        synchronized (lockCinta) {
            try {
                System.out.println(Thread.currentThread().getName() 
                    + ": usa la Cinta 6 segs.");
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                // cachai o cachai po 🗣️
            }
        }
    }

    // algo mas...
}
