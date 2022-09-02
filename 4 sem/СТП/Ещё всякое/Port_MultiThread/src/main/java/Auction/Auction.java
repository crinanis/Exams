package Auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BIDS_NUMBER=5;

    public Auction(){

        this.bids = new ArrayList<Bid>();
        this.barrier = new CyclicBarrier(BIDS_NUMBER,
                new Runnable() {
                    @Override
                    public void run() {

                        Bid winner = Auction.this.defineWinner();
                        System.out.println("Ставка №" +
                                winner.getBidId() + ",ценв" +
                                winner.geyPrice() + " победила!");
                    }
                });

    }

    public boolean add(Bid e){
        return bids.add(e);
    }

    private Bid defineWinner() {
        return Collections.max(bids, new Comparator<Bid>() {
            @Override
            public int compare(Bid o1, Bid o2) {
                return o1.geyPrice() - o2.geyPrice();
            }
        });
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }
}
