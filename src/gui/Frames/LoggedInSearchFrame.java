/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import gui.Tables.AlbumFrame;
import gui.Tables.PlaylistFrame;
import gui.Tables.SongFrame;
import abstractclass.components.FrameCreate;
import datamanipulation.PlaylistDelete;
import dbconnection.Database;
import gui.Panels.CreatePanel;
import gui.Panels.SearchAndDeletePanel;
import gui.Panels.ShowAllPanel;
import gui.Tables.AlbumTrendingFrame;
import gui.Tables.ArtistTrendingFrame;
import gui.Tables.SongTrendingFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import sgbd.project.SGBDProject;
import sgbd.project.SGBDProject.CurrentUser;


/**
 *
 * @author User
 */
public class LoggedInSearchFrame extends FrameCreate {
    SearchAndDeletePanel searchPanel = new SearchAndDeletePanel();
    CreatePanel createPanel = new CreatePanel();
    ShowAllPanel showAllPanel = new ShowAllPanel();
        public LoggedInSearchFrame(){
        super("Hello "+CurrentUser.getInstance().getUser_name()+"!");
        this.setSize(800, 200);
        buttonsControl();
    }
    private void buttonsControl(){
        container.add(searchPanel.getSearchPanel(),BorderLayout.NORTH);
        container.add(showAllPanel.getShowAllPanel(),BorderLayout.LINE_START);
        container.add(createPanel.getCreatePanel(),BorderLayout.LINE_END);
        searchPanel.trending.songTrendingButton.addActionListener((ActionEvent e) ->{
            if(e.getSource()== searchPanel.trending.songTrendingButton)
            {
                new SongTrendingFrame().setVisible(rootPaneCheckingEnabled);
            }
        });
          searchPanel.trending.albumTrendingButton.addActionListener((ActionEvent e) ->{
            if(e.getSource()== searchPanel.trending.albumTrendingButton)
            {
                new AlbumTrendingFrame().setVisible(rootPaneCheckingEnabled);
            }
        });
           searchPanel.trending.artistTrendingButton.addActionListener((ActionEvent e) ->{
            if(e.getSource()== searchPanel.trending.artistTrendingButton)
            {
                new ArtistTrendingFrame().setVisible(true);
            }
        });
        searchPanel.deletePlaylist.deletePlaylistButton.addActionListener((ActionEvent e)->{
            if(e.getSource() == searchPanel.deletePlaylist.getDeletePlaylistButton()){
              new PlaylistDelete().Delete(searchPanel.deletePlaylist.getDeletePlaylistSearch().getText(),SGBDProject.CurrentUser.getInstance().getUser_name());
            }
        });
        searchPanel.songSearch.songSearchButton.addActionListener((ActionEvent e) -> {
            if(e.getSource() == searchPanel.songSearch.songSearchButton)
            {
              new SongFrame(searchPanel.songSearch.getSongSearch().getText()).setVisible(true);
            }
        });
         searchPanel.albumSearch.albumSearchButton.addActionListener((ActionEvent e) -> {
            if(e.getSource() == searchPanel.albumSearch.albumSearchButton)
            {
                new AlbumFrame(searchPanel.albumSearch.getAlbumSearch().getText()).setVisible(true);
            }
        });
          searchPanel.playlistSearch.playlistSearchButton.addActionListener((ActionEvent e) -> {
            if(e.getSource() == searchPanel.playlistSearch.playlistSearchButton)
            {
               new PlaylistFrame(searchPanel.playlistSearch.getPlaylistSearch().getText()).setVisible(true);
            }
           
        });
          showAllPanel.showAllSongs.addActionListener((ActionEvent e) ->{
              if(e.getSource() == showAllPanel.showAllSongs)
            {
                new SongFrame().setVisible(rootPaneCheckingEnabled);
            }
          });
           showAllPanel.showAllAlbums.addActionListener((ActionEvent e)->{
               if(e.getSource() == showAllPanel.showAllAlbums)
            {
                new AlbumFrame().setVisible(rootPaneCheckingEnabled);
            }
           });
           showAllPanel.showAllPlaylists.addActionListener((ActionEvent e)->{
               if(e.getSource() == showAllPanel.showAllPlaylists)
            {
                new PlaylistFrame().setVisible(rootPaneCheckingEnabled);
            }
           });
               
        createPanel.createAlbum.addActionListener((ActionEvent e) -> {
            if(e.getSource() == createPanel.createAlbum)
            {
                new NameAlbumFrame().setVisible(true);
            }
        });
        createPanel.createSong.addActionListener((ActionEvent e) -> {
            if(e.getSource() == createPanel.createSong)
            {
                new AddSongFrame().setVisible(true);
            }
        });
        createPanel.createPlaylist.addActionListener((ActionEvent e) -> {
            if(e.getSource() == createPanel.createPlaylist)
            {
                new NamePlaylistFrame().setVisible(true);
            }
        });
    }

}
