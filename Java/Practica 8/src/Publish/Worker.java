package Publish;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public class Worker extends SwingWorker<Void, Integer> {
    private int n;
    private Panel panel;

    public Worker(int n, Panel panel) {
        this.n = n;
        this.panel = panel;
    }

    private boolean esPrimo(int n) {
        boolean esprimo = true;
        int i = 2;
        while (i * i <= n && esprimo) {
            if (n % i == 0) esprimo = false;
            i++;
        }
        return esprimo;
    }


    private List<Integer> listaPrimos(int n) {
        this.setProgress(0);
        List<Integer> lista = new ArrayList<Integer>();
        int i = 0;
        int pprimo = 2;
        while (i < n) {
            if (esPrimo(pprimo)) {
                lista.add(pprimo);

                publish(pprimo);

                i++;
            }
            pprimo++;
        }
        return lista;
    }

    @Override
    protected Void doInBackground() throws Exception {
        // TODO Auto-generated method stub
        listaPrimos(n);
        return null;
    }

    public void process(List<Integer> lista) {
        panel.escribeLista(lista);
    }
	/*
	public void done(){
		try {
			panel.escribeLista( this.get() );
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
}
