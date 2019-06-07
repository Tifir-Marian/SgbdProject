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
import models.PlaylistSongModel;

/**
 *
 * @author User
 */
public class PlaylistSongInsert {

    public PlaylistSongInsert() {
    }
    public PlaylistSongInsert(PlaylistSongModel playlistSongModel)
    {
        Insert(playlistSongModel.GetNextPlaylistSongId(),playlistSongModel.getID_Playlist(),playlistSongModel.getID_Song());
    }

    private void Insert(int id,int id_playlist, int id_song) {
        Connection con = Database.getConnection();
        try {
            CallableStatement insertCommand = con.prepareCall("{call insert_playlist_songs(?,?,?)}");
            insertCommand.setInt(1, id);
            insertCommand.setInt(2, id_playlist);
            insertCommand.setInt(3, id_song);
            insertCommand.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex);
            new InvalidDataFrame("Inserare PlaylistSong").setVisible(true);
        }
    }
}
