package tp4.ejercicio6;

/*
│
└── Main.java (El Orquestador)
    ├── [ ] Instanciar el recurso compartido (Taxi).
    ├── [ ] Instanciar y lanzar el hilo del Taxista (Estará dormido de inmediato porque no hay pasajeros).
    └── [ ] En un bucle, instanciar y lanzar varios hilos Pasajeros y observar cómo el Taxista los atiende de a uno de forma coreografiada.
 */
public class Main {
    private static final int NUM_PASAJEROS = 2; // Número de pasajeros a simular
    private static final int NUM_TAXIS = 1; // Número de taxis a simular

    public static void main(String[] args) {
        // Instanciamos el recurso compartido (Taxi) con los permisos:
        // 1 taxi libre, 0 taxista dormido, 0 pasajero dormido / no taxi taken yet
        Taxi taxiRecurso = new Taxi(1, 0, 0);

        // Instanciamos y lanzamos el hilo del Taxista
        Taxista taxista = new Taxista("Taxista-1", taxiRecurso);
        Thread hiloTaxista = new Thread(taxista);
        hiloTaxista.start();

        // En un bucle, instanciamos y lanzamos varios hilos Pasajeros
        for (int i = 1; i <= NUM_PASAJEROS; i++) {
            Pasajero pasajero = new Pasajero("Pasajero-" + i, taxiRecurso);
            Thread hiloPasajero = new Thread(pasajero);
            hiloPasajero.start();
        }
    }
}
