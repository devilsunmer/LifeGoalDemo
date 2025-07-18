package com;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class ModelButton {
	//UI操作介面使用
	JPanel marrigeChoose;
	JLabel kidUnit;
	JSpinner kid;
	JRadioButton wishKid;
	JRadioButton noneChild;
	JRadioButton noneWedding;
	JPanel hoceChoose;
	JRadioButton richHouse;
	JRadioButton familyHouse;
	JRadioButton simpleHouse;
	JPanel likeThingChoose;
	JTextField likeThingPayMoney;
	JTextField likeThingName;
	JLabel likeThingPay;
	JLabel likeThingTitle;
	
	
	



	public ModelButton(JPanel marrigeChoose, JLabel kidUnit, JSpinner kid, JRadioButton wishKid, JRadioButton noneChild,
			JRadioButton noneWedding, JPanel hoceChoose, JRadioButton richHouse, JRadioButton familyHouse,
			JRadioButton simpleHouse, JPanel likeThingChoose, JTextField likeThingPayMoney, JTextField likeThingName,
			JLabel likeThingPay, JLabel likeThingTitle) {
		super();
		this.marrigeChoose = marrigeChoose;
		this.kidUnit = kidUnit;
		this.kid = kid;
		this.wishKid = wishKid;
		this.noneChild = noneChild;
		this.noneWedding = noneWedding;
		this.hoceChoose = hoceChoose;
		this.richHouse = richHouse;
		this.familyHouse = familyHouse;
		this.simpleHouse = simpleHouse;
		this.likeThingChoose = likeThingChoose;
		this.likeThingPayMoney = likeThingPayMoney;
		this.likeThingName = likeThingName;
		this.likeThingPay = likeThingPay;
		this.likeThingTitle = likeThingTitle;
	}

	public void marrigeOption(setOption,wishKid,kid,noneChild,noneWedding)
	{	
		this.kidUnit=kidUnit;
		
		wishKid.setVisible(setOption);
		kid.setVisible(setOption);
		kidUnit.setVisible(setOption);
		noneChild.setVisible(setOption);
		noneWedding.setVisible(setOption);
		marrigeChoose.setVisible(setOption);
	}
	
	public void houseOption(setOption)
	{	
		simpleHouse.setVisible(setOption);
		richHouse.setVisible(setOption);
		familyHouse.setVisible(setOption);
	}
	
	public void likeThingOption(boolean setOption,JRadioButton richHouse, JRadioButton familyHouse, JRadioButton simpleHouse)
	{	
		simpleHouse.setVisible(setOption);
		richHouse.setVisible(setOption);
		familyHouse.setVisible(setOption);
	}
}
