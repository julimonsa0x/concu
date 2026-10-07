package tp3.ejercicio8;

public class Turno {
    private char turnoActual;

    public Turno(char turnoInicial) {
        this.turnoActual = turnoInicial;
    }

    // El método está sincronizado. ¡El candado está en el objeto Turno!
    public synchronized void imprimir(char miLetra, int cantVeces, char proximaLetra) {
        
        // 1. ESPERA GUARDADA (Condición)
        // Se usa while, no if, porque al despertar hay que re-verificar la condición[cite: 8, 18]
        while (this.turnoActual != miLetra) {
            try {
                this.wait(); // Me duermo y suelto la llave[cite: 5]
            } catch (InterruptedException e) {}
        }

        // 2. ACCIÓN (Si llegué acá, es mi turno)
        for (int i = 0; i < cantVeces; i++) {
            System.out.print(miLetra);
        }

        //System.out.print(" | "); esto no funca 
        if (miLetra == 'C') {
            System.out.print(" | ");
        }
        
        // 3. PASO DEL MANDO
        this.turnoActual = proximaLetra;

        // 4. NOTIFICACIÓN
        // Despierto a todos los hilos que están dormidos esperando por este monitor[cite: 16]
        this.notifyAll(); 
    }
}