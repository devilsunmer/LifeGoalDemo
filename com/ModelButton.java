package com;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class ModelButton {
	//UI操作介面使用
	
	JLabel kidUnit;
	JSpinner kid;
	JRadioButton wishKid;
	JRadioButton noneChild;
	JRadioButton noneWedding;
	JRadioButton richHouse;
	JRadioButton familyHouse;
	JRadioButton simpleHouse;
	
	
	
	
	public ModelButton(JLabel kidUnit, JSpinner kid, JRadioButton wishKid, JRadioButton noneChild,
			JRadioButton noneWedding) {
		super();
		this.kidUnit = kidUnit;
		this.kid = kid;
		this.wishKid = wishKid;
		this.noneChild = noneChild;
		this.noneWedding = noneWedding;
	}

	public ModelButton(JRadioButton richHouse, JRadioButton familyHouse, JRadioButton simpleHouse) {
		super();
		this.richHouse = richHouse;
		this.familyHouse = familyHouse;
		this.simpleHouse = simpleHouse;
	}



	public void marrigeOption(boolean setOption,JLabel kidUnit, JSpinner kid, JRadioButton wishKid, JRadioButton noneChild,
			JRadioButton noneWedding)
	{	wishKid.setVisible(setOption);
		kid.setVisible(setOption);
		kidUnit.setVisible(setOption);
		noneChild.setVisible(setOption);
		noneWedding.setVisible(setOption);
	}
	
	public void houseOption(boolean setOption,JRadioButton richHouse, JRadioButton familyHouse, JRadioButton simpleHouse)
	{	
		simpleHouse.setVisible(setOption);
		richHouse.setVisible(setOption);
		familyHouse.setVisible(setOption);
	}
}
