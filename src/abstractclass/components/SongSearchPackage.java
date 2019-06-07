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
public abstract class SongSearchPackage {
      private final JLabel songLabel = new JLabel("Type the name of a song!");
      public Button songSearchButton = new Button("Search the song");
      private JTextField songSearch= new JTextField();


    public JLabel getSongLabel() {
        return songLabel;
    }

    public Button getSongSearchButton() {
        return songSearchButton;
    }

    public JTextField getSongSearch() {
        return songSearch;
    }
}
