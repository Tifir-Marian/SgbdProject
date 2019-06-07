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
import models.AlbumSongModel;

/**
 *
 * @author User
 */
public class AlbumSongInsert {

    public AlbumSongInsert() {
    }
     public AlbumSongInsert(AlbumSongModel albumSongModel) {
         Insert(albumSongModel.GetNextPlaylistSongId(),albumSongModel.getID_Album(),albumSongModel.getID_Song());
    }
    
    
     private void Insert(int id,int id_album,int id_song)
    {
         Connection con = Database.getConnection();
        try{
            CallableStatement insertCommand = con.prepareCall("{call insert_album_songs(?,?,?)}");
            insertCommand.setInt(1, id);
            insertCommand.setInt(2, id_album);
            insertCommand.setInt(3, id_song);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            new InvalidDataFrame("Inserare AlbumSong").setVisible(true);
        }
    }
}
