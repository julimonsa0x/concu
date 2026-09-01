package tp3.ejercicio3;

public class Main {
    public static void main(String[] args) {
        
        Jaula jaula = new Jaula();
        Hamster h1 = new Hamster("hamster1", jaula);
        Hamster h2 = new Hamster("hamster2", jaula);
        Hamster h3 = new Hamster("hamster3", jaula);
        
        h1.start();
        h2.start();
        h3.start();
    }
}
