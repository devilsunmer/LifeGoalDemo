package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JLabel;

public class ModelUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup chance = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelUI frame = new ModelUI();
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
	public ModelUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 204, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton marrige = new JRadioButton("結婚基金");
		marrige.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(marrige);
		marrige.setBounds(6, 6, 107, 23);
		panel.add(marrige);
		
		JRadioButton house = new JRadioButton("買房基金");
		house.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(house);
		house.setBounds(6, 31, 107, 23);
		panel.add(house);
		
		JRadioButton likething = new JRadioButton("變成喜歡的東西");
		likething.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(likething);
		likething.setBounds(6, 56, 123, 23);
		panel.add(likething);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(6, 81, 107, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		JPanel marrigeChoose = new JPanel();
		marrigeChoose.setBounds(224, 10, 200, 124);
		contentPane.add(marrigeChoose);
		marrigeChoose.setLayout(null);
		
		JRadioButton kid = new JRadioButton("預計生子");
		buttonGroup_1.add(kid);
		kid.setFont(new Font("標楷體", Font.PLAIN, 14));
		kid.setBounds(6, 6, 107, 23);
		marrigeChoose.add(kid);
		
		JRadioButton noneChild = new JRadioButton("不育");
		buttonGroup_1.add(noneChild);
		noneChild.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneChild.setBounds(6, 31, 107, 23);
		marrigeChoose.add(noneChild);
		
		JRadioButton noneWedding = new JRadioButton("裸婚");
		buttonGroup_1.add(noneWedding);
		noneWedding.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneWedding.setBounds(6, 56, 107, 23);
		marrigeChoose.add(noneWedding);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(119, 4, 30, 22);
		marrigeChoose.add(spinner);
		spinner.setForeground(new Color(128, 128, 128));
		spinner.setBackground(new Color(192, 192, 192));
		spinner.setFont(new Font("微软雅黑", Font.BOLD, 12));
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 0));
		
		JLabel lblNewLabel = new JLabel("個");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel.setBounds(160, 10, 30, 15);
		marrigeChoose.add(lblNewLabel);

	}
}
