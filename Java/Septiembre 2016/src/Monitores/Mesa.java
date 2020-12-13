package Monitores;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mesa {
    private boolean[] listaJugadas;
    private int N;
    private int num = 0;
    private int numCaras = 0;
    private int numCruces = 0;
    private int ganador = N;

    private boolean hayQueJugar = true;
    private boolean HayQueComprobar = false;

    private Lock l = new ReentrantLock(true);
    private Condition cParada = l.newCondition();

    public Mesa(int N) {
        this.N = N;
        this.listaJugadas = new boolean[N];
    }


    /**
     * @param id   del jugador que llama al metodo
     * @param cara : true si la moneda es cara, false en otro caso
     * @return un valor entre 0 y N. Si devuelve N es que ning�n jugador
     * ha ganado y hay que repetir la partida. Si  devuelve un n�mero menor que N, es el id del
     * jugador ganador.
     * <p>
     * Un jugador llama al metodo nuevaJugada cuando quiere poner
     * el resultado de su tirada (cara o cruz) sobre la mesa.
     * El jugador deja su resultado y, si no es el �ltimo, espera a que el resto de
     * los jugadores pongan sus jugadas sobre la mesa.
     * El �ltimo jugador comprueba si hay o no un ganador, y despierta
     * al resto de jugadores
     */
    public int nuevaJugada(int id, boolean cara) throws InterruptedException {
        l.lock();
        int miGanador;

        try {
            while (!hayQueJugar) {
                cParada.await();
            }

            // Gestion jugada
            listaJugadas[id] = cara;
            num++;
            if (cara) numCaras++;
            else numCruces++;
            System.out.println("Jugador " + id + " ha tirado moneda, han jugado: " + num);

            // Comprobaciones
            if (num < N) { // Si hace falta jugar mas espero
                while (!HayQueComprobar) {
                    cParada.await();
                }

            } else { // Si ya han jugado compruebo
                ganador();
                System.out.println("El ganador es " + ganador);
                System.out.println("******************");
                HayQueComprobar = true;
                hayQueJugar = false;
                cParada.signalAll();
            }

            // Gestion comprobadores
            num--;
            if (cara) numCaras--;
            else numCruces--;
            if (num == 0) {
                HayQueComprobar = false;
                hayQueJugar = true;
                cParada.signalAll();;
            }

            miGanador = ganador;
        } finally {
            l.unlock();
        }



        return miGanador;
    }

    private void ganador() {
        int gana = -1;
        if (numCaras == 1) gana = 1;
        if (numCruces == 1) gana = 0;
        boolean hayGanador = gana != -1; // hay un ganador si alguien tiene una
        // moneda distinta a todos los dem�s
        if (hayGanador) { // si hay ganador lo busco
            boolean enc = false;
            int i = 0;
            while (!enc) {
                if (listaJugadas[i] == (gana == 1)) {
                    ganador = i;
                    enc = true;
                } else {
                    i++;
                }
            }
        } else ganador = N;


    }
}
