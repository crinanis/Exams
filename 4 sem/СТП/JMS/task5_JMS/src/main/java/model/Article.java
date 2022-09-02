package model;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private String title;
    private Date date;

    public Article(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String toString() {
        return  "\"title\":\"" + title + "\"\n" +
                "\"date\":\"" + date + "\"";
    }
}
