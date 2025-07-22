package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.RealTimeUI;
import com.controller.NumberController;
import com.model.NumberResponse;

public class RealTime {
	private RealTimeUI realTimeUI;
	private DayPay daypay;
	private static String goal;
	private static Integer hopeSave;
	private static Integer income;
	private static Integer fixedSpend;
	private String mes;
	private final static List<DayRecord> dayRecords = new ArrayList<>();
	private final static List<MonthRecord> monthRecords = new ArrayList<>();


	private static RealTime instance = new RealTime();// chatgpt表示確保所有地方共用資料
	

	public RealTime() {
	}

	public static RealTime getInstance() {
		return instance;
	}

	public static String getGoal() {
		return instance.goal;
	}

	public void setGoal(String goal) {
		instance.goal = goal;
	}

	public static Integer getIncome() {
		return instance.income;
	}

	public static void setIncome(Integer startMoney) {
		instance.income = startMoney;
	}

	public static Integer getFixedSpend() {
		return instance.fixedSpend;
	}

	public static void setFixedSpend(Integer fixedSpendStart) {
		instance.fixedSpend = fixedSpendStart;
	}

	public static Integer getHopeSave() {
		return instance.hopeSave;
	}

	public void setHopeSave(Integer saveMoney) {
		instance.hopeSave = saveMoney;
	}

	public String getMes() {
		return instance.mes;
	}

	public void setMes(String mes) {
		instance.mes = mes;
	}
	
	//將目標數字轉為大寫中文讓人方便閱讀
	public static String hopeSaveToChinese() {
		Integer hopeChinese=RealTime.getHopeSave();
		if(hopeChinese==null||hopeChinese==0) return "零";
		NumberController controller = new NumberController();
		NumberResponse someNumber=controller.convert(hopeChinese);
		return someNumber.toString();
	}
	

	// JRadioButton轉String
	public String changeToString(JRadioButton change) {
		String Change = change.getText().trim();
		return Change;
	}

	// 文字轉數字
	public Integer stringToInteger(String Change) {
		Integer change = Integer.parseInt(Change);
		return change;
	}

	// JRadioButton轉數字
	public void turnToInt(JRadioButton change) {
		stringToInteger(changeToString(change));
	}

	// JSpinner轉數字
	public Integer changeToInt(JSpinner num) {
		Integer value = (Integer) num.getValue();
		return value;
	}

	// JTextField轉數字
	public static Integer textTOInt(JTextField why) {
		if (why == null) {
	        return 0; // 如果 JTextField 為 null，返回默認值 0
	    }

	    String okay = why.getText().trim(); // 直接獲取文本並去除空白字符
	    Integer fine = 0; // 默認值是 0

	    try {
	        if (!okay.isEmpty()) {
	            fine = Integer.parseInt(okay); // 嘗試將文本轉換為整數
	        }
	    } catch (NumberFormatException ex) {
	        System.out.println("無效的數字輸入，設置為默認值 0");
	        fine = 0; // 如果無效，設置為 0
	    }

	    return fine;
	}

	// 加入每天開銷或存錢
	public static void addRecord(DayRecord record) {
		dayRecords.add(record);
	}

	public static List<DayRecord> getDayRecords() {
		return dayRecords;
	}

	public static Integer getTotalSpend() {
		return dayRecords.stream().mapToInt(DayRecord::getSpend).sum();
	}

	public static Integer getTotalSaving() {
		return dayRecords.stream().mapToInt(DayRecord::getSaving).sum();
	}

	public static void updateDisplay() {
		JTextArea howMuchNow=new JTextArea();
		SwingUtilities.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            howMuchNow.setText("");  // 清空
	            howMuchNow.append("目前可用金額： " + (income + getTotalSaving() - fixedSpend) + " 元\n");
	            howMuchNow.append("累計存入金額： " + getTotalSaving() + " 元\n");
	            howMuchNow.append("累計支出金額： " + getTotalSpend() + " 元\n");
	            howMuchNow.append("距離目標金額還差： " + (income - getTotalSaving()) + " 元\n");
	        }});
		}

	
	
	//加上每月結算的部分內容

    public static void addMonthRecord(int pay, int save) throws Exception {
    	MonthRecords().add(new MonthRecord(null, DayPay.getItem(), pay, save));
    }

    public static List<MonthRecord> MonthRecords() {
        return MonthRecords();
    }

    public static List<MonthRecord> getMonthRecordsForCurrentMonth(Integer month) {
        return monthRecords.stream()
                            .filter(record -> record.getMonth() == month)  // 假设 MonthRecord 有 getMonth() 方法
                            .collect(Collectors.toList());
    }
    
    public static int getCurrentMonth() {
        LocalDate today = LocalDate.now();
        return today.getMonthValue();
    }
    
    public static void resetMonthRecords() {
        monthRecords.clear();  // 清空当前月的记录
    }
    
    
    

}
