package ejercicio2;

public class Avion {
    private String matricula;
    private int metrosEnvergadura;
    private int yearFabricacion;

    //private int hp ??? usan: Comercial y Helice

    public Avion(String matricula, int metrosEnvergadura, int yearFabricacion) {
        this.matricula = matricula;
        this.metrosEnvergadura = metrosEnvergadura;
        this.yearFabricacion = yearFabricacion;
    }
    
    public int getMetrosEnvergadura()   { return metrosEnvergadura; }

    public String getMatricula()        { return matricula; }

    public int getYearFabricacion()     { return yearFabricacion; }
}
