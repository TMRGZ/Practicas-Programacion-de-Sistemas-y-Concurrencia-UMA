package Done;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class WorkerSearcher extends SwingWorker<List<String>, Void> {
    private List<Integer> listaA;
    private List<Integer> listaB;
    private Panel panel;

    public WorkerSearcher(List<Integer> listaA, List<Integer> listaB, Panel panel) {
        this.listaA = listaA;
        this.listaB = listaB;
        this.panel = panel;
    }


    @Override
    protected List<String> doInBackground() throws Exception {
        return listaMensajes(listaA, listaB);
    }

    private List<String> listaMensajes(List<Integer> listaA, List<Integer> listaB) {
        List<String> mensajes = new ArrayList<>();

        for (int i = 0; i < listaA.size(); i++) {
            double hypot = Math.hypot(listaA.get(i), listaB.get(i));

            if (hypot % 1 == 0) {
                mensajes.add(i + ": " + listaA.get(i) + "^2 + " + listaB.get(i) + "^2 == " + (int) hypot + " <- Terna Pitagorica");
            } else {
                mensajes.add(i + ": " + listaA.get(i) + "^2 + " + listaB.get(i) + "^2 == " + hypot);
            }
        }
        return mensajes;
    }

    public void done() {
        try {
            panel.escribeListaFinal(this.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
