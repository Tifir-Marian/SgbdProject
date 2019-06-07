/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;


import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author User
 */
public class MFControlPanel extends JPanel{
    JPanel controlPanel = new JPanel() ;
    Button login = new Button("Login");
    Button register = new Button("Register");
    Button loglessUser = new Button("Proceed without login");
    public JPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(JPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
   
    private void init()
    {
        controlPanel.setBorder(new LineBorder((Color.GRAY),2));
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.add(login);
        controlPanel.add(register);
        controlPanel.add(loglessUser);
       
    }

    public Button getLogin() {
        return login;
    }

    public Button getRegister() {
        return register;
    }

    public Button getLoglessUser() {
        return loglessUser;
    }
    public MFControlPanel() {
      init();
    }
    
}
