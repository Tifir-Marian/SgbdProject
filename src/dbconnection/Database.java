/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Database {
   private static Connection connection = null;
   private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
   private static final String USER = "student";
   private static final String PASSWORD = "STUDENT";
   private Database() { }
   
   private static void createConnection()  {
        try {  
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connectare reusita la baza de date Spotify");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Deconnectare reusita!");
        } catch (SQLException ex) {
            System.out.println("Decconectare esuata!");
        }
    }
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        
        return connection;
    }
}
