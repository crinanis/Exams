import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class Consumer2 implements MessageListener {
    ConnectionFactory factory = new ConnectionFactory();

    public Consumer2(){

        try(JMSContext context = factory.createContext("admin","admin",JMSContext.CLIENT_ACKNOWLEDGE)){
            context.setClientID("client124");
            factory.setProperty(ConnectionConfiguration.imqAddressList,"mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination dest = context.createTopic("ArticleTopic");
            JMSConsumer consumer = context.createDurableConsumer((Topic) dest,"SecurityCenter");
            consumer.setMessageListener(this);
            System.out.println("Listening started ...");
            Thread.sleep(1000000);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }


    @Override
    public void onMessage(Message message) {
        try {
            Article article = message.getBody(Article.class);
            message.acknowledge();
            System.out.println(article);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Consumer2 consumer = new Consumer2();
    }
}
