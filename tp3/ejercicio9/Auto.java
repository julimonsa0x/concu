package tp3.ejercicio9;
import java.util.concurrent.ThreadLocalRandom;

public class Auto implements Runnable {
    private String patente;
    private String modelo;
    private String marca;
    private int kilometraje;
    private int capacidadTanque; // Para saber cuánto cargar
    private Surtidor surtidor; 

    private int tanqueActual;
    private int limiteReserva; // Agregamos el límite de reserva

    public Auto(String patente, String modelo, String marca, int kilometraje, int capacidadTanque, Surtidor s) {
        this.modelo = modelo;
        this.marca = marca;
        this.patente = patente;
        this.kilometraje = kilometraje;   
        this.capacidadTanque = capacidadTanque;
        this.tanqueActual = capacidadTanque; // Sale con tanque lleno
        this.limiteReserva = capacidadTanque / 4; // Reserva es el 25% del tanque
        this.surtidor = s;
    }

    public void pasear() {
        // Consumo aleatorio para desincronizar los hilos de forma natural
        int kmRecorridos = ThreadLocalRandom.current().nextInt(10, 21); 
        
        // en caso q el tanque baje de 0 en un solo viaje...
        if (tanqueActual - kmRecorridos < 0) {
            kmRecorridos = tanqueActual;
        }

        this.kilometraje += kmRecorridos;
        this.tanqueActual -= kmRecorridos; // simplificacion 1KM = 1L
        
        System.out.println(" [!] Auto-" + patente + " recorrió " + kmRecorridos + "km. Tanque: " + tanqueActual + "L");
        
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500)); 
        } catch (InterruptedException e) { }
    }
    
    public void irACargar() {
        System.out.println(" [!] Auto-" + patente + " en RESERVA. Buscando surtidor...");
        int litrosFaltantes = capacidadTanque - tanqueActual; 
        
        // Se intenta cargar. Si el Surtidor.surtir() devuelve true, todo OK...
        if (this.surtidor.surtir(litrosFaltantes)) {
            tanqueActual += litrosFaltantes;
            System.out.println("[:D] Auto-" + patente + " llenó el tanque. Listo para seguir.");
        } else {
            // forzamos salida loop y muere el hilo (status = stopped)...
            tanqueActual = 0;
        }
    }
    
    @Override
    public void run() {
        while (tanqueActual > 0) {
            
            if (tanqueActual > limiteReserva) {
                pasear();
            } else {
                irACargar();
            }
        }
        System.out.println(" [!] Auto-" + patente + " finalizo su viaje (no consiguio/se quedo sin nafta).");
    }
}