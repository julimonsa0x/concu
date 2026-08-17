package tp2.ejercicio3;
import utils.UtilsConcu;



public class ThreadEjemplo extends Thread {
    
    public ThreadEjemplo(String str) {
        super(str);
    }

    
    public void run() {
        for(int i=0;i<6;i++) {
            System.out.println(i+" "+getName()+UtilsConcu.obtenerTimestamp());
        }
        System.out.println("Termina thread: "+getName());
    }
    
}