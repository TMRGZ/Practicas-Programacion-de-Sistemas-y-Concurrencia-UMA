package Publish;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkerGenerator extends SwingWorker<Void, String> {
    private int n;
    private Panel panel;
    private List<Integer> lista;
    private String tipoLista;
    private final WorkerSearcher ws;

    public WorkerGenerator(int n, List<Integer> lista, Panel panel, String tipoLista, WorkerSearcher ws) {
        this.n = n;
        this.panel = panel;
        this.lista = lista;
        this.tipoLista = tipoLista;
        this.ws = ws;
    }

    @Override
    protected Void doInBackground() throws Exception {
        listaNumeros(n);
        return null;
    }

    private List<Integer> listaNumeros(int n) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            int rnd = ThreadLocalRandom.current().nextInt(0, 100);
            lista.add(rnd);

            synchronized (ws) {
                ws.notify();
            }

            String msg = "(" + i + ": " + rnd + ")";
            publish(msg);
            Thread.sleep(50);
        }
        return lista;
    }

    public void process(List<String> lista) {
        panel.escribeLista(lista, tipoLista);


    }

    /*public void done(){
        try {
            panel.escribeLista(this.get(), tipoLista);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }*/
}
