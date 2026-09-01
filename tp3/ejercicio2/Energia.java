package tp3.ejercicio2;

public class Energia {
    private int units;

    public Energia(int u) {
        this.units = u;
    }

    public int getUnidades() {
        return this.units;
    }

    public synchronized void incrementarEn(int cant) {
        // aqui iria la logica de seccion critica??
        // ...
        // en principio la solucion es synchronized
        // para que no haya caos al sumar y restar
        System.out.print(units+" (poder) pre-modif. por: "+Thread.currentThread().getName()+"\n");
        this.units += cant;
        System.out.print(units+" (poder) pos-modif. por: "+Thread.currentThread().getName()+"\n");
    }

    public void setEnergia(int cant) {
        this.units = cant;
    }
}
