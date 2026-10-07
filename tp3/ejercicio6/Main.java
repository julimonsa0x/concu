package tp3.ejercicio6;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {

        Area montañaRusa = new Area("Montaña Rusa", 2);
        Area calesita = new Area("Calesita", 4);
        Area autitos = new Area("Autitos Chocadores", 3);
        Area laberinto = new Area("Laberinto", 2);
        Area pool = new Area("pool", 2);


        // Lanzamos n visitantes queriendo ir a lugares potencialmente iguales
        for (int i = 1; i <= 8; i++) {
            Usuario u = new Usuario("User-" + i);
            
            int randomArea = ThreadLocalRandom.current().nextInt(1, 6);
            switch (randomArea) {
                case 1:     u.setArea(montañaRusa);     break;
                case 2:     u.setArea(calesita);        break;
                case 3:     u.setArea(autitos);         break;
                case 4:     u.setArea(laberinto);       break;
                case 5:     u.setArea(pool);            break;
                default:    throw new AssertionError();
            }

            Thread h = new Thread(u, "User-nro.:" + i);
            h.start();
        }
    }
}
