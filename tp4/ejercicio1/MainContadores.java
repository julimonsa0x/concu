package tp4.ejercicio1;

public class MainContadores {
    public static void main(String[] args) {
        
        // 1. ARMAMOS EL ESCENARIO (Una única instancia en la memoria)
        ContadorObjetoSincronico elUnicoContador = new ContadorObjetoSincronico();

        // 2. CREAMOS LOS ACTORES (Le pasamos EL MISMO contador a ambas tareas)
        Runnable tarea1 = new TareaSumadora(elUnicoContador);
        Runnable tarea2 = new TareaSumadora(elUnicoContador);

        // 3. LOS ENVOLVEMOS EN HILOS
        Thread hilo1 = new Thread(tarea1);
        Thread hilo2 = new Thread(tarea2);

        // 4. ¡ACCIÓN!
        hilo1.start();
        hilo2.start();

        // 5. EL ÁRBITRO (Esperamos a que terminen la obra)
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {}

        // 6. RESULTADO FINAL
        System.out.println("Valor final del contador: " + elUnicoContador.getValor());
    }
}