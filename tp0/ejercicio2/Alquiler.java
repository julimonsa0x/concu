package ejercicio2;

public class Alquiler {
    private String cliente;
    private String fechaInicio;
    private String horaInicio;
    private String fechaFin;
    private String horaFin;
    private int posEstacionamiento;
    private Avion avion;

    // constructor


    /**
     * El cálculo del alquiler se realiza multiplicando la duración del alquiler en horas por un módulo
     * que se obtiene multiplicando por 20 la envergadura en metros. Este valor se incrementa en una
     * cantidad fija (250 en la actualidad). Es importante considerar que este valor puede cambiar en el
     * futuro y puede variar en otros aeropuertos.
     * @return
     */
    public int calcularCostoAlquiler() {
        //double duracionHoras = calcularDuracionHoras();
        
        // 1ro. Obtener modulo multiplicando la envergadura por 20
        int modulo = avion.getEnvergadura() * 20;
        
        // 2do. Calcular la duracion del alquiler en horas
        int duracionHoras = (horaFin - horaInicio) * ;

        // Calcular el costo del alquiler
        int costoAlquiler = duracionHoras * (modulo + 250);

        return costoAlquiler;
    }
}
