/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.Playlist;
import dbconnection.Database;
import gui.Frames.InvalidDataFrame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author User
 */
public final class PlaylistModel extends Playlist {
    
    public PlaylistModel(int ID, String user_name, String playlist_name, String date_created) {
    this.ID = ID;
    this.user_name = user_name;
    this.playlist_name = playlist_name;
    this.date_created = date_created;
    }
    public PlaylistModel(){}
    
    public int GetNextPlaylistId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Playlist");
            getId.execute();
            int value =getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
   public int GetPlaylistIdByName(String name)
   {
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call playlist_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, name);
            getId.execute();
            int value = getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
  public ResultSet GetPlaylistByName(String name)
   {

        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_playlist_by_name(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setString(2, name);
            getId.executeQuery();
            return  (ResultSet) getId.getObject(1);
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get a playlist!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
  public ResultSet GetAllPlaylist(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_all_playlists}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.executeQuery();
            return  (ResultSet) getId.getObject(1);
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get all the playlists!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
}
