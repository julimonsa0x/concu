package tp4.ejercicio4;

public class Main {
    public static void main(String[] args) {
        // Creamos el centro de copiado con SOLO 2 impresoras
        GestorImpresion gestor = new GestorImpresion(2);

        // Creamos 5 clientes compitiendo por 2 impresoras
        for (int i = 1; i <= 5; i++) {
            Cliente c = new Cliente("Cliente-" + i, gestor);
            Thread hilo = new Thread(c);
            hilo.start();
        }
    }
}