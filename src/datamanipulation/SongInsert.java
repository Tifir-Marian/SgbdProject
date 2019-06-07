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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.SongModel;

/**
 *
 * @author User
 */
public class SongInsert {

    public SongInsert() {
    }
    
    public SongInsert(SongModel newSong) 
    {
        Insert(newSong.GetNextSongId(),newSong.getName(),newSong.getID_artist(),newSong.getAlbum_name(),newSong.getGenre_name(),getDate(),newSong.getDuratie());
    }
    private java.sql.Date getDate(){
               java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
            return sqlDate;
    }
    public void InsertSongIntoPlaylist(String song_name,String artist_name,String playlist_name){
         Connection con = Database.getConnection();
         try{
            CallableStatement insertCommand = con.prepareCall("{call add_song_to_playlist(?,?,?)}");
            insertCommand.setString(1,song_name);
            insertCommand.setString(2, artist_name);
            insertCommand.setString(3,playlist_name);
            insertCommand.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex);
            new InvalidDataFrame("Inserare Song Into Your Playlist").setVisible(true);
            }
        
    }
    private void Insert(int id,String name,int artist_id,String album_name,String genre_name,java.sql.Date date,String duratie)
    {
        if(ValidateDuration(duratie)){
        Connection con = Database.getConnection();
        try{
            CallableStatement insertCommand = con.prepareCall("{call insert_song(?,?,?,?,?,?,?,?,?,?)}");
            insertCommand.setInt(1,id);
            insertCommand.setString(2, name);
            insertCommand.setInt(3,artist_id);
            insertCommand.setString(4,album_name);
            insertCommand.setString(5, genre_name);
            insertCommand.setDate(6, date);
            insertCommand.setInt(7,0);
            insertCommand.setInt(8,0);
            insertCommand.setInt(9,0);
            insertCommand.setString(10,duratie);
            insertCommand.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex);
            new InvalidDataFrame("Inserare Song").setVisible(true);
            }
        }
        else
        new InvalidDataFrame("Timpul introdus").setVisible(true);
    }
          private boolean ValidateDuration(String duratie)
      {
          char[] validate = duratie.toCharArray();
          for(char index:validate)
          {
              if(index <'0' || index > '9')
              {
                  if ( index != ':')
                      return false;
              }
          }
          return true;
      }
          
          
}
