package P2P;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.jmq.jmsserver.core.Producer;

import javax.jms.*;

public class P2Producer {

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();

        try(JMSContext context = factory.createContext("admin","admin")){

            factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination dest = context.createQueue("P2PMess");
            JMSProducer producer = context.createProducer();

            TextMessage message = context.createTextMessage("Hello, muzafackers!!!!");
            producer.send(dest,message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
