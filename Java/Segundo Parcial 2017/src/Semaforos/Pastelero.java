package Semaforos;

import java.util.*;
public class Pastelero extends Thread{

	private Random r = new Random();
	private Semaforos.Bandeja p;
	public Pastelero(Semaforos.Bandeja p){
		this.p = p;
		
	}
	
	
	public void run(){
		while (true){
			try {
				Thread.sleep(r.nextInt(200));
				p.tarta();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
