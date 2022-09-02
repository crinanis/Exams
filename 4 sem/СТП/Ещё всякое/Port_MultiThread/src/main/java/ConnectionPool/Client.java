package ConnectionPool;

public class Client  extends Thread{

    private boolean reading  =false;
    private  ConnectionPool<Connect> pool;
    public Client(ConnectionPool<Connect> pool){
        this.pool  =pool;
    }

    @Override
    public void run() {
        Connect connect = null;
        try {
            connect = pool.getResource(500);
            reading = true;
            System.out.println("Соеденения клиент №"+this.getId() + " соеденение №" + connect.getConnectID());
            connect.using();
        } catch (Exception e) {
            System.out.println(this.getId() + " отказано в соеденении");
        }finally {
            if(connect!=null){
                reading=false;
                System.out.println("Соеденения клиент №"+this.getId() + " :" + connect.getConnectID() + " отсойденился");
                pool.returnResource(connect);
            }
        }
    }

    public boolean isReading() {
        return reading;
    }
}
