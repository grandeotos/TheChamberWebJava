package mx.tec.TheChamberWeb.gamer.dao;

import mx.tec.TheChamberWeb.gamer.model.Gamer;
import mx.tec.TheChamberWeb.util.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GamerIdentDao implements IGamerIdentDao {

    @Override
    public Gamer register(String gamerID, String firstName, String lastName, String password, String email, String curp){
        // "SELECT * FROM accounts WHERE username = " + user + " AND password = " + password
        // X SQL Injection
        String sql = "INSERT INTO `gamerids` (`gamerId`, `firstName`, `lastName`, `password`, `email`, `curp`) VALUES (?, ?, ?, ?, ?, ?);";
        String sqluser = "SELECT idCandidato, gamerId, firstName, lastName, password, email, curp FROM gamerids WHERE gamerId = ? AND password = ?;";
        try{
            Connection conexion = MySQLConnection.getConnection();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, gamerID);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, curp);
            //ResultSet tiene los resultados del SELECT
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            Connection conexion2 = MySQLConnection.getConnection();
            PreparedStatement newpreparedStatement = conexion2.prepareStatement(sqluser);
            newpreparedStatement.setString(1, gamerID);
            newpreparedStatement.setString(2, password);
            System.out.println(newpreparedStatement);
            ResultSet resultSet = newpreparedStatement.executeQuery();
            if(resultSet.next()){
                Gamer gamer = new Gamer();
                gamer.setIdCandidato(resultSet.getInt("idCandidato"));
                gamer.setGamerID(resultSet.getString("gamerId"));
                gamer.setFirstName(resultSet.getString("firstName"));
                gamer.setLastName(resultSet.getString("lastName"));
                gamer.setPassword(resultSet.getString("password"));
                gamer.setEmail(resultSet.getString("email"));
                gamer.setCurp(resultSet.getString("curp"));
                preparedStatement.close();
                conexion.close();
                conexion2.close();
                return gamer;
            }else{
                return null;
            }
        }catch(Exception ex){
            System.out.println(ex.getClass().getCanonicalName() + " e " + ex.getMessage());
        }
        return null;
    }
}
