import java.util.concurrent.*;
public class Contador {
    Semaphore s = new Semaphore(1);
    private int cont = 0;

    public void inc() throws InterruptedException {
        s.acquire();
        cont++;
        s.release();
    }

    public int getCont() {
        return cont;
    }
}
