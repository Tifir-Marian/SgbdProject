/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import datamanipulation.AlbumInsert;
import datamanipulation.ArtistInsert;
import gui.Panels.NameAlbumPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import models.AlbumModel;
import models.ArtistModel;
/**
 *
 * @author User
 */
public class NameAlbumFrame extends FrameCreate{
    
    NameAlbumPanel nameAlbumPanel = new NameAlbumPanel(); 
    
    public NameAlbumFrame(String text) {
        super("Insert the name of the album!");
        buttonsControll();
    }
    public NameAlbumFrame(){
        super("Insert the name of the album!");
        buttonsControll();
    }
    public void buttonsControll(){
       this.setSize(600,100);
       container.add(nameAlbumPanel.getAlbumNamePanel(),BorderLayout.CENTER);
       nameAlbumPanel.nameAlbumButton.addActionListener((ActionEvent e) -> {
           if(e.getSource() == nameAlbumPanel.getNameAlbumButton())
           {
               ArtistModel artistModel = new ArtistModel();
               AlbumModel  albumModel = new AlbumModel(0,nameAlbumPanel.getNameArtist().getText(),nameAlbumPanel.getNameAlbum().getText(),0,0,0);
               if(artistModel.GetArtistIdByName(nameAlbumPanel.getNameArtist().getText()) == 0)
               {
                   artistModel.setStage_name(nameAlbumPanel.getNameArtist().getText());
                   ArtistInsert insert = new ArtistInsert(artistModel); 
                   albumModel = new AlbumModel(0,artistModel.getStage_name(),nameAlbumPanel.getNameAlbum().getText(),0,0,0);
               }
               AlbumInsert insert = new AlbumInsert(albumModel);
               new InsertSongIntoAlbumFrame(albumModel).setVisible(rootPaneCheckingEnabled);
               this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
           }
       });
    }
}
