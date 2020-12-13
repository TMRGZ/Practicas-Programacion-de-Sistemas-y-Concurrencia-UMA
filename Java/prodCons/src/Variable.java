public class Variable {

    private int v;
    private boolean hayDato = false;

    public void almacenar(int n) {
//        Lo usa el productor
        while (hayDato) {
            System.out.println("Productor espera");
            Thread.yield(); // CS-prod
        }

        v = n; // Acceso critico
        hayDato = true; // CS-cons
    }

    public int getV() {
        while (!hayDato) {
            System.out.println("Consumidor espera");
            Thread.yield(); // CS-cons
        }

        int w = v;
        hayDato = false; // CS-prod

        return w;
    }
}
