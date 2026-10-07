package tp4.ejercicio8;

public class Mozo implements Runnable {

    private String nombre;
    private Confiteria confiteria;

    public Mozo(Confiteria confiteria, String nombre) {
        this.confiteria = confiteria;
        this.nombre = nombre;
    }
    
    public void run() { 
        while(true) {
            try{
                // 1ro: espera a que el cliente avise que quiere pedir
                confiteria.esperarEmpleado();
        
                Thread.sleep(3000); // e.g: frie la comida
                
                // 2do: avisa al cliente que la comida esta lista
                confiteria.entregarComida();
                
                // 3ro: esperar a que el cliente se despida y liberar el asiento
                confiteria.esperarDespedida();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
