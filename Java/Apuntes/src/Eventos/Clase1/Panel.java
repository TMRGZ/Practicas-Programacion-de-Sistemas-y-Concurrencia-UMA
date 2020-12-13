package Eventos.Clase1;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Panel extends JPanel {
    private JButton si = new JButton("Si");
    private JButton no = new JButton("No");
    private JLabel ms = new JLabel("Inicio");
    private JLabel msPrimos = new JLabel("n. primos");
    private JTextField primos = new JTextField(10);
    private JTextArea area = new JTextArea(10, 50);
    private JScrollPane scroll = new JScrollPane(area);
    private JLabel mensaje = new JLabel("GUI creada");

    public Panel() {
        JPanel panel1 = new JPanel();
        panel1.add(si);
        panel1.add(no);
        panel1.add(ms);

        JPanel panel2 = new JPanel();
        panel2.add(msPrimos);
        panel2.add(primos);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(panel1);
        panel3.add(panel2);

        this.setLayout(new BorderLayout());
        this.add(panel3, BorderLayout.NORTH);
        this.add(scroll, BorderLayout.CENTER);
        this.add(mensaje, BorderLayout.SOUTH);
    }

    public void controlador(Controlador ctr) {
        si.addActionListener(ctr);
        si.setActionCommand("SI");

        no.addActionListener(ctr);
        no.setActionCommand("NO");

        primos.addActionListener(ctr);
        primos.setActionCommand("PRIMOS");
    }

    public void cambia(String str) {
        ms.setText(str);
    }

    public void limpiaArea() {
        area.setText("");
    }

    public void escribirLista(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            area.append(lista.get(i) + " ");

            if ((i + 1) % 10 == 0) area.append("\n");
        }
    }

    public int numero() {
        return Integer.parseInt(primos.getText());
    }
}
