/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Tables;

import abstractclass.components.Tabel;
import dbconnection.Database;
import gui.Frames.InvalidDataFrame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ArtistModel;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author User
 */
public class SongTrendingFrame extends Tabel{

    public SongTrendingFrame() {
        Trending();
    }

    private void Trending() {
      Connection con = Database.getConnection();
        try{
            //artist_id,name,album_name,likes,dislikes,duratie
            String tmp[] = {"Artist Name","Name","Album Name","Likes","Dislikes","Duration"};
             List<String[]> allTheSongs= new ArrayList<>();
            CallableStatement trendingCommand = con.prepareCall("{?=call trending_songs}");
            trendingCommand.registerOutParameter(1, OracleTypes.CURSOR);
            trendingCommand.executeUpdate();
            ResultSet rs = (ResultSet) trendingCommand.getObject(1);
            while(rs.next()){
                ArtistModel artistModel = new ArtistModel();
                allTheSongs.add(new String[] {artistModel.GetArtistNameById(Integer.valueOf(rs.getString(1))),rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5),rs.getString(6)});
            }
            rs.close();
            trendingCommand.close();
            setData(tmp,allTheSongs);
            setSize(800, 500);
        } catch (SQLException ex) {
            System.out.println(ex);
            new InvalidDataFrame("Trending Songs").setVisible(true);
        }    
    }
    
}
