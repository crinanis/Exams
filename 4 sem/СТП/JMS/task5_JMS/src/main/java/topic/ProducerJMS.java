package topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import model.Article;

import javax.jms.*;
import java.util.Date;

public class ProducerJMS {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination destination = context.createTopic("Article");
            JMSProducer producer = context.createProducer();
            Article article = new Article("test", new Date());
            ObjectMessage msg = context.createObjectMessage(article);
            producer.send(destination, msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
