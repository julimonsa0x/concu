package tp4.ejercicio7;

public class Camion implements Runnable {

    private Surtidor surtidor;
    
    public Camion(Surtidor aRecargar) {
        this.surtidor = aRecargar;
    }
    
    public void run()  {
        // todo fix both while true loops !!>!>!>!!!!?!?!?!?!?
        // and prompt 2 previous terminals bcoz keep stucking
        // !!!!!
        while (true) {
           
            acaa debajo en comentario los 2 outputs rotos previos que se quedaban colgados hasta el infinito y no printeaban nada mas...comentario
            /**
             * PS E:\Code\UNCOMA\concu>  & 'C:\Program Files\Eclipse Adoptium\jdk-17.0.14.7-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\Usuario\AppData\Roaming\Code\User\workspaceStorage\909236162788b2955f2736170d79a69d\redhat.java\jdt_ws\concu_a805bec6\bin' 'tp4.ejercicio7.Main' 
 [!] Camion recargando el surtidor de ypf...
 [!] Auto-DEF456 recorrió 13km. Tanque: 27L
 [!] Auto-ABC123 recorrió 19km. Tanque: 31L
 [!] Auto-JKL012 recorrió 17km. Tanque: 43L
 [!] Auto-GHI789 recorrió 12km. Tanque: 33L
 [!] Auto-DEF456 recorrió 11km. Tanque: 16L
 [!] Auto-JKL012 recorrió 19km. Tanque: 24L
 [!] Auto-GHI789 recorrió 14km. Tanque: 19L
 [!] Auto-ABC123 recorrió 14km. Tanque: 17L
 [!] Auto-DEF456 recorrió 16km. Tanque: 0L
 [!] Auto-JKL012 recorrió 20km. Tanque: 4L
 [!] Auto-GHI789 recorrió 19km. Tanque: 0L
 [!] Auto-JKL012 en RESERVA. Buscando surtidor...
[:D] Surtidor: Suministrando 56L. Quedan 43L.
[:D] Auto-JKL012 llenó el tanque. Listo para seguir.
 [!] Auto-JKL012 recorrió 15km. Tanque: 45L
 [!] Auto-DEF456 finalizo su viaje (no consiguio/se quedo sin nafta).
 [!] Auto-ABC123 recorrió 16km. Tanque: 1L
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
 [!] Auto-JKL012 recorrió 12km. Tanque: 33L
 [!] Auto-GHI789 finalizo su viaje (no consiguio/se quedo sin nafta).
 [!] Surtidor: Auto pide 49L pero solo hay 43L. ¡Llamando al camión!
 [!] Auto-ABC123 finalizo su viaje (no consiguio/se quedo sin nafta).
 [...] Camion bloquea la estacion para re-filling...
 [!] Auto-JKL012 recorrió 15km. Tanque: 18L
 [!] Auto-JKL012 recorrió 11km. Tanque: 7L
[ OK ] Camion termina y se va...
 [!] Camion recargando el surtidor de ypf...
 [!] Auto-JKL012 en RESERVA. Buscando surtidor...
[:D] Surtidor: Suministrando 53L. Quedan 46L.
[:D] Auto-JKL012 llenó el tanque. Listo para seguir.
 [!] Auto-JKL012 recorrió 18km. Tanque: 42L
 [!] Auto-JKL012 recorrió 13km. Tanque: 29L
 [!] Auto-JKL012 recorrió 16km. Tanque: 13L
 [!] Auto-JKL012 en RESERVA. Buscando surtidor...
 [!] Surtidor: Auto pide 47L pero solo hay 46L. ¡Llamando al camión!
 [!] Auto-JKL012 finalizo su viaje (no consiguio/se quedo sin nafta).
 [...] Camion bloquea la estacion para re-filling...
[ OK ] Camion termina y se va...
 [!] Camion recargando el surtidor de ypf...
PS E:\Code\UNCOMA\concu>  e:; cd 'e:\Code\UNCOMA\concu'; & 'C:\Program Files\Eclipse Adoptium\jdk-17.0.14.7-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\Usuario\AppData\Roaming\Code\User\workspaceStorage\909236162788b2955f2736170d79a69d\redhat.java\jdt_ws\concu_a805bec6\bin' 'tp4.ejercicio7.Main' 
 [!] Camion recargando el surtidor de ypf...
 [!] Auto-DEF456 recorrió 14km. Tanque: 26L
 [!] Auto-GHI789 recorrió 17km. Tanque: 28L
 [!] Auto-JKL012 recorrió 16km. Tanque: 44L
 [!] Auto-ABC123 recorrió 10km. Tanque: 40L
 [!] Auto-JKL012 recorrió 18km. Tanque: 26L
 [!] Auto-DEF456 recorrió 14km. Tanque: 12L
 [!] Auto-ABC123 recorrió 20km. Tanque: 20L
 [!] Auto-GHI789 recorrió 15km. Tanque: 13L
 [!] Auto-JKL012 recorrió 10km. Tanque: 16L
 [!] Auto-DEF456 recorrió 12km. Tanque: 0L
 [!] Auto-ABC123 recorrió 14km. Tanque: 6L
 [!] Auto-GHI789 recorrió 13km. Tanque: 0L
 [!] Auto-JKL012 recorrió 11km. Tanque: 5L
 [!] Auto-DEF456 finalizo su viaje (no consiguio/se quedo sin nafta).
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
 [!] Auto-GHI789 finalizo su viaje (no consiguio/se quedo sin nafta).
[:D] Surtidor: Suministrando 44L. Quedan 55L.
[:D] Auto-ABC123 llenó el tanque. Listo para seguir.
 [!] Auto-ABC123 recorrió 13km. Tanque: 37L
 [!] Auto-JKL012 en RESERVA. Buscando surtidor...
[:D] Surtidor: Suministrando 55L. Quedan 0L.
 [!] Surtidor: Queda poca nafta. ¡Despertando al camión!
[:D] Auto-JKL012 llenó el tanque. Listo para seguir.
 [...] Camion bloquea la estacion para re-filling...
 [!] Auto-JKL012 recorrió 20km. Tanque: 40L
 [!] Auto-ABC123 recorrió 20km. Tanque: 17L
 [!] Auto-JKL012 recorrió 13km. Tanque: 27L
 [!] Auto-ABC123 recorrió 15km. Tanque: 2L
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
 [!] Auto-JKL012 recorrió 19km. Tanque: 8L
[ OK ] Camion termina y se va...
 [!] Camion recargando el surtidor de ypf...
[:D] Surtidor: Suministrando 48L. Quedan 51L.
[:D] Auto-ABC123 llenó el tanque. Listo para seguir.
 [!] Auto-ABC123 recorrió 15km. Tanque: 35L
 [!] Auto-JKL012 en RESERVA. Buscando surtidor...
 [!] Surtidor: Auto pide 52L pero solo hay 51L. ¡Llamando al camión!
 [...] Camion bloquea la estacion para re-filling...
 [!] Auto-JKL012 finalizo su viaje (no consiguio/se quedo sin nafta).
 [!] Auto-ABC123 recorrió 20km. Tanque: 15L
 [!] Auto-ABC123 recorrió 11km. Tanque: 4L
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
[ OK ] Camion termina y se va...
 [!] Camion recargando el surtidor de ypf...
[:D] Surtidor: Suministrando 46L. Quedan 53L.
[:D] Auto-ABC123 llenó el tanque. Listo para seguir.
 [!] Auto-ABC123 recorrió 19km. Tanque: 31L
 [!] Auto-ABC123 recorrió 10km. Tanque: 21L
 [!] Auto-ABC123 recorrió 16km. Tanque: 5L
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
[:D] Surtidor: Suministrando 45L. Quedan 8L.
 [!] Surtidor: Queda poca nafta. ¡Despertando al camión!
[:D] Auto-ABC123 llenó el tanque. Listo para seguir.
 [...] Camion bloquea la estacion para re-filling...
 [!] Auto-ABC123 recorrió 18km. Tanque: 32L
 [!] Auto-ABC123 recorrió 19km. Tanque: 13L
 [!] Auto-ABC123 recorrió 10km. Tanque: 3L
 [!] Auto-ABC123 en RESERVA. Buscando surtidor...
[ OK ] Camion termina y se va...
 [!] Camion recargando el surtidor de ypf...
[:D] Surtidor: Suministrando 47L. Quedan 52L.
[:D] Auto-ABC123 llenó el tanque. Listo para seguir.
 [!] Auto-ABC123 recorrió 16km. Tanque: 34L
 [!] Auto-ABC123 recorrió 15km. Tanque: 19L
 [!] Auto-ABC123 recorrió 19km. Tanque: 0L
 [!] Auto-ABC123 finalizo su viaje (no consiguio/se quedo sin nafta).
PS E:\Code\UNCOMA\concu> 
             */
           
           

            // sin .sleep() por el momento
            
            while (true) {
                System.out.println(" [!] Camion recargando el surtidor de ypf...");
                this.surtidor.recargar();
            }
        }
    }
    
}
