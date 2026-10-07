package parciales.ejercicio2;

public class PizarraDividida {
    private boolean tizaDisponible = true;
    private boolean digitalDisponible = true;

    // Objetos "llave" independientes
    private final Object lockTiza = new Object();
    private final Object lockDigital = new Object();

    public void tomarTiza(String nombre) {
        synchronized(lockTiza) { // Solo bloquea la mitad de tiza
            while(!tizaDisponible) { try{ lockTiza.wait(); } catch(Exception e){} }
            tizaDisponible = false;
        }
    }

    public void soltarTiza(String nombre) {
        synchronized(lockTiza) {
            tizaDisponible = true;
            lockTiza.notifyAll();
        }
    }
    
    public void tomarDigital(String nombre) {
        synchronized(lockDigital) { // Solo bloquea la mitad digital
            while(!digitalDisponible) { try{ lockDigital.wait(); } catch(Exception e){} }
            digitalDisponible = false;
        }
    }

    public void soltarDigital(String nombre) {
        synchronized(lockDigital) {
            digitalDisponible = true;
            lockDigital.notifyAll();
        }
    }
    // ... Métodos idénticos pero sincronizando sobre (lockDigital) ...
}