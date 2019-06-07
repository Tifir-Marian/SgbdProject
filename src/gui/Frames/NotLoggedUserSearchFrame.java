/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import gui.Panels.SearchAndDeletePanel;
import interfaces.connectors.iGoToMainFrame;
import static interfaces.connectors.iGoToMainFrame.goToMainFrame;
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
public class NotLoggedUserSearchFrame extends JFrame implements iGoToMainFrame{
    
    SearchAndDeletePanel searchPanel = new SearchAndDeletePanel();
    private void init(){
        Container container = this.getContentPane();
        this.setSize(625, 125);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(searchPanel.getSearchPanel(),BorderLayout.CENTER);
        container.add(goToMainFrame,BorderLayout.AFTER_LAST_LINE);
        this.goToMainFrame();
        this.setVisible(true);
        goToMainFrame.addActionListener((ActionEvent e) -> {
            if(e.getSource()==goToMainFrame)
            {
                new MainFrame().setVisible(true);
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    
    public NotLoggedUserSearchFrame(){
        super("User not logged!");
        init();
    }
}
