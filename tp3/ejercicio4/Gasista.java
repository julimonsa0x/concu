package tp3.ejercicio4;

import java.util.concurrent.ThreadLocalRandom;

public class Gasista implements Runnable {
    private String nombre;
    private CajaHerramienta caja;

    public Gasista(String name, CajaHerramienta tools){
        this.nombre = name;
        this.caja = tools;
    }

    @Override
    public void run() {
        try {
            // misma idea ejercicio 3
            // randomizo 1)llave o 2)nivel

            for (int i = 0; i < 4; i++) {
                int rand = ThreadLocalRandom.current().nextInt(1,4);
                switch (rand) {
                    case 1:
                        System.out.println(Thread.currentThread().getName()+
                            ": usando Llave...");
                        caja.usarLlave();
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
                    default:
                        throw new AssertionError();
                }
            }
        } catch (InterruptedException e) {
            System.getLogger(Albanil.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
    
}