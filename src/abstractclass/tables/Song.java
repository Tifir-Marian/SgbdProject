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
public  abstract class Song {
    protected int ID;
    protected String name;
    protected int ID_artist;
    protected String album_name;
    protected String genre_name;
    protected Integer likes;
    protected Integer dislikes;
    protected Integer vizualizari;
    protected String duratie;

    public Integer getVizualizari() {
        return vizualizari;
    }

    public void setVizualizari(Integer vizualizari) {
        this.vizualizari = vizualizari;
    }
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID_artist() {
        return ID_artist;
    }

    public void setID_artist(int ID_artist) {
        this.ID_artist = ID_artist;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getDuratie() {
        return duratie;
    }

    public void setDuratie(String duratie) {
        this.duratie = duratie;
    }

}
