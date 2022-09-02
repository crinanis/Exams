import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private String text;
    private Date date;

    public Article(){}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return text + " { " + date.toString() + " }";
    }
}
