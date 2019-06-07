/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import datamanipulation.AlbumSongInsert;
import datamanipulation.PlaylistSongInsert;
import gui.Panels.AddSongPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import models.SongModel;
import datamanipulation.SongInsert;
import models.AlbumModel;
import models.AlbumSongModel;
import models.ArtistModel;
import models.PlaylistSongModel;

/**
 *
 * @author User
 */
public class AddSongFrame extends FrameCreate {
    AddSongPanel addSongPanel =new AddSongPanel();
    ArtistModel artistModel = new ArtistModel();
    Button addSong = new Button("Add");
    public AddSongFrame() {
        super("Add song");
        panelInitialization();
        SimpleSong();
    }
    public AddSongFrame(AlbumModel albumModel)
    {
        super("Add song");
        panelInitialization();
        AlbumSong(albumModel);
    }
    public AddSongFrame(int playlistId)
    {
        super("Add song");
        panelInitialization();
        PlaylistSong(playlistId);
        
    }
    private void panelInitialization()
    {
        this.setSize(400,170);
        container.add(addSongPanel.getAddSongPanel(),BorderLayout.PAGE_START);
        container.add(addSong,BorderLayout.CENTER);
    }
    private void SimpleSong(){
          addSong.addActionListener((ActionEvent e)->{
            if(e.getSource() == this.addSong)
            {
                ArtistModel artistModel = new ArtistModel();
                Insert(addSongPanel.getName().getText(),addSongPanel.getArtist_name().getText()
                        ,artistModel.GetArtistIdByName(addSongPanel.getArtist_name().getText()),
                        null,addSongPanel.getGenre_name().getText(),addSongPanel.getMin_duration().getText()+":"+
                addSongPanel.getSec_duration().getText());           
            }
        });
    }
    private void AlbumSong(AlbumModel albumName){
        addSong.addActionListener((ActionEvent e)->{
            if(e.getSource() == this.addSong)
            {
                ArtistModel tmpArtist = new ArtistModel();
                InsertAlbumSong(addSongPanel.getName().getText(), artistModel.GetArtistIdByName(addSongPanel.getArtist_name().getText()),
                albumName.getAlbum_name(), addSongPanel.getGenre_name().getText(),albumName.GetAlbumIdByName(albumName.getAlbum_name()),
                addSongPanel.getMin_duration().getText()+":"+addSongPanel.getSec_duration().getText());    
            }
        });
    }
    private void PlaylistSong(int playlistId)
    {
        addSong.addActionListener((ActionEvent e)->{
            if(e.getSource() == this.addSong)
            {

                InsertPlaylistSong(addSongPanel.getName().getText(),artistModel.GetArtistIdByName(addSongPanel.getArtist_name().getText())
                ,"",addSongPanel.getGenre_name().getText(),playlistId,addSongPanel.getMin_duration().getText()+":"+
                addSongPanel.getSec_duration().getText());   
            }     
        });
            
    }
    private void Insert(String name,String artist_name,int artistid,String album_name,String genre_name,String duratie)
    {
        SongModel newSong = new SongModel(0,name,artistid,album_name,genre_name,0,0,0,duratie); 
        SongInsert insertSong = new SongInsert(newSong); 
    }
    
    private void InsertPlaylistSong(String name,int artistid,String album_name,String genre_name,int playlistId,String duratie)
    {
        SongModel newSong = new SongModel(0,name,artistid,album_name,genre_name,0,0,0,duratie);
        SongInsert insertSong = new SongInsert(newSong);
        PlaylistSongModel playlistSongModel =new PlaylistSongModel(0,playlistId,newSong.GetNextSongId()-1);
        PlaylistSongInsert playlistSongInsert = new PlaylistSongInsert(playlistSongModel);
    }
     private void InsertAlbumSong(String name,int artistid,String album_name,String genre_name,int albumId,String duratie)
    {
        SongModel newSong = new SongModel(0,name,artistid,album_name,genre_name,0,0,0,duratie);
        SongInsert insertSong = new SongInsert(newSong);
        AlbumSongModel albumSongModel =new AlbumSongModel(0,albumId,newSong.GetNextSongId()-1);
        AlbumSongInsert albumSongInsert = new AlbumSongInsert(albumSongModel);
    }
}
