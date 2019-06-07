/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;
import abstractclass.components.FrameCreate;
import datamanipulation.PasswordDecript;
import datamanipulation.UserInsert;
import gui.Panels.RegisterPanel;
import static interfaces.connectors.iGoToMainFrame.goToMainFrame;
import static interfaces.connectors.iRegister.register;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import models.UserModel;

/**
 *
 * @author User
 */
public class RegisterFrame extends FrameCreate {
    
    RegisterPanel registerPanel = new RegisterPanel();

    public RegisterFrame() {
        super("Register");
        ButtonController();
    }
    
    private void ButtonController()
    {
        this.setSize(320, 240);
        container.add(registerPanel.getRegisterPanel(),BorderLayout.PAGE_START);
        RegisterPanel.register.addActionListener((ActionEvent e) -> {
        if(e.getSource() == register)
            {
                UserModel userModel = new UserModel();
                userModel.setUser_name(registerPanel.getUser().getText());
                String salt = PasswordDecript.getSalt(30);
                String mySecurePassword = PasswordDecript.generateSecurePassword(String.valueOf(registerPanel.getPass().getPassword()), salt);
                userModel.setEmail(registerPanel.getEmail().getText());
                userModel.setPassword(salt+" "+mySecurePassword);
                UserInsert userInsert = new UserInsert(userModel);
                new LoginFrame().setVisible(rootPaneCheckingEnabled);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
        RegisterPanel.goToMainFrame.addActionListener((ActionEvent e)->{
            if(e.getSource()==goToMainFrame)
            {
                new MainFrame().setVisible(true);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    
    
    
}
