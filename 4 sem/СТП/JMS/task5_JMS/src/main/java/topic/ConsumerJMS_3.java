package topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import model.Article;

import javax.jms.*;

public class ConsumerJMS_3 implements MessageListener {

    public ConsumerJMS_3() {
/*
        Модель подтверждения получения сообщения
        DUPS_OK_ACKNOWLEDGE
           Работа по подтверждению получения сообщения перекладывается на Session
            Если нарушена работа сервера - сообщение будут вновь доставлены
*/
        ConnectionFactory factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin", JMSContext.DUPS_OK_ACKNOWLEDGE)) {
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
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConsumerJMS_3();
    }
}
