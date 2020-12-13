package Hebras.Clase2;

public class Hebra extends Thread {

    public Hebra(String nombre) {
        super(nombre);
    }

    public void quienSoy() {
        System.out.println(Thread.currentThread());
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            this.quienSoy();
        }
    }
}
