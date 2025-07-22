package controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.LoginUI;
import com.RealTimeUI;

import model.LoginModel;
import view.LoginView;

public class LoginController {
	private static LoginModel loginModel;
	private static LoginView loginView;
	
	private static JTextField usernameField = new JTextField();
    private static JPasswordField passwordField = new JPasswordField();
    private static JTextField imageTextIn = new JTextField();
    private static JLabel imageText = new JLabel();
    private static JButton loginInButton = new JButton("登入");
   
	static String usernameFieldText="帳號輸入teacher";
	static String PasswordfieldText = "請輸入密碼123";
	
	static String imageTextInput=loginView.getImageText().getText();
	
	static JLabel waring = new JLabel("");
	
	
	public LoginController(LoginModel loginModel, LoginView loginView) {
		this.loginModel = loginModel;
		this.loginView = loginView;
		refreshImageTextIn();
		login();
		loginModel.imageTextSetRule(loginView.getImageText());
	}
	
	public static void login() 
	{
		try {
			if("teacher".equals(loginView.getUsername())&&"123".equals(loginView.getPassword())) {
			waring.setText("登入成功");
			waring.setFont(new Font("標楷體", Font.PLAIN, 12));
			RealTimeUI realTimeUI=new RealTimeUI();
			realTimeUI.setVisible(true);
			LoginUI login = new LoginUI();
			login.dispose();
			}else {
				usernameField.setText(usernameFieldText);
				usernameField.setForeground(new Color(192, 192, 192));
				passwordField.setEchoChar((char) 0);
				passwordField.setText(PasswordfieldText);
				passwordField.setForeground(new Color(192,192,192));
				imageTextIn.setText("");
				waring.setText("帳號或密碼錯誤");
				waring.setFont(new Font("標楷體", Font.PLAIN, 12));
				waring.setForeground(new Color(255,0,0));
			}
		}catch(Exception ex){
			ex.printStackTrace();
			waring.setText("請重新嘗試");
			waring.setFont(new Font("標楷體", Font.PLAIN, 12));
			waring.setForeground(new Color(255,0,0));
		}
		
		
	}
	
	public static void login2() {
		try {
			if(!imageTextInput.equals(loginModel.getImageTextInside())) {
				waring.setText("驗證錯誤");
				waring.setFont(new Font("標楷體", Font.PLAIN, 12));
				waring.setForeground(new Color(255,0,0));
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			waring.setText("請重新嘗試");
			waring.setFont(new Font("標楷體", Font.PLAIN, 12));
			waring.setForeground(new Color(255,0,0));
		}
		
		try {
			if("teacher".equals(loginView.getUsername())&&"123".equals(loginView.getPassword())) {
				RealTimeUI realTimeUI=new RealTimeUI();
				realTimeUI.setVisible(true);
				waring.setText("登入成功");
				waring.setFont(new Font("標楷體", Font.PLAIN, 12));
				LoginUI loginUI = new LoginUI();
				loginUI.dispose();
			}
			else {
				usernameField.setText(usernameFieldText);
				usernameField.setForeground(new Color(192, 192, 192));
				passwordField.setEchoChar((char) 0);
				passwordField.setText(PasswordfieldText);
				passwordField.setForeground(new Color(192,192,192));
				imageTextIn.setText("");
				waring.setText("帳號或密碼錯誤");
				waring.setFont(new Font("標楷體", Font.PLAIN, 12));
				waring.setForeground(new Color(255,0,0));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			waring.setText("請重新嘗試");
			waring.setFont(new Font("標楷體", Font.PLAIN, 12));
			waring.setForeground(new Color(255,0,0));
		}
		
	}
	
	private void refreshImageTextIn() {
		
		loginModel.imageTextSetRule(loginView.getImageText());
	}
	
	

}
