package SAX;

public class Card {

    protected int number;
    private String name;
    protected int sum;
    private String login;

    public Card(){}

    public Card(int number, String name, int sum, String login) {
        this.number = number;
        this.name = name;
        this.sum = sum;
        this.login = login;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "SAX.Card: " + number;
    }
}
