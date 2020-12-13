package Semaforos.nido;

import java.util.Random;

public class Bebes extends Thread {
    private Nido n;
    private int id;
    private static Random r = new Random();

    public Bebes(Nido n, int id) {
        this.n = n;
        this.id = id;
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
                n.comeBichito(id);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
