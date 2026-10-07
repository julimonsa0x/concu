package tp4.ejercicio5;
import java.util.concurrent.Semaphore;
import utils.UtilsConcu;

public class GestorImpresion {
    private Semaphore libreA;
    private Semaphore libreB;

    public GestorImpresion(int cantA, int cantB) {
        this.libreA = new Semaphore(cantA);
        this.libreB = new Semaphore(cantB);
    }

    public void usarImpresoraA(String nombreCliente) {
        try {
            // 1. El cliente pide una impresora (Se bloquea si están todas a 0)
            libreA.acquire();
            
            // 2. Si pasó el acquire, tiene una impresora asignada
            System.out.println("[!]  " + nombreCliente + " está imprimiendo su documento en impresora A... [3segs.]"+ UtilsConcu.obtenerTimestamp());
            Thread.sleep(3000); // Simulamos tiempo de impresión
            
            System.out.println("[OK] " + nombreCliente + " terminó y se retira de impresora A."+ UtilsConcu.obtenerTimestamp());
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. Pase lo que pase, devuelve el permiso
            libreA.release();
        }
    }

    public void usarImpresoraB(String nombreCliente) {
        try {
            // 1. El cliente pide una impresora (Se bloquea si están todas a 0)
            libreB.acquire();
            
            // 2. Si pasó el acquire, tiene una impresora asignada
            System.out.println("[!]  " + nombreCliente + " está imprimiendo su documento en impresora B... [3segs.]"+ UtilsConcu.obtenerTimestamp());
            Thread.sleep(3000); // Simulamos tiempo de impresión
            
            System.out.println("[OK] " + nombreCliente + " terminó y se retira de impresora B."+ UtilsConcu.obtenerTimestamp());
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. Pase lo que pase, devuelve el permiso
            libreB.release();
        }
    }

    public void usarImpresoraAB(String nombreCliente) {
        boolean acquiredA = false;
        boolean acquiredB = false;
        
        try {
            /*
            
             */
            while (true) {
                if (libreA.tryAcquire()) {
                    acquiredA = true;
                    break; // adquirió A
                } else if (libreB.tryAcquire()) {
                    acquiredB = true;
                    break; // adquirió B
                } else {
                    Thread.sleep(250); // espera un poco antes de reintentar
                    System.out.println("[" + nombreCliente + "] Esperando impresora A o B..." + UtilsConcu.obtenerTimestamp());
                }
            }
            
            // fixed con el while de arriba, pero genera 
            // espera activa (polling)
            //libreA.acquire();
            //libreB.acquire();

            // 2. Si pasó el acquire, tiene una impresora asignada
            String tipo = acquiredA ? "A" : "B";
            System.out.println("[!]  " + nombreCliente + " está imprimiendo en impresora " + tipo + UtilsConcu.obtenerTimestamp() + "...");
            Thread.sleep(3000); 
            System.out.println("[OK] " + nombreCliente + " terminó y se retira de impresora " + tipo + UtilsConcu.obtenerTimestamp() + ".");
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. Pase lo que pase, devuelve el permiso
            if (acquiredA) {
                libreA.release();
            }
            if (acquiredB) {
                libreB.release();
            }
        }
    }
    
}