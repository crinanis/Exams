package Auction;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid extends Thread {

    private int bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int id, int price, CyclicBarrier barrier){
        this.bidId = id;
        this.price = price;
        this.barrier = barrier;
    }

    public int getBidId() {
        return bidId;
    }

    public int  geyPrice() {
        return price;
    }


    @Override
    public void run() {
        System.out.println("Клиент " + this.bidId + " определил цену");
        try {
            Thread.sleep(new Random().nextInt(50));
            int delta = new Random().nextInt(50);
            price+=delta;
            System.out.println("Ставка " + bidId + " : " + price);
            barrier.await();
            System.out.println("Подождите ...");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
