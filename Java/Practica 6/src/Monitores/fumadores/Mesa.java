package Monitores.fumadores;

public class Mesa {

    private int ing = -1; // Mesa Vacia
    private boolean finFumar = true;

    public synchronized void nuevoIngrediente(int i) throws InterruptedException {
        //i es el ingrediente que no se pone

        while (!finFumar || ing != -1) {
            wait();
        }
        finFumar = true;

        ing = i;
        notifyAll();
        System.out.println("En la mesa esta el ingrediente: " + ing);

    }

    public synchronized void quieroFumar(int id) throws InterruptedException {
        //id espera los ingredientes que no tiene

        while (ing != id) {
            wait();
        }

        ing = -1;
        finFumar = false;
        System.out.println("Fumador: " + id + " quiere fumar");
    }

    public synchronized void finFumar(int id) {
        //el fumador id ha terminado de fumar

        System.out.println("Fumador: " + id + " termino de fumar");
        finFumar = true;
        notifyAll();
    }
}
