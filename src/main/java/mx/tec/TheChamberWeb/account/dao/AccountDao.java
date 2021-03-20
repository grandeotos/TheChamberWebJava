package mx.tec.TheChamberWeb.account.dao;

import mx.tec.TheChamberWeb.account.model.Account;
import mx.tec.TheChamberWeb.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao implements IAccountDao{

    @Override
    public Account auth(String user, String password) {
        // "SELECT * FROM accounts WHERE username = " + user + " AND password = " + password
        // X SQL Injection
        String sql = "SELECT id, username, password, email FROM accounts WHERE username = ? AND password = ?";
        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);

            //ResultSet tiene los resultados del SELECT
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Account cuenta = new Account();
                cuenta.setId(resultSet.getInt("id"));
                cuenta.setUser(resultSet.getString("username"));
                cuenta.setPassword(resultSet.getString("password"));
                cuenta.setEmail(resultSet.getString("email"));
                preparedStatement.close();
                conexion.close();
                return cuenta;
            }else{
                return null;
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
