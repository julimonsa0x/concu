package utils;

public class Colors {
    public static final String RESET = "\033[0m";
    
    // HILOS (Brillantes para destacar sobre gris oscuro)
    public static final String MAIN = "\033[1;36m";      // Cyan Bold (Orquestador / Main)
    public static final String CONTROL = "\033[1;32m";   // Green Bold (Hilo Controlador)
    public static final String BLUE = "\033[1;34m";      // Blue Bold (Producto Eléctrico)
    public static final String YELLOW = "\033[1;33m";    // Yellow Bold (Producto Mecánico)
    
    // RECURSO COMPARTIDO
    public static final String RECURSO = "\033[1;35m";   // Magenta Bold (Centro de Producción)
    
    // ESTADOS ESPECIALES
    public static final String ALERTA = "\033[1;31m";    // Red Bold (Para bloqueos o semáforo en rojo)
}