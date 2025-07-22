package com.model.modelChoose;

import javax.swing.JTextField;

public class LikeThingModel extends AllModel{
	JTextField likeThingPayMoney;
	JTextField likeThingName;
	
	public LikeThingModel(JTextField likeThingName,JTextField likeThingPayMoney) {
		super();
		this.likeThingPayMoney=likeThingPayMoney;
		this.likeThingName=likeThingName;
		setSaveMoneyOption();
		setGoalOption();
	}
	
	public void setSaveMoneyOption() {
		this.saveMoney=(stringToInteger(likeThingPayMoney.getText()));
	}
	
	public void setGoalOption() {
			this.goal=likeThingName.getText();
	}
	
	public String Message() {
		return "為了"+likeThingName.getText()+"將要努力存"+likeThingPayMoney.getText()+"元";
	}
	

}
