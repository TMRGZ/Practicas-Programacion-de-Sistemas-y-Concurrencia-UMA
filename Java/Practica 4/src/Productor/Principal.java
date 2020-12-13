package Productor;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tam = 5;
		Buffer buffer  = new Buffer(tam);
		
		Productor prod = new Productor(buffer,50);
		Consumidor cons = new Consumidor(buffer,50);
		
		prod.start();
		cons.start();
		
		try{
			prod.join();
			cons.join();
		} catch (InterruptedException ie){}
		
		System.out.println("Fin del programa");
	}

}
