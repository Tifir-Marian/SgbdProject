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
import models.AlbumModel;
import models.PlaylistModel;

/**
 *
 * @author User
 */
public final class AlbumInsert {

    public AlbumInsert() {
    }

    public AlbumInsert(AlbumModel newAlbum) {
        Insert(newAlbum.GetNextAlbumId(),newAlbum.getArtist_name(),newAlbum.getAlbum_name(),getDate());
    }
    
    private java.sql.Date getDate(){
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        return sqlDate;
    }
    
    public void Insert(int ID,String artist_name, String album_name,java.sql.Date date)
    {
         Connection con = Database.getConnection();
        try {
            CallableStatement insertCommand = con.prepareCall("{call insert_album(?,?,?,?,?,?,?)}");
            insertCommand.setInt(1, ID);
            insertCommand.setString(2, artist_name);
            insertCommand.setString(3, album_name);
            insertCommand.setDate(4, date);
            insertCommand.setInt(5, 0);
            insertCommand.setInt(6, 0);
            insertCommand.setInt(7, 0);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Inseare Album").setVisible(true);
        }
    }
    public void InserAlbumIntoPlaylist(String album_name,String playlist_name)
    {
        Connection con = Database.getConnection();
         try {
            CallableStatement insertCommand = con.prepareCall("{call add_album_to_playlist(?,?)}");
            insertCommand.setString(1, album_name);
            insertCommand.setString(2, playlist_name);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Inseare Album").setVisible(true);
        }   
    }
}
