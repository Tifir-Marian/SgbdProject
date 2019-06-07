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
public abstract class AlbumSearchPackage {
    private final JLabel albumLabel = new JLabel("Type the name of an album");
    public Button albumSearchButton = new Button("Search the album");
    private JTextField albumSearch= new JTextField();

    public JLabel getAlbumLabel() {
        return albumLabel;
    }

    public Button getAlbumSearchButton() {
        return albumSearchButton;
    }

    public JTextField getAlbumSearch() {
        return albumSearch;
    }


    
}
