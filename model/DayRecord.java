package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayRecord {
	private Date date;
	private String item; // ComboBox選項
	private Integer spend; // 消費金額
	private Integer saving; // 存入金額

	public DayRecord(Date date,String item, Integer spend, Integer saving) throws Exception {
		this.date=thedate(date);
		this.item = item;
		this.spend = spend;
		this.saving = saving;
		
	}

	public String getItem() {
		return item;
	}

	public Integer getSpend() {
		return spend;
	}

	public Integer getSaving() {
		return saving;
	}
	
	public Date thedate(Date date) throws Exception {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2023-07-20";  // 假設你從某個地方得到的日期字串
        Date value = dateFormat.parse(dateString); 
        return value;
	}

	@Override
	public String toString() {
		return item + " 類別今日消費: " + spend + "元\n 存入: " + saving + "元\n";
	}

	public Date getDate() {
		return date;
	}
}
