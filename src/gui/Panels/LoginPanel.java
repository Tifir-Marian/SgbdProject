/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;


import gui.Frames.MainFrame;
import interfaces.connectors.iGoToMainFrame;
import static interfaces.connectors.iGoToMainFrame.goToMainFrame;
import interfaces.connectors.iLogin;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author User
 */
public class LoginPanel implements iLogin,iGoToMainFrame {


    JPanel loginPanel = new JPanel();
      public LoginPanel()
    {
        this.goToMainFrame();
        init();
    }
      
    private void init()
    {
        loginPanel.setBorder(new LineBorder((Color.GRAY),2));
        loginPanel.setLayout(new GridLayout(6,1));
        loginPanel.add(userLabel);
        loginPanel.add(user);
        loginPanel.add(passwordLabel);
        loginPanel.add(password);
        loginPanel.add(login);
        loginPanel.add(goToMainFrame);
        
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

}
