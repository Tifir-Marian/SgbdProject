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
public abstract class DeletePlaylistPackage {
    private JLabel deleteLabel = new JLabel("Type the name of the playlist you want to delete");
    public Button deletePlaylistButton = new Button("Delete the playlist");
    private JTextField deletePlaylistSearch= new JTextField();

    public JLabel getDeleteLabel() {
        return deleteLabel;
    }

    public void setDeleteLabel(JLabel deleteLabel) {
        this.deleteLabel = deleteLabel;
    }

    public Button getDeletePlaylistButton() {
        return deletePlaylistButton;
    }

    public void setDeletePlaylistButton(Button deletePlaylistButton) {
        this.deletePlaylistButton = deletePlaylistButton;
    }

    public JTextField getDeletePlaylistSearch() {
        return deletePlaylistSearch;
    }

    public void setDeletePlaylistSearch(JTextField deletePlaylistSearch) {
        this.deletePlaylistSearch = deletePlaylistSearch;
    }


    
}
