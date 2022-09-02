package topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import model.Article;

import javax.jms.*;

public class ConsumerJMS_2 implements MessageListener {

    public ConsumerJMS_2() {
/*
        Модель подтверждения получения сообщения
        CLIENT_ACKNOWLEDGE
           требует явного подтверждения - acknowledge() из приемника
*/
        ConnectionFactory factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.CLIENT_ACKNOWLEDGE)) {
            factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676;mq://127.0.0.1:7676");

            Destination destination = context.createTopic("Article");
            JMSConsumer consumer = context.createConsumer(destination);
            consumer.setMessageListener(this);
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("New message:");
            System.out.println(message.getBody(Article.class));
            //message.acknowledge(); // <- явное подтверждение
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConsumerJMS_2();
    }
}
