package tp2.ejercicio7;

public class CompraCliente {
    private String nombre;
    private int[] productos;

    // TODO: Argegar constructor y metodos de acceso
    public CompraCliente(String nombre, int[] prods) {
        this.nombre = nombre;
        this.productos = prods;
    }

    public String getNombre()   { return this.nombre; }
    public int[] getProductos() { return this.productos; }
    
    // ...
    
}
