package Lago;

public class Lago {
	
	//Se a�aden tres variables de sincronizacion de Peterson
	//Una para controlar que no se pueda decrementar el nivel si vale 0
	//Otra para controlar el acceso de los decrementos de las presas.
	
	
	private int nivel = 0;
	private volatile boolean fp1 = false, fp2 = false;
	private volatile int turno = 1;
	
	
	private volatile boolean fp = false, fr = false;
	private volatile int turnop = 1;
	
	
	/**
	 * para el rio
	 */
	
	public void inc() {
		
		fr = true;
		turno = 2;
		while(fp && turno == 2) Thread.yield();
		nivel++;
		System.out.println("Rio incrementa: "+nivel);
		fr = false;
	}
	
	/**
	 * para la presa 1
	 */
	
	public void dec1() {
		
		fp1 = true;
		turnop = 2;
		while(fp2 && turnop == 2) Thread.yield();
		
		while(nivel == 0 ) Thread.yield();
		
		fp = true;
		turno = 1;
		while(fr && turno == 1) Thread.yield();
		
		nivel--;
		System.out.println("Presa1 decrementa: "+nivel);
		fp = false;
		fp1 = false;
	}
	
	
	/**
	 * para la presa 2
	 */
	
	public void dec2() {
		
		fp2 = true;
		turnop = 1;
		while(fp1 && turnop == 1) Thread.yield();
		
		while(nivel == 0 ) Thread.yield();
		
		
		fp = true;
		turno = 1;
		while(fr && turno == 1) Thread.yield();
		
		nivel--;
		System.out.println("Presa2 decrementa: "+nivel);
		fp = false;
		fp2 = false;
	}
	
	public int nivel() {
		return nivel;
	}
	
}
