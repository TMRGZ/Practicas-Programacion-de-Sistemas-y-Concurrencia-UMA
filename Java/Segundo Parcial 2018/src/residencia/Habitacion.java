package residencia;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Habitacion {
    //Si la cantidad de estudiantes en la habitaci�n es igual o mayor que este l�mite, el decano entra en la habitaci�n
    //El programa debe funcionar correctamente para cualquier valor de este l�mite
    private Lock l = new ReentrantLock(true);
    private Condition puedeEntrarEstudiante = l.newCondition();
    private Condition puedeSalirEstudiante = l.newCondition();
    private Condition puedeEntrarDecano = l.newCondition();
    private Condition puedeSalirDecano = l.newCondition();

    private static final int LIMITE_ESTUDIANTES = 10;
    private int numEstudiantes = 0;
    private boolean hayDecano = false;
    private boolean decanoQuiereEntrar = false;
    private boolean decanoVeSalaVacia = true;

    public void entraEstudiante(int id) throws InterruptedException {
        //System.out.println("Estudiante " + id + " quiere entrar");
        l.lock();

        try {
            while (hayDecano) {
                puedeEntrarEstudiante.await();
            }

            numEstudiantes++;
            System.out.println("Estudiante " + id + " entra, hay: " + numEstudiantes);
            decanoQuiereEntrar = numEstudiantes >= LIMITE_ESTUDIANTES;

            if (decanoQuiereEntrar) {
                puedeEntrarDecano.signalAll();
            }

            puedeSalirEstudiante.signalAll();

        } finally {
            l.unlock();
        }
    }

    public void saleEstudiante(int id) throws InterruptedException {
        //System.out.println("Estudiante " + id + " quiere salir");
        l.lock();

        try {
            while (numEstudiantes == 0) {
                puedeSalirEstudiante.await();
            }

            numEstudiantes--;
            System.out.println("Estudiante " + id + " sale, hay: " + numEstudiantes);
            decanoVeSalaVacia = numEstudiantes == 0;

            if (decanoVeSalaVacia) {
                puedeEntrarDecano.signalAll();
            }

            puedeEntrarEstudiante.signalAll();


        } finally {
            l.unlock();
        }

    }

    public void entraDecano() throws InterruptedException {
        //System.out.println("Decano quiere entrar");
        l.lock();

        try {
            while (!decanoQuiereEntrar || hayDecano) {
                puedeEntrarDecano.await();
            }

            hayDecano = true;
            System.out.println("Decano entra");
            decanoVeSalaVacia = numEstudiantes == 0;

            if (!decanoVeSalaVacia) {
                puedeSalirEstudiante.signalAll();
            } else {
                puedeSalirDecano.signalAll();
            }

        } finally {
            l.unlock();
        }
    }

    public void saleDecano() throws InterruptedException {
        //System.out.println("Decano quiere salir");
        l.lock();

        try {
            while (!hayDecano) {
                puedeSalirDecano.await();
            }

            hayDecano = false;
            System.out.println("Decano sale");
            puedeEntrarEstudiante.signalAll();
            puedeEntrarDecano.signalAll();

        } finally {
            l.unlock();
        }
    }
}
