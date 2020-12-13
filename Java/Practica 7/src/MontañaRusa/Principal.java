package MontañaRusa;

public class Principal {


    public static void main(String[] args) {
        Coche c = new Coche();
        Pasajero[] pas = new Pasajero[10];

        for (int i = 0; i < pas.length; i++) {
            pas[i] = new Pasajero(i, c);
        }

        c.start();

        for (Pasajero pa1 : pas) {
            pa1.start();
        }

        try {
            Thread.sleep(3000);
            c.interrupt();

            for (Pasajero pa : pas) {
                pa.interrupt();
            }

            for (Pasajero pa : pas) {
                pa.join();
            }
            System.out.println("fin");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}
