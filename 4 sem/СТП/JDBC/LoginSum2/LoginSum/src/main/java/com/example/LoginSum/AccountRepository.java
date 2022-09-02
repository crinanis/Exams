package com.example.LoginSum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    private Connection connection;

    public AccountRepository(){
        connection  = Connector.getConnection();
    }


    public List<Account> getAll(){

        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM ACCOUNT";

        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(query);
            ResultSet resultSet  = statement.executeQuery();

            while (resultSet.next()){

                Account account = new Account();
                account.setId(resultSet.getInt(1));
                account.setLogin(resultSet.getString(2));
                account.setSum(resultSet.getInt(3));
                accounts.add(account);
            }

            return accounts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    public void transaction(int value, int id){

        PreparedStatement statement = null;
        String query = "update account set sum=? where id=?";

        try {
            statement= connection.prepareStatement(query);
            statement.setInt(1,value);
            statement.setInt(2,id);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



}
