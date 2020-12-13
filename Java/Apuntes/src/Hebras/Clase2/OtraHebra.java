package Hebras.Clase2;

public class OtraHebra extends Thread {
    private Hebra h;

    public OtraHebra(String nombre, Hebra h) {
        super(nombre);
        this.h = h;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            h.quienSoy();
        }
    }
}
