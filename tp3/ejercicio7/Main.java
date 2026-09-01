package tp3.ejercicio7;

public class Main {
    public static void main(String[] args) {

        Surtidor ypf = new Surtidor(9999);
        Auto a1 = new Auto("ABC123", "Modelo1", "Marca1", 10000);
        Auto a2 = new Auto("DEF456", "Modelo2", "Marca2", 20000);
        Auto a3 = new Auto("GHI789", "Modelo3", "Marca3", 30000);
        Auto a4 = new Auto("JKL012", "Modelo4", "Marca4", 40000);

        Thread t1 = new Thread(a1, "Auto 1");
        Thread t2 = new Thread(a2, "Auto 2");
        Thread t3 = new Thread(a3, "Auto 3");
        Thread t4 = new Thread(a4, "Auto 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }
    
}
