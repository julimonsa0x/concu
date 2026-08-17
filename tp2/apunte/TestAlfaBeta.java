package tp2.apunte;

public class TestAlfaBeta {
    public static void main (String[] args){
    
        /* ------- opcion 1 ------- */
        HiloAlfaBeta alfa = new HiloAlfaBeta(
        "Hilo Alfa", 8);
    
        HiloAlfaBeta beta = new HiloAlfaBeta(
        "Hilo Beta", 4);
    
        //alfa.start();
        //beta.start();
        System.out.println("Probando hilos");



        /* ------- opcion 2 ------- */
        RunnableAlfaBeta charlieDeltaRunnable_1 = new RunnableAlfaBeta(5);
        RunnableAlfaBeta charlieDeltaRunnable_2 = new RunnableAlfaBeta(3);
        Thread charlie = new Thread (charlieDeltaRunnable_1, "Hilo Alfa");
        Thread delta = new Thread (charlieDeltaRunnable_2, "Hilo Beta");
        charlie.start();
        delta.start();
        System.out.println("estoy saliendo del main");   

    }
} 