package Ejercicio2;

public class Hebra extends Thread {
    private int iter;
    private VariableCompartida v;

    public Hebra(VariableCompartida v, int iter) {
        this.v = v;
        this.iter = iter;
    }

    public void run() {
        for (int i = 0; i < iter; i++) {
            v.incrementar();
            System.out.println(v.getV());
        }
    }
}

