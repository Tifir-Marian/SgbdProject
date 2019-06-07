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
public abstract class AlbumSong {
    protected int ID;
    protected int ID_Album;
    protected int ID_Song;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Album() {
        return ID_Album;
    }

    public void setID_Album(int ID_Album) {
        this.ID_Album = ID_Album;
    }

    public int getID_Song() {
        return ID_Song;
    }

    public void setID_Song(int ID_Song) {
        this.ID_Song = ID_Song;
    }
}
