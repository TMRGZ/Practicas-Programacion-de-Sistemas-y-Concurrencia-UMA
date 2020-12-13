package sushi;

import java.util.concurrent.Semaphore;

public class Bar {
    //n�mero de asientos. El programa debe de funcionar correctamente con cualquier n�mero de asientos
    public static final int NUM_ASIENTOS = 5;

    private Semaphore mutex = new Semaphore(1);
    private Semaphore puedoEntrar = new Semaphore(1);
    private Semaphore puedoIrme = new Semaphore(0);

    private int libres = NUM_ASIENTOS;
    private boolean hayQueSalir = false;

    /**
     * Utilizado por el cliente id cuando quiere entrar en el restaurante.
     * Si hay sitio, se sienta. Si est� lleno, debe esperar a que TODO el grupo
     * que ocupa el restaurante se haya marchado antes de sentarse.
     */
    public void pidoMesa(int id) throws InterruptedException {
        //System.out.println("Quiere entrar: " + id);
        puedoEntrar.acquire();
        mutex.acquire();

        libres--;
        System.out.println("Ha entrado: " + id + " quedan libres: " + libres);
        boolean estaLleno = libres == 0;

        puedoIrme.release();

        if (estaLleno) {
            hayQueSalir = true;
        } else if (libres > 0){
            //System.out.println("Entra otro");
            puedoEntrar.release();
        }

        //System.out.println("Fin pidoMesa");
        mutex.release();
    }

    /**
     * Utilizado por el cliente id cuando se marcha del restaurante
     */
    public void meVoy(int id) throws InterruptedException {
        //System.out.println("Quiere salir: " + id);
        puedoIrme.acquire();
        mutex.acquire();

        libres++;
        System.out.println("Ha Salido: " + id + " quedan libres: " + libres);
        hayQueSalir = libres != NUM_ASIENTOS;

        if (hayQueSalir) {
            puedoIrme.release();
        } else {
            puedoEntrar.release();
        }

        mutex.release();
    }

}
