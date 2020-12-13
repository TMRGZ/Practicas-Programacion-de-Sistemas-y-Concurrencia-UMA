package Monitores;

import java.util.*;
public class Android extends Thread{
	
	private static Random r = new Random();
	private Monitores.Barca b;
	private int id;
	public Android(Monitores.Barca b, int id){
		this.b = b;
		this.id = id;
	}

	
	public void run(){
		while (true){
			try {
				b.android(id);
				Thread.sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
