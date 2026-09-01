package tp3.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificarCuenta2 extends Thread {
    private CuentaBanco2 cb;

    public VerificarCuenta2(CuentaBanco2 unaCuenta) {
        this.cb = unaCuenta;
    }

    public void run() {
        for(int i=0; i <= 3; i++) {
            try {
                if(!cb.hacerRetiro(10)) {
                    System.out.println("Cuenta esta sobregirada");
                }
            } catch (InterruptedException e) {
                Logger.getLogger(VerificarCuenta2.class.getName()).
                    log(Level.SEVERE, null, e);
            }
        }
    }
    
}
