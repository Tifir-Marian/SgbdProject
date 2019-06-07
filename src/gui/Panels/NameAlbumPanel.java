/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import java.awt.BorderLayout;
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
public class NameAlbumPanel {
     private JPanel albumNamePanel = new JPanel();
     private JLabel nameAlbumLabel = new JLabel("Album name:");
     private JLabel nameArtistLabel = new JLabel("Artist name:");
     private JTextField nameAlbum = new JTextField();
     private JTextField nameArtist = new JTextField();
     public Button nameAlbumButton = new Button("Set name");
     public NameAlbumPanel(){
         init();
     }
     
     private void init(){
        albumNamePanel.setBorder(new LineBorder((Color.GRAY),2));
        albumNamePanel.setLayout(new GridLayout(3,2));
        albumNamePanel.add(nameAlbumLabel);
        albumNamePanel.add(nameAlbum);
        albumNamePanel.add(nameArtistLabel);
        albumNamePanel.add(nameArtist);
        albumNamePanel.add(nameAlbumButton,BorderLayout.CENTER);
     }
    /* Returneaza numele artistului */
    public JTextField getNameArtist() {
        return nameArtist;
    }
    /*Returneaza numele albumului*/
    public JTextField getNameAlbum() {
        return nameAlbum;
    }
    public Button getNameAlbumButton() {
        return nameAlbumButton;
    }
    public JPanel getAlbumNamePanel() {
        return albumNamePanel;
    }
}
