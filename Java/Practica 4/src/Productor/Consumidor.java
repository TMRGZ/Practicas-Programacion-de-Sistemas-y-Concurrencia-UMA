package Productor;

import java.util.*;
public class Consumidor extends Thread{
	private Buffer b; //acceso al recurso
	private int n;  // n�mero de iteraciones
	private Random r = new Random();
	
	public Consumidor(Buffer b,int n){
		this.b = b;
		this.n = n;
	}

	
	public void run(){
		
		for (int i = 0; i<n; i++){
			System.out.println(b.extraer());
			try {
				Thread.sleep(r.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
