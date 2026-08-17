package tp2.ejercicio4;
import utils.UtilsConcu;


// Al convertir la clase en Runnable, dejara de ser un "hilo" y sera una "tarea"
// debremos agregarle un atributo nombre, un constructor, y cambiar getName()
// por el currentThread.getname() de clase, porque antes los heredaba de Thread...

//public class ThreadEjemplo2 extends Thread {
public class RunnableEjemplo implements Runnable {

    private String nombre;
    
    public RunnableEjemplo(String str) {
        //super(str);
        this.nombre = str;
    }

    public void run() {
        for(int i=0; i<6; i++) {
            System.out.println(i+" " +
                Thread.currentThread().getName() +
                UtilsConcu.obtenerTimestamp()
            );
        }
        System.out.println("Termina Runnable: "+Thread.currentThread().getName());
    }
}