package com;

public class ExtremeModel  extends AllModel{
	Integer saveWorkig;//存錢進度

	ExtremeModel(Integer goal, Integer income, Integer saveWorkig)
	{
		super(goal, income);
		this.saveWorkig=(int) (income*0.9);
		fixedCost=(int) (income*0.07);
		livingExpenses=(int) (income*0.03);
	}
	
}
