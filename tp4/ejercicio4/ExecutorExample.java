/*import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//
// ejemplo con thread pools, 
//

public class ExecutorExample {
    public void main(String[] args) {
        // 1. Contratamos una plantilla fija de 5 hilos listos para trabajar.
        ExecutorService executorService = Executors.newFixedThreadPool(5);//[cite: 14]
        
        // 2. Tenemos 10 tareas para procesar en nuestro bucle.
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);//[cite: 14]
            
            // 3. ¡La magia! En vez de instanciar un Thread y darle a .start(), 
            // simplemente le pasamos el worker al método .execute().
            executorService.execute(worker);//[cite: 14]
        }
        
        // 4. Le avisamos al gestor que apague los hilos de forma segura 
        // una vez que terminen de vaciar la cola de tareas.
        executorService.shutdown();//[cite: 14]
    }
}*/