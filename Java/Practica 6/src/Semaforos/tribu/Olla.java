package Semaforos.tribu;

import java.util.concurrent.*;

public class Olla {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore esperoComer = new Semaphore(0);
    private Semaphore esperoCocinar = new Semaphore(1);
    private static final int R = 5;
    private int racionesActuales = 0;


    public void nuevoExplorador() throws InterruptedException {
        //System.out.println("entro en nuevo explorador");

        esperoCocinar.acquire();

        racionesActuales = R;

        System.out.println("Negro asesino pone blanco inocente para comer");

        esperoComer.release();
        mutex.release();
    }


    public void comeRacion(int id) throws InterruptedException {
        //System.out.println("entro en comer racion r");

        esperoComer.acquire();
        mutex.acquire();

        racionesActuales--;
        if (racionesActuales == 0) esperoCocinar.release();
        else esperoComer.release();


        System.out.println("Negro " + id + " come trozo blanco, quedan: " + racionesActuales);
        mutex.release();

    }

}
