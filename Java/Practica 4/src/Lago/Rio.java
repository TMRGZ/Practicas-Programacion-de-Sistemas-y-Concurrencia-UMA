package Lago;

public class Rio extends Thread {

	private Lago l;
	public Rio(Lago l) {
		this.l = l;
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			l.inc();
		}
	}
	
}
