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
public class AddExistingSongPanel {   
    public JTextField name= new JTextField();
    public JTextField artist_name = new JTextField();
    public JLabel nameLabel = new JLabel("Song name");
    public JLabel artist_nameLabel = new JLabel("Artist name");
    public Button addExistingSong = new Button("Add an existing song");
    public AddExistingSongPanel() {
    }


    public Button getAdd() {
        return addExistingSong;
    }

    public void setAdd(Button add) {
        this.addExistingSong = add;
    }


    public JTextField getName() {
        return name;
    }

    public void setName(JTextField name) {
        this.name = name;
    }

    public JTextField getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(JTextField artist_name) {
        this.artist_name = artist_name;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getArtist_nameLabel() {
        return artist_nameLabel;
    }

    public void setArtist_nameLabel(JLabel artist_nameLabel) {
        this.artist_nameLabel = artist_nameLabel;
    }
    
}
