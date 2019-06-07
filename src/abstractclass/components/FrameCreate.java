/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractclass.components;

import java.awt.ComponentOrientation;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public abstract class FrameCreate extends JFrame {
    
    protected Container container = this.getContentPane();

    public Container getContainer() {
        return container;
    }
    public FrameCreate(String text) {
        super(text);
        init();
    }
    public FrameCreate(){
        super();
        init();
    }
    protected void init(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        this.setVisible(true);
    }
}
