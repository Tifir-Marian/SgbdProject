/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import gui.Panels.LoginPanel;
import gui.Panels.MFControlPanel;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainFrame extends JFrame {
    static int counter =0;
    MFControlPanel controlPanel = new MFControlPanel();
    LoginPanel loginPanel = new LoginPanel();
      public MainFrame(){
        super("Spotify");
        init();
    }
    private void init()
    {
        counter++;
        Container container = this.getContentPane();
        this.setSize(320, 240);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(controlPanel.getControlPanel(),BorderLayout.CENTER);
         controlPanel.getRegister().addActionListener((ActionEvent e) -> {
            if(e.getSource()==controlPanel.getRegister()){            
                new RegisterFrame().setVisible(true);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
        controlPanel.getLogin().addActionListener((ActionEvent e) -> {
            if(e.getSource() == controlPanel.getLogin() ){
                new LoginFrame().setVisible(true);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
        controlPanel.getLoglessUser().addActionListener((ActionEvent e) -> {
          if(e.getSource() == controlPanel.getLoglessUser())
          {
              new NotLoggedUserSearchFrame().setVisible(true);
              this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
          }      
        });
      

    }
    
    
}
