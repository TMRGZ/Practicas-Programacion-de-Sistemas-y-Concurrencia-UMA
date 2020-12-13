package Semaforos.cadenaMontaje;

import java.util.Arrays;
import java.util.concurrent.Semaphore;


public class Cadena {

    private int N = 10;
    private int[] cadena = new int[N];
    private int numObj = 0;

    // 5 semaforos necesarios 1 mutex + 4 generales
    private Semaphore mutex = new Semaphore(1); // Mutex siempre inicializado a 1
    private Semaphore hayEspacio = new Semaphore(N);
    private Semaphore[] hayProd = new Semaphore[3];

    public Cadena() {
        for (int i = 0; i < hayProd.length; i++) {
            hayProd[i] = new Semaphore(0);
        }

        for (int i = 0; i < cadena.length; i++) {
            cadena[i] = -1;     // -1 = Hueco
        }
    }


    public void nuevoProducto(int id) throws InterruptedException {
        hayEspacio.acquire();
        mutex.acquire();

        int i = 0;
        while (cadena[i] != -1) i++; // Buscar hueco

        cadena[i] = id;
        numObj++;
        System.out.println("Col " + id + " pone: " + numObj);
        System.out.println(Arrays.toString(cadena));
        hayProd[id].release();

        mutex.release();
    }


    public void extraeProducto(int id) throws InterruptedException {
        hayProd[id].acquire();
        mutex.acquire();

        int i = 0;
        while (cadena[i] != id) i++;

        cadena[i] = -1;
        numObj--;
        System.out.println("Emp " + id + " extrae: " + numObj);
        System.out.println(Arrays.toString(cadena));

        hayEspacio.release();

        mutex.release();
    }


}
