package tp2.ejercicio4;

public class MainRunnableEjemplo {
    public static void main(String[] args) {

        
        //new ThreadEjemplo2("MariaJose").start();
        //new ThreadEjemplo2("JoseMaria").start();
        
        RunnableEjemplo hiloToRunnable = new RunnableEjemplo("runnable!");
        RunnableEjemplo hiloToRunnable2 = new RunnableEjemplo("runnable!");

        Thread ejemplo1 = new Thread(hiloToRunnable, "MariaJose");
        Thread ejemplo2 = new Thread(hiloToRunnable2, "JoseMaria");

        ejemplo1.start();
        ejemplo2.start();


        System.out.println("Termina thread main");
    }
}
