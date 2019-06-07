/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.connectors;

import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public interface iRegister {
        final JLabel emailLabel = new JLabel("Insert Email");
        JTextField email = new JTextField();
        final JLabel passwordLabel = new JLabel("Insert Password");
        JPasswordField password = new JPasswordField();
        final JLabel userLabel = new JLabel("Insert Username");
        JTextField user = new JTextField();
        Button register = new Button("Register");
        
    default JTextField getUser() {
        return user;
    }

    default JPasswordField getPass() {
        return password;
    }

    default Button getRegisterButton() {
        return register;
    }
    
    default JTextField getEmail() {
        return email;
    }
}
