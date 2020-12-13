package sushi;

public class Principal {
	
	public static void main(String[] args){
		//n�mero de clientes. El programa debe de funcionar correctamente con cualquier n�mero de clientes
		final int NUM_CLIENTES = 15;
		//crear recurso compartido y hebras y lanzar hebras
		Bar b = new Bar();
		Cliente c[] = new Cliente[NUM_CLIENTES];
		
		for (int i = 0; i < NUM_CLIENTES; i++) {
			c[i] = new Cliente(i, b);
			
		}
		
		for (int i = 0; i < NUM_CLIENTES; i++) {
			c[i].start();
		}
	}
}
