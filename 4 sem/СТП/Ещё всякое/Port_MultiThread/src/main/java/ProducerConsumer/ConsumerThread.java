package ProducerConsumer;

public class ConsumerThread extends Thread{

    Store store;

    public ConsumerThread(Store store){
        this.store = store;
    }


    @Override
    public void run() {
        for(int i=0;i<6;++i){
            store.get();
        }
    }
}
