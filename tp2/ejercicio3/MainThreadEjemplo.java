package tp2.ejercicio3;
public class MainThreadEjemplo {
    public static void main(String[] args) {
        
        new ThreadEjemplo("MariaJose").start();
        new ThreadEjemplo("JoseMaria").start();
        
        System.out.println("Termina thread main");
    }
}
