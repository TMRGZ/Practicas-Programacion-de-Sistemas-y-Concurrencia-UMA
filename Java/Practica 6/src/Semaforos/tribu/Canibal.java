package Semaforos.tribu;

import java.util.Random;

public class Canibal extends Thread {
    private Olla n;
    private int id;
    private static Random r = new Random();

    public Canibal(Olla n, int id) {
        this.n = n;
        this.id = id;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(r.nextInt(20));
                n.comeRacion(id);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
