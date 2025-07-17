package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ModelChoose extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelChoose frame = new ModelChoose();
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
	public ModelChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 258, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(58, 10, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("目標:");
		lblNewLabel.setBounds(10, 13, 46, 15);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 249, 464, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton goalSetButton = new JButton("目標設定");
		goalSetButton.setBounds(10, 10, 87, 23);
		panel_1.add(goalSetButton);
		
		JButton dayPayInButton = new JButton("每日進出");
		dayPayInButton.setBounds(10, 69, 87, 23);
		panel_1.add(dayPayInButton);
		
		JButton monthClearButton = new JButton("月底清算");
		monthClearButton.setBounds(153, 10, 87, 23);
		panel_1.add(monthClearButton);

	}
}
