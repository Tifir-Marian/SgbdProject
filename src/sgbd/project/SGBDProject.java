/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgbd.project;

import dbconnection.Database;
import gui.Frames.MainFrame;

/**
 *
 * @author User
 */
public class SGBDProject {
    public static class CurrentUser
    {
        private Boolean isConnected = false;
        private String user_name = "";
         private static CurrentUser single_instance = null; 
        private CurrentUser() {
        }
        
        private CurrentUser(String user_name) {
            setIsConnected(true);
            setUser_name(user_name);
        }
        
        public static CurrentUser getInstance()
        {
            if (single_instance == null) 
            single_instance = new CurrentUser(); 
  
        return single_instance; 
        }
        
        public static CurrentUser getInstance(String user_name)
        {
            if (single_instance == null) 
            single_instance = new CurrentUser(user_name); 
  
        return single_instance; 
        }
        
        public Boolean getIsConnected() {
            return isConnected;
        }

        public void setIsConnected(Boolean isConnected) {
            this.isConnected = isConnected;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database.getConnection();
        new MainFrame().setVisible(true);

    }
    
}
