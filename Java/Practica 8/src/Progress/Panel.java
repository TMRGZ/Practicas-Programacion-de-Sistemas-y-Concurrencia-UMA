package Progress;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;


public class Panel extends JPanel {

    private JButton si = new JButton("Si");
    private JButton no = new JButton("No");
    private JLabel ms = new JLabel("Inicio");
    private JLabel msPrimos = new JLabel("n. primos");
    private JTextField primos = new JTextField(10);
    private JTextArea area = new JTextArea(10, 50);
    private JScrollPane scroll = new JScrollPane(area);
    private JLabel mensaje = new JLabel("GUI creada");

    private JProgressBar progreso = new JProgressBar(0, 100);

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

        progreso.setStringPainted(true);

        JPanel panelSur = new JPanel();
        panelSur.add(mensaje);
        panelSur.add(progreso);
        this.add(panelSur, BorderLayout.SOUTH);

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

    public void escribeLista(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            area.append(lista.get(i) + "  ");
            if ((i + 1) % 10 == 0) area.append("\n");
        }
    }

    public int numero() {
        return Integer.parseInt(primos.getText());
    }

    public void progreso(int n) {
        progreso.setValue(n);
    }
}
