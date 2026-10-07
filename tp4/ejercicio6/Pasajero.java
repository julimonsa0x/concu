package tp4.ejercicio6;

public class Pasajero implements Runnable {
    private String nombre;
    private Taxi taxiRecurso;

    public Pasajero(String nombre, Taxi taxiRecurso) {
        this.nombre = nombre;
        this.taxiRecurso = taxiRecurso;
    }

    public void run() {
/*        while(true){
            // 1ro con .subir() hace su tarea 
            taxiRecurso.tomarTaxi();

            // 2do espera un toque antes de volver a subir
            // le puse 10 segundos para simular busqeuda de otro pasajero...
            // aunque capaz  mejor randomizarlo entre 5 y 10 segundos para que no se vea tan mecanico...
            int espera = 5000 + (int)(Math.random() * 5000); // entre 5 y 10 segundos
            try {
                Thread.sleep(espera); // Simulamos el tiempo de espera
                System.out.println("[!]  " + nombre + " está esperando... [3segs.]"+ UtilsConcu.obtenerTimestamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/


            
        // segun me epxlico gemini...:
        // el pasajero solo toma el taxi, llega destino y muere el hilo...
        // a modo de prueba nosotros hacemos que el main lance varios pasajeros
        // y el taxista los atienda de a uno...  
        taxiRecurso.tomarTaxi();
       
    }
}
