package Done;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements ActionListener{

	private Panel panel;
	public Controlador(Panel panel){
		this.panel = panel;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("SI")){
			panel.cambia("sí pulsado");
		} else if (e.getActionCommand().equals("NO")){
			panel.cambia("no pulsado");
		} else if (e.getActionCommand().equals("PRIMOS")){
			try{
				int n = panel.numero();
				panel.limpiaArea();
				Worker w = new Worker(n,panel);
				w.execute();
				//panel.escribeLista(listaPrimos(n));//tarea costosa
			}catch(Exception ie){
				
			}
		}
	}

}
