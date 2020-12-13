package Lago;

public class Presa extends Thread {
	private Lago l;
	private int id;
	
	public Presa(Lago l,int id) {
		this.l = l;
		this.id = id;
	}
	
	public void run() {
		for(int i = 0;i<500;i++) {
			if(id == 1) l.dec1();
			else l.dec1();
		}
	}
	
}
