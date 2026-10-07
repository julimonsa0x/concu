package parciales.ejercicio2;

public class Main {
    public static void main(String[] args) {
        
        final int CANTIDAD_ALUMNOS = 10;
        Pizarra pizarra = new Pizarra();
        Alumno[] alumnos = new Alumno[CANTIDAD_ALUMNOS];
        
        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            alumnos[i] = new Alumno("Alumno nro:" + (i + 1), pizarra);
            new Thread(alumnos[i]).start();
        }
        
    }
}
