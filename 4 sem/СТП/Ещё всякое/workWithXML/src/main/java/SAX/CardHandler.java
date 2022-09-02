package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;


public class CardHandler extends DefaultHandler {

    String thisElement="";
    private Set<Card> cards;
    private Card current = null;


    public CardHandler(){
        cards = new HashSet<>();
    }


    public Set<Card> getCards() {
        return cards;
    }

    public void startElement(String uri, String localName,
                             String qName, Attributes attrs){
        if("card".equals(localName)){
            current = new Card();
            current.setLogin(attrs.getValue(0));
        }
        thisElement = qName;
    }

    public void endElement(String uri, String localName,
                           String qName){
        if("card".equals(localName)){
            cards.add(current);
        }
        thisElement = "";
    }

    public void characters(char[] ch, int start, int length){
        String s = new String(ch,start,length).trim();

        if(thisElement.equals("name")){
            current.setName(new String(ch,start,length));
        }
        if(thisElement.equals("sum")){
            current.setSum(Integer.parseInt(s));
        }
        if(thisElement.equals("number")){
            current.setNumber(Integer.parseInt(s));
        }

    }
}
