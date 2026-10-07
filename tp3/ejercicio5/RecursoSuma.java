package tp3.ejercicio5;

import java.util.concurrent.ThreadLocalRandom;

public class RecursoSuma {
    private int[] arr = new int[50000];
    private int sumaFinal = 0;
    private int hilosTerminados = 0; // ok??

    private int sumaSecuencialDeControl = 0;

    public RecursoSuma() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(1, 11); // rango [1, 11)
            //arr[i] = i + 1;

            // test chequeo secuencial
            this.sumaSecuencialDeControl += arr[i];
        }        
    }

    public void sumar(int inicio, int fin) {
        // ghub copilot generated code ok???
        int sumaParcial = 0;
        for (int i = inicio; i < fin; i++) {
            sumaParcial += arr[i];
        }
        synchronized (this) {
            sumaFinal += sumaParcial;
        }
    }

    public synchronized void sumarAlTotal(int sumaParcial) {
        this.sumaFinal += sumaParcial;
        this.hilosTerminados++;  // le pedi a gemini evitar .join() y me dio este approach... ok?
    }

    public int getSumaFinal()       { return sumaFinal; }
    public int getHilosTerminados() { return hilosTerminados; }
    public int[] getArreglo()       { return arr; }
    public int getSumaSecuencialDeControl() { return sumaSecuencialDeControl; }


    // public void run() {} sin .run() xq lo hace la otra clase 
    // contin8uar last prompt 
}
