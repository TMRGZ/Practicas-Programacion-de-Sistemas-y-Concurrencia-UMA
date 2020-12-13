package Impresoras;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mmar
 * Soluci�n al problema del gestor de impresoras utilizando
 * condiciones. La condici�n colaGeneral es utilizada por todas las
 * hebras cuando piden una impresora y no hay del tipo que piden.
 * <p>
 * Las colas colaA y colaB son utilizadas en exclusiva por las hebras de tipo
 * A y B, respectivamente.
 */
public class Gestor {
    private Lock l = new ReentrantLock(true);
    private int numA;
    private int numB;

    // Para impresora A
    private boolean impALibre = true;
    private Condition cImpA = l.newCondition();
    // Para impresora B
    private boolean impBLibre = true;
    private Condition cImpB = l.newCondition();
    // Para impresora AB
    private Condition cImpAB = l.newCondition();

    public Gestor(int numA, int numB) {
        this.numA = numA;
        this.numB = numB;
    }


    public void qImpresoraA(int id) throws InterruptedException {
        l.lock();

        try {
            while (!impALibre) {
                cImpA.await();
            }
            numA--;
            impALibre = numA > 0;

            System.out.println("Pagina " + id + " impresa en A, quedan: " + numA);


        } finally {
            l.unlock();
        }
    }


    public void qImpresoraB(int id) throws InterruptedException {
        l.lock();

        try {
            while (!impBLibre) {
                cImpB.await();
            }
            numB--;
            impBLibre = numB > 0;

            System.out.println("Pagina " + id + " impresa en B, quedan: " + numB);

        } finally {
            l.unlock();
        }
    }


    public char qImpresoraAB(int id) throws InterruptedException {
        l.lock();
        char res = 'X';

        try {
            while (!impALibre && !impBLibre) {
                cImpAB.await();
            }

            if (impALibre) {
                res = 'A';
                qImpresoraA(id);

            } else if (impBLibre) {
                res = 'B';
                qImpresoraB(id);
            }

        } finally {
            l.unlock();
        }
        return res;
    }


    public void dImpresora(char tipo) {
        l.lock();

        try {
            if (tipo == 'A') {
                numA++;
                System.out.println("Impresora A queda libre, quedan: " + numA);
                impALibre = true;
                cImpA.signal();
            } else if (tipo == 'B') {
                numB++;
                System.out.println("Impresora B queda libre, quedan: " + numB);
                impBLibre = true;
                cImpB.signal();
            }

        } finally {
            cImpAB.signal();
            l.unlock();
        }
    }
}
