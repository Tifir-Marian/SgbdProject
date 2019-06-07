/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.PlaylistSong;
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
public final class PlaylistSongModel extends PlaylistSong{
  
    public PlaylistSongModel(int ID, int ID_Playlist, int ID_Song) {
        this.ID = ID;
        this.ID_Playlist = ID_Playlist;
        this.ID_Song = ID_Song;
    }
    public PlaylistSongModel(){};
    
    public int GetNextPlaylistSongId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Playlist_songs");
            getId.execute();
            int value = getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
}
