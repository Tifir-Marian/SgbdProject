/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Tables;

import abstractclass.components.Tabel;
import gui.Frames.InvalidDataFrame;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ArtistModel;
import models.SongModel;

/**
 *
 * @author User
 */
public class SongFrame extends Tabel {
        SongModel songModel = new SongModel();
        ArtistModel artistModel = new ArtistModel();
    public SongFrame(String name) {
        super();
        tableInitialization(name);
    }
    public SongFrame() {
        super();
        allTableInitialization();
    }
    private void tableInitialization(String name){
        String tmp[] = {"Name","Artist Name","Album Name","Genre Name","Release Date","Duration","Likes","Dislikes","Views"};
        List<String[]> allTheSongs= new ArrayList<>();
        List<String> songInfo = new ArrayList<>();
        songInfo= songModel.GetSongByName(name);
        System.out.println(songInfo.get(1));
        allTheSongs.add(new String[] {songInfo.get(0),
            String.valueOf(artistModel.GetArtistNameById(Integer.valueOf(songInfo.get(1))))
                ,songInfo.get(2),songInfo.get(3),songInfo.get(4),
                songInfo.get(8),songInfo.get(5),songInfo.get(6),songInfo.get(7)});
        setData(tmp,allTheSongs);
        setSize(800, 75);
        
    }
    private void allTableInitialization(){
           try {
               // name,artist_id,album_name,genre_name,realease_date,likes,dislikes,vizualizari,duratie
            String tmp[] = {"Artist Name","Album Name","Song Name","Genre Name","Release Date","Likes","Dislikes","Views","Duration"};
            List<String[]> allTheSongs= new ArrayList<>();
            ResultSet result= songModel.GetAllSongs();
            while(result.next())
            {
             allTheSongs.add(new String[] {String.valueOf(artistModel.GetArtistNameById(Integer.valueOf(result.getString(2)))),
              result.getString(3),result.getString(1),result.getString(4),result.getString(5)
              ,result.getString(6),result.getString(7),result.getString(8),result.getString(9)});
            }
            setData(tmp,allTheSongs);
            setSize(800, 1000);
            result.close();
        } catch (SQLException ex) {
            new InvalidDataFrame("Search all the songs!").setVisible(true);
            Logger.getLogger(SongFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
