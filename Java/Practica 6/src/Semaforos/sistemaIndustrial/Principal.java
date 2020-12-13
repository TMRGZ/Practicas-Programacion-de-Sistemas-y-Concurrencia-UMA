package Semaforos.sistemaIndustrial;

public class Principal {
    public static void main(String[] args) {
        Proceso p = new Proceso();
        Trabajador t = new Trabajador(p);
        Sensor[] s = new Sensor[3];


        for (int i = 0; i < s.length; i++)
            s[i] = new Sensor(p, i);

        t.start();

        for (int i = 0; i < s.length; i++)
            s[i].start();
    }
}
