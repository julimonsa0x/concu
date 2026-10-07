package tp3.ejercicio6;

public class Usuario implements Runnable{
    private String nombre;
    private Area areaDeseada;

    public Usuario(String nombre, Area areaDeseada) {
        this.nombre = nombre;
        this.areaDeseada = areaDeseada;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(Area deseada) {
        this.areaDeseada = deseada;
    }

    public void run() {
        try {
            // simulo logica y tiempo de reserva...
            System.out.println(" intento de reserva... ");
            //Thread.sleep(250);
        } catch (Exception e) {
            // ...
        }

        boolean reserva = areaDeseada.reservarLugarPara(this.nombre);
       
        if (!reserva) {
            System.out.println(this.nombre + " no pudo conseguir reserva en "
                + areaDeseada.getNombre() + "[cupo="+areaDeseada.getCupo()+"]"
            );
        }
    }
    
}
