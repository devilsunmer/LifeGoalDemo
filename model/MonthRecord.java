package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthRecord {
	private Date date;
	private String itemSet;
	private Integer pay;
	private Integer save;
	 private Integer month;
	
	public MonthRecord(Integer month,String itemSet,Integer pay, Integer save) throws Exception {
		this.month=month;
		this.itemSet=itemSet;
		this.pay = pay;
		this.save = save;
		
	}

	public Integer getPay() {
		return pay;
	}

	public Integer getSave() {
		return save;
	}

	public Date getDate() {
		return date;
	}

	public String getItemSet() {
		return itemSet;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Date thedate(Date date) throws Exception {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         String dateString = "2023-07-20";  // 假設你從某個地方得到的日期字串
         Date value = dateFormat.parse(dateString); 
         return value;
	}
	
	public String dateRecode() {
        return "日期: " + date + " | 類別: " + itemSet + " | 花費金額: " + pay+" | 存入金額: "+save;
    }

}
