package tp4.ejercicio6;
import java.util.concurrent.Semaphore;
import utils.UtilsConcu;

public class Taxi {
    // Protege el taxi para que suba solo 1 pasajero a la vez.
    private Semaphore semTaxiLibre; // libre = 1 permiso, ocupado = 0 permisos

    // El taxista duerme hasta que el pasajero sube.
    // awake driver = 1 permiso, driver sleeping / waiting for client = 0 permisos
    private Semaphore semWakeDriver; 

    // El pasajero duerme durante el viaje hasta llegar a destino.
    // awake client = 1 permiso, pasajero durmiendo = 0 permisos
    private Semaphore semViajeTerminado; 

    public Taxi(int libre, int wakeDriver, int viajeTerminado) {
        this.semTaxiLibre = new Semaphore(libre);
        this.semWakeDriver = new Semaphore(wakeDriver);
        this.semViajeTerminado = new Semaphore(viajeTerminado);
    }

    /**
     * para conducir() debemos
     * 1ro: acquire() el semWakeDriver (el taxista duerme hasta que el pasajero sube)
     * 2do: logica del viaje()
     * 3ro: release() el semViajeTerminado (despierta al pasajero)
     */
    public void conducir() {
        try {
            // bloqueo hasta que el pasajero suba al taxi
            semWakeDriver.acquire();
            System.out.println("[!]  El taxista está conduciendo el taxi... [3segs.]"+ UtilsConcu.obtenerTimestamp());
            
            Thread.sleep(3000); // Simulamos tiempo de viaje
            System.out.println("[OK] El taxista terminó el viaje y se retira del taxi." + UtilsConcu.obtenerTimestamp());
            
            semViajeTerminado.release(); // despierta al pasajero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * para tomarTaxi() debemos:
     * 1ro: acquire() el semTaxiLibre (un pasajero espera hasta que el taxi esté libre)
     * 2do: release() el semWakeDriver (despierta al taxista)
     * 3ro: acquire() el semViajeTerminado (el pasajero duerme durante el viaje hasta llegar a destino)
     * 4to: release() el semTaxiLibre (libera el taxi para que otro pasajero pueda tomarlo)
     * asumo que entre 3 y 4 (3.9 seria) el pasajero llega a su destino exitosamente... 
     * la logica es media trivial y no importa de momento...
     */
    public void tomarTaxi() {
        try {
            semTaxiLibre.acquire();
            System.out.println("[!]  El pasajero subió al taxi y despertó al taxista..."+ UtilsConcu.obtenerTimestamp());
            
            semWakeDriver.release();
            
            semViajeTerminado.acquire();
            System.out.println("[OK] El pasajero llegó a su destino y se retira del taxi." + UtilsConcu.obtenerTimestamp());
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 4to: libera el taxi para que otro pasajero pueda tomarlo
            semTaxiLibre.release();
        }
    }
    
}
