package Progress;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Panel extends JPanel {
    //Titulos
    private JLabel tituloArriba = new JLabel("Longitud de la lista a generar de pares aleatorios?");
    private JLabel tituloAbajoIzq = new JLabel("Lista de naturales A        ");
    private JLabel tituloAbajoDer = new JLabel("        Lista de naturales B");
    private JLabel mensajeAbajo = new JLabel("Comprobaciones de ternas pitagoricas");
    //Insertar Texto
    private JTextField insertarPares = new JTextField(5);
    //Mostrar texto
    private JTextArea arribaIzq = new JTextArea(10, 25);
    private JTextArea arribaDer = new JTextArea(10, 25);
    private JTextArea abajo = new JTextArea(10, 50);
    //Scrolls Area
    private JScrollPane scrollArribaIzq = new JScrollPane(arribaIzq);
    private JScrollPane scrollArribaDer = new JScrollPane(arribaDer);
    private JScrollPane scrollAbajo = new JScrollPane(abajo);

    private JProgressBar progreso = new JProgressBar(0, 100);

    public Panel() {
        //Formar Panel Arriba
        JPanel panel1 = new JPanel();
        panel1.add(tituloArriba);
        panel1.add(insertarPares);
        // Colocar Panel Arriba
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(1, 1));
        panelSuperior.add(panel1);
        // Formar Panel Central
        //      Formar Panel Central Superior
        JPanel panelCentralSupeior = new JPanel();
        panelCentralSupeior.add(scrollArribaIzq);
        panelCentralSupeior.add(scrollArribaDer);
        //      Formar Panel Central Central
        JPanel panelCentralCentral = new JPanel();
        panelCentralCentral.add(tituloAbajoIzq);
        panelCentralCentral.add(tituloAbajoDer);
        //      Formar Panel Central Inferior
        JPanel panelCentralInferior = new JPanel();
        panelCentralInferior.add(scrollAbajo);
        // Colocar Panel Central
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelCentralSupeior, BorderLayout.NORTH);
        panelCentral.add(panelCentralCentral, BorderLayout.CENTER);
        panelCentral.add(panelCentralInferior, BorderLayout.SOUTH);

        progreso.setStringPainted(true);

        JPanel panelSur = new JPanel();
        panelSur.add(mensajeAbajo);
        panelSur.add(progreso);

        this.setLayout(new BorderLayout());
        this.add(panelSuperior, BorderLayout.NORTH);
        this.add(panelCentral, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);
    }


    public void controlador(Controlador ctr) {
        insertarPares.addActionListener(ctr);
        insertarPares.setActionCommand("PARES");
    }

    public void limpiaArea() {
        arribaDer.setText("");
        arribaIzq.setText("");
        abajo.setText("");
    }

    public void escribeLista(List<String> lista, String tipoLista) {
         /*for (int i = 0; i < lista.size(); i++) {
            if (tipoLista.equals("A")){
                arribaIzq.append("(" + i + ": " + lista.get(i) + ")\n");
            } else {
                arribaDer.append("(" + i + ": " + lista.get(i) + ")\n");
            }

        }*/

        for (String string : lista) {
            if (tipoLista.equals("A")){
                arribaIzq.append(string + "\n");
            } else {
                arribaDer.append(string + "\n");
            }
        }
    }

    public void escribeListaFinal(List<String> strings) {
        strings.forEach(string -> abajo.append(string + "\n"));
    }


    public int numero() {
        return Integer.parseInt(insertarPares.getText());
    }

    public void progreso(int n){
        progreso.setValue(n);
    }

}
