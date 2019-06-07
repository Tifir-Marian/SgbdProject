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
import java.sql.SQLException;
import models.ArtistModel;

/**
 *
 * @author User
 */
public class ArtistInsert {

    public ArtistInsert(ArtistModel artistModel) {
        Insert(artistModel.GetNextArtistId(),artistModel.getStage_name(),getDate());
    }
        private java.sql.Date getDate(){
               java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            return sqlDate;
    }
    private void Insert(int id,String name,java.sql.Date date){
        Connection con = Database.getConnection();
        try {
            CallableStatement insertCommand = con.prepareCall("{call insert_artist(?,?,?)}");
            insertCommand.setInt(1, id);
            insertCommand.setString(2, name);
            insertCommand.setDate(3, date);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.print(ex);
            new InvalidDataFrame("Inseare Artist").setVisible(true);
        }
        
    }
}
