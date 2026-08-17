package tp2.ejercicio6;
import java.util.concurrent.ThreadLocalRandom; // sugerencia copilot
import utils.UtilsConcu;

public class Corredor implements Runnable{
    private String nombre;
    private int distRecorrida;

    public Corredor(String nombreCorredor) {
        this.nombre = nombreCorredor;
        this.distRecorrida = 0;
    }

    public int getDistancia()   { return distRecorrida; }
    public String getNombre()   { return nombre; }
    
    @Override
    public void run() {
        try {
            for(int i=0; i < 10; i++) {
                int random = ThreadLocalRandom.current().nextInt(1, 11); // rango [1, 11)
                this.distRecorrida += random;
                
                System.out.println("corredor: "+this.nombre+", avancé: "+random+", score: "+distRecorrida+"/ 100 (total)" + UtilsConcu.obtenerTimestamp());
                Thread.sleep(50); // "debe descansar..." o deberia ir .sleep() fuera del for???
            }
        } catch (InterruptedException e) {
            System.out.println();
        }
    }
    
}
