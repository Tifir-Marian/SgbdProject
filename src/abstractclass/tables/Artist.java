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
public abstract class Artist {
    protected int ID;
    protected String stage_name;
    protected String debut_year;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }

    public String getDebut_year() {
        return debut_year;
    }

    public void setDebut_year(String debut_year) {
        this.debut_year = debut_year;
    }
}
