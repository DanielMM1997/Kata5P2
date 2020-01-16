package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DataBase {
    private String URL;
    private Connection connection = null;
    
    public DataBase(String URL) {
        this.URL = URL;
    }

    public void open() {
        
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de Datos abierta.");
        } catch (SQLException e){
            System.out.println("Error open: " + e.getMessage());
        }
    }

    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada.");
            } catch (SQLException e){
                System.out.println("Error close: " + e.getMessage());
            }
        }
    }

    public void selectEmails() {
        String SQL = "SELECT * FROM MAIL";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID\tEMAILS");
            while (resultset.next()) {
                System.out.println(resultset.getInt("ID") + "\t" +
                                   resultset.getString("Mail"));
            }
        } catch (SQLException e) {
            System.out.println("Error select: " + e.getMessage());
        }
    }

    public void insertEmail(List<String> lista) {
        String SQL = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement(SQL);
            for (String email : lista) {
                prepareStatement.setString(1, email);
                prepareStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    
    public void deleteEmail(String email) {
        String SQL = "DELETE FROM EMAIL WHERE Mail = " + '"' + email + '"';
        try {
            Statement statement = this.connection.createStatement();
            statement.executeQuery(SQL);
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
