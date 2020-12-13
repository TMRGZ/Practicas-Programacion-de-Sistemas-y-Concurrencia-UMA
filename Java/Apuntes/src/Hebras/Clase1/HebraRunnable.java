package Hebras.Clase1;

public class HebraRunnable implements Runnable {
    private int id;

    public HebraRunnable(int id) {
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(id + ": " + i + "\n");
        }
    }
}
