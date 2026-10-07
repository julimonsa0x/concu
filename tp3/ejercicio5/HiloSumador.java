package tp3.ejercicio5;

public class HiloSumador implements Runnable {
    private RecursoSuma recurso;
    private int inicio;
    private int fin;

    public HiloSumador(RecursoSuma recurso, int inicio, int fin) {
        this.recurso = recurso;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run() {
        int sumaParcial = 0;
        int[] arregloRef = recurso.getArreglo();

        // 1. Sumamos localmente SIN CANDADOS (Máxima velocidad)
        for (int i = inicio; i < fin; i++) {
            sumaParcial += arregloRef[i];
        }

        // 2. Reportamos el resultado final al recurso protegido
        recurso.sumarAlTotal(sumaParcial);
    }
}
