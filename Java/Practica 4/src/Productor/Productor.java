package Productor;

import java.util.*;
public class Productor extends Thread{
	
	private Buffer b; //acceso al buffer
	private int n;   // numero de iteraciones
	private Random r = new Random();
	
	public Productor(Buffer b,int n){
		this.b = b;
		this.n = n;
	}
	
	public void run(){
		
		for (int i = 0; i<n; i++){
			b.poner(i);
			try {
				Thread.sleep(r.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
