/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.components;

import java.awt.Button;

/**
 *
 * @author User
 */
public abstract class TrendingPackage {
        public Button artistTrendingButton = new Button("Trending artists!");
        public Button songTrendingButton = new Button("Trending songs!");
        public Button albumTrendingButton = new Button("Trending albums!");

    public Button getArtistTrendingButton() {
        return artistTrendingButton;
    }

    public void setArtistTrendingButton(Button artistTrendingButton) {
        this.artistTrendingButton = artistTrendingButton;
    }

    public Button getSongTrendingButton() {
        return songTrendingButton;
    }

    public void setSongTrendingButton(Button songTrendingButton) {
        this.songTrendingButton = songTrendingButton;
    }

    public Button getAlbumTrendingButton() {
        return albumTrendingButton;
    }

    public void setAlbumTrendingButton(Button albumTrendingButton) {
        this.albumTrendingButton = albumTrendingButton;
    }
        
}
