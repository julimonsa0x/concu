package tp4.ejercicio7;
import java.util.concurrent.Semaphore;

public class Surtidor {
    private int cantMax;        
    private int cantActual;     
    private int umbral = 20;    

    // Los "Motores" de la concurrencia
    private Semaphore semMutex = new Semaphore(1);   // Protege 'cantActual'
    private Semaphore semCamion = new Semaphore(0);  // El camión arranca dormido
    private Semaphore semAutos = new Semaphore(1);   // Barrera de entrada: 1 = Abierta
    
    public Surtidor(int capacidad) {
        this.cantMax = capacidad;
        this.cantActual = capacidad;
    }

    public boolean surtir(int cantCarga) {
        boolean res = false;
        try {
            // [PASO 1]: Barrera de entrada.
            // Si el camión tiene la ficha (semAutos = 0), los autos se quedan congelados aquí.
            semAutos.acquire();
            semAutos.release(); 
            
            // [PASO 2]: Exclusión Mutua. 
            // Tomamos la manguera ANTES de leer o modificar 'cantActual'
            semMutex.acquire();
            
            Thread.sleep(100); // Simulamos el tiempo que tarda en conectar la manguera

            if (cantCarga <= cantActual) {
                // Hay nafta, cargamos.
                cantActual -= cantCarga;
                res = true;
                System.out.println("[:D] Surtidor: Suministrando " + cantCarga + "L. Quedan " + cantActual + "L.");

                // Evaluamos si dejamos poca nafta
                if (cantActual < umbral) {
                    System.out.println(" [!] Surtidor: Queda poca nafta. ¡Despertando al camión!");
                    semCamion.release(); // Le pasamos la ficha al camión
                }
                
            } else {
                // No hay suficiente nafta para este auto (Emergencia)
                System.out.println(" [!] Surtidor: Auto pide " + cantCarga + "L pero solo hay " + cantActual + "L. ¡Llamando al camión!");
                
                // Vaciamos el tanque artificialmente para forzar la recarga
                cantActual = 0; 
                semCamion.release(); // Despertamos al camión sí o sí
                
                // Nota: 'res' sigue siendo false. El Auto se irá, y su propio while() 
                // lo hará volver a intentar entrar por la barrera.
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // [PASO 3]: Pase lo que pase (cargó o no cargó), suelta la manguera.
            semMutex.release();
        }
        return res;
    }

    public void recargar() {
        try {
            // [PASO A]: El camión duerme profundamente (se bloquea al no haber permiso)
            semCamion.acquire();

            // [PASO B]: Un auto nos despertó. Lo primero que hacemos es CERRAR LA BARRERA.
            // Al hacer acquire, quitamos la única ficha. Los autos nuevos se trabarán.
            semAutos.acquire();

            System.out.println(" [...] Camion bloquea la estacion para re-filling...");
            Thread.sleep(3000); 
            
            cantActual = cantMax; // Llenamos el tanque
            System.out.println("[ OK ] Camion termina y se va...");

            // [PASO C]: REABRIR LA BARRERA. 
            // Devolvemos la ficha para que los autos amontonados pasen.
            semAutos.release();
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}