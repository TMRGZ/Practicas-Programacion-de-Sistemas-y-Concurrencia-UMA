package Semaforos.nido;

import java.util.concurrent.Semaphore;

public class Nido {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore hayComida = new Semaphore(0);
    private Semaphore hayEspacio = new Semaphore(1);

    private int bichos = 0;
    private int TAM = 3;


    public void nuevoBichito(int id) throws InterruptedException {
        hayEspacio.acquire();
        mutex.acquire();

        bichos++;
        System.out.println("Bichito " + id + " puesto en nido, hay: " + bichos);

        if (bichos < TAM) {
            hayEspacio.release();
        }

        if (bichos > 1) {
            hayComida.release();
        }


        mutex.release();
    }


    public void comeBichito(int id) throws InterruptedException {
        hayComida.acquire();
        mutex.acquire();

        bichos--;
        System.out.println("Bichito " + id + " comido, quedan: " + bichos);

        if (bichos > 1) {
            hayComida.release();
        }

        if (bichos < TAM) {
            hayEspacio.release();
        }

        mutex.release();
    }

}
