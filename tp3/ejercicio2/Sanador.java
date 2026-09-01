package tp3.ejercicio2;

public class Sanador implements Runnable {
    private Energia pwr;

    public Sanador(Energia cant) {
        this.pwr = cant;
    }
    
    public void run() {
        for(int i=0; i <= 10; i++) {
            try {
                this.pwr.incrementarEn(5);
                Thread.sleep(500);
                System.out.println();
                //System.out.println("energia: " + pwr.getUnidades()
                //    + "alterada por: Sanador");
            } catch (InterruptedException e) {
                // log??? nothign???    
            }
        }
    }
}
