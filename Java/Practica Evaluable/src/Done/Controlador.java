package Done;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
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


                WorkerGenerator w1 = new WorkerGenerator(n, panel, "A");
                w1.execute();
                WorkerGenerator w2 = new WorkerGenerator(n, panel, "B");
                w2.execute();
                WorkerSearcher ws = new WorkerSearcher(w1.get(), w2.get(), panel);
                ws.execute();

            } catch (Exception ie) {

            }
        }
    }
}
