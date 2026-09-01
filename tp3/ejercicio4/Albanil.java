package tp3.ejercicio4;

import java.util.concurrent.ThreadLocalRandom;

import tp3.ejercicio3.Hamster;

public class Albanil implements Runnable {
    private String name;
    private CajaHerramienta caja;

    public Albanil(String name, CajaHerramienta tools) {
        this.name = name;
        this.caja = tools;
    }

    @Override
    public void run() {
        try {
            // misma idea ejercicio 3
            // randomizo 1)cuchara, 2)nivel o 3)cinta

            for (int i = 0; i < 4; i++) {
                int rand = ThreadLocalRandom.current().nextInt(1,4);
                switch (rand) {
                    case 1:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando cuchara...");
                        caja.usarCuchara();
                        Thread.sleep(250);
                        // thread.sleep called in loop lo saco olo dejo!???
                    break;
                    
                    case 2:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando nivel...");
                        caja.usarNivel();
                        Thread.sleep(250);
                        // thread.sleep called in loop lo saco olo dejo!???
                    break;
                    
                    case 3:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando cinta...");
                        caja.usarCinta();
                        Thread.sleep(250);
                        // thread.sleep called in loop lo saco olo dejo!???
                        // si lo saco me salta error en el catch...
                    break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (InterruptedException e) {
            System.getLogger(Albanil.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
    
}
