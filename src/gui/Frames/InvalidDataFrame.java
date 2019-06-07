/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Frames;

import abstractclass.components.FrameCreate;
import gui.Panels.InvalidDataPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;


/**
 *
 * @author User
 */
public class InvalidDataFrame  extends FrameCreate{
    InvalidDataPanel invalidDataPanel = new InvalidDataPanel();
    
    
    public InvalidDataFrame()
    {
        super();
        add();
    }
    public InvalidDataFrame(String nume)
    {
        super();
        invalidDataPanel = new InvalidDataPanel(nume); 
        add();
    }
    
    private void add()
    {
        setSize(400,60);
        container.add(invalidDataPanel.getInvalidData(),BorderLayout.CENTER);
    }
}
