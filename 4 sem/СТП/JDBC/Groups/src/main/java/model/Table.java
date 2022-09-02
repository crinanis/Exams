package model;

public class Table {
    private int id;
    private int groups;
    private String fullname;
    public Table(int id, int groups, String fullname) {
        this.id = id;
        this.groups = groups;
        this.fullname = fullname;
    }
public Table(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGroups() {
        return groups;
    }
    public void setGroups(int groups) {
        this.groups = groups;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
