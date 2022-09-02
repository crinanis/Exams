package com.example.LoginSum;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static final String url = "jdbc:mysql://localhost/exam?serverTimezone=Europe/Moscow&useSSL=false";
    public static final String root = "root";
    public static final String pass = "123hateGnom546";

    public static  Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getConstructor().newInstance();
            return DriverManager.getConnection(url,root,pass);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
