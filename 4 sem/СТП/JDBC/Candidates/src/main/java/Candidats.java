public class Candidats {
    private int id;
    private String last_name;
    public Candidats(int id, String last_name, int countUsers) {
        this.id = id;
        this.last_name = last_name;
        this.countUsers = countUsers;
    }

public Candidats() {}
    private int countUsers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getCountUsers() {
        return countUsers;
    }

    public void setCountUsers(int countUsers) {
        this.countUsers = countUsers;
    }
}
