/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.components;

import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public abstract class PlaylistSearchPackage {
    private final JLabel playlistLabel = new JLabel("Type the name of a playlist!");
    public Button playlistSearchButton = new Button("Search the playlist");
    private JTextField playlistSearch= new JTextField();

    public JLabel getPlaylistLabel() {
        return playlistLabel;
    }

    public Button getPlaylistSearchButton() {
        return playlistSearchButton;
    }

    public JTextField getPlaylistSearch() {
        return playlistSearch;
    }


    
}
