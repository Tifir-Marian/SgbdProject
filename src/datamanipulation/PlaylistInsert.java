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
import models.PlaylistModel;
import sgbd.project.SGBDProject.CurrentUser;

/**
 *
 * @author User
 */
public class PlaylistInsert {

    public PlaylistInsert() {
    }

    
    public PlaylistInsert(PlaylistModel playlistModel) {
        Insert(playlistModel.GetNextPlaylistId(),CurrentUser.getInstance().getUser_name(),playlistModel.getPlaylist_name(),getDate());
    }
    
    private void Insert(Integer ID,String user_name,String playlist_name,java.sql.Date date)
    {
        Connection con = Database.getConnection();
        try{
            CallableStatement insertCommand = con.prepareCall("{call insert_playlist(?,?,?,?)}");
            insertCommand.setInt(1, ID);
            insertCommand.setString(2, user_name);
            insertCommand.setString(3, playlist_name);
            insertCommand.setDate(4,date);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Inserare Playlist").setVisible(true);
        }
    }
    
    
    private java.sql.Date getDate(){
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        return sqlDate;
    }
    
    public void InsertPlaylistIntoPlaylist(String from_playlist_name,String to_playlist_name)
    {
         Connection con = Database.getConnection();
        try{
            CallableStatement insertCommand = con.prepareCall("{call add_playlist_to_playlist(?,?)}");
            insertCommand.setString(1, from_playlist_name);
            insertCommand.setString(2, to_playlist_name);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Inserare Playlist").setVisible(true);
        }
    }
}
