package tp4.ejercicio3;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos de semaforos con sus permisos iniciales
        // Solo el Semáforo 1 arranca en uno, los demás arrancan en cero (bloqueados)
        Semaphore sem1 = new Semaphore(1); 
        Semaphore sem2 = new Semaphore(0); 
        Semaphore sem3 = new Semaphore(0); 

        // 2. Creamos las tareas pasando: (Nombre, MiSemáforo, SemáforoDesbloquear)
        // Ojo al orden de desbloqueo: P1 desbloquea a P3, P3 a P2, P2 a P1
        Proceso p1 = new Proceso("P1", sem1, sem3);
        Proceso p3 = new Proceso("P3", sem3, sem2);
        Proceso p2 = new Proceso("P2", sem2, sem1);

        // 3. Envolvemos en Hilos y disparamos
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        Thread t3 = new Thread(p3);

        t1.start();
        t2.start();
        t3.start();
    }
}