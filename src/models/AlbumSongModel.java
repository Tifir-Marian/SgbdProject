/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.AlbumSong;
import dbconnection.Database;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class AlbumSongModel extends AlbumSong {
    
    public AlbumSongModel(int id,int id_album,int id_song)
    {
        this.ID=id;
        this.ID_Album=id_album;
        this.ID_Song=id_song;
    }
    public AlbumSongModel(){}
    
      public int GetNextPlaylistSongId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Album_songs");
            getId.execute();
            int value =getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
}
