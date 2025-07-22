package model;

import java.util.Objects;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class DayPay {
	
	private JComboBox dayPayChoose;
	private static JTextField dayPay;
	private static JTextField daySave;
	static String item;
	static Integer spend;
	static Integer save;
	static Integer futureTotalSpend;
	static Integer futureTotalsave;
	static Integer availableMoney;
	
	public DayPay(JComboBox dayPayChoose,JTextField dayPay,JTextField daySave) {
		super();
		this.setDayPayChoose(dayPayChoose);
		this.dayPay=dayPay;
		this.daySave=daySave;
	}

	public static String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public int getFutureTotalSpend() {
		return futureTotalSpend;
	}

	public void setFutureTotalSpend(int futureTotalSpend) {
		this.futureTotalSpend = futureTotalSpend;
	}

	public int getFutureTotalsave() {
		return futureTotalsave;
	}

	public void setFutureTotalsave(int futureTotalsave) {
		this.futureTotalsave = futureTotalsave;
	}

	public int getAvailableMoney() {
		
		return availableMoney;
	}

	public void setAvailableMoney(int availableMoney) {
		this.availableMoney = availableMoney;
	}
	
	public static Integer changeByInt(JTextField ha) {
		String fast = Objects.requireNonNullElse(ha != null ? ha.getText() : null, "").trim();
		Integer value=Integer.parseInt(fast);
		return value;
	}

	public JComboBox getDayPayChoose() {
		return dayPayChoose;
	}

	public void setDayPayChoose(JComboBox dayPayChoose) {
		this.dayPayChoose = dayPayChoose;
	}
	
}
