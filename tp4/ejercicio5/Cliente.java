package tp4.ejercicio5;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresion impre;
    private char tipoImpresora; // 'A', 'B' o 'X'

    public Cliente(String nombre, GestorImpresion impreCompartida, char tipoImpresora) {
        this.nombre = nombre;
        this.impre = impreCompartida;
        this.tipoImpresora = tipoImpresora;
    }

    @Override
    public void run() {
        System.out.println("[User] " + nombre + " llega al centro de copiado.");
        
        // El gestor se encarga de frenarlo o dejarlo pasar
        switch (tipoImpresora) {
            case 'A':
                impre.usarImpresoraA(nombre);
                break;
            case 'B':
                impre.usarImpresoraB(nombre);
                break;
            case 'X':
                impre.usarImpresoraAB(nombre);
                break;
        }
    }
}