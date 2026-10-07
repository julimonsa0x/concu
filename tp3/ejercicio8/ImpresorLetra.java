package tp3.ejercicio8;

public class ImpresorLetra implements Runnable {
    private Turno turno;
    private char letra;
    private int cantidad;
    private char proximaLetra; // A quién le paso la pelota

    // Respondiendo a tu duda: la cantidad "n" y el orden llegan por acá
    public ImpresorLetra(Turno turno, char letra, int cant, char proximaLetra) {
        this.turno = turno;
        this.letra = letra;
        this.cantidad = cant;
        this.proximaLetra = proximaLetra;
    }

    @Override
    public void run() {
        // Bucle infinito para que la secuencia ABBCCC se repita por siempre
        while (true) {
            // El hilo solo le pide al recurso que imprima, el recurso se encarga de frenarlo si no es su turno
            turno.imprimir(this.letra, this.cantidad, this.proximaLetra);

            try {
                Thread.sleep(250); // Una pausa visual para que no te inunde la consola
                //System.out.print(" | ");
            } catch (Exception e) {}
        }
    }
}