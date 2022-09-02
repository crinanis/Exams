package db;

import model.Table;

import java.sql.*;
import java.util.ArrayList;

public class Mytable {
    private static Connection connection;
    private static Statement statement;
    static Integer commonSum = 0;
    public static ArrayList<Table> select(int groups) throws SQLException {
        ArrayList<Table> tables = new ArrayList<Table>();
        try {
            String sql = "SELECT * FROM mytable WHERE mytable.groups= '" + groups + "'";
            statement = GetConnection().createStatement();
            ResultSet resultSet= statement.executeQuery(sql);
                    while (resultSet.next()) {
                        int id1 =resultSet.getInt("id");
                        int groups1 = resultSet.getInt("groups");
                        String fullname1 = resultSet.getString("fullname");
                        Table tb = new Table(id1, groups1, fullname1);
                        tables.add(tb);
                    }
                }
         catch (Exception ex) {
            System.out.println(ex);
        }
        return tables;
    }
    public static Connection GetConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?serverTimezone=Europe/Moscow&useSSL=false",
                    "root", "Ksusha20031007");
            System.out.println("Connection succesfull!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
        return connection;
    }
}
