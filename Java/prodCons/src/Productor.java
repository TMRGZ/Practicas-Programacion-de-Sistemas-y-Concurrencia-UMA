public class Productor extends Thread {

    private Variable v;

    public Productor(Variable v) {
        this.v = v;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            v.almacenar(i);
        }
    }
}
