package tp4.ejercicio9;

public class ProductoMecanico implements Runnable{
    
    private CentroProduccion centroProduccion;

    public ProductoMecanico(CentroProduccion centroProduccion) {
        this.centroProduccion = centroProduccion;
    }

    @Override
    public void run() {
        // llega a la cinta mecanica
        centroProduccion.llegaMecanico();

        try {

            // Simula un tiempo de ensamblaje aleatorio entre 1 y 2.5 segundos
            Thread.sleep(java.util.concurrent.ThreadLocalRandom.current().nextInt(1000, 2500));
            
            //Thread.sleep(1000); // tiempo de ensamblaje
            // sacamos los souts() de los .run() para evitar duplicados
            //System.out.println("ensamblando mec.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // sale de la cinta mecanica
        centroProduccion.saleMecanico();
        // sacamos los souts() de los .run() para evitar duplicados
        //System.out.println("Producto mecanico saliendo...");
    }
    
}
