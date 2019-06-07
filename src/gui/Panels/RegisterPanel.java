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
import interfaces.connectors.iRegister;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


/**
 *
 * @author User
 */
public class RegisterPanel implements iRegister,iGoToMainFrame{
    
    JPanel registerPanel = new JPanel();
    public RegisterPanel() {
        init();
    }
    
    private void init()
    {
        registerPanel.setBorder(new LineBorder((Color.GRAY),2));
        registerPanel.setLayout(new GridLayout(8,1));
        registerPanel.add(userLabel);
        registerPanel.add(user);
        registerPanel.add(emailLabel);
        registerPanel.add(email);
        registerPanel.add(passwordLabel);
        registerPanel.add(password);
        registerPanel.add(register);
        registerPanel.add(goToMainFrame);
    }
    
    public JPanel getRegisterPanel() {
        return registerPanel;
    }

}
