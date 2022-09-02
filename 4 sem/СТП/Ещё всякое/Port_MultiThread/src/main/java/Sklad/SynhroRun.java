package Sklad;

public class SynhroRun {

    public static void main(String[] args) {

        ResourceObj s = null;

        try {
            s = new ResourceObj();
            SyncThread t1 = new SyncThread("Машина 1" , s);
            SyncThread t2 = new SyncThread("Машина 2" , s);
            SyncThread t3 = new SyncThread("Машина 3" , s);
            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
