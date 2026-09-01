package tp3.ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class Hamster extends Thread {
    String name;
    Jaula jaula;
    
    public Hamster(String nombre, Jaula j) {
        this.name = nombre;
        this.jaula = j;
    }
    
    @Override
    public void run() {
        try {
            // randomizo 1.rueda, 2) plato o 3)hamaca
            // para no hacerlo secuencial 

            // aunque no es 100% util considerando que 
            // no podemos ver si ganamos o no el lock (yet...)

            // con semafotos tendrias mas sentiod
            for (int i = 0; i < 4; i++) {
                int rand = ThreadLocalRandom.current().nextInt(1,4);
                switch (rand) {
                    case 1:
                        System.out.println(Thread.currentThread().getName()+
                            "tries to wheel");
                        jaula.usarRueda();
                        Thread.sleep(250);
                    break;
                    
                    case 2:
                        System.out.println(Thread.currentThread().getName()+
                            "tries to wheel");
                        jaula.usarPlato();
                        Thread.sleep(250);
                    break;
                    
                    case 3:
                        System.out.println(Thread.currentThread().getName()+
                            "tries to wheel");
                        jaula.usarHamaca();
                        Thread.sleep(250);
                    break;
                    default:
                        throw new AssertionError();
                }
            }
        } catch (InterruptedException e) {
            System.getLogger(Hamster.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
}
