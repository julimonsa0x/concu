package tp3.ejercicio9;

public class Camion implements Runnable {

    private Surtidor surtidor;
    
    public Camion(Surtidor aRecargar) {
        this.surtidor = aRecargar;
    }
    
    public void run()  {
        while (true) {
            
            // sin .sleep() por el momento
            
            while (true) {
                System.out.println(" [!] Camion recargando el surtidor de ypf...");
                this.surtidor.recargar();
            }
        }
    }
    
}
