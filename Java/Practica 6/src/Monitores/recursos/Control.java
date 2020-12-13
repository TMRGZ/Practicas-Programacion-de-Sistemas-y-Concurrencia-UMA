package Monitores.recursos;

import java.util.ArrayList;


public class Control {
    private int NUM; //numero total de recursos
    private ArrayList<Integer> esperando = new ArrayList<>();
    private int numEsperas = 0;
    private int turno = -1;

    public Control(int num) {
        this.NUM = num;
    }

    public synchronized void qRecursos(int id, int num) throws InterruptedException {
        numEsperas++;
        System.out.println("Proceso " + id + " pide: " + num + " recursos, quedan: " + NUM);

        if (numEsperas > 1) {
            esperando.add(id);
            while (turno != id) wait();
        }

        while (num > NUM) {
            wait();
        }

        NUM -= num;
        System.out.println("Proceso " + id + " devuelve: " + num + " recursos, quedan: " + NUM);

        if (!esperando.isEmpty()) {
            turno = esperando.remove(0);
        } else {
            turno = -1;
        }

        numEsperas--;
        notifyAll();
    }

    public synchronized void libRecursos(int id, int num) {
        NUM += num;
        System.out.println("Proceso " + id + " devuelve: " + num + " recursos");
        notifyAll();
    }
}
