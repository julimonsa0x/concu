package tp4.ejercicio6;

public class Taxista implements Runnable{
    
    private String nombre;
    private Taxi taxiRecurso;

    public Taxista(String nombre, Taxi taxiRecurso) {
        this.nombre = nombre;
        this.taxiRecurso = taxiRecurso;
    }

    public void run() {

        // segun me explico gemini...:
        // el hilo taxista corre 24/7 nonstop 
        while(true){
            // 1ro: con .conducir() hace su tarea 
            taxiRecurso.conducir();

            // 2do descansa un toque antes de volver a conducir

            // !!! correcion gemini: el taxista no descansa, el taxista duerme 
            // hasta que un pasajero sube al taxi, y eso ya lo hace el 
            // semWakeDriver.acquire() dentro del metodo conducir()...

            // entonces no hace falta que el taxista haga un sleep() para descansar,
            // tampoco hara falta el try/catch...
            
            /*try {
                Thread.sleep(3000); // Simulamos el tiempo de descanso
                System.out.println("[!]  " + nombre + " está descansando... [3segs.]"+ UtilsConcu.obtenerTimestamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
    
}
