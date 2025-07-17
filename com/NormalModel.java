package com;

import javax.swing.JComboBox;

public class NormalModel extends AllModel{
	JComboBox rateChoose;
	Double saveRate;//存錢比例
	
	
	NormalModel(Integer goal, Integer income ,Double saveRate)
	{
		
		super(goal,income);
		String RateChoose=rateChoose.getModel().toString();
		if(RateChoose=="30")
		{	saveRate=0.3;
			saveWorkig=(int) (income*saveRate);
			fixedCost=(int) ((income-saveWorkig)*0.5);
			livingExpenses=income-saveWorkig-fixedCost;
			
		}else if(RateChoose=="50") {
			saveRate=0.5;
			saveWorkig=(int) (income*saveRate);
			fixedCost=(int) ((income-saveWorkig)*0.5);
			livingExpenses=income-saveWorkig-fixedCost;
		}else {
			saveRate=0.7;
			saveWorkig=(int) (income*saveRate);
			fixedCost=(int) ((income-saveWorkig)*0.5);
			livingExpenses=income-saveWorkig-fixedCost;
		}
		
	}
}
