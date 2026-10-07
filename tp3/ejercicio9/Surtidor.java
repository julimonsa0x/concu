package tp3.ejercicio9;

public class Surtidor {
    private int cantMax;        // gas total de la ypf
    private int cantActual;     // gas actual de la ypf
    private int umbral = 20;    // umbral hardcodeado pero podria ser un 5% o 10% del cantMax

    private boolean recargando = false; // atrb nuevo, para el camion..!

    public Surtidor(int capacidad) {
        this.cantMax = capacidad;
        this.cantActual = capacidad;
    }

    // ========
    // .surtir() lo necesita el runnable Auto.java
    // ========
    public synchronized boolean surtir(int cantCarga) {
        boolean res = false;
        try {

            // [Caso A]: puedo cargar?
            while(recargando) {
                // si el camion seteó recargando a true, los auto se duermen y esperan...
                // al hacer wait(), el auto suelta la llave para dar paso al camion
                wait();
            }
            
            // y de aca para abajo se ejecuta si tomamos el lock, osea que
            // el camion lo ha soltado y salimos del while previo...
            Thread.sleep(3000); // supongamos tarda 3 seg en cargar nafta
            if (cantCarga <= cantActual) {
                cantActual -= cantCarga;
                res = true;

                // [Caso B]: le damos el visto bueno al camion al momento de tener 
                // poco combustible en la estacion...
                if (cantActual < umbral) {
                    System.out.println(" [!] Surtidor: Queda poca nafta en la estacion: " + (int)((double)cantActual / cantMax * 100) + "%.");
                    notifyAll();
                }
                System.out.println("[:D] Surtidor: Suministrando " + cantCarga + " litros. | Estacion: " + (int)((double)cantActual / cantMax * 100) + "%.");
            } else {
                System.out.println(" [!] Surtidor: No hay suficiente combustible en la estacion: " + (int)((double)cantActual / cantMax * 100) + "%.");
            }
        } catch (InterruptedException e) {}
        return res;
    }

    // ===========
    // .recargar() lo necesita el runnable Camion.java
    // ===========
    public synchronized void recargar() {
        try {
            
            // [Caso C]: 
            // El camión siempre va a evaluar esto usando un while, igual que 
            // el ejemplo teórico del buffer[cite: 12].
            // Si la nafta es MAYOR a umbral=20 (todo ok), el camión se va a dormir.
            while (cantActual >= umbral) {
                wait();
            }

            // [Caso D]: LA RECARGA (El camión fue despertado por un auto)
            // Si el código llegó hasta acá, es porque cantActual < 20 y un auto 
            // nos despertó con un notifyAll().
            recargando = true;
            System.out.println(" [...] Camion bloquea la estacion para re-filling...");
            Thread.sleep(5000);     // le simulamos demora de 5 segundos...
            cantActual = cantMax;
            System.out.println("[ OK ] Camion termina y se va...");

            // [Caso E]: REABRIR LA ESTACION
            recargando = false;
            notifyAll();
            
        } catch (InterruptedException e) { }
    }
}
