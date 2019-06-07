/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.Album;
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
public final class AlbumModel extends Album {

    //E cu caps daca e keye primara
    public AlbumModel(int ID, String artist_name, String album_name, int likes, int dislikes, int views) {
        this.ID = ID;
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }
     public AlbumModel(){}
     
     public int GetNextAlbumId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Album");
            getId.execute();
            int value = getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
     public ResultSet GetAlbumNameById(int id)
     {
         try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_album_name_by_id(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setInt(2, id);
            getId.execute();
             return  (ResultSet) getId.getObject(1);
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
        
     public int GetAlbumIdByName(String name)
     {
         try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_album_id_by_name(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, name);
            getId.execute();
            int value = getId.getInt(1);
            getId.close();
             return  value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return 0;
     }
     
     public List<String> GetAlbumByName(String name)
     {
         try {
              // id,artist_name,name_album,release_date,likes,dislikes,views
             List<String> albumInfo=new ArrayList<>();
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_album_by_name(?)}");
            getId.registerOutParameter(1, OracleTypes.CURSOR);
            getId.setString(2, name);
            getId.execute();
            ResultSet rs =(ResultSet) getId.getObject(1);
            while(rs.next()){
                albumInfo.add(rs.getString(1));
                albumInfo.add(rs.getString(2));
                albumInfo.add(rs.getString(3));
                albumInfo.add(rs.getString(4));
                albumInfo.add(rs.getString(5));
                albumInfo.add(rs.getString(6));
                albumInfo.add(rs.getString(7));
            }
            rs.close();
            getId.close();
             return  albumInfo;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
     }
    public ResultSet GetAllAlbums(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_all_albums}");
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
