import com.sun.messaging.ConnectionConfiguration;

import javax.jms.*;
import com.sun.messaging.ConnectionFactory;

public class Consumer implements MessageListener {

    ConnectionFactory factory = new ConnectionFactory();

    public Consumer(){

        try(JMSContext context = factory.createContext("admin","admin", JMSContext.DUPS_OK_ACKNOWLEDGE)){
            context.setClientID("client234");
            factory.setProperty(ConnectionConfiguration.imqAddressList,"mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination dest = context.createTopic("ArticleTopic");
            JMSConsumer consumer = context.createDurableConsumer((Topic) dest,"SecurityCenter");
            consumer.setMessageListener(this);
            System.out.println("Listening started ...");
            Thread.sleep(100000);
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
            System.out.println(article);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
    }
}
