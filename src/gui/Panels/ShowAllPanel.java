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
public class ShowAllPanel {


     JPanel showAllPanel = new JPanel();
    public Button showAllSongs = new Button("Show all the songs");
    public Button showAllAlbums = new Button("Show all the albums");
    public Button showAllPlaylists = new Button("Show all the playlists");

    public ShowAllPanel() {
        showAllPanel.setBorder(new LineBorder((Color.GRAY),2));
        showAllPanel.setLayout(new GridLayout(1,3));
        showAllPanel.add(showAllSongs);
        showAllPanel.add(showAllAlbums);
        showAllPanel.add(showAllPlaylists);
    }

    public JPanel getShowAllPanel() {
        return showAllPanel;
    }

    
}
