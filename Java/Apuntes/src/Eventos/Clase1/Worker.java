package Eventos.Clase1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Worker extends SwingWorker<List<Integer>, Void> {
    private int n;
    private  Panel panel;

    public Worker(int n, Panel panel) {
        this.n = n;
        this.panel = panel;
    }

    private boolean esPrimo(int n) {
        boolean esPrimo = true;

        int i = 2;

        while (i * i <= n && esPrimo) {
            if (n % i == 0) esPrimo = false;
            i++;
        }
        return esPrimo;
    }

    private List<Integer> listaPrimos(int n) {
        List<Integer> lista = new ArrayList<>();
        int i = 0;
        int pprimo = 2;

        while (i < n) {
            if (esPrimo(pprimo)) {
                lista.add(pprimo);
                i++;
            }

            pprimo++;
        }
        return lista;
    }

    @Override
    protected List<Integer> doInBackground() throws Exception {
        return listaPrimos(n);
    }

    public void done(){
        try {
            panel.escribirLista(this.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
