/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class AddExistingPlaylistPanel {
    public JTextField playlist_name = new JTextField();
    public JLabel playlist_nameLabel = new JLabel("Playlist name");
    public Button addExistingPlaylist = new Button("Add an playlist to your playlist");

    public AddExistingPlaylistPanel() {
    }


    public JTextField getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(JTextField playlist_name) {
        this.playlist_name = playlist_name;
    }

    public JLabel getPlaylist_nameLabel() {
        return playlist_nameLabel;
    }

    public void setPlaylist_nameLabel(JLabel playlist_nameLabel) {
        this.playlist_nameLabel = playlist_nameLabel;
    }

    public Button getAddExistingPlaylist() {
        return addExistingPlaylist;
    }

    public void setAddExistingPlaylist(Button addExistingPlaylist) {
        this.addExistingPlaylist = addExistingPlaylist;
    }
    
}
