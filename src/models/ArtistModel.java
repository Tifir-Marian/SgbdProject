/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import abstractclass.tables.Artist;
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
public final class ArtistModel extends Artist {

    public ArtistModel(int ID, String stage_name, String debut_year) {
        this.ID = ID;
        this.stage_name = stage_name;
        this.debut_year = debut_year;
    }
    public ArtistModel(){}
   
public int GetNextArtistId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "Artist");
            getId.execute();
            int value =getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
   public int GetArtistIdByName(String name){
        try {
            Connection tempCon = Database.getConnection();
            int value;
            CallableStatement getId = tempCon.prepareCall("{? = call get_artist_id(?)}");
                getId.registerOutParameter(1, java.sql.Types.INTEGER);
                getId.setString(2, name);
                getId.execute();
                value = getId.getInt(1);
                getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
   }
   public String GetArtistNameById(int id){
        try {
            Connection tempCon = Database.getConnection();
            String value;
                CallableStatement getId = tempCon.prepareCall("{? = call get_artist_name(?)}");
                getId.registerOutParameter(1, java.sql.Types.VARCHAR);
                getId.setInt(2, id);
                getId.execute();
                value = getId.getString(1);
                getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
}
