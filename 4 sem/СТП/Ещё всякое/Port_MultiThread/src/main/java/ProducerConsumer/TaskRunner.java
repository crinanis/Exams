package ProducerConsumer;

public class TaskRunner {
    public static void main(String[] args) {
        Store store = new Store();
        new ProducerThread(store).start();
        new ConsumerThread(store).start();
    }
}
