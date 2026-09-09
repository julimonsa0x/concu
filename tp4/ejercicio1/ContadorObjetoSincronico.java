package tp4.ejercicio1;

public class ContadorObjetoSincronico {
    private int valor = 0;

    // agrego un obj para el lock
    private final Object lock = new Object();
    
    public void incrementar() {
        // synchronized ((Integer) valor) {
        // se saca la de arriba y usamos el lock nuevo de abajo
        
        synchronized(lock) {
            valor++;
        }
    }

    public void decrementar() {
        // synchronized (this) {
        // lo mismo aca...
        
        synchronized (lock) {
            valor--;
        }
    }

    //public synchronized int getValor() {
    // y aca directamente 
    public int getValor() {
        synchronized (lock) {
            return valor;
        }
    }

    /*
    pd:  usar un synchronized( (Integer) n ) falla por inmutabilidad de Integer
    recordar que los primitivos como int no tienen lock, por lo que se usa Integer,
    pero de igual manera, a ese valor casteado Java no lo muta, sino que 
    lo desecha, crea uno nuevo y lo incrementa....

    pd2: si lockeabamos valor en el incrementar() y this en el .decrermentar()
    sucede que entramos a lo que sea que haga el 1er metodo con lock en int
    y luego entramos al 2do con lock en this, ninguno se entera del otro enonces
    los hilos haran modificaciones (en este caso simple) pero potencialmente peligrosas
    estaremos dentro de seccion critica con 2 hilos !!!
     */
}
