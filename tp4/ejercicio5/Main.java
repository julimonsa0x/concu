package tp4.ejercicio5;

public class Main {
    public static void main(String[] args) {
        // punto 4 old...Creamos el centro de copiado con SOLO 2 impresoras

        // para punto 5)
        // Creamos el centro de copiado con 2 parametros cantA y cantB
        GestorImpresion gestor = new GestorImpresion(1,2);

        // Creamos 5 clientes compitiendo por 2 impresoras
        for (int i = 1; i <= 10; i++) {
            
            // random char A, B or X for cliente
            char tipoImpresora;
            int rand = (int) (Math.random() * 3);
            if (rand == 0) {
                tipoImpresora = 'A';
            } else if (rand == 1) {
                tipoImpresora = 'B';
            } else {
                tipoImpresora = 'X';
            }

            Cliente c = new Cliente("Cliente-" + i, gestor, tipoImpresora);
            Thread hilo = new Thread(c);
            hilo.start();
        }
    }
}