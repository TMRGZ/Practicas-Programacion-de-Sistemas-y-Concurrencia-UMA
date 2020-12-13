package Semaforos.nido;

import java.util.concurrent.Semaphore;

public class NidoAux {
    private static final int TAM = 5;
    int numB = 0;

    private Semaphore mutex = new Semaphore(1);
    private Semaphore hayEspacio = new Semaphore(1);
    private Semaphore hayComida = new Semaphore(0);


    public void nuevoBichito(int id) throws InterruptedException {
        hayEspacio.acquire();
        mutex.acquire();

        numB++;
        if (numB < TAM) hayEspacio.release();

        if (numB == 1) hayComida.release();


        System.out.println("Annadido por: " + id);

        mutex.release();
    }


    public void comeBichito(int id) throws InterruptedException {
        hayComida.acquire();
        mutex.acquire();

        numB--;
        if (numB > 0) hayComida.release();

        if (numB == TAM - 1) hayEspacio.release();

        System.out.println("Comido por: " + id);

        mutex.release();
    }

}
