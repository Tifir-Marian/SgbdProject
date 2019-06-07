package gui.Tables;

import abstractclass.components.Tabel;
import gui.Frames.InvalidDataFrame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ArtistModel;
import models.PlaylistModel;
import models.SongModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class PlaylistFrame extends Tabel{
            PlaylistModel playlistModel = new PlaylistModel();
            SongModel songModel = new SongModel();
            ArtistModel artistModel = new ArtistModel();
    public PlaylistFrame(String name) {
        super();
        TableInitialization(name);
    }
    public PlaylistFrame(){
        super();
        AllTableInitialization();
    }
    private void TableInitialization(String name){
          try {
            String tmp[] = {"Username","Playlist Name","Playlist Create Date","Song Name","Song Duration","Artist"
                    ,"Album Name","Genre Name","Release Date","Likes","Dislikes","Views"};
            List<String[]> allTheSongs= new ArrayList<>();
            int PlaylistID=0;
            List<String> allPlaylistName = new ArrayList<>();
            List<Integer> allSongId = new ArrayList<>();
           ResultSet resultPlaylist= playlistModel.GetPlaylistByName(name);
            while(resultPlaylist.next())
            {
                allPlaylistName.add(resultPlaylist.getString(2));
                 allPlaylistName.add(resultPlaylist.getString(3));                    
                   allPlaylistName.add(resultPlaylist.getString(4));
                   PlaylistID=resultPlaylist.getInt(1);  
            }
            resultPlaylist.close();
             ResultSet resultIdSong = songModel.GetSongIdByPlaylistId(Integer.valueOf(PlaylistID));
            while(resultIdSong.next())
            {allSongId.add(resultIdSong.getInt(1));}
            resultIdSong.close();
            ArtistModel aModel = new ArtistModel();
            for (int index:allSongId){
                
                List<String> resultSong = songModel.GetSongByPlaylistId(index);
                
                allTheSongs.add(new String[] {allPlaylistName.get(0),allPlaylistName.get(1),allPlaylistName.get(2),resultSong.get(0)
                        ,resultSong.get(1),aModel.GetArtistNameById(Integer.valueOf(resultSong.get(2))),resultSong.get(3),resultSong.get(4),resultSong.get(5),resultSong.get(6)
                ,resultSong.get(7),resultSong.get(8)});              
            }

            setData(tmp,allTheSongs);
            setSize(800, 800);
            
        } catch (SQLException ex) {
            new InvalidDataFrame("Search a song!").setVisible(true);
            Logger.getLogger(SongFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
 private void AllTableInitialization(){
          try {
            
            String tmp[] = {"Username","Playlist Name","Playlist Create Date"};
            List<String[]> allTheSongs= new ArrayList<>();    
            ResultSet resultPlaylist= playlistModel.GetAllPlaylist();
            while(resultPlaylist.next())
            {
                        allTheSongs.add(new String[] {resultPlaylist.getString(1),resultPlaylist.getString(2),
                        resultPlaylist.getString(3)});
            }
            resultPlaylist.close();
            setData(tmp,allTheSongs);
            setSize(800, 800);
        } catch (SQLException ex) {
            new InvalidDataFrame("Search a song!").setVisible(true);
            Logger.getLogger(SongFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}