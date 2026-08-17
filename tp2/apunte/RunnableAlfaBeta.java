package tp2.apunte;

public class RunnableAlfaBeta implements Runnable {
    int cantidad;

    public RunnableAlfaBeta(int laCantidad){
        this.cantidad = laCantidad;
    }

    public void run(){
        for (int i=1; i<cantidad; i++){
            System.out.println(
                Thread.currentThread().getName() + " en ejecución"
            );
        }
    }
}