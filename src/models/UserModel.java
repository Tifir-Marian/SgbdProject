/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import abstractclass.tables.User;
import dbconnection.Database;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author User
 */
public final class UserModel extends User {

    public UserModel(int ID, String user_name, String email, String password, java.sql.Date date ) {
        this.ID = ID;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.create_date = date;
    }

    public UserModel() {}
    
    public int GetNextUserId(){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getId = tempCon.prepareCall("{? = call get_next_id(?)}");
            getId.registerOutParameter(1, java.sql.Types.INTEGER);
            getId.setString(2, "User_app");getId.execute();
            int value = getId.getInt(1);
            getId.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    return 0;
    }
    public String GetUserPassword(String name){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getUserID = tempCon.prepareCall("{? = call get_user_password(?)}");
            getUserID.registerOutParameter(1, java.sql.Types.VARCHAR);
            getUserID.setString(2, name);
            getUserID.execute();
            String value = getUserID.getString(1);
             getUserID.close();
            return value;
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Boolean FindPassword(String password){
        try {
            Connection tempCon = Database.getConnection();
            CallableStatement getPassID = tempCon.prepareCall("{? = call get_user_password_id(?)}");
            getPassID.registerOutParameter(1, java.sql.Types.INTEGER);
            getPassID.setString(2, password);
            getPassID.execute();
            if(getPassID.getInt(1) != 0){
                getPassID.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


  
}
