package Semaforos.sistemaIndustrial;

import java.util.concurrent.Semaphore;

public class Proceso {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore[] hayQueMedir = new Semaphore[3]; // Para sensores
    private Semaphore hayQueHacerCosas = new Semaphore(0); // Para el trabajador
    private int nMediciones = 0;

    public Proceso (){
        for (int i = 0; i < hayQueMedir.length; i++) {
            hayQueMedir[i] = new Semaphore(1);
        }
    }


    public void medirSensores(int id) throws InterruptedException {
        hayQueMedir[id].acquire();
        mutex.acquire();

        System.out.println("El sensor: " + id + " ha medido");
        nMediciones++;

        if (nMediciones == 3) hayQueHacerCosas.release();

        mutex.release();
    }

    public void hacerCosas(int id) throws InterruptedException {
        hayQueHacerCosas.acquire();
        mutex.acquire();

        System.out.println("Se han hecho cosas");

        for (Semaphore aHayQueMedir : hayQueMedir) {
            aHayQueMedir.release();
        }
        nMediciones = 0;

        mutex.release();
    }
}
