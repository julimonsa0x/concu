package tp3.ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificarCuenta extends Thread{
    private CuentaBanco cb;

    public VerificarCuenta(CuentaBanco unaCuenta) {
        this.cb = unaCuenta;
    }

    private void hacerRetiro(int cantidad) throws InterruptedException {
        if (cb.getBalance() >= cantidad) {
            System.out.println(Thread.currentThread().getName() +
            " esta retirando: " + cantidad);
            
            Thread.sleep(1000);
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() +
            ": Retiro realizado");

            System.out.println(Thread.currentThread().getName() +
            ": Los fondos son de: " + cb.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta" 
                + " para realizar el retiro Sr. " + Thread.currentThread().getName());

            System.out.println("Su saldo actual es de: " + cb.getBalance());
            Thread.sleep(1000);
        }
    }

    public void run() {
        for(int i = 0; i <= 3; i++) {
            try {
                this.hacerRetiro(10);
                if (cb.getBalance() < 0) {
                    System.out.println("Cuenta está sobregirada");
                }
            } catch (InterruptedException e) {
                Logger.getLogger(VerificarCuenta.class.getName()).
                    log(Level.SEVERE, null, e);
            }
        }
    }
    
}
