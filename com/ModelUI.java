package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class ModelUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup chance = new ButtonGroup();
	ModelButton chooseFirst;
	private final ButtonGroup marrigeGroup = new ButtonGroup();
	private final ButtonGroup houseGroup = new ButtonGroup();

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
		
		JPanel basic = new JPanel();
		basic.setBounds(10, 10, 204, 124);
		contentPane.add(basic);
		basic.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("猶豫要不要加入");
		rdbtnNewRadioButton_3.setEnabled(false);
		rdbtnNewRadioButton_3.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(6, 81, 107, 23);
		basic.add(rdbtnNewRadioButton_3);
		
		JPanel secondChoose = new JPanel();
		secondChoose.setBounds(224, 10, 200, 124);
		contentPane.add(secondChoose);
		secondChoose.setLayout(null);
		
		JRadioButton wishKid = new JRadioButton("預計生子");
		marrigeGroup.add(wishKid);
		wishKid.setFont(new Font("標楷體", Font.PLAIN, 14));
		wishKid.setBounds(6, 6, 107, 23);
		secondChoose.add(wishKid);
		
		JRadioButton noneChild = new JRadioButton("不育");
		marrigeGroup.add(noneChild);
		noneChild.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneChild.setBounds(6, 31, 107, 23);
		secondChoose.add(noneChild);
		
		JRadioButton noneWedding = new JRadioButton("裸婚");
		marrigeGroup.add(noneWedding);
		noneWedding.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneWedding.setBounds(6, 56, 107, 23);
		secondChoose.add(noneWedding);
		
		JSpinner kid = new JSpinner();
		kid.setBounds(119, 4, 30, 22);
		secondChoose.add(kid);
		kid.setForeground(new Color(128, 128, 128));
		kid.setBackground(new Color(192, 192, 192));
		kid.setFont(new Font("微软雅黑", Font.BOLD, 12));
		kid.setModel(new SpinnerNumberModel(1, 1, 5, 0));
		
		JLabel kidUnit = new JLabel("個");
		kidUnit.setFont(new Font("標楷體", Font.PLAIN, 14));
		kidUnit.setBounds(160, 10, 30, 15);
		secondChoose.add(kidUnit);
		
		JRadioButton richHouse = new JRadioButton("高級住宅");
		houseGroup.add(richHouse);
		richHouse.setBounds(6, 56, 123, 23);
		secondChoose.add(richHouse);
		richHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JRadioButton familyHouse = new JRadioButton("2~3房");
		houseGroup.add(familyHouse);
		familyHouse.setBounds(6, 31, 107, 23);
		secondChoose.add(familyHouse);
		familyHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		JRadioButton simpleHouse = new JRadioButton("一房一廳");
		houseGroup.add(simpleHouse);
		simpleHouse.setBounds(6, 6, 107, 23);
		secondChoose.add(simpleHouse);
		simpleHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		
		/*************按鈕設計**************/
		/**模式選擇*/
		
		/**
		 * 這個是選擇結婚基金模式的時候
		 * 主要設定部分大概分為:
		 * 1.有小孩為期望值
		 * 2.沒有小孩、純結婚的頂客族
		 * 3.只有登記結婚、存錢過兩人世界為主
		 */
		JRadioButton marrige = new JRadioButton("結婚基金");
		marrige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFirst.marrigeOption(true, kidUnit, kid, marrige, marrige, marrige);
				chooseFirst.houseOption(false, simpleHouse, familyHouse, richHouse);
				
			}
		});
		marrige.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(marrige);
		marrige.setBounds(6, 6, 107, 23);
		basic.add(marrige);
		
		/**
		 * 這個是選擇買房基金模式的時候，設定部分
		 * 可以依據簡單一室一廳
		 * 或是2~3房
		 * 或是別墅、高級公寓等之類的歸納
		 */
		JRadioButton house = new JRadioButton("買房基金");
		house.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFirst.marrigeOption(false, kidUnit, kid, marrige, marrige, marrige);
				chooseFirst.houseOption(true, simpleHouse, familyHouse, richHouse);
				
			}
		});
		house.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(house);
		house.setBounds(6, 31, 107, 23);
		basic.add(house);
		
		/**
		 * 這個是選擇以物品為目標模式的時候，設定部分
		 * 用String來設計主要目標的金額以及各項指標
		 */
		JRadioButton likething = new JRadioButton("變成喜歡的東西");
		likething.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseFirst.marrigeOption(false, kidUnit, kid, marrige, marrige, marrige);
				chooseFirst.houseOption(false, simpleHouse, familyHouse, richHouse);
				
			}
		});
		likething.setFont(new Font("標楷體", Font.PLAIN, 14));
		chance.add(likething);
		likething.setBounds(6, 56, 123, 23);
		basic.add(likething);
		
		
		

	}
}
