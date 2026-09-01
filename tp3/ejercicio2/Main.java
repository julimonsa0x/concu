package tp3.ejercicio2;

public class Main {
    public static void main(String[] args) {
        Energia pwr = new Energia(10);

        Oscura hiloResta = new Oscura(pwr);
        Sanador hiloSuma = new Sanador(pwr);

        Thread restador = new Thread(hiloResta, "restador");
        Thread sumador = new Thread(hiloSuma, "sumador");
        
        restador.start();
        sumador.start();
    }
}
