public class Principal {
    public static void main(String[] args) {
        Variable v = new Variable();
        Productor prod = new Productor(v);
        Consumidor cons = new Consumidor(v);

        prod.start();
        cons.start();
    }
}
