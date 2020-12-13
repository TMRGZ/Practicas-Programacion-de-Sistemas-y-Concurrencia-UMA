package Semaforos;

import java.util.concurrent.*;

public class Mesa {
    private Semaphore mutex = new Semaphore(1);
    private Semaphore hayQueJugar = new Semaphore(1);
    private Semaphore hayQueComprobar = new Semaphore(0);
    private boolean[] listaJugadas;
    private int N;
    private int num = 0;
    private int numCaras = 0;
    private int numCruces = 0;
    private int ganador = N;

    public Mesa(int N) {
        this.N = N;
        this.listaJugadas = new boolean[N];
    }


    /**
     * @param id   del jugador que llama al m�todo
     * @param cara : true si la moneda es cara, false en otro caso
     * @return un valor entre 0 y N. Si devuelve N es que ning�n jugador
     * ha ganado y hay que repetir la partida. Si  devuelve un n�mero menor que N, es el id del
     * jugador ganador.
     * <p>
     * Un jugador llama al m�todo nuevaJugada cuando quiere poner
     * el resultado de su tirada (cara o cruz) sobre la mesa.
     * El jugador deja su resultado y, si no es el �ltimo, espera a que el resto de
     * los jugadores pongan sus jugadas sobre la mesa.
     * El �ltimo jugador comprueba si hay o no un ganador, y despierta
     * al resto de jugadores
     */
    public int nuevaJugada(int id, boolean cara) throws InterruptedException {
        int miGanador;
        hayQueJugar.acquire();
        mutex.acquire();

        listaJugadas[id] = cara;
        num++;
        if (cara) numCaras++;
        else numCruces++;
        System.out.println("Jugador " + id + " ha tirado moneda, han jugado: " + num);

        if (num < N) { // Faltan por jugar
            mutex.release(); // Vuelvo atras, necesito abrir el mutex
            hayQueJugar.release();
            hayQueComprobar.acquire(); // Bloqueo para no contear cuando faltan por jugar
            mutex.acquire(); // Hay que cerrar el mutex
        } else {  // Ya han jugado todos
            ganador();
        }
        // No hay acquire, por tanto puedo pasar
        miGanador = ganador;

        num--;
        if (cara) numCaras--;
        else numCruces--;
        if (num > 0)
            hayQueComprobar.release(); // Necesito comprobar mas
        else {
            hayQueJugar.release(); // Una vez terminado de contear, vuelvo a jugar
            System.out.println("El ganador ha sido "+ganador);
        }

        mutex.release();


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
