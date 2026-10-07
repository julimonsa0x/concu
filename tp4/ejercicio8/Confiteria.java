package tp4.ejercicio8;

import java.util.concurrent.Semaphore;

public class Confiteria {
    
    private Semaphore semAsiento = new Semaphore(1);    // init permit = 1
    private Semaphore semAvisoMozo = new Semaphore(0);    // init permit = 0
    private Semaphore semComidaLista = new Semaphore(0);    // init permit = 0
    private Semaphore semDespedida = new Semaphore(0);     // init permit = 0

    /**
     * constructor vacio xq o podriamos darle los permisos por parametros
     * o bien, como hicimos aca, hardcodearlos segun caso conveniente...
     */
    public Confiteria() {
        // ...
    }

    // metodos para el cliente thread

    public void ocuparAsientoYLlamarMozo() {
        try {
            semAsiento.acquire(); // espera a que haya un asiento disponible
            System.out.println("Cliente ocupa un asiento y llama al mozo.");
            semAvisoMozo.release(); // avisa al mozo que hay un cliente esperando
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public void esperarComida() {
        
        try {
            semComidaLista.acquire(); // espera a que el mozo indique que la comida está lista
            System.out.println("Cliente recibe la comida y empieza a comer.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void agradecerYDespedirse() {
        
        System.out.println("Cliente agradece y se despide.");
        semDespedida.release(); // avisa al mozo que el cliente se despide
        semAsiento.release(); // libera el asiento para el próximo cliente
    }
    
    // metodos para el mozo thread

    public void esperarEmpleado() {
        try{
            semAvisoMozo.acquire(); // espera a que un cliente llame al mozo
            System.out.println("Mozo atiende al cliente.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void entregarComida() {
        System.out.println("Mozo entrega la comida al cliente.");
        semComidaLista.release(); // avisa al cliente que la comida está lista
    }

    public void esperarDespedida() {
        try{
            semDespedida.acquire(); // espera a que el cliente se despida
            System.out.println("Mozo recibe agradecimiento y despedida del cliente.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}