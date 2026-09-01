package tp3.ejercicio4;

public class Main {
    public static void main(String[] args) {
        
        CajaHerramienta cajita = new CajaHerramienta();

        Albanil a1 = new Albanil("pepe", cajita);
        Albanil a2 = new Albanil("cacho", cajita);
        Gasista g1 = new Gasista("rodo", cajita);
        Electricista e1 = new Electricista("capo", cajita);
        
        Thread h1 = new Thread(a1, "pepe");
        Thread h2 = new Thread(a2, "cacho");
        Thread h3 = new Thread(g1, "rodo");
        Thread h4 = new Thread(e1, "capo");

        h1.start(); h2.start(); h3.start(); h4.start();
        
    }
}
