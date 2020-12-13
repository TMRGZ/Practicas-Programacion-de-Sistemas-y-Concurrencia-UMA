package Done;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;

public class WorkerGenerator extends SwingWorker<List<Integer>,Void> {
    private int n;
    private Panel panel;
    private String tipoLista;

    public WorkerGenerator(int n, Panel panel, String tipoLista) {
        this.n = n;
        this.panel = panel;
        this.tipoLista = tipoLista;
    }

    @Override
    protected List<Integer> doInBackground() throws Exception {
        return listaNumeros(n);
    }

    private List<Integer> listaNumeros(int n) {
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lista.add(ThreadLocalRandom.current().nextInt(0, 100));
        }
        return lista;
    }

    public void done(){
        try {
            panel.escribeLista(this.get(), tipoLista);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
