/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Tables;

import abstractclass.components.Tabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.AlbumModel;
import models.ArtistModel;
import models.SongModel;



/**
 *
 * @author User
 */
public final class AlbumFrame extends Tabel {
    AlbumModel albumModel = new AlbumModel(); 
    SongModel songModel = new SongModel();
    ArtistModel artistModel = new ArtistModel();
    public AlbumFrame(String name) {
        super();
        TableInitialization(name);
    }
    public AlbumFrame(){
        super();
        AllTableInitialization();
    }
    
    protected void TableInitialization(String name){
        String tmp[] = {"Artist Name","Album Name","Song Name","Genre_Name","Release Date","Likes","Dislikes","Views"};
        List<String[]> allTheSongs= new ArrayList<>();
        List<String> albumInfo=new ArrayList<>();
        List<String[]> songs = new ArrayList<>();
        List<String> songInfo = new ArrayList<>();
        //id,artist_name,name_album,release_date,likes,dislikes,views
        albumInfo =albumModel.GetAlbumByName(name);
        songs = songModel.GetSongsByAlbumName(albumInfo.get(2));
        for(String[] index_Song:songs){
            for(String index:index_Song){
                //name,artist_id,album_name,genre_name,realease_date,likes,dislikes,vizualizari
                songInfo.add(index);
            }
            allTheSongs.add(new String[] {albumInfo.get(1),albumInfo.get(2),songInfo.get(0),songInfo.get(3),
                    songInfo.get(4),songInfo.get(5),songInfo.get(6),songInfo.get(7)});
        songInfo = new ArrayList<>();
        }
        setData(tmp,allTheSongs);
        setSize(800, 800);
        
    }
        protected void AllTableInitialization(){
         try {
            String tmp[] = {"Artist Name","Album Name","Likes","Dislikes","Views"};
            List<String[]> allTheSongs= new ArrayList<>(); 
            ResultSet resultAlbum =albumModel.GetAllAlbums();
            while(resultAlbum.next()){
                     allTheSongs.add(new String[] {resultAlbum.getString(1),resultAlbum.getString(2),resultAlbum.getString(3),resultAlbum.getString(4),
                     resultAlbum.getString(5)});
            }
            resultAlbum.close();
            setData(tmp,allTheSongs);
            setSize(800, 800);
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
