package tp3.ejercicio7;

public class Auto implements Runnable{
    private String patente;
    private String modelo;
    private String marca;
    private int kilometraje;

    public Auto(String patente, String modelo, String marca, int kilometraje) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.kilometraje = kilometraje;
    }

    @Override
    public void run() {
        
    }
    
}
