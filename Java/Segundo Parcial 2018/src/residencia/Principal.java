package residencia;



public class Principal {

	public static void main(String[] args) throws InterruptedException {
    //n�mero de estudiantes. El programa debe de funcionar correctamente con cualquier n�mero de estudiantes
	  final int NUM_ESTUDIANTES = 30;
    //crear recurso compartido y hebras y lanzar hebras
	  Habitacion h = new Habitacion();
	  Estudiante[] e = new Estudiante[NUM_ESTUDIANTES];
	  Decano d = new Decano(h);
	  
	  for (int i = 0; i < NUM_ESTUDIANTES; i++) {
		  e[i] = new Estudiante(i, h);
	  }
	  
	  d.start();
	  
	  for (int i = 0; i < NUM_ESTUDIANTES; i++) {
		  
		  e[i].start();
	  }
	}
}
