package SAX;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class SaxRunner {
    public static void main(String[] args) {
        try {
            CardHandler sh = new CardHandler();
            XMLReader xmlReader=null;
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(sh);
            xmlReader.parse("D:\\GIT\\JAVA_EXAM\\workWithXML\\src\\main\\java\\files\\card.xml");

            Set<Card> a = sh.getCards();
            System.out.println(sh.getCards());

        } catch (SAXException e) {
            System.out.println(e.getException());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
