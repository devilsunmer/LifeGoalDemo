package com.model.modelChoose;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class MarrigeModel extends AllModel{
	JSpinner kid;
	JRadioButton wishKid;
	JRadioButton noneChild;
	JRadioButton noneWedding;
	
	public MarrigeModel(JRadioButton wishKid,JSpinner kid,JRadioButton noneChild,JRadioButton noneWedding) {
		super();
		this.kid=kid;
		this.wishKid=wishKid;
		this.noneChild=noneChild;
		this.noneWedding=noneWedding;
		setGoalOption();
		setSaveMoneyOption();
	}
	
	
	
	public void setSaveMoneyOption() {
		if(wishKid.isSelected()) {
			switch (changeToInt(kid)) {
            case 1:
                this.saveMoney = 520000;  // 1個小孩
                break;
            case 2:
                this.saveMoney = 1020000;  // 2個小孩
                break;
            case 3:
                this.saveMoney = 1520000;  // 3個小孩
                break;
            case 4:
                this.saveMoney = 2020000;  // 4個小孩
                break;
            default:
                this.saveMoney = 2520000;  // 5個小孩
                break;
            }
		}else if(noneChild.isSelected()) {
			this.saveMoney=790000;
		}else {
			this.saveMoney=480000;
		}
	}
	
	public void setGoalOption() {
		if(wishKid.isSelected()) {
			switch (changeToInt(kid)) {
			
			case 1:
                this.goal="結婚+1個小孩";  // 1個小孩
               
                break;
            case 2:
            	this.goal="結婚+2個小孩";  // 2個小孩
            	
                break;
            case 3:
            	this.goal="結婚+3個小孩";  // 3個小孩
            	
                break;
            case 4:
            	this.goal="結婚+4個小孩";  // 4個小孩
            	
            default:
            	this.goal="結婚+5個小孩";  // 5個小孩
            	
                break;
            }
		}else if(noneChild.isSelected()) {
			this.goal="結婚+不要小孩";
			
		}else {
			this.goal="沒有儀式、沒有小孩的簡單婚姻";
			
		}
	}
	
	public String Message() {
		if(wishKid.isSelected()==true) {
			return "謝謝您選擇增產報國的模式，1個不嫌少，多了更是好！";
		}else if(noneChild.isSelected()==true) {
			return "選擇不育的婚姻狀態，以自我、父母、伴侶為主的模式";
		}else if(noneWedding.isSelected()==true) {
			return "已選擇經濟實惠的{裸婚}婚姻模式";
		}else {
			return "請選擇完整模式才可以執行";
		}
	}

	
}
