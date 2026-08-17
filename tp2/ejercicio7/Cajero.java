package tp2.ejercicio7;

import utils.UtilsConcu;

public class Cajero {
    private String nombre;

    // TODO: Agregar Constructor, y métodos de acceso
    public Cajero(String nombrecito) {
        this.nombre = nombrecito;
    }

    public String getNombre()   {return this.nombre;}    

    // completar este metodo (listo)
    public void esperarXsegundos(int timeProd) {
        try {
            Thread.sleep(timeProd*1000);
        } catch (InterruptedException e) {
            System.out.println(this.getNombre() + " Interrumpido");
        }
    }

    public void procesarCompra(CompraCliente compraCliente, long timeStamp) {
        
        System.out.println("El cajero " + this.nombre
        + "\n COMIENZA A PROCESAR LA COMPRA DEL CLIENTE \n"
        + compraCliente.getNombre() + " EN EL TIEMPO: "
        + (System.currentTimeMillis() - timeStamp) / 1000 + " seg");

        for(int i=0; i<compraCliente.getProductos().length; i++) {
            this.esperarXsegundos(compraCliente.getProductos()[i]);
            System.out.println("Procesado el producto"+(i+1)
                + "-> Tiempo:"
                + (System.currentTimeMillis()-timeStamp)/1000+"seg"
            );
        }

        System.out.println("El cajero"+this.nombre
            + "\nHA TERMINADO DE PROCESAR"
            + compraCliente.getNombre()+"EN EL TIEMPO:"
            + (System.currentTimeMillis()-timeStamp)/1000+"seg"
        );
    }
}