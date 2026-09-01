package tp3.ejercicio4;

import java.util.concurrent.ThreadLocalRandom;

public class Electricista implements Runnable {
    private String nombre;
    private CajaHerramienta caja;

    public Electricista(String name, CajaHerramienta tools) {
        this.nombre = name;
        this.caja = tools;
    }
    
    @Override
    public void run() {
        try {
            // misma idea ejercicio 3
            // randomizo 1)buscapolos o 2)cinta

            for (int i = 0; i < 4; i++) {
                int rand = ThreadLocalRandom.current().nextInt(1,4);
                switch (rand) {
                    case 1:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando Buscapolos...");
                        caja.usarBuscapolos();
                        Thread.sleep(250);
                        // thread.sleep called in loop lo saco olo dejo!???
                    break;
                    
                    case 2:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando cinta...");
                        caja.usarCinta();
                        Thread.sleep(250);
                        // thread.sleep called in loop lo saco olo dejo!???
                        // si lo saco me salta error en el catch...
                    break;
                    default:
                        //throw new AssertionError();
                }
            }//fix assertionerrros
        } catch (InterruptedException e) {
            System.getLogger(Albanil.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
    
}
