package tp4.ejercicio8;

public class Empleado implements Runnable {

    private String nombre;
    private Confiteria confiteria;

    public Empleado(Confiteria confiteria, String nombre) {
        this.confiteria = confiteria;
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                
                // 1 ocupa un asiento y llama al mozo
                // [!] simula tiempo de llegada del cliente
                // [!] segun gemini para evitar que los 
                // [!] k empleados entren todos en el milisegundo 0
                Thread.sleep( (long) (Math.random() * 3000) );
                confiteria.ocuparAsientoYLlamarMozo();
        
                // 2 espera a que el mozo le entregue la comida
                confiteria.esperarComida();
        
                Thread.sleep(3000); // e.g: come la milanesa
                
                // 3 agradece y se despide
                confiteria.agradecerYDespedirse();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
