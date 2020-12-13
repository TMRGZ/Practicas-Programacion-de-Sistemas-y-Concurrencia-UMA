package Semaforos.sistemaIndustrial;

import java.util.Random;

public class Sensor extends Thread{
    private static Random r = new Random();
    private Proceso p;
    private int id;

    public Sensor(Proceso p, int id){
        this.p = p;
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try{
                p.medirSensores(id);
                Thread.sleep(r.nextInt(1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

