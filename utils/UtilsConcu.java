package utils;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UtilsConcu {
    /**
     * ejemplo de uso:
     * sout("...soyInesGarcia " + obtenerTimestamp());
     * @return e.g: "... ran at = [45.120453]"
     */
    public static String obtenerTimestamp() {
        String tiempoFormateado = "";
        
        // momento exacto
        LocalTime ahora = LocalTime.now();
        
        // ss = segundos, 
        // SSS = milisegundos, 
        // SSSSSS = microsegundos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ss.SSSSSSS"); 
        
        tiempoFormateado = ahora.format(formato);
        
        return " | ran at = [" + tiempoFormateado + "]";
    }
}