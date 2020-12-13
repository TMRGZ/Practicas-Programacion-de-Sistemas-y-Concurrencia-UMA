package Monitores.fumadores;

import java.util.Random;
public class Agente extends Thread{
	private Random r = new Random();
	private Mesa m;
	public Agente(Mesa m){
		this.m = m;
	}

	public void run(){
		while (true){
			try {
				m.nuevoIngrediente(r.nextInt(3));
				Thread.sleep(r.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
