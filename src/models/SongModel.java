/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.Song;
import dbconnection.Database;
import gui.Frames.InvalidDataFrame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author User
 */
public final class SongModel extends Song {
 
    public SongModel(int ID, String name,int id_artist, String album_name, String genre_name, Integer likes, Integer dislikes, Integer vizualizari,String duratie) {
        this.ID = ID;
        this.name = name;
        this.ID_artist = id_artist;
        this.album_name = album_name;
        this.genre_name = genre_name;
        this.likes = likes;
        this.dislikes = dislikes;
        this.vizualizari = vizualizari;
        this.duratie = duratie;
    }
    public SongModel() {
    }

   public int GetNextSongId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Song");
            getId.execute();
            int value=getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
   public int GetSongId(String name)
   {
       try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_song_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, name);
            getId.execute();
            int value =getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
   public List<String> GetSongByName(String name)
   {

        try {
            //name,artist_id,album_name,genre_name,realease_date,likes,dislikes,vizualizari,duratie
            List<String> songInfo = new ArrayList<>();
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_song_by_name(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setString(2, name);
            getId.executeQuery();
            ResultSet rs =(ResultSet) getId.getObject(1);
            while(rs.next()){
                songInfo.add(rs.getString(1));
                songInfo.add(rs.getString(2));
                songInfo.add(rs.getString(3));
                songInfo.add(rs.getString(4));
                songInfo.add(rs.getString(5));
                songInfo.add(rs.getString(6));
                songInfo.add(rs.getString(7));
                songInfo.add(rs.getString(8));
                songInfo.add(rs.getString(9));
            }
            rs.close();
            getId.close();
            return songInfo; 
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get a song!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   public List<String> GetSongByPlaylistId(int id)
   {

        try {
            List<String> Song=new ArrayList<>();
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_the_songs_by_playlist_id(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setInt(2,id);
            getId.executeQuery();
            ResultSet rs =(ResultSet) getId.getObject(1);
            while(rs.next())
            {
            Song.add(rs.getString(1));
            Song.add(rs.getString(9));
            Song.add(rs.getString(2));
            Song.add(rs.getString(3));
            Song.add(rs.getString(4));
            Song.add(rs.getString(5));
            Song.add(rs.getString(6));
            Song.add(rs.getString(7));
            Song.add(rs.getString(8));
            }
            rs.close();
            getId.close();
            return  Song;
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get a song!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   public ResultSet GetSongIdByPlaylistId(int ID)
   {
       try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_id_of_song_by_playlist_id(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setInt(2, ID);
            getId.executeQuery();
            return  (ResultSet) getId.getObject(1);
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get a song!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   public List<String[]> GetSongsByAlbumName(String name){
        try {
            //name,artist_id,album_name,genre_name,realease_date,likes,dislikes,vizualizari
            List<String[]> songFromAlbum= new ArrayList<>();
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_the_songs_by_album_name(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setString(2, name);
            getId.executeQuery();
            ResultSet rs =(ResultSet) getId.getObject(1);
            while(rs.next())
            {
                songFromAlbum.add(new String[] {rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8)});
            }
            rs.close();
            return  songFromAlbum;
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get a song!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   public ResultSet GetAllSongs(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_all_songs}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.executeQuery();
            return  (ResultSet) getId.getObject(1);
        
        } catch (SQLException ex) {
            new InvalidDataFrame("Get all the songs!").setVisible(true);
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
}
