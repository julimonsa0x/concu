package tp2.ejercicio7;

public class MainRunnable {

    public static void main(String[] args) {
        
        CompraCliente compra1 = new CompraCliente("CompraCliente1",
            new int[] {2, 2, 1, 5, 2, 3}
        );
        CompraCliente compra2 = new CompraCliente("CompraCliente2",
            new int[] {1, 3, 5, 1, 1}
        );
        
        // TODO: Completar main

        long rn = System.currentTimeMillis();
        /* 
        CajeroThread cajero1 = new CajeroThread("pepe1", compra1, rn);
        CajeroThread cajero2 = new CajeroThread("pepe2", compra2, rn);
        cajero1.start();
        cajero2.start();
        */

        CajeroRunnable cajero1 = new CajeroRunnable("pepe1", compra1, rn);
        CajeroRunnable cajero2 = new CajeroRunnable("pepe2", compra2, rn);

        Thread caja1 = new Thread(cajero1, "caja1");
        Thread caja2 = new Thread(cajero2, "caja2");

        caja1.start();
        caja2.start();
        
        System.out.println("fin c/ runnable");

    }

}
