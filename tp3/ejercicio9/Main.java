package tp3.ejercicio9;

public class Main {
    public static void main(String[] args) {

        Surtidor ypf = new Surtidor(99);

        Auto a1 = new Auto("ABC123", "Modelo1", "Marca1", 10000, 50, ypf);
        Auto a2 = new Auto("DEF456", "Modelo2", "Marca2", 20000, 40,ypf);
        Auto a3 = new Auto("GHI789", "Modelo3", "Marca3", 30000, 45,ypf);
        Auto a4 = new Auto("JKL012", "Modelo4", "Marca4", 40000, 60,ypf);

        Camion c = new Camion(ypf);
        
        Thread t1 = new Thread(a1, "Auto 1");
        Thread t2 = new Thread(a2, "Auto 2");
        Thread t3 = new Thread(a3, "Auto 3");
        Thread t4 = new Thread(a4, "Auto 4");
        Thread t5  = new Thread(c, "camion");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
    
}
