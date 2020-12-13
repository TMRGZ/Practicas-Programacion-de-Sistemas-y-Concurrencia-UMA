public class Consumidor extends Thread {

    private Variable v;

    public Consumidor(Variable v) {
        this.v = v;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(v.getV());
        }
    }
}
