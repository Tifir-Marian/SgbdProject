/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

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
public class AddSongPanel {
    JPanel addSongPanel= new JPanel();
    
    JTextField name= new JTextField();
    JTextField genre_name = new JTextField();
    JTextField artist_name = new JTextField();
    JTextField min_duration = new JTextField();
    JTextField sec_duration = new JTextField();
    
    
    JLabel nameLabel= new JLabel("Enter song name");
    JLabel genre_nameLabel = new JLabel("Enter genre name");
    JLabel artist_nameLabel= new JLabel("Enter artist name");
    JLabel min_durationLabel = new JLabel("Enter min of the song!");
    JLabel sec_durationLabel = new JLabel("Enter sec of the song!");
    
    
    public AddSongPanel() {
    init();
    }

    private void init()
    {
        addSongPanel.setBorder(new LineBorder((Color.GRAY),2));
        addSongPanel.setLayout(new GridLayout(5,2));
        addSongPanel.add(nameLabel);
        addSongPanel.add(name);
        addSongPanel.add(artist_nameLabel);
        addSongPanel.add(artist_name);
        addSongPanel.add(genre_nameLabel);
        addSongPanel.add(genre_name);
        addSongPanel.add(min_durationLabel);
        addSongPanel.add(min_duration);
        addSongPanel.add(sec_durationLabel);
        addSongPanel.add(sec_duration);
    }

    public JTextField getArtist_name() {
        return artist_name;
    }

    public JPanel getAddSongPanel() {
        return addSongPanel;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getGenre_name() {
        return genre_name;
    }

    public JTextField getMin_duration() {
        return min_duration;
    }

    public JTextField getSec_duration() {
        return sec_duration;
    }

    
}
