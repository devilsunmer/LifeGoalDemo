package com;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.MonthCount;
import model.MonthRecord;
import model.RealTime;
import java.awt.Font;

public class MonthCountUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthCountUI frame = new MonthCountUI();
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
	public MonthCountUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 10, 385, 130);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea outputShow = new JTextArea();
		outputShow.setBounds(10, 10, 365, 110);
		panel.add(outputShow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 161, 385, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea outputPrint = new JTextArea();
		outputPrint.setBounds(361, 24, 0, 0);
		panel_1.add(outputPrint);
		outputPrint.setEnabled(false);
		outputPrint.setEditable(false);

		/**************按鈕處理*******************/
		/** 回到上一頁 **/
		JButton monthBack = new JButton("上一頁");
		monthBack.setFont(new Font("標楷體", Font.PLAIN, 14));
		monthBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RealTimeUI realTimeUI=new RealTimeUI();
				realTimeUI.setVisible(true);
				dispose();
			}
		});
		monthBack.setBounds(10, 26, 87, 23);
		panel_1.add(monthBack);
		
		/**進行所有紀錄的結算，再給出總表**/
		JButton countAll = new JButton("結算(壞的)");
		countAll.setFont(new Font("標楷體", Font.PLAIN, 14));
		countAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Integer start ;
					if(RealTime.getInstance().getIncome()==0){
						start=0;
					}else{
						start = RealTime.getInstance().getIncome();
					}// 起始金額
					Integer goal;
					if(RealTime.getInstance().getHopeSave()==0){
						goal=0;
					}else {
						goal = RealTime.getInstance().getHopeSave();
					}
					// 目標金額

			        // 假設你有這樣的方法可以取得每日紀錄的資料
					Integer currentMonth;
					if(RealTime.getCurrentMonth()==0) {
						currentMonth = 0;
					}else {
						currentMonth = RealTime.getCurrentMonth();
					}
					List<MonthRecord> records = RealTime.getMonthRecordsForCurrentMonth(currentMonth);
			        if(RealTime.getMonthRecordsForCurrentMonth(currentMonth)==null) {
			        	records=new ArrayList<>();
			        	}else {
			        	records=RealTime.getMonthRecordsForCurrentMonth(currentMonth);
			        }
					Integer totalPay = 0;
			        Integer totalSave = 0;

			        for (MonthRecord r : records) {
			            totalPay += r.getPay();   // 每日花費
			            totalSave += r.getSave(); // 每日存入
			        }

			        Integer nowCanUse = start + totalSave - totalPay;
			        Integer stillNeedToSave = goal - (start + totalSave); // 距離目標金額還差多少

			        StringBuilder result = new StringBuilder();
			        result.append("【本月結算】\n");
			        result.append(" 總開銷金額：").append(totalPay).append(" 元\n");
			        result.append(" 總存入金額：").append(totalSave).append(" 元\n");
			        result.append(" 目前可用金額：").append(nowCanUse).append(" 元\n");
			        result.append(" 距離目標金額還差：").append(stillNeedToSave).append(" 元\n");

			        outputShow.setText(result.toString());

			    } catch (NumberFormatException ex) {
			        JOptionPane.showMessageDialog(null, "請確認起始金額與目標金額輸入為數字！");
			    }
			}
		});
		countAll.setBounds(107, 26, 119, 23);
		panel_1.add(countAll);
		
		/**列印報表**/
		JButton monthPrint = new JButton("列印(還未測試)");
		monthPrint.setFont(new Font("標楷體", Font.PLAIN, 14));
		monthPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MonthCount monthCount=new MonthCount();
				try {
					outputPrint.setText(monthCount.generateReport());
					outputPrint.print();
				} catch (PrinterException we) {
					we.printStackTrace();
					outputShow.setText("無法進行列印");
				}
			}
		});
		monthPrint.setBounds(236, 26, 139, 23);
		panel_1.add(monthPrint);
		
		
		
	}

}
