/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import datamanipulation.AlbumInsert;
import datamanipulation.PlaylistInsert;
import datamanipulation.SongInsert;
import gui.Panels.AddExistingAlbumPanel;
import gui.Panels.AddExistingPlaylistPanel;
import gui.Panels.AddExistingSongPanel;
import gui.Panels.CreatePlaylistPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class InsertIntoPlaylistFrame extends FrameCreate {
    CreatePlaylistPanel createPlaylistPanel = new CreatePlaylistPanel();

    public InsertIntoPlaylistFrame(String playlistName) {
        super("Create Playlist");
        panelInitialization(playlistName); 
    }
    private void panelInitialization(String playlistName)
    {
        this.setSize(600,200);
        container.add(createPlaylistPanel.getCreatePlaylistPanel(),BorderLayout.NORTH);    
        createPlaylistPanel.addExistingSongPanel.addExistingSong.addActionListener((ActionEvent e) -> {
            if(e.getSource() == createPlaylistPanel.addExistingSongPanel.addExistingSong)
            {
                SongInsert songInsert = new SongInsert();
                songInsert.InsertSongIntoPlaylist(createPlaylistPanel.addExistingSongPanel.getName().getText()
                        ,createPlaylistPanel.addExistingSongPanel.getArtist_name().getText(), playlistName);
            }
        });
        createPlaylistPanel.addExistingPaylistPanel.addExistingPlaylist.addActionListener((ActionEvent e)->{
            if(e.getSource() == createPlaylistPanel.addExistingPaylistPanel.addExistingPlaylist)
            {
                PlaylistInsert playlistInsert = new PlaylistInsert();
                playlistInsert.InsertPlaylistIntoPlaylist(
                        createPlaylistPanel.addExistingPaylistPanel.getPlaylist_name().getText(), playlistName);
            }
        });
         createPlaylistPanel.addExistingAlbumPanel.addExistingAlbum.addActionListener((ActionEvent e)->{
             if(e.getSource() == createPlaylistPanel.addExistingAlbumPanel.addExistingAlbum)
            {
                AlbumInsert albumInsert = new AlbumInsert();
                albumInsert.InserAlbumIntoPlaylist( 
                        createPlaylistPanel.addExistingAlbumPanel.getAlbum_name().getText(), playlistName);
            }
        });
    }
}
