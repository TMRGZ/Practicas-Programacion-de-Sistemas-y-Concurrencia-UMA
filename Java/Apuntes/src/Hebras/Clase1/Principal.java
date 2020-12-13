package Hebras.Clase1;

public class Principal {
    public static void main(String[] args) {
//        Hebras.Clase1.Hebra h1 = new Hebras.Clase1.Hebra(1);
//        Hebras.Clase1.Hebra h2 = new Hebras.Clase1.Hebra(2);

        Thread h1 = new Thread(new HebraRunnable(1));
        Thread h2 = new Thread(new HebraRunnable(2));

        h1.run();
        h2.run();
    }
}
