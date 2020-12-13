package Hebras.Clase1;

public class Hebra {

    private int id;

    public Hebra(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(id + ": " + i + " ");
        }
    }
}
