package Ejercicio1;

public class main {
    public static void main(String[] args) {
        Hebra h1 = new Hebra('a', 500);
        Hebra h2 = new Hebra('b', 500);
        Hebra h3 = new Hebra('c', 500);

        h1.start();
        h2.start();
        h3.start();
    }
}
