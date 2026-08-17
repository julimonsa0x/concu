package tp2.ejercicio6;

public class Carrera {
    
    public static void main(String[] args) {
        
        System.out.println("inicia main");
        
        Corredor[] corredores = new Corredor[100]; 
        Thread[] hilos = new Thread[100];
        
        for (int i=0; i<10; i++) {
            
            Corredor c = new Corredor("Corredor nro: "+ (i+1));
            Thread h = new Thread(c);
            
            corredores[i] = c;
            hilos[i] = h;
            
            h.start();
        }

        
        for (int i =0; i <10; i++) {
            try {
                
                // el main espera a que el hilo 'i' terminme sus 100 pasos
                hilos[i].join();
                
            } catch (InterruptedException e) {
                System.out.println("interrumpido en catch");
            }
        }
        
        System.out.println("Fin ejecucion del Main...");
        
        // luego logica para el mayor corredor distRecorrida
        int mayorPos = 0;
        int mayorDist = 0;
        String flash = "?";
        for (int i=0; i<10; i++) {
            if (corredores[i].getDistancia() > corredores[mayorPos].getDistancia()) {
                mayorPos = i;
                mayorDist = corredores[i].getDistancia();
                flash = corredores[i].getNombre();
            }
        }

        System.out.println("corredor con mayor distancia recorrida: "+flash+
            ", con: "+mayorDist+" pasos...");
        
    }
    
}
