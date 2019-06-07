/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class InvalidDataPanel {
    JPanel invalidData = new JPanel();
    JLabel invalidDataText = new JLabel("Date invalide!");
    
    public InvalidDataPanel()
    {
        init();
    }
    public InvalidDataPanel(String text)
    {
        setInvalidDataText(new JLabel("Erroare la " +text));
        init();
    }
    private void init(){
        invalidData.add(invalidDataText);
    }

    public JPanel getInvalidData() {
        return invalidData;
    }

    public JLabel getInvalidDataText() {
        return invalidDataText;
    }

    public void setInvalidDataText(JLabel invalidDataText) {
        this.invalidDataText = invalidDataText;
    }
    
}
