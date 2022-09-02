package SAX;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {

    public void valid(){

        String filename = "D:\\GIT\\JAVA_EXAM\\workWithXML\\src\\main\\java\\files\\card.xml";
        String schemaname = "D:\\GIT\\JAVA_EXAM\\workWithXML\\src\\main\\java\\files\\shema.xsd";
        Schema schema = null;

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);


        try {
            schema=factory.newSchema(new File(schemaname));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);

            CardHandler cardHandler = new CardHandler();
            validator.setErrorHandler(cardHandler);
            validator.validate(source);
            System.out.println("Valid...");
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ValidatorSAX validatorSAX = new ValidatorSAX();
        validatorSAX.valid();
    }


}
