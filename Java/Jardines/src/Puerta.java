public class Puerta extends Thread {

    private Contador cont;
    private int id;

    public Puerta(Contador cont, int id) {
        this.cont = cont;
        this.id = id;
    }

    public void run(){
        for (int i = 0; i < 1000; i++) {


        }
    }
}
