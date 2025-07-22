package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField imageTextIn = new JTextField();
    private JLabel imageText = new JLabel();
    private JButton loginInButton = new JButton("登入");
    
    
    
    private String username;
    private String password;
    
    
	public String getUsername() {
		return usernameField.getText();
	}
	public void setUsername(String username) {
		usernameField.setText(username);
	}
	public String getPassword() {
		return passwordField.getPassword().toString();
	}
	public void setPassword(String password) {
		passwordField.setEchoChar((char) 0);
		passwordField.setText(password);
		
	}
	public JTextField getImageTextIn() {
		return imageTextIn;
	}
	public void setImageTextIn(JTextField captchaInput) {
		this.imageTextIn = captchaInput;
	}
	public JLabel getImageText() {
		return imageText;
	}
	public void setImageText(JLabel captchaImageLabel) {
		this.imageText = captchaImageLabel;
	}
	public JButton getLoginButton() {
		return loginInButton;
	}
	public void setLoginButton(JButton loginButton) {
		this.loginInButton = loginButton;
	}

	public void addLoginListener(ActionListener listener) {
		loginInButton.addActionListener(listener);
	}
	
	
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
    
}
