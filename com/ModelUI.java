package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.controller.NumberController;
import com.model.NumberResponse;
import com.model.modelChoose.AllModel;
import com.model.modelChoose.HouseModel;
import com.model.modelChoose.LikeThingModel;
import com.model.modelChoose.MarrigeModel;

import controller.ModelButton;
import model.RealTime;

public class ModelUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup chanceGroup = new ButtonGroup();
	private final ButtonGroup marrigeGroup = new ButtonGroup();
	private JTextField likeThingName;
	private JTextField likeThingPayMoney;
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
		
		JPanel marrigeChoose = new JPanel();
		marrigeChoose.setBounds(224, 10, 200, 124);
		contentPane.add(marrigeChoose);
		marrigeChoose.setLayout(null);
		
		JRadioButton wishKid = new JRadioButton("預計生子");
		marrigeGroup.add(wishKid);
		wishKid.setFont(new Font("標楷體", Font.PLAIN, 14));
		wishKid.setBounds(6, 6, 107, 23);
		marrigeChoose.add(wishKid);
		
		JRadioButton noneChild = new JRadioButton("不育");
		marrigeGroup.add(noneChild);
		noneChild.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneChild.setBounds(6, 31, 107, 23);
		marrigeChoose.add(noneChild);
		
		JRadioButton noneWedding = new JRadioButton("裸婚");
		marrigeGroup.add(noneWedding);
		noneWedding.setFont(new Font("標楷體", Font.PLAIN, 14));
		noneWedding.setBounds(6, 56, 107, 23);
		marrigeChoose.add(noneWedding);
		
		JSpinner kid = new JSpinner();
		kid.setBounds(119, 4, 30, 22);
		marrigeChoose.add(kid);
		kid.setForeground(new Color(128, 128, 128));
		kid.setBackground(new Color(192, 192, 192));
		kid.setFont(new Font("微软雅黑", Font.BOLD, 12));
		kid.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		
		JLabel kidUnit = new JLabel("個");
		kidUnit.setFont(new Font("標楷體", Font.PLAIN, 14));
		kidUnit.setBounds(160, 10, 30, 15);
		marrigeChoose.add(kidUnit);
		
		JPanel houseChoose = new JPanel();
		houseChoose.setBounds(224, 144, 200, 124);
		contentPane.add(houseChoose);
		houseChoose.setLayout(null);
		
		JRadioButton simpleHouse = new JRadioButton("一房一廳");
		houseGroup.add(simpleHouse);
		simpleHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		simpleHouse.setBounds(6, 6, 107, 23);
		houseChoose.add(simpleHouse);
		
		JRadioButton familyHouse = new JRadioButton("多房家庭");
		houseGroup.add(familyHouse);
		familyHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		familyHouse.setBounds(6, 31, 107, 23);
		houseChoose.add(familyHouse);
		
		JRadioButton richHouse = new JRadioButton("高級公寓");
		houseGroup.add(richHouse);
		richHouse.setFont(new Font("標楷體", Font.PLAIN, 14));
		richHouse.setBounds(6, 56, 107, 23);
		houseChoose.add(richHouse);
		
		JPanel likeThingChoose = new JPanel();
		likeThingChoose.setLayout(null);
		likeThingChoose.setBounds(14, 144, 200, 124);
		contentPane.add(likeThingChoose);
		
		JLabel likeThingTitle = new JLabel("想存錢購買的東西：");
		likeThingTitle.setFont(new Font("標楷體", Font.PLAIN, 14));
		likeThingTitle.setBounds(10, 10, 139, 25);
		likeThingChoose.add(likeThingTitle);
		
		likeThingName = new JTextField();
		likeThingName.setFont(new Font("標楷體", Font.PLAIN, 14));
		likeThingName.setColumns(10);
		likeThingName.setBounds(10, 33, 139, 25);
		likeThingChoose.add(likeThingName);
		
		likeThingPayMoney = new JTextField();
		likeThingPayMoney.setFont(new Font("標楷體", Font.PLAIN, 14));
		likeThingPayMoney.setColumns(10);
		likeThingPayMoney.setBounds(10, 89, 139, 25);
		likeThingChoose.add(likeThingPayMoney);
		
		JLabel likeThingPay = new JLabel("金額預估：");
		likeThingPay.setFont(new Font("標楷體", Font.PLAIN, 14));
		likeThingPay.setBounds(10, 64, 139, 25);
		likeThingChoose.add(likeThingPay);
		
		/**
		 * 這個是選擇結婚基金模式的時候
		 * 主要設定部分大概分為:
		 * 1.有小孩為期望值
		 * 2.沒有小孩、純結婚的頂客族
		 * 3.只有登記結婚、存錢過兩人世界為主
		 */
		JRadioButton marrige = new JRadioButton("結婚基金");
		marrige.setFont(new Font("標楷體", Font.PLAIN, 14));
		chanceGroup.add(marrige);
		marrige.setBounds(6, 6, 107, 23);
		basic.add(marrige);
		
		/**
		 * 這個是選擇買房基金模式的時候，設定部分
		 * 可以依據簡單一室一廳
		 * 或是2~3房
		 * 或是別墅、高級公寓等之類的歸納
		 */
		JRadioButton house = new JRadioButton("買房基金");
		house.setFont(new Font("標楷體", Font.PLAIN, 14));
		chanceGroup.add(house);
		house.setBounds(6, 31, 107, 23);
		basic.add(house);
		
		/**
		 * 這個是選擇以物品為目標模式的時候，設定部分
		 * 用String來設計主要目標的金額以及各項指標
		 */
		JRadioButton likeThing = new JRadioButton("變成喜歡的東西");
		likeThing.setFont(new Font("標楷體", Font.PLAIN, 14));
		chanceGroup.add(likeThing);
		likeThing.setBounds(6, 56, 123, 23);
		basic.add(likeThing);
		
		JLabel chooseReturn = new JLabel("");
		chooseReturn.setFont(new Font("標楷體", Font.PLAIN, 15));
		chooseReturn.setHorizontalAlignment(SwingConstants.CENTER);
		chooseReturn.setBounds(10, 278, 414, 40);
		contentPane.add(chooseReturn);
		
		
		/*************按鈕設計**************/
		/**模式選擇的部分
		 * 然後要在設計轉場進入最後金錢規劃的部份*/
		
		marrigeChoose.setVisible(false);
		houseChoose.setVisible(false);
		likeThingChoose.setVisible(false);
		ActionListener switchListener = e -> {
			AllModel allModel;
			chooseReturn.setText(null);
			ModelButton chooseFirst=new ModelButton(marrigeChoose,wishKid, 
					kid, kidUnit,noneChild, noneWedding,houseChoose,simpleHouse,
					familyHouse, richHouse,likeThingChoose,likeThingTitle, 
					likeThingName, likeThingPay, likeThingPayMoney);
			if(marrige.isSelected()==true)
			{	
				chooseFirst.marrigeOption(true);
				chooseFirst.houseOption(false);
				chooseFirst.likeThingOption(false);		
			}else if(house.isSelected()==true)
			{
				chooseFirst.marrigeOption(false);
				chooseFirst.houseOption(true);
				chooseFirst.likeThingOption(false);
				
			}else if(likeThing.isSelected()==true)
			{
				chooseFirst.marrigeOption(false);
				chooseFirst.houseOption(false);
				chooseFirst.likeThingOption(true);
				
			}else
			{
				chooseFirst.marrigeOption(false);
				chooseFirst.houseOption(false);
				chooseFirst.likeThingOption(false);
			}
		};
		marrige.addActionListener(switchListener);
		house.addActionListener(switchListener);
		likeThing.addActionListener(switchListener);
		marrige.setSelected(false);
		house.setSelected(false);
		likeThing.setSelected(false);
		
		/**確認選擇後開始判斷要給出什麼樣的數值**/
		JButton enterGoal = new JButton("確認目標");
		enterGoal.setFont(new Font("標楷體", Font.PLAIN, 12));
		enterGoal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					String goal=null;
					Integer saveMoey=0;
					String message=null;
					
						if(marrige.isSelected()==true) {
							AllModel secondChoose=new MarrigeModel(wishKid,kid,noneChild,noneWedding);
							goal=secondChoose.getGoal();
							saveMoey=secondChoose.getSaveMoney();
							message=secondChoose.Message();
						}else if(house.isSelected()) {
							AllModel secondChoose=new HouseModel(simpleHouse, familyHouse,richHouse);
							goal=secondChoose.getGoal();
							saveMoey=secondChoose.getSaveMoney();
							message=secondChoose.Message();
						}else {
							AllModel secondChoose=new LikeThingModel(likeThingName,likeThingPayMoney);
							goal=secondChoose.getGoal();
							saveMoey=secondChoose.getSaveMoney();
							message=secondChoose.Message();
						}
						
					
					RealTime.getInstance().setGoal(goal);
					RealTime.getInstance().setHopeSave(saveMoey);
					RealTime.getInstance().setMes(message);
					
					RealTimeUI realTimeUI=new RealTimeUI();
					realTimeUI.setVisible(true);
					dispose();
					//測試有沒有丟出值
//					System.out.println("目標：" + goal);
//					System.out.println("金額：" + saveMoey);
//					System.out.println("RealTime.getInstance() 中的目標：" + RealTime.getInstance().getGoal());
//					System.out.println("RealTime.getInstance() 中的金額：" + RealTime.getInstance().getSaveMoney());
			}
		});
		enterGoal.setBounds(22, 328, 87, 23);
		contentPane.add(enterGoal);
		
		/**重新設定**/
		JButton resetChoose = new JButton("重新選擇");
		resetChoose.setFont(new Font("標楷體", Font.PLAIN, 12));
		resetChoose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chanceGroup.clearSelection();
				ModelButton chooseFirst=new ModelButton(marrigeChoose, wishKid, kid, kidUnit, 
						noneChild, noneWedding, houseChoose, simpleHouse, familyHouse, 
						richHouse, likeThingChoose, likeThingTitle, likeThingName, likeThingPay, 
						likeThingPayMoney);
				chooseFirst.clearOption(false);
			}
		});
		resetChoose.setBounds(119, 328, 87, 23);
		contentPane.add(resetChoose);
		
		/**離開應用程式**/
		JButton modelLeave = new JButton("離開");
		modelLeave.setFont(new Font("標楷體", Font.PLAIN, 12));
		modelLeave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		modelLeave.setBounds(324, 328, 87, 23);
		contentPane.add(modelLeave);
		
		/**回到上一頁**/
		JButton backButton = new JButton("回上一頁");
		backButton.setFont(new Font("標楷體", Font.PLAIN, 12));
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RealTimeUI realTimeUI=new RealTimeUI();
				realTimeUI.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(227, 328, 87, 23);
		contentPane.add(backButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
