package tp4.ejercicio1;

public class TareaSumadora implements Runnable {
    // El actor guarda una referencia al escenario
    private ContadorObjetoSincronico miContador;

    // El director (Main) le inyectará el contador al nacer
    public TareaSumadora(ContadorObjetoSincronico contadorCompartido) {
        this.miContador = contadorCompartido;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.miContador.incrementar(); 
        }
    }
}