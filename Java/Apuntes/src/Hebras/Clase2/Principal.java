package Hebras.Clase2;

public class Principal {
    public static void main(String[] args) {

        Hebra h = new Hebra("Hebras.Clase2.Hebra 1");
        OtraHebra otra = new OtraHebra("Hebras.Clase2.Hebra 2", h);

        h.start();
        otra.start();
    }
}
