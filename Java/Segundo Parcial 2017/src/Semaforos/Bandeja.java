package Semaforos;


import java.util.concurrent.Semaphore;

public class Bandeja {

	private int R = 8; // numero de raciones por pastel
	private Semaphore mutex = new Semaphore(1);
	private Semaphore esperoRacion = new Semaphore(0);
	private Semaphore esperoPeticion = new Semaphore(1);
	private int racionesActuales = 0;

	/**
	 * Un niño que quiere una ración de tarta llama a este método para
	 * cogerla de la bandeja. 
	 * El niño debe esperar si  la bandeja está vacía a que el pastelero
	 * ponga una nueva tarta  
	 * @param id del niño que pide la ración
	 * @throws InterruptedException
	 */
	public void quieroRacion(int id) throws InterruptedException{
		esperoRacion.acquire();
		mutex.acquire();

		racionesActuales--;
		if (racionesActuales==0) esperoPeticion.release();
		else esperoRacion.release();


		System.out.println("Ninno: " + id + " coge racion, quedan: " + racionesActuales);

		mutex.release();
	}
	
	/**
	 * El pastelero llama a este método para poner una nueva tarta en
	 * la bandeja. Tiene que esperar a que la bandeja esté vacía para ponerla.
	 * @throws InterruptedException
	 */
	public void tarta() throws InterruptedException{
		esperoPeticion.acquire();

		racionesActuales = R;

		System.out.println("Nueva tarta puesta");

		esperoRacion.release();
		mutex.release();
	}
}
