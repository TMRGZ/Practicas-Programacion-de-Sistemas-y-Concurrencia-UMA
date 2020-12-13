package Eventos.Clase1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements ActionListener {

    private Panel panel;

    public Controlador(Panel panel) {
        this.panel = panel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SI")) {
            panel.cambia("Si pulsado");

        } else if (e.getActionCommand().equals("NO")) {
            panel.cambia("No pulsado");

        } else if (e.getActionCommand().equals("PRIMOS")) {
            try {
                int n = panel.numero();
                panel.limpiaArea();
                Worker w = new Worker(n, panel);
                w.execute(); // No bloquea
                //panel.escribirLista(listaPrimos(n)); // Tarea costosa, bloquea interfaz

            } catch (Exception ie) {
                ie.getStackTrace();
            }
        }
    }
}
