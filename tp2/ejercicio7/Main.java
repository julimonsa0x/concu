package tp2.ejercicio7;

public class Main {
    
    public static void main(String[]args){

        CompraCliente compra1 = new CompraCliente("CompraCliente1",
            new int[] {2,2,1,5,2,3}
        );
        CompraCliente compra2 = new CompraCliente("CompraCliente2",
            new int[] {1,3,5,1,1}
        );
        Cajero cajero1 = new Cajero("Cajero1");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        cajero1.procesarCompra(compra1, initialTime);
        cajero1.procesarCompra(compra2, initialTime);
    }
    
}
