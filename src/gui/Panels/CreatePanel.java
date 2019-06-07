/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import gui.Frames.AddSongFrame;
import gui.Frames.NameAlbumFrame;
import gui.Frames.NamePlaylistFrame;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panoul de comanda pentru crearea de Albume,melodii si playlisturi
 * @author User
 */
public class CreatePanel {
   public JPanel createPanel = new JPanel();
   public Button createAlbum = new Button("Add an Album!");
   public Button createSong = new Button("Add a Song!");
   public Button createPlaylist = new Button("Create a Playlist!");
   

    public CreatePanel() {
        init();
    }
    private void init(){
        createPanel.setBorder(new LineBorder((Color.GRAY),2));
        createPanel.setLayout(new GridLayout(1,3));
        createPanel.add(createAlbum);
        createPanel.add(createSong);
        createPanel.add(createPlaylist);

    }

    public JPanel getCreatePanel() {
        return createPanel;
    }

    
}
