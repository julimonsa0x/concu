package tp2.ejercicio2;
import utils.UtilsConcu;

public class TesteoHilos {
    public static void main(String[] args) {
        Thread miHilo = new Hilo();
        miHilo.start();
        
        System.out.println("En el main "+ UtilsConcu.obtenerTimestamp());
    }
}
