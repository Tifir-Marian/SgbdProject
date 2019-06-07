/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import gui.Panels.InsertSongIntoAlbumPanel;
import gui.Tables.AlbumFrame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import models.AlbumModel;

/**
 *
 * @author User
 */
public class InsertSongIntoAlbumFrame extends FrameCreate {
    InsertSongIntoAlbumPanel insertSongIntoAlbumPanel = new InsertSongIntoAlbumPanel();
    public InsertSongIntoAlbumFrame(AlbumModel albumName) {
        super("Album Create");
        buttonsControll(albumName);
    }
    private void buttonsControll(AlbumModel albumName)
    {
        this.setSize(400, 100);
        container.add(insertSongIntoAlbumPanel.getSongPanel(),BorderLayout.CENTER);
        insertSongIntoAlbumPanel.addSong.addActionListener((ActionEvent e) ->{
            if(e.getSource() == insertSongIntoAlbumPanel.addSong)
            {
                new AddSongFrame(albumName).setVisible(rootPaneCheckingEnabled);
            }
        });
        insertSongIntoAlbumPanel.listCurrentSongs.addActionListener((ActionEvent e)->{
            if(e.getSource() == insertSongIntoAlbumPanel.listCurrentSongs)
            {
                  new AlbumFrame(albumName.getAlbum_name()).setVisible(rootPaneCheckingEnabled);
            }
        });
    } 
            
    
}
