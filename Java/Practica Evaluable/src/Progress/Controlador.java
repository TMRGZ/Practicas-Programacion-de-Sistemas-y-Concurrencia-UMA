package Progress;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


public class Controlador implements ActionListener, PropertyChangeListener {
    private Panel panel;

    public Controlador(Panel panel) {
        this.panel = panel;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("PARES")) {
            try {
                int n = panel.numero();
                panel.limpiaArea();
                List<Integer> listaA = new ArrayList<>();
                List<Integer> listaB = new ArrayList<>();
                listaA.clear();
                listaB.clear();

                WorkerSearcher ws = new WorkerSearcher(listaA, listaB, panel);
                WorkerGenerator w1 = new WorkerGenerator(n,listaA, panel, "A", ws);
                WorkerGenerator w2 = new WorkerGenerator(n,listaB, panel, "B", ws);

                ws.addPropertyChangeListener(this);

                w1.execute();
                w2.execute();
                ws.execute();


            } catch (Exception ignored) {

            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
        if (evt.getPropertyName().equals("progress")) {
            panel.progreso((Integer) evt.getNewValue());
        }
    }
}
