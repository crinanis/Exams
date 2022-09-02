package Sklad;

public class ResourceObj {


    public  ResourceObj(){

    }

    public synchronized void dumping(String str, int i){
        try {
            System.out.println(str);
            Thread.sleep((long)Math.random()*50);
            System.out.println("-> "+ i + " товар выгружен");
        } catch (InterruptedException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
