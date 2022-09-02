package ConnectionPool;

import java.util.Random;

public class Connect {

    private  int connectID;
    public Connect(int id){
        this.connectID = id;
    }

    public int getConnectID() {
        return connectID;
    }

    public void setConnectID(int connectID) {
        this.connectID = connectID;
    }
    public void using(){
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
