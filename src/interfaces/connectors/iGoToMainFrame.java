/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.connectors;

import java.awt.Button;

/**
 *
 * @author User
 */
public interface iGoToMainFrame {
    final Button goToMainFrame = new Button("Go to first page.");
    default void goToMainFrame(){}
}
