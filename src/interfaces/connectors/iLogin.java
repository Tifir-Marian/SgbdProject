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
public interface iLogin {
    Button login = new Button("Login");
    final JLabel userLabel = new JLabel("Insert User");
    JTextField user = new JTextField();
    final JLabel passwordLabel = new JLabel("Insert Password");
    JPasswordField password = new JPasswordField();
    default JTextField getUser(){
        return user;
    }
    default JPasswordField getPassword(){
        return password;
    }
    default Button getLoginButton(){
        return login;
    }
}
