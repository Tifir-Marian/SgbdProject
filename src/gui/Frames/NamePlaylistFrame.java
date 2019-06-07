/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import datamanipulation.PlaylistInsert;
import gui.Panels.NamePlaylistPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import models.PlaylistModel;
import sgbd.project.SGBDProject;
import sgbd.project.SGBDProject.CurrentUser;

/**
 *
 * @author User
 */
public class NamePlaylistFrame extends FrameCreate {
    NamePlaylistPanel namePlaylistPanel = new NamePlaylistPanel();

    public NamePlaylistFrame(String text) {
        super("Insert the name of the playlisst!");
        buttonsControll();
    }

    public NamePlaylistFrame() {
        super("Insert the name of the playlist!");
        buttonsControll();
    }
    private void buttonsControll(){
        this.setSize(600,100);
        container.add(namePlaylistPanel.getNameplaylistPanel(),BorderLayout.CENTER);
        namePlaylistPanel.playlist_nameButton.addActionListener((ActionEvent e) -> {
            if(e.getSource()==namePlaylistPanel.playlist_nameButton)
            {
                PlaylistModel playlistModel = new PlaylistModel();
                playlistModel.setPlaylist_name(namePlaylistPanel.getPlaylist_name().getText());
                playlistModel.setUser_name(CurrentUser.getInstance().getUser_name());
                PlaylistInsert playlistInsert = new PlaylistInsert(playlistModel);
                new InsertIntoPlaylistFrame(namePlaylistPanel.getPlaylist_name().getText())
                        .setVisible(rootPaneCheckingEnabled);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
