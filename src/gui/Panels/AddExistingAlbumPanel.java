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
public class AddExistingAlbumPanel {
    public JTextField album_name = new JTextField();
    public JLabel album_nameLabel = new JLabel("Album name");
    public Button addExistingAlbum = new Button("Add an album to your playlist");
   
    public AddExistingAlbumPanel() {
    }

    public JTextField getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(JTextField album_name) {
        this.album_name = album_name;
    }

    public JLabel getAlbum_nameLabel() {
        return album_nameLabel;
    }

    public void setAlbum_nameLabel(JLabel album_nameLabel) {
        this.album_nameLabel = album_nameLabel;
    }

    public Button getAddExistingAlbum() {
        return addExistingAlbum;
    }

    public void setAddExistingAlbum(Button addExistingAlbum) {
        this.addExistingAlbum = addExistingAlbum;
    }
    
}
