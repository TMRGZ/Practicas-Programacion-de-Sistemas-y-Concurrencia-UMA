package Ejercicio1;

public class Hebra extends Thread {
    private char c;
    private int iter;

    public Hebra(char c, int iter) {
        this.c = c;
        this.iter = iter;
    }

    public void run() {
        for (int i = 0; i < iter; i++) {
            System.out.println(c);
        }
    }
}
