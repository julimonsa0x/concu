package tp2.apunte;

public class HiloAlfaBeta extends Thread {
    int cantidad;

    public HiloAlfaBeta(String nombre, int laCantidad){
        // super(nombre) llama al constructor de la clase Thread, que recibe un String con el nombre del hilo.
        super(nombre);
        this.cantidad = laCantidad;
    }
    public void run(){
        for (int i=1; i<this.cantidad; i++){
            System.out.println(this.getName() + " en ejecución");
            System.out.println(Thread.currentThread() + " ----- " +
                Thread.currentThread().getName()
            );
        }
    }
}