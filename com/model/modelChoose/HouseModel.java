package com.model.modelChoose;

import javax.swing.JRadioButton;

public class HouseModel extends AllModel{
	JRadioButton richHouse;
	JRadioButton familyHouse;
	JRadioButton simpleHouse;
	
	public HouseModel(JRadioButton simpleHouse,JRadioButton familyHouse,JRadioButton richHouse) {
		super();
		this.richHouse=richHouse;
		this.familyHouse=familyHouse;
		this.simpleHouse=simpleHouse;
		setSaveMoneyOption();
		setGoalOption();
		
		}
	
	public void setSaveMoneyOption() {
		if(simpleHouse.isSelected()) {
			this.saveMoney=7500000;
		}else if(familyHouse.isSelected()) {
			this.saveMoney=120000000;
		}else {
			this.saveMoney=35000000;
		}
	}
	
	public void setGoalOption() {
		if(simpleHouse.isSelected()) {
		this.goal="一房一廳";
	}else if(familyHouse.isSelected()) {
		this.goal="家庭房";
	}else {
		this.goal="高級住宅生活";
	}}
	
	public String Message() {
		if(simpleHouse.isSelected()==true) {
			return "已選擇購置簡單生活使用的房屋模式";
		}else if(familyHouse.isSelected()==true) {
			return "已選擇購置家庭使用的房屋模式";
		}else if(richHouse.isSelected()==true){
			return "將要挑戰高級住宅存錢模式";
		}else {
			return "請選擇完整模式才可以執行";
		}
	}

}
