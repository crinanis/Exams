package ProducerConsumer;

public class ProducerThread extends Thread{

    Store store;

    public ProducerThread(Store store){
        this.store =store;
    }


    @Override
    public void run() {
       for(int i=1;i<6;i++){
           store.put();
       }
    }
}
