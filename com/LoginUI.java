package com;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.LoginModel;
import view.LoginView;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField=new JPasswordField();
	private JLabel imageText;
	private JTextField imageTextIn;
	String PasswordIn=new String(passwordField.getPassword());
	
	private LoginModel loginModel;
	private LoginView loginView;
	private LoginController loginCotroller;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 250, 275, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**帳號欄輸入設置**/
		usernameField = new JTextField();
		String usernameFieldText="帳號輸入teacher";
		usernameField.setText(usernameFieldText);
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(usernameField.getText().equals(usernameFieldText))
				{
					usernameField.setText("");
					usernameField.setForeground(new Color(0,0,0));
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(usernameField.getText().trim().isEmpty())
				{
					usernameField.setText(usernameFieldText);
					usernameField.setForeground(new Color(192, 192, 192));
				}
			}
		});
		usernameField.setForeground(new Color(192, 192, 192));
		usernameField.setFont(new Font("標楷體", Font.PLAIN, 12));
		usernameField.setBounds(101, 58, 133, 21);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		
		/**密碼欄輸入設置**/
		passwordField = new JPasswordField();
		String PasswordfieldText = "請輸入密碼123";
		passwordField.setEchoChar((char) 0);
		passwordField.setText(PasswordfieldText);
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PasswordIn=PasswordfieldText;
				if(PasswordIn.equals(PasswordfieldText)) {
					passwordField.setText("");
					passwordField.setEchoChar('●');
					passwordField.setForeground(new Color(0,0,0));
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				PasswordIn=new String(passwordField.getPassword());
				if(PasswordIn.trim().isEmpty())
				{
					passwordField.setEchoChar((char) 0);
					passwordField.setText(PasswordfieldText);
					passwordField.setForeground(new Color(192, 192, 192));
				}
			}
		});
		
		passwordField.setForeground(new Color(192,192,192));
		passwordField.setFont(new Font("標楷體", Font.PLAIN, 12));
		passwordField.setBounds(101, 89, 133, 21);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel.setBounds(34, 58, 60, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(34, 89, 60, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton newUserButton = new JButton("創建");
		newUserButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		newUserButton.setBounds(147, 121, 87, 23);
		contentPane.add(newUserButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 154, 239, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel imageText = new JLabel();
		imageText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		imageText.setToolTipText("點擊圖片可更換驗證碼");
		imageText.setFont(new Font("標楷體", Font.PLAIN, 12));
		imageText.setBounds(10, 10, 120, 40);
		imageText.revalidate();
		imageText.repaint();
		panel.add(imageText);
		
		imageTextIn = new JTextField();
		imageTextIn.setText("還在努力");
		imageTextIn.setBackground(new Color(255, 255, 255));
		imageTextIn.setFont(new Font("標楷體", Font.PLAIN, 12));
		imageTextIn.setBounds(138, 21, 96, 21);
		panel.add(imageTextIn);
		imageTextIn.setColumns(10);
		
		JLabel waring = new JLabel("");
		waring.setBackground(new Color(255, 255, 255));
		waring.setHorizontalAlignment(SwingConstants.CENTER);
		waring.setFont(new Font("標楷體", Font.PLAIN, 12));
		waring.setBounds(10, 10, 239, 35);
		contentPane.add(waring);
		
		
		/*************************操作介面*****************************/
		/**登入介面登入按鈕設置**/
		JButton loginInButton = new JButton("登入");
		loginInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(usernameField.getText().equals("teacher")&&PasswordIn.equals("123")) {
					waring.setText("登入成功");
					waring.setFont(new Font("標楷體", Font.PLAIN, 12));
					RealTimeUI realTimeUI=new RealTimeUI();
					realTimeUI.setVisible(true);
					dispose();
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
		});
		loginInButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		loginInButton.setBounds(34, 121, 87, 23);
		contentPane.add(loginInButton);
	
		/**登入介面離開按鈕**/
		JButton loginLeave = new JButton("離開");
		loginLeave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		loginLeave.setFont(new Font("標楷體", Font.PLAIN, 14));
		loginLeave.setBounds(147, 228, 87, 23);
		contentPane.add(loginLeave);
		
		/**清除登入介面訊息按鈕**/
		JButton loginClearButton = new JButton("清除");
		loginClearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameField.setText(usernameFieldText);
				usernameField.setForeground(new Color(192, 192, 192));
				passwordField.setEchoChar((char) 0);
				passwordField.setText(PasswordfieldText);
				passwordField.setForeground(new Color(192,192,192));
				imageTextIn.setText("");
				
			}
		});
		loginClearButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		loginClearButton.setBounds(34, 228, 87, 23);
		contentPane.add(loginClearButton);
		
	}}
