package com;

public class CustomModel extends AllModel{
	
	public CustomModel(Integer goal, Integer income,Integer fixedCost,Integer livingExpenses) {
		super(goal, income);
		this.fixedCost=fixedCost;
		this.livingExpenses=livingExpenses;
		this.saveWorkig=income-fixedCost-livingExpenses;
	}

}
