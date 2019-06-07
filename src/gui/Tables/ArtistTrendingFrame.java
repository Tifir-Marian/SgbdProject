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
import oracle.jdbc.OracleTypes;

/**
 *
 * @author User
 */
public class ArtistTrendingFrame extends Tabel{

    public ArtistTrendingFrame() {
        Trending();
    }
    
    
    private void Trending() {
      Connection con = Database.getConnection();
        try{
            String tmp[] = {"Artist","Debut Year"};
             List<String[]> allTheSongs= new ArrayList<>();
            CallableStatement trendingCommand = con.prepareCall("{?=call trending_artist}");
            trendingCommand.registerOutParameter(1, OracleTypes.CURSOR);
            trendingCommand.executeUpdate();
            ResultSet rs = (ResultSet) trendingCommand.getObject(1);
            while(rs.next()){
                allTheSongs.add(new String[] {rs.getString(1),rs.getString(2)});
            }
            rs.close();
            trendingCommand.close();
            setData(tmp,allTheSongs);
            setSize(800, 500);
        } catch (SQLException ex) {
            System.out.println(ex);
            new InvalidDataFrame("Trending Artist").setVisible(true);
        }    
    }
}
