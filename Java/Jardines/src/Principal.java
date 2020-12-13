public class Principal {

    public static void main(String[] args) {
        Contador cont = new Contador();
        Puerta p0 = new Puerta(cont, 0);
        Puerta p1 = new Puerta(cont, 1);
        p0.start();
        p1.start();

        try {
            p0.join();
            p1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cont.getCont());
    }
}
