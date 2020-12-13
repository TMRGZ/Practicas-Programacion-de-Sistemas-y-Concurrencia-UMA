package Semaforos.sistemaIndustrial;

import java.util.Random;

public class Trabajador extends Thread{
    private Random r = new Random();
    private Proceso p;

    public Trabajador(Proceso p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(r.nextInt(200));
                p.hacerCosas(r.nextInt(3));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
