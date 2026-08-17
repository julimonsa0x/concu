package tp2.ejercicio7;

public class MainThread {
    public static void main(String[] args) {
        
        CompraCliente compra1 = new CompraCliente("CompraCliente1",
            new int[] {2, 2, 1, 5, 2, 3}
        );
        CompraCliente compra2 = new CompraCliente("CompraCliente2",
            new int[] {1, 3, 5, 1, 1}
        );
        
        // TODO: Completar main

        long rn = System.currentTimeMillis();
        CajeroThread cajero1 = new CajeroThread("pepe1", compra1, rn);
        CajeroThread cajero2 = new CajeroThread("pepe2", compra2, rn);

        cajero1.start();
        cajero2.start();
        

    }
}
