package tp4.ejercicio9;

public class Main {
    
    public static void main(String[] args) {

        /* [!] redundante los parametros!!!                         */
        /* [!] de igual manera es mejor tener ambas formas??? !!!   */
        /* [?] o siempre priorizar parametros???                    */

        // 1ro recurso compartido
        CentroProduccion centroProduccion = new CentroProduccion(5, 5, 1);

        // 2do hilo controlador
        Thread tControlador = new Thread(new HiloControlador(centroProduccion));
        tControlador.start();
        
        // 3ro simulamos llegada constante de piezas a la fabrica...:
        while (true) {
            try {

                //1 hacer un thread.sleep random y corto para separar la llegada entre productos...
                //2 instanciar un electrico, wrap en un thread y start()
                //3 instanciar un mecanico, wrap en un thread y start()
                //tip usar probabilidad con math.random() dentro del loop para decidir si en 
                // esta vuelta especifica llega solo un electrico, solo un mecanico o ambos...

                Thread.sleep(3000); // tiempo de llegada
                Thread tElectrico = new Thread(new ProductoElectrico(centroProduccion));
                //tElectrico.start(); comentado por el random agregado debajo...
                Thread tMecanico = new Thread(new ProductoMecanico(centroProduccion));
                //tMecanico.start(); comentado por el random agregado debajo...

                int random = (int) (Math.random() * 3); // 0, 1, 2
                if (random == 0) {          // 0= solo electrico
                    tElectrico.start();
                } else if (random == 1) {   // 1= solo mecanico
                    tMecanico.start();
                } else {                    // 2= ambos
                    tElectrico.start();
                    tMecanico.start();
                }

                // ...alternando la luz cada 5 segundos
                //Thread.sleep(5000);
                //centroProduccion.cambiaLineas();
                //System.out.println("luzElectricaVerde alternando...");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*
        
        // crear hilos de productos electricos
        for (int i = 0; i < 10; i++) {
            Thread tElectrico = new Thread(new ProductoElectrico(centroProduccion));
            tElectrico.start();
        }

        // crear hilos de productos mecanicos
        for (int i = 0; i < 10; i++) {
            Thread tMecanico = new Thread(new ProductoMecanico(centroProduccion));
            tMecanico.start();
        }

        */
       
    }
    
}
