/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamanipulation;

import dbconnection.Database;
import gui.Frames.InvalidDataFrame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.UserModel;

/**
 *
 * @author User
 */
public class UserInsert {
    
    public UserInsert(UserModel userModel)
    {
         Insert(userModel.GetNextUserId(),userModel.getUser_name(),userModel.getEmail(),userModel.getPassword(),getDate());
    }
    private java.sql.Date getDate(){
               java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            return sqlDate;
    }
    private void Insert(int id ,String user_name,String email,String password,java.sql.Date date)
    {
        Connection con = Database.getConnection();
        try {            
            CallableStatement insertCommand = con.prepareCall("{call insert_user_app(?,?,?,?,?)}");
            insertCommand.setInt(1, id);
            insertCommand.setString(2, user_name);
            insertCommand.setString(3, email);
            insertCommand.setString(4, password);
            insertCommand.setDate(5, date);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Inserare User").setVisible(true);
        }
    }
}
