package tp4.ejercicio1;

public class ContadorSincronico {
    private int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public void decrementar() {
        valor--;
    }
    
    public synchronized int getValor() {
        return valor;
    }
}
