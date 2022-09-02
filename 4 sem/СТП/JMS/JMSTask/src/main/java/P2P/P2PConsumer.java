package P2P;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class P2PConsumer implements MessageListener {

    private ConnectionFactory factory;

    public P2PConsumer(){

        factory = new ConnectionFactory();

        try(JMSContext context = factory.createContext("admin","admin")){

            factory.setProperty(ConnectionConfiguration.imqAddressList,"mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination dest = context.createQueue("P2PMess");
            JMSConsumer consumer  = context.createConsumer(dest);

            consumer.setMessageListener(this);
            Thread.sleep(100000);
        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onMessage(Message message) {
        try {
            String str = message.getBody(String.class);
            System.out.println(str);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        P2PConsumer p2PConsumer = new P2PConsumer();
    }
}
