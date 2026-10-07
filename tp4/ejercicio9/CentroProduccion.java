package tp4.ejercicio9;

import java.util.concurrent.Semaphore;

import utils.Colors;

public class CentroProduccion {
    // atributos de Capacidad
    private Semaphore semCintaElectrica;// = new Semaphore(5);
    private Semaphore semCintaMecanica;// = new Semaphore(5);
    private Semaphore semCruce;// = new Semaphore(1);

    private int maxElec;
    private int maxMec;

    // atributos de la interseccion 
    private volatile boolean luzElectricaVerde = true;
    private String nombre = "none";

    /**
     * default semCintaElectrica permits 5
     * default semCintaMecanica permits 5
     * default semCruce permits 1
     */
    public CentroProduccion(int maxElec, int maxMec, int permitsCruce) {
        this.maxElec = maxElec;
        this.maxMec = maxMec;
        this.semCintaElectrica = new Semaphore(maxElec);
        this.semCintaMecanica = new Semaphore(maxMec);
        this.semCruce = new Semaphore(permitsCruce);
        
    }


    public void llegaElectrico() {
        try {
            
            semCintaElectrica.acquire();
            int cantEnCinta = maxElec - semCintaElectrica.availablePermits();
            System.out.println(Colors.BLUE +"Llega un producto electrico, hay " + cantEnCinta + " en la cinta electrica");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void llegaMecanico() {
        try {
            semCintaMecanica.acquire();
            int cantEnCinta = maxMec - semCintaMecanica.availablePermits();
            System.out.println(Colors.YELLOW +"Llega un producto mecanico, hay " + cantEnCinta + " en la cinta mecanica");
            // el tiempo de ensamblaje va en el run() del thread !!!
        } catch (InterruptedException e) {}
    }

    /**
     * GESTIÓN DE SALIDA: PRODUCTO ELÉCTRICO
     * 
     * [1ro] -> ESPERA:   luzElectricaVerde == true (Polling)
     * [2do] -> TOMA:     semCruce (Exclusión mutua de la intersección)
     * [3ro] <- DEVUELVE: semCruce (Libera la intersección para el próximo)
     * [4to] <- DEVUELVE: semCintaElectrica (Libera su lugar en la fábrica)
     */
    public void saleElectrico() {
        try {
            // 1: polling
            // espera a que la luz este verde para los electricos
            while( !luzElectricaVerde ) { Thread.sleep(100); }
            
            // si sale del polling, entonces while ha terminado
            // xq luzElectricaVerde == true, seguimos...

            // 2: mutex (la interseccion)
            semCruce.acquire(); // toma el control de la salida
            System.out.println(Colors.BLUE +"Sale un producto electrico");
            semCruce.release(); // libera el control de la salida

            // 3: libera el espacio en la cinta
            semCintaElectrica.release();
            int cantEnCinta = maxElec - semCintaElectrica.availablePermits();
            System.out.println(Colors.BLUE +"...y quedan " + cantEnCinta + " en la cinta electrica");
        } catch (InterruptedException e) {}
    }

    public void saleMecanico() {
        try {
            // 1: polling
            // espera a que la luz este roja para los mecanicos
            while( luzElectricaVerde ) { Thread.sleep(100); }

            semCruce.acquire(); // toma el control de la salida
            System.out.println(Colors.YELLOW +"Entra un producto mecanico...");
            semCruce.release(); // libera el control de la salida

            semCintaMecanica.release();
            int cantEnCinta = maxMec - semCintaMecanica.availablePermits();
            System.out.println(Colors.YELLOW +"...y quedan " + cantEnCinta + " en la cinta mecanica");

        } catch (InterruptedException e) {}
    }
    
    public void cambiaLineas() {
        luzElectricaVerde = !luzElectricaVerde;
        if(luzElectricaVerde) {
            System.out.println("Luz verde para electricos!"); // luz roja para mecanicos
        } else {
            System.out.println("Luz verde para mecanicos!"); // luz roja para electricos
        }
    }

}
