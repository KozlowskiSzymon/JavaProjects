import java.util.ArrayList;

public class Klasa {
    public static void main(String[] args) {

        Crate crate= new Crate();

        BottlesFactory factory = new BottlesFactory(crate);
        CratesChanger changer = new CratesChanger(crate);

        Thread produce = new Thread(factory, "produce");
        Thread change = new Thread(changer, "change");

        produce.start();
        change.start();

    }
}

class BottlesFactory implements Runnable{

    private Crate crate;
    private int bottleNumber = 0;
    public BottlesFactory(Crate crate){
        this.crate = crate;
    }
    @Override
    public void run() {

        synchronized (crate){

            System.out.println(Thread.currentThread().getName()+ ": "+"Produkuje butelki");
            while(true){
                while(crate.isCrateFull()){
                    try {
                        System.out.println(Thread.currentThread().getName()+ ": Trzeba wymienić skrzynkę");
                        crate.wait();
                        System.out.println(Thread.currentThread().getName()+ ": Znowu produkuję");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+ ": "+"Wyprodukowałem butelke:" + ++bottleNumber);
                crate.addNewBottle(new Bottle());
                crate.notifyAll();
            }

        }
    }
}

class CratesChanger implements Runnable{

    private Crate crate;
    public CratesChanger(Crate crate){
        this.crate = crate;
    }
    @Override
    public void run() {
        synchronized (crate){
            while (true) {
                while(!crate.isCrateFull()){
                    try {
                        System.out.println(Thread.currentThread().getName()+ ": Czekam na pełną skrzynkę");
                        crate.wait();
                        System.out.println(Thread.currentThread().getName()+ ": skrzynka pełna!!!!!!!!!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                crate.getNumberOfBottles();
                crate.changeCrate();
                crate.getNumberOfBottles();
                crate.notifyAll();
            }
        }
    }
}

class Crate{
    private int CAPACITY = 10;
    private ArrayList bottleList = new ArrayList(CAPACITY);
    private int crateNumber = 0;

    public synchronized int getNumberOfBottles(){
        return bottleList.size();
    }

    public synchronized boolean isCrateFull(){

        if(bottleList.size() == CAPACITY)
            return true;
        return false;
    }
    public synchronized void addNewBottle(Bottle bottle){
            bottleList.add(bottle);
    }
    public synchronized  void changeCrate(){
        System.out.println(Thread.currentThread().getName()+ ": "+"Wymieniam skrzynkę numer: "+ ++crateNumber);
        bottleList.clear();
    }
}
class Bottle{

    public Bottle() {
    }
}
