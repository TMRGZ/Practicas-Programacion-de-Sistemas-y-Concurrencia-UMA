package Productor;


public class Buffer {

    private int[] buffer;
    private int p = 0;
    private int c = 0;
    private int nElem = 0; // sincronizacion


    private volatile boolean fp = false, fc = false;
    private volatile int turno = 0;


    public Buffer(int tam) {
        buffer = new int[tam];
    }

    /**
     * el productor utiliza este m�todo para a�adir un nuevo dato
     * al buffer
     */

    public void poner(int e) {

        // espero si el buffer  esta lleno


        while (nElem == buffer.length) Thread.yield();

        // accedo en exclusion mutua con peterson

        fp = true;
        turno = 1;

        while (fc && turno == 1) Thread.yield();

        buffer[p] = e;
        p = (p + 1) % buffer.length;
        nElem++;

        fp = false;
    }

    /**
     * el consumidor utiliza este m�todo para extraer un nuevo dato
     * del buffer
     */

    public int extraer() {
        // espero si el buffer esta vacio

        while (nElem == 0) Thread.yield();

        //  accedo en exclusion mutua

        fc = true;
        turno = 0;

        while (fp && turno == 0) Thread.yield();


        //Seccion no critica

        int a = buffer[c];
        c = (c + 1) % buffer.length;
        nElem--;

        fc = false;

        return a;
    }
}
