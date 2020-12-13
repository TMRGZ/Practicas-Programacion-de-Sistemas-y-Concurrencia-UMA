package MontañaRusa;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Coche extends Thread {
    private Lock l = new ReentrantLock(true);
    private int tam;
    private int numPas = 0;

    // Para entradas
    private boolean pEntrada = true;
    private Condition cPEntrada = l.newCondition();
    // Para salidas
    private boolean pSalida = false;
    private Condition cPSalida = l.newCondition();
    // Para lleno
    private boolean estaLleno = false;
    private Condition cPLleno = l.newCondition();

    public Coche(int tam) {
        this.tam = tam;
    }

    public Coche() {
        tam = 5;
    }


    public void subir(int id) throws InterruptedException {
        // id del pasajero que se sube al coche
        l.lock(); // Inicio proteccion

        try {
            while (!pEntrada) {  // Si no paso por puerta, espero
                cPEntrada.await();
            }
            System.out.println("Pasajero: " + id + " se sube");

            numPas++;   // Si paso hay mas pasajeros

            if (numPas == tam) {
                System.out.println("Coche lleno, dar vuelta");
                pEntrada = false;
                estaLleno = true;
                cPLleno.signal();
            }


        } finally {
            l.unlock(); // Quito la proteccion
        }

    }

    public void bajar(int id) throws InterruptedException { // Se puede poner syncronized, pero es pesado computacionalmente
        // id del pasajero que se baja del coche
        l.lock();

        try {
            while (!pSalida) {
                cPSalida.await();
            }

            System.out.println("Pasajero: " + id + " se baja");
            numPas--;

            if (numPas == 0) {
                pSalida = false;
                estaLleno = false;
                pEntrada = true;
                cPEntrada.signalAll();
                System.out.println("Coche vacio");
            }

        } finally {
            l.unlock();
        }

    }


    public void esperaLleno() throws InterruptedException {
        //el coche espera a que este lleno para dar una vuelta
        l.lock();

        try {
            while (!estaLleno) {
                cPLleno.await();
            }
            Thread.sleep(200);

            pSalida = true;
            cPSalida.signalAll();


        } finally {
            l.unlock();
        }

    }

    public void run() {
        boolean fin = false;

        while (!this.isInterrupted() && !fin)
            try {
                this.esperaLleno();

            } catch (InterruptedException ie) {
                fin = true;
            }
    }
}