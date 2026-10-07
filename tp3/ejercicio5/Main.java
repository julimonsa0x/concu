package tp3.ejercicio5;

public class Main {
    public static void main(String[] args) {
        int k = 10; // Cantidad de hilos
        int tamanioPorcion = 50000 / k; // Cada hilo procesa 5000
        
        RecursoSuma recurso = new RecursoSuma();

        for (int i = 0; i < k; i++) {
            int inicio = i * tamanioPorcion;
            int fin = inicio + tamanioPorcion;
            
            HiloSumador tarea = new HiloSumador(recurso, inicio, fin);
            new Thread(tarea).start();
        }

        // El reemplazo del .join() -> El Main se queda esperando aquí
        while(recurso.getHilosTerminados() < k) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }

        // Si salimos del while, ¡es porque los 10 hilos sumaron!
        System.out.println("La suma total es: " + recurso.getSumaFinal());

        
        // test chequeo secuencial
        int resultadoConcurrente = recurso.getSumaFinal();
        int resultadoEsperado = recurso.getSumaSecuencialDeControl();

        System.out.println("Suma calculada por los hilos: " + resultadoConcurrente);
        System.out.println("Suma real (secuencial): " + resultadoEsperado);

        if (resultadoConcurrente == resultadoEsperado) {
            System.out.println("¡ÉXITO! La concurrencia no perdió ni un solo número.");
        } else {
            System.out.println("¡ALERTA! Hay una condición de carrera, se perdieron datos.");
        }
    }
}
