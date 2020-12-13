package Lago;


public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tam = 5;
		Lago l  = new Lago();
		
		Presa p1 = new Presa(l,1);
		Presa p2 = new Presa(l,2);
		Rio r = new Rio(l);
		
		p1.start();
		p2.start();;
		r.start();
		
		try {
			p1.join();
			p2.join();
			r.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		System.out.println("El nivel de la presa es :"+l.nivel());
	}
}
