package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.controller.NumberController;
import com.model.NumberResponse;

import model.DayRecord;
import model.RealTime;

public class RealTimeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField returnGoal;
	private JTextField startMoney;
	public static JTextField returnHopeSaveMoney;
	public static JTextField fixedSpendStart;
	RealTime reaelTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealTimeUI frame = new RealTimeUI();
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
	public RealTimeUI() {
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

		JLabel returnGoalTitle = new JLabel("存錢目標：");
		returnGoalTitle.setFont(new Font("標楷體", Font.PLAIN, 14));
		returnGoalTitle.setBounds(10, 13, 86, 15);
		panel.add(returnGoalTitle);

		returnGoal = new JTextField();
		returnGoal.setHorizontalAlignment(SwingConstants.CENTER);
		returnGoal.setEnabled(false);
		returnGoal.setBounds(106, 10, 96, 21);
		panel.add(returnGoal);
		returnGoal.setColumns(10);

		JLabel startMoneyTitle = new JLabel("每月可用金額：");
		startMoneyTitle.setFont(new Font("標楷體", Font.PLAIN, 14));
		startMoneyTitle.setBounds(10, 38, 111, 21);
		panel.add(startMoneyTitle);

		/** 起始金額即時計算跟輸入 **/
		startMoney = new JTextField();
		startMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer start = Integer.parseInt(startMoney.getText().trim());
					Integer totalSaved = 0;
					Integer totalSpent = 0;

					RealTime.updateDisplay(); // 更新顯示內容
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "請輸入數字！");
				}
			}
		});
		startMoney.setHorizontalAlignment(SwingConstants.CENTER);
		startMoney.setText("0");
		startMoney.setBounds(106, 38, 96, 21);
		panel.add(startMoney);
		startMoney.setColumns(10);

		JLabel returnHopeSaveMoneyTitle = new JLabel("期望存錢金額：");
		returnHopeSaveMoneyTitle.setFont(new Font("標楷體", Font.PLAIN, 14));
		returnHopeSaveMoneyTitle.setBounds(10, 69, 111, 21);
		panel.add(returnHopeSaveMoneyTitle);

		JLabel fixedSpendStartTitle = new JLabel("生活固定支出：");
		fixedSpendStartTitle.setFont(new Font("標楷體", Font.PLAIN, 14));
		fixedSpendStartTitle.setBounds(10, 100, 111, 21);
		panel.add(fixedSpendStartTitle);

		returnHopeSaveMoney = new JTextField();
		returnHopeSaveMoney.setHorizontalAlignment(SwingConstants.CENTER);
		returnHopeSaveMoney.setText("0");
		returnHopeSaveMoney.setEnabled(false);
		returnHopeSaveMoney.setColumns(10);
		returnHopeSaveMoney.setBounds(106, 69, 96, 21);
		panel.add(returnHopeSaveMoney);

		fixedSpendStart = new JTextField();
		fixedSpendStart.setHorizontalAlignment(SwingConstants.CENTER);
		fixedSpendStart.setText("0");
		fixedSpendStart.setColumns(10);
		fixedSpendStart.setBounds(106, 100, 96, 21);
		panel.add(fixedSpendStart);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 249, 464, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("其他功能還在努力構思");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(198, 43, 181, 26);
		panel_1.add(lblNewLabel);

		JTextArea howMuchNow = new JTextArea();
		howMuchNow.setBounds(278, 10, 196, 229);
		contentPane.add(howMuchNow);

		/***************** 按鈕設計 ******************/

		/** 目標設定跳轉到模式選擇的地方，再回傳目標的值回來 **/
		JButton goalSetButton = new JButton("目標設定");
		goalSetButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		goalSetButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModelUI modelUI = new ModelUI();
				modelUI.setVisible(true);
				dispose();
			}
		});
		goalSetButton.setBounds(10, 10, 115, 23);
		panel_1.add(goalSetButton);

		RealTime.getInstance();
		returnGoal.setText(RealTime.getGoal());
		RealTime.getInstance();
		returnHopeSaveMoney.setText(RealTime.hopeSaveToChinese());

		JTextArea output = new JTextArea();
		output.setBounds(10, 131, 225, 70);
		panel.add(output);
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setText("目前這款僅限娛樂使用，千萬不要當真。\n 如果有問題去投訴ChatGPT，它給我的數據。");
		output.setText(RealTime.getInstance().getMes());

		/** 每天進出的紀錄 **/
		JButton dayPayInButton = new JButton("每日進出");
		dayPayInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (returnGoal.getText() == null || returnGoal.getText().trim().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "請先設定存錢目標！");
				    return;
				}else {
				DayPayUI daypayUI = new DayPayUI();
				daypayUI.setVisible(true);
				dispose();
				}
			}
		});
		dayPayInButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		dayPayInButton.setBounds(168, 10, 115, 23);
		panel_1.add(dayPayInButton);

		/** 最後清算的畫面，來確認是否有真正達到計畫目標 **/
		JButton monthClearButton = new JButton("月底清算");
		monthClearButton.setFont(new Font("標楷體", Font.PLAIN, 14));
		monthClearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (returnGoal.getText() == null || returnGoal.getText().trim().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "請先設定存錢目標！");
				    return;
				}else {
				MonthCountUI monthCount = new MonthCountUI();
				monthCount.setVisible(true);
				dispose();
				}
			}
		});
		monthClearButton.setBounds(325, 10, 115, 23);
		panel_1.add(monthClearButton);

		/** 回到登入畫面 **/
		JButton realTimeBackLogin = new JButton("登出");
		realTimeBackLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI loginUI = new LoginUI();
				loginUI.setVisible(true);
				dispose();
			}
		});
		realTimeBackLogin.setFont(new Font("標楷體", Font.PLAIN, 14));
		realTimeBackLogin.setBounds(234, 79, 87, 23);
		panel_1.add(realTimeBackLogin);

		/** 關閉程式 **/
		JButton realTimeOut = new JButton("關閉");
		realTimeOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		realTimeOut.setFont(new Font("標楷體", Font.PLAIN, 14));
		realTimeOut.setBounds(329, 79, 87, 23);
		panel_1.add(realTimeOut);

		/** 調取現有所有資料去計算顯示目前情況 **/
		JButton countEnter = new JButton("計算目前金額");
		countEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
                
				if (returnGoal.getText() == null || returnGoal.getText().trim().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "請先設定存錢目標！");
				    return;
				}else {
					try {
						RealTime mama=new RealTime();
						// 取得用戶輸入的資料
						Integer income = Integer.parseInt(startMoney.getText().trim());  
			            Integer fixedSpend = Integer.parseInt(fixedSpendStart.getText().trim());  //固定支出
			            Integer hopeSave = Integer.parseInt(returnHopeSaveMoney.getText().trim());  // 存錢目標金額
		
			            // 使用 RealTime 中的方法來進行計算
			            Integer usefulMoney = income-fixedSpend;
			            Integer dailyInOut = RealTime.getTotalSaving()-RealTime.getTotalSpend();  // 使用真實的數據來替代
			            Integer nowCash = usefulMoney + dailyInOut;  // 使用真實的數據來替代
			            Integer remaining = hopeSave-nowCash;
			            
			            // 更新期望存錢金額顯示欄位
		                returnHopeSaveMoney.setText(hopeSave.toString());
					
		                StringBuilder dayday = new StringBuilder();
						for (DayRecord r : RealTime.getDayRecords()) {
							dayday.append(r.toString()).append("\n");
						}
						dayday.append("\n總消費: ").append(mama.getTotalSpend());
						dayday.append("\n總存入: ").append(mama.getTotalSaving()-RealTime.getTotalSpend());
						
		                // 組合顯示的文字信息
						dayday.append(" 存錢目標金額：").append(hopeSave).append(" 元\n");
						dayday.append(" 每月可用金額：").append(income).append(" 元\n");
						dayday.append(" 扣除固定支出後：").append(fixedSpend).append(" 元\n");
						dayday.append(" 目前可用金額：").append(nowCash).append(" 元\n");
						dayday.append(" 距離目標還差：").append(remaining).append(" 元\n");
	
		                // 更新顯示區域
		                howMuchNow.setText(dayday.toString());

		            } catch (NumberFormatException ex) {
		            	System.out.println(startMoney.toString());
		                howMuchNow.setText(" 請確認所有欄位皆為有效的數字！");
		            } catch (Exception ex) {
		                ex.printStackTrace();  // 捕獲異常並打印堆疊信息
		                howMuchNow.setText(" 發生未知錯誤，請稍後再試！");
		            }
				
				}
			}
		});
		countEnter.setFont(new Font("標楷體", Font.PLAIN, 14));
		countEnter.setBounds(10, 36, 133, 23);
		panel_1.add(countEnter);

		/** 清除畫面中輸入的內容 **/
		JButton realTimeClear = new JButton("清除輸入內容");
		realTimeClear.setBounds(10, 61, 133, 23);
		panel_1.add(realTimeClear);
		realTimeClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText("清除所有需要輸入的內容");
				startMoney.setText("0");
				fixedSpendStart.setText("0");
			}
		});
		realTimeClear.setFont(new Font("標楷體", Font.PLAIN, 14));

	}
	
	/***method***/
	
	public void updateRealTimeUI(String goal, Integer saveMoney, String mes) {
		returnGoal.setText(goal);
		returnHopeSaveMoney.setText(saveMoney.toString());
		
	}

		
	
}
