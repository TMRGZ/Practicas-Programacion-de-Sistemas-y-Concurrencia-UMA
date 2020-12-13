package Monitores;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barca extends Thread {
    private Lock l = new ReentrantLock(true);

    // Android
    private boolean pAndroid = true;
    private Condition cAndroid = l.newCondition();
    private int numAndroid = 0;
    // iPhone
    private boolean pIphone = true;
    private Condition cIphone = l.newCondition();
    private int numIphone = 0;
    // Viaje
    private boolean finViaje = false;
    private Condition esperoLleno = l.newCondition();

    /**
     * Un estudiante con móvil android llama a este método
     * cuando quiere cruzar el río. Debe esperarse a montarse en la
     * barca de forma segura, y a llegar a la otra orilla del antes de salir del
     * método
     *
     * @param id del estudiante android que llama al método
     * @throws InterruptedException
     */
    public void android(int id) throws InterruptedException {
        l.lock();

        try {
            while (!pAndroid) {
                cAndroid.await();
            }

            // Gestion subir
            numAndroid++;
            System.out.println("Se ha subido un Android, iPhones=" + numIphone + " Androids=" + numAndroid);

            if ((numAndroid==1 && numIphone == 2)|| numAndroid==3){ // Si ya no es seguro o si ya hay 2 iphones, no meter mas
                pIphone = false;
            } else if (numAndroid==2 && numIphone ==1){ // Si ya hay dos android no meter mas
                pAndroid = false;
            }

            // Comprobaciones
            if (numIphone + numAndroid == 4) {
                System.out.println("Barca enviada");
                pIphone = false;
                pAndroid = false;
                finViaje = true;
                esperoLleno.signalAll();
            }else{
                while (!finViaje){ // Si no termino el viaje, esperas
                    esperoLleno.await();
                }
            }

            // Una vez terminado, bajas a los android
            numAndroid--;
            System.out.println("Se ha bajado un Android, iPhones=" + numIphone + " Androids=" + numAndroid);

            // Una vez bajados, se reinicia el viaje
            if (numIphone == 0 && numAndroid == 0) {
                System.out.println("Se han bajado todos");
                pAndroid = true;
                cAndroid.signalAll();
                pIphone = true;
                cIphone.signalAll();
                finViaje = false;
            }


        } finally {
            l.unlock();
        }
    }

    /**
     * Un estudiante con móvil android llama a este método
     * cuando quiere cruzar el río. Debe esperarse a montarse en la
     * barca de forma segura, y a llegar a la otra orilla del antes de salir del
     * método
     *
     * @param id del estudiante android que llama al método
     * @throws InterruptedException
     */

    public void iphone(int id) throws InterruptedException {
        l.lock();

        try {
            while (!pIphone) {
                cIphone.await();
            }

            numIphone++;
            System.out.println("Se ha subido un iPhone, iPhones=" + numIphone + " Androids=" + numAndroid);

            if ((numIphone==1 && numAndroid == 2)|| numIphone==3){
                pAndroid = false;
            } else if (numIphone==2 && numAndroid ==1){
                pIphone = false;
            }


            if (numIphone + numAndroid == 4) {
                System.out.println("Barca enviada");
                pIphone = false;
                pAndroid = false;
                finViaje = true;
                esperoLleno.signalAll();
            }else{
                while (!finViaje){
                    esperoLleno.await();
                }
            }

            numIphone--;
            System.out.println("Se ha bajado un iPhone, iPhones=" + numIphone + " Androids=" + numAndroid);


            if (numIphone == 0 && numAndroid == 0) {
                System.out.println("Se han bajado todos");
                pAndroid = true;
                cAndroid.signalAll();
                pIphone = true;
                cIphone.signalAll();
                finViaje = false;
            }


        } finally {
            l.unlock();
        }
    }


}
