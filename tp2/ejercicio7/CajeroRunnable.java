package tp2.ejercicio7;

import utils.UtilsConcu;

public class CajeroRunnable implements Runnable{
    private String nombre;
    private CompraCliente compraCliente;
    private long initialTime;

    //TODO:Agregar constructor,y métodos de acceso
    public CajeroRunnable(String name, CompraCliente compra1, long initTime) {
        this.nombre = name;
        this.compraCliente = compra1;
        this.initialTime = initTime;
    }
    
    public void esperarXsegundos(int prodTime) {
        try {
            Thread.sleep(prodTime*1000);
        } catch (InterruptedException e) {
            System.out.println(this.nombre + " Interrumpido");
        }
    }
    
    public void run(){
        System.out.println("El cajero"+this.nombre
            +" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE"
            +this.compraCliente.getNombre()+" EN EL TIEMPO:"
            +(System.currentTimeMillis()-this.initialTime)/1000
            +"seg"
        );

        for(int i=0;i<this.compraCliente.getProductos().length; i++) {
            this.esperarXsegundos(compraCliente.getProductos()[i]);
            System.out.println("Procesado el producto"+(i+1)
                +" del cliente"+this.compraCliente.getNombre()
                +" -> Tiempo:"
                +(System.currentTimeMillis()-this.initialTime)/1000
                +"seg"
            );
        }

        System.out.println("El cajero"+this.nombre
            +" HA TERMINADO DE PROCESAR"
            +this.compraCliente.getNombre()+" EN EL TIEMPO:"
            +(System.currentTimeMillis()-this.initialTime)/1000
            +"seg"
        );
    }
}