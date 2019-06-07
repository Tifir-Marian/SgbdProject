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
public class InsertSongIntoAlbumPanel  {
    
    protected JPanel songPanel = new JPanel();
    public Button listCurrentSongs = new Button("Current album songs");
    public Button addSong = new Button("Add a song");

    public InsertSongIntoAlbumPanel() {
    init();
    }
    private void init()
    {
        
        songPanel.setBorder(new LineBorder((Color.GRAY),2));
        songPanel.setLayout(new GridLayout(1,2));
        songPanel.add(addSong);
        songPanel.add(listCurrentSongs);
    }



    public Button getListCurrentSongs() {
        return listCurrentSongs;
    }



    public JPanel getSongPanel() {
        return songPanel;
    }



    
}
