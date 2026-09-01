package tp3.ejercicio1;

public class Main2 {
    public static void main(String[] args) {
        CuentaBanco2 cb = new CuentaBanco2(50);

        VerificarCuenta2 vcL = new VerificarCuenta2(cb);
        VerificarCuenta2 vcJ = new VerificarCuenta2(cb);

        Thread lucas = new Thread(vcL, "Lucas");
        Thread jere = new Thread(vcJ, "Jere");
        
        lucas.start();
        jere.start();
    }
}
