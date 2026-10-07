package tp3.ejercicio6;

public class Area {
    private String nombre;
    private int cupoMax;
    private int cupoUsado = 0;

    public Area(String nombre, int cupoMax) {
        this.nombre = nombre;
        this.cupoMax = cupoMax;
    }
    
    public synchronized boolean reservarLugarPara(String nombreUsuario) {
        boolean res = false;
        if (cupoUsado < cupoMax) {
            res = true;
            cupoUsado++;
            
            System.out.println("Reserva ok para "+nombreUsuario+" en "+this.nombre+
                "["+this.getCupo()+"]"
            );
        }
        return res;
    }

    public String getNombre()   { return this.nombre; }
    public int getCupo()        { return this.cupoMax - this.cupoUsado; }
    
}
