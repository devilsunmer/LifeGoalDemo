package com;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.DayPay;
import model.DayRecord;
import model.RealTime;

public class DayPayUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dayPay;
	private JTextField daySave;
	DayPay daypay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayPayUI frame = new DayPayUI();
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
	public DayPayUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(21, 10, 297, 226);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("今日開銷：");
		lblNewLabel.setBounds(59, 24, 88, 32);
		panel.add(lblNewLabel);

		dayPay = new JTextField();
		dayPay.setHorizontalAlignment(SwingConstants.RIGHT);
		dayPay.setText("0");
		dayPay.setBounds(108, 88, 96, 21);
		panel.add(dayPay);
		dayPay.setColumns(10);

		JComboBox dayPayChoose = new JComboBox();
		dayPayChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dayPayChoose.setModel(new DefaultComboBoxModel(new String[] { "食", "衣", "住", "育", "樂" }));
		dayPayChoose.setBounds(108, 55, 88, 23);
		panel.add(dayPayChoose);

		JLabel lblNewLabel_1 = new JLabel("今日存款：");
		lblNewLabel_1.setBounds(59, 120, 60, 15);
		panel.add(lblNewLabel_1);

		daySave = new JTextField();
		daySave.setHorizontalAlignment(SwingConstants.RIGHT);
		daySave.setText("0");
		daySave.setColumns(10);
		daySave.setBounds(108, 145, 96, 21);
		panel.add(daySave);

		JLabel lblNewLabel_1_1 = new JLabel("元");
		lblNewLabel_1_1.setBounds(207, 148, 29, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("元");
		lblNewLabel_1_1_1.setBounds(207, 91, 29, 15);
		panel.add(lblNewLabel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 257, 297, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/************** 按鈕處理 *******************/
		/** 將記錄存入 **/
		JButton dayPaySave = new JButton("存入");
		dayPaySave.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date getADate=new Date();
					String currentDate = dateFormat.format(getADate);
					String item = (String) dayPayChoose.getSelectedItem();
					if (item == null) {
						item = null; // 若返回 null，設為 0
					}
					Integer spend = Integer.parseInt(dayPay.getText().trim());
					if (spend == null) {
						spend = 0; // 若返回 null，設為 0
					}
					Integer saving = Integer.parseInt(daySave.getText().trim());
					if (saving == null) {
						saving = 0; // 若返回 null，設為 0
					}
					Integer futureTotalSpend = RealTime.getTotalSpend() + spend;
					if (RealTime.getTotalSpend() == null) {
						futureTotalSpend=spend; // 若返回 null，設為 0
					}else {
						futureTotalSpend = RealTime.getTotalSpend() + spend;
					}
					Integer futureTotalSaving;
					if (RealTime.getTotalSaving() == null) {
						futureTotalSaving=saving; // 若返回 null，設為 0
					}else {
						futureTotalSaving = RealTime.getTotalSaving() + saving;
					}
					Integer availableMoney=0;
					if(RealTime.getIncome()==null) {
						availableMoney=futureTotalSaving+ saving - futureTotalSpend;
					}else {
						availableMoney =RealTime.getIncome() + futureTotalSaving
								+ saving - futureTotalSpend;
					}

					if (availableMoney < 0) {
						JOptionPane.showMessageDialog(null, "超出目前可用金額，請重新調整金額！");
						return; // 不存入
					}

					DayRecord record = new DayRecord(getADate,item, spend, saving);
					RealTime.addRecord(record); // 存入靜態記錄清單

					RealTimeUI realTimeUI = new RealTimeUI(); // 切換到新畫面
					realTimeUI.setVisible(true);
					dispose();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "請輸入有效的金額", "錯誤", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "日期有錯誤", "錯誤", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		dayPaySave.setFont(new Font("標楷體", Font.PLAIN, 14));
		dayPaySave.setBounds(10, 52, 87, 23);
		panel_1.add(dayPaySave);

		/** 清除資料 **/
		JButton dayPayClear = new JButton("清除");
		dayPayClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dayPay.setText("0");
				daySave.setText("0");
				dayPayChoose.setSelectedIndex(0); // 回復 ComboBox 到第一項
				dayPayChoose.setEnabled(true);
			}
		});
		dayPayClear.setFont(new Font("標楷體", Font.PLAIN, 14));
		dayPayClear.setBounds(107, 52, 87, 23);
		panel_1.add(dayPayClear);

		/** 回到上一頁 **/
		JButton dayPayBeck = new JButton("上一頁");
		dayPayBeck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RealTimeUI realTimeUI = new RealTimeUI();
				realTimeUI.setVisible(true);
				dispose();
			}
		});
		dayPayBeck.setFont(new Font("標楷體", Font.PLAIN, 14));
		dayPayBeck.setBounds(204, 52, 87, 23);
		panel_1.add(dayPayBeck);

	}
}
