package mx.tec.TheChamberWeb.applicant.dao;

import mx.tec.TheChamberWeb.util.MySQLConnection;
import mx.tec.TheChamberWeb.applicant.model.Applicant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ApplicantDao implements IApplicantDao {

    @Override
    public Applicant register(String gamerID, String firstName, String lastName, String password, String email, String curp){
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
                Applicant applicant = new Applicant();
                applicant.setIdCandidato(resultSet.getInt("idCandidato"));
                applicant.setGamerID(resultSet.getString("gamerId"));
                applicant.setFirstName(resultSet.getString("firstName"));
                applicant.setLastName(resultSet.getString("lastName"));
                applicant.setPassword(resultSet.getString("password"));
                applicant.setEmail(resultSet.getString("email"));
                applicant.setCurp(resultSet.getString("curp"));
                preparedStatement.close();
                conexion.close();
                conexion2.close();
                return applicant;
            }else{
                return null;
            }
        }catch(Exception ex){
            System.out.println(ex.getClass().getCanonicalName() + " e " + ex.getMessage());
        }
        return null;
    }
}
