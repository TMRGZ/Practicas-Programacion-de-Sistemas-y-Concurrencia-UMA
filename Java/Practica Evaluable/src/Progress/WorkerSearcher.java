package Progress;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerSearcher extends SwingWorker<Void, String> {
    private List<Integer> listaA;
    private List<Integer> listaB;
    private Panel panel;

    public WorkerSearcher(List<Integer> listaA, List<Integer> listaB, Panel panel) {
        this.listaA = listaA;
        this.listaB = listaB;
        this.panel = panel;
    }


    @Override
    protected Void doInBackground() throws Exception {
        listaMensajes(listaA, listaB);
        return null;
    }

    private synchronized void listaMensajes(List<Integer> listaA, List<Integer> listaB) throws InterruptedException {
        List<String> mensajes = new ArrayList<>();

        for (int i = 0; i < panel.numero(); i++) {
            while (listaA.size() <= i || listaB.size() <= i){
                wait();
            }

            double hypot = Math.hypot(listaA.get(i), listaB.get(i));
            String msg = i + ": " + listaA.get(i) + "^2 + " + listaB.get(i) + "^2 == ";


            msg = hypot % 1 == 0 ? msg + (int) hypot + " <- Terna Pitagorica" : msg + hypot;

            mensajes.add(msg);
            this.setProgress((i + 1) * 100 / panel.numero());

            publish(msg);
            Thread.sleep(50);
        }
    }

    public void process(List<String> lista) {
        panel.escribeListaFinal(lista);
    }

    /*public void done() {
        try {
            panel.escribeListaFinal(this.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }*/
}
