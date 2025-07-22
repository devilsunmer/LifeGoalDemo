package com.model.modelChoose;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public abstract class AllModel{
	String goal;//存錢目標
	Integer saveMoney;//存錢目標金額
	Integer saveWorkig;//存錢進度
	Integer income;//每月收入
	Integer fixedCost;//固定開銷-房租、貸款、水電、網路電信
	Integer livingExpenses;//生活開銷-食物、交通、醫療、教育、保養
	String mes;
	
	
	public AllModel() {
        this.goal=goal;
		this.saveMoney = saveMoney;
		this.mes=mes;
		
	}

	public String getGoal() {
		return goal;
	}



	public void setGoal(String goal) {
		this.goal = goal;
	}



	public Integer getSaveMoney() {
		return saveMoney;
	}



	public void setSaveMoney(Integer saveMoney) {
		this.saveMoney = saveMoney;
	}



	public Integer getSaveWorkig() {
		return saveWorkig;
	}

	public void setSaveWorkig(Integer saveWorkig) {
		this.saveWorkig = saveWorkig;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getFixedCost() {
		return fixedCost;
	}

	public void setFixedCost(Integer fixedCost) {
		this.fixedCost = fixedCost;
	}

	public Integer getLivingExpenses() {
		return livingExpenses;
	}

	public void setLivingExpenses(Integer livingExpenses) {
		this.livingExpenses = livingExpenses;
	}
	
	
	
	//JRadioButton轉String
	public String changeToString(JRadioButton change) {
		String Change = change.getText().trim();
		return Change;
	}
	
	//文字轉數字
	public Integer stringToInteger(String Change) {
		Integer change=Integer.parseInt(Change);
		return change;
	}
	
	//JRadioButton轉數字
	public void turnToInt(JRadioButton change) {
		stringToInteger(changeToString(change));
	}
	
	//JSpinner轉數字
	public Integer changeToInt(JSpinner num) {
		Integer value=(Integer)num.getValue();
		return value;
	}
	
	public void setSaveMoneyOption() {}
	
	public void setGoalOption() {}
	
	public String Message() {
		return "請選擇完整模式才可以執行";
	}
	
	
   
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
