package tp4.ejercicio4;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresion impre;

    public Cliente(String nombre, GestorImpresion impreCompartida) {
        this.nombre = nombre;
        this.impre = impreCompartida;
    }

    @Override
    public void run() {
        System.out.println("[User] " + nombre + " llega al centro de copiado.");
        
        // El gestor se encarga de frenarlo o dejarlo pasar
        impre.usarImpresora(nombre); 
    }
}