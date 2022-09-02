package ConnectionPool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ConnectionPool <T> {

    private final static int POOL_SIZE = 3;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> resources = new LinkedList<T>();


    public ConnectionPool(Queue<T> source){
        resources.addAll(source);
    }

    public T getResource(long maxWaitMillis) throws Exception {
        try {
            if(semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)){
                T res = resources.poll();
                return res;
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        throw new Exception(":превышено время ожидания");
    }

    public void returnResource(T res){
        resources.add(res);
        semaphore.release();
    }


}
