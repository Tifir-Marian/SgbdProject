/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author User
 */
public class NamePlaylistPanel {
    private final JPanel nameplaylistPanel = new JPanel();
    private final JTextField playlist_name=new JTextField();
    private final JLabel playlist_nameLabel = new JLabel("Insert playlist name");
    public Button playlist_nameButton = new Button("Add name");

    public NamePlaylistPanel() {
        init();
    }

    private void init(){
        nameplaylistPanel.setBorder(new LineBorder((Color.GRAY),2));
        nameplaylistPanel.setLayout(new GridLayout(3,1));
        nameplaylistPanel.add(playlist_nameLabel);
        nameplaylistPanel.add(playlist_name);
        nameplaylistPanel.add(playlist_nameButton);
    }
    public JTextField getPlaylist_name() {
        return playlist_name;
    }

    public JLabel getPlaylist_nameLabel() {
        return playlist_nameLabel;
    }

    public Button getPlaylist_nameButton() {
        return playlist_nameButton;
    }

    public JPanel getNameplaylistPanel() {
        return nameplaylistPanel;
    }
    
}
