/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import search.components.AlbumSearchComponentsPackage;
import search.components.DeletePlaylistComponentsPackage;
import search.components.PlaylistSearchComponentsPackage;
import search.components.SongSearchComponenetsPackage;
import search.components.TrendingComponentsPackage;

/**
 * Panoul de comanda pentru panoul de cautare a albumelor,melodiiler si playlisturilor /**
 * Panoul de comanda pentru panoul de cautare a albumelor,melodiiler si playlisturilor 
 * @author User
 */


public class SearchAndDeletePanel {
    public SongSearchComponenetsPackage songSearch = new SongSearchComponenetsPackage();
    public PlaylistSearchComponentsPackage playlistSearch = new PlaylistSearchComponentsPackage();
    public AlbumSearchComponentsPackage albumSearch = new AlbumSearchComponentsPackage();
    public DeletePlaylistComponentsPackage deletePlaylist = new DeletePlaylistComponentsPackage();
    public TrendingComponentsPackage trending = new TrendingComponentsPackage();
    JPanel searchPanel = new JPanel();
    private void init(){
        searchPanel.setBorder(new LineBorder((Color.GRAY),2));
        searchPanel.setLayout(new GridLayout(5,1));
        searchPanel.add(songSearch.getSongLabel());
        searchPanel.add(songSearch.getSongSearch());
        searchPanel.add(songSearch.getSongSearchButton());
        searchPanel.add(albumSearch.getAlbumLabel());
        searchPanel.add(albumSearch.getAlbumSearch());
        searchPanel.add(albumSearch.getAlbumSearchButton());
        searchPanel.add(playlistSearch.getPlaylistLabel());
        searchPanel.add(playlistSearch.getPlaylistSearch());
        searchPanel.add(playlistSearch.getPlaylistSearchButton());
        searchPanel.add(deletePlaylist.getDeleteLabel());
        searchPanel.add(deletePlaylist.getDeletePlaylistSearch());
        searchPanel.add(deletePlaylist.getDeletePlaylistButton());
        searchPanel.add(trending.getArtistTrendingButton());
        searchPanel.add(trending.getAlbumTrendingButton());
        searchPanel.add(trending.getSongTrendingButton());
        
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public SearchAndDeletePanel() {
       init();
    }
    
}
