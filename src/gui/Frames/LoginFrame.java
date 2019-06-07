/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;
import datamanipulation.PasswordDecript;
import gui.Panels.LoginPanel;
import static interfaces.connectors.iGoToMainFrame.goToMainFrame;
import static interfaces.connectors.iLogin.login;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import models.UserModel;
import sgbd.project.SGBDProject;

/**
 *
 * @author User
 */
public class LoginFrame extends JFrame {
     LoginPanel loginPanel = new LoginPanel();

    public LoginFrame() {
        super("Login");
        init();
    }
    
    private void init()
    {
        Container container = this.getContentPane();
        this.setSize(320, 240);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(loginPanel.getLoginPanel(),BorderLayout.PAGE_START);
        loginPanel.getLoginButton().addActionListener((ActionEvent e) -> {
            if(e.getSource() == login)
            {
                UserModel userModel = new UserModel();
                userModel.setUser_name(loginPanel.getUser().getText());
                String salt="",securePassword="",aux;
                int schimba=0;
                aux=userModel.GetUserPassword(loginPanel.getUser().getText());
                char[] getSecurePassword = aux.toCharArray();
                for (char index : getSecurePassword)
                {
                    if(index == ' ')
                        schimba++;
                    if(index != ' ')
                    {
                        if(schimba==0)
                        {
                            salt=salt+index;
                        }
                        else
                        {
                            securePassword=securePassword+index;
                        }
                    }
                }
                if(PasswordDecript.verifyUserPassword(String.valueOf(loginPanel.getPassword().getPassword()), securePassword, salt))
                  {
                    SGBDProject.CurrentUser tmp = SGBDProject.CurrentUser.getInstance(userModel.getUser_name());
                    new LoggedInSearchFrame().setVisible(rootPaneCheckingEnabled);
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                  }
                else
                 {
                    new InvalidDataFrame("Loggare").setVisible(rootPaneCheckingEnabled);
                 }
            }
        });
        LoginPanel.goToMainFrame.addActionListener((ActionEvent e) -> {
            if(e.getSource()==goToMainFrame)
            {
                new MainFrame().setVisible(true);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
