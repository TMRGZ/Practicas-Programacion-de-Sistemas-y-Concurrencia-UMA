package Agua;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorAgua {
    private Lock l = new ReentrantLock(true);
    private int numH = 0;
    private int numO = 0;

    // Para oxigeno
    private boolean pHidro = true;
    private Condition cPHidro = l.newCondition();
    // Para Hidrogeno
    private boolean pOxi = true;
    private Condition cPOxi = l.newCondition();
    // Para combinacion
    private boolean yaCombinados = false;
    private Condition cPCombinados = l.newCondition();


    public void hListo(int id) throws InterruptedException {
        l.lock();

        try {
            while (!pHidro) {
                cPHidro.await();
            }
            numH++;

            System.out.println("Atomo de H añadido: " + id + " hay: " + numH);

            if (numO == 1) {
                pOxi = false;
            } else if (numH == 2) {
                pHidro = false;
            }

            moleculaCombinada();


        } finally {
            l.unlock();
        }
    }

    public void oListo(int id) throws InterruptedException {
        l.lock();

        try {
            while (!pOxi) {
                cPOxi.await();
            }
            numO++;

            System.out.println("Atomo de O añadido: " + id + " hay: " + numO);

            if (numO == 1) {
                pOxi = false;
            } else if (numH == 2) {
                pHidro = false;
            }

            moleculaCombinada();


        } finally {
            l.unlock();
        }
    }

    private void moleculaCombinada() throws InterruptedException {
        if (numH + numO == 3) {
            pHidro = false;
            pOxi = false;
            System.out.println("Molecula combinada");
            yaCombinados = true;
            numH = 0;
            pHidro = true;
            cPHidro.signalAll();
            numO = 0;
            pOxi = true;
            cPOxi.signalAll();
            cPCombinados.signalAll();
        } else {
            while (!yaCombinados) {
                cPCombinados.await();
            }
        }
    }
}
