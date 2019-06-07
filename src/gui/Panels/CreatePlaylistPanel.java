/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
 *
 * @author User
 */
public class CreatePlaylistPanel  {
    JPanel createPlaylistPanel = new JPanel();
    public AddExistingSongPanel addExistingSongPanel = new AddExistingSongPanel();
    public AddExistingPlaylistPanel addExistingPaylistPanel = new AddExistingPlaylistPanel();
    public AddExistingAlbumPanel addExistingAlbumPanel = new AddExistingAlbumPanel();
    public Button addSong = new Button("Add a new song");
    public Button currentPlaylistSongs = new Button("View current existing songs");
    public CreatePlaylistPanel() {
    init();
    }
    
    private void init()
    {
        createPlaylistPanel.setBorder(new LineBorder((Color.GRAY),2));
        createPlaylistPanel.setLayout(new GridLayout(4,3));
        createPlaylistPanel.add(addExistingAlbumPanel.album_nameLabel);
        createPlaylistPanel.add(addExistingAlbumPanel.album_name);
        createPlaylistPanel.add(addExistingAlbumPanel.addExistingAlbum);   
        createPlaylistPanel.add(addExistingPaylistPanel.playlist_nameLabel);
        createPlaylistPanel.add(addExistingPaylistPanel.playlist_name);
        createPlaylistPanel.add(addExistingPaylistPanel.addExistingPlaylist);
        createPlaylistPanel.add(addExistingSongPanel.nameLabel);
        createPlaylistPanel.add(addExistingSongPanel.name);
        createPlaylistPanel.add(addExistingSongPanel.addExistingSong);
        createPlaylistPanel.add(addExistingSongPanel.artist_nameLabel);
        createPlaylistPanel.add(addExistingSongPanel.artist_name);
 
    }
     
    public JPanel getCreatePlaylistPanel() {
        return createPlaylistPanel;
    }

}
