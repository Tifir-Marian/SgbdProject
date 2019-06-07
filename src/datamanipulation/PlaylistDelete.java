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

/**
 *
 * @author User
 */
public final class PlaylistDelete {
    public PlaylistDelete(){
        
    }
    public PlaylistDelete(String playlistName,String username){
        Delete(playlistName,username);
    }
    public void Delete(String playlistName,String username){
        Connection con = Database.getConnection();
        try{
            CallableStatement deleteCommand = con.prepareCall("{call delete_playlist(?,?)}");
            deleteCommand.setString(1, playlistName);
            deleteCommand.setString(2, username);
            deleteCommand.executeUpdate();
            deleteCommand.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            new InvalidDataFrame("Stergere Playlist").setVisible(true);
        }
    }
}
