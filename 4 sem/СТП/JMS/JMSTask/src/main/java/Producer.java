import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;
import java.util.Date;

public class Producer {
    public static void main(String[] args) {

        System.out.println("Producer start work");
        ConnectionFactory factory = new ConnectionFactory();

        try(JMSContext connection = factory.createContext("admin","admin", JMSContext.SESSION_TRANSACTED)){
            factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination dest = connection.createTopic("ArticleTopic");
            JMSProducer producer  = connection.createProducer();

            for(int i =0;i<5;++i){
                Article article = new Article();
                article.setText("Message " + (i+1));
                article.setDate(new Date());
                ObjectMessage message = connection.createObjectMessage(article);
                producer.send(dest, message);
                System.out.println("Message " + (i+1) + " send...");
            }

            System.out.println("Producer ended work...");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
