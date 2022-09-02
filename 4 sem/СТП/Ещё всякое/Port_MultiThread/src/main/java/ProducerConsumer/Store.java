package ProducerConsumer;

public class Store {

    int counter = 0;
    final int N =3; //max product count
    private boolean available = false;

    //producer method
    synchronized void put(){
        while (counter>=3){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        counter++;
        System.out.println("Добавлен продукт");
        System.out.println("Продктов на скалде: " + counter);
        notify();
    }

    //consumer method
    synchronized void get(){
        while (counter<1){
            try {
                wait();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
            counter--;
            System.out.println("Куплен товар");
            System.out.println("на складе " + counter + " товар(ов)");
    }

}
