package tp3.ejercicio8;

public class Main {
    public static void main(String[] args) {
        // El recurso compartido nace con el turno 'A'
        Turno turnoCompartido = new Turno('A');

        // el parametro cant en cada ImpresorLetra puede variar pero por default 
        // es A 1, B 2 y C 3 veces... lo altero para testing purposes...
        
        // Hilo A: Imprime 'A', 1 vez, y le cede el turno a 'B'
        ImpresorLetra impA = new ImpresorLetra(turnoCompartido, 'A', 1, 'B');
        
        // Hilo B: Imprime 'B', 2 veces, y le cede el turno a 'C'
        ImpresorLetra impB = new ImpresorLetra(turnoCompartido, 'B', 2, 'C');
        
        // Hilo C: Imprime 'C', 3 veces, y le cede el turno de vuelta a 'A'
        ImpresorLetra impC = new ImpresorLetra(turnoCompartido, 'C', 1, 'A');

        Thread hiloA = new Thread(impA);
        Thread hiloB = new Thread(impB);
        Thread hiloC = new Thread(impC);

        hiloA.start();
        hiloB.start();
        hiloC.start();
    }
}