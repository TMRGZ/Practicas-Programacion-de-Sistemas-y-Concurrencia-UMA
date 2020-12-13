package Publish;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Controlador implements ActionListener {
    private Panel panel;

    public Controlador(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("PARES")) {
            try {
                int n = panel.numero();
                panel.limpiaArea();

                List<Integer> listaA = new ArrayList<>();
                List<Integer> listaB = new ArrayList<>();

                WorkerSearcher ws = new WorkerSearcher(listaA, listaB, panel);
                WorkerGenerator w1 = new WorkerGenerator(n, listaA, panel, "A", ws);
                WorkerGenerator w2 = new WorkerGenerator(n, listaB, panel, "B", ws);
                w1.execute();
                w2.execute();
                ws.execute();

            } catch (Exception ie) {

            }
        }
    }
}
