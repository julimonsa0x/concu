package tp4.ejercicio9;
import utils.Colors;

public class HiloControlador implements Runnable {
    private CentroProduccion centroProduccion;

    public HiloControlador(CentroProduccion centroProduccion) {
        this.centroProduccion = centroProduccion;
    }

    @Override
    public void run() {
        while (true) {
            // alterna la luz cada 5 segundos
            try {

                // Simula un tiempo de ensamblaje aleatorio entre 2 y 3.5 segundos
                Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(2000, 3500));
                
                
                //Thread.sleep(5000);
                // sacamos los souts() de los .run() para evitar duplicados
                
                // este particular lo dejo...
                System.out.println(Colors.CONTROL +"HiloControlador alternando luz... after 5s");

                centroProduccion.cambiaLineas();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
