package tp4.ejercicio4;
import java.util.concurrent.Semaphore;
import utils.UtilsConcu;

public class GestorImpresion {
    // Semáforo general: inicia con N permisos
    private Semaphore impresorasLibres;

    public GestorImpresion(int maxImpresoras) {
        this.impresorasLibres = new Semaphore(maxImpresoras);
    }
     
    // Centralizamos la lógica aquí. El cliente solo llama a este método.
    public void usarImpresora(String nombreCliente) {
        try {

            //int rn = (int) System.currentTimeMillis();
            
            // 1. El cliente pide una impresora (Se bloquea si están todas a 0)
            impresorasLibres.acquire();

            // 2. Si pasó el acquire, tiene una impresora asignada
            System.out.println("[!]  " + nombreCliente + " está imprimiendo su documento... " + "- acquired"+ UtilsConcu.obtenerTimestamp());
            Thread.sleep(3000); // Simulamos tiempo de impresión
            
            System.out.println("[OK] " + nombreCliente + " terminó y se retira.");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 3. Pase lo que pase, devuelve el permiso
            impresorasLibres.release();
            System.out.println(" - released: "+ UtilsConcu.obtenerTimestamp());
        }
    }
}