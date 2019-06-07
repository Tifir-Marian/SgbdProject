/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.tables;

/**
 *
 * @author User
 */
public abstract class PlaylistSong {
    protected int ID;
    protected int ID_Playlist;
    protected int ID_Song;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Playlist() {
        return ID_Playlist;
    }

    public void setID_Playlist(int ID_Playlist) {
        this.ID_Playlist = ID_Playlist;
    }

    public int getID_Song() {
        return ID_Song;
    }

    public void setID_Song(int ID_Song) {
        this.ID_Song = ID_Song;
    }

}
