package controller;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.RealTimeUI;
import com.model.modelChoose.AllModel;

public class ModelButton {
	//UI操作介面使用
	private RealTimeUI realTimeUI;
	private JTextField goalTextField;
	private JTextField hopeSaveMoneyTextField;
	JPanel marrigeChoose;
	JLabel kidUnit;
	JSpinner kid;
	JRadioButton wishKid;
	JRadioButton noneChild;
	JRadioButton noneWedding;
	JPanel houseChoose;
	JRadioButton richHouse;
	JRadioButton familyHouse;
	JRadioButton simpleHouse;
	JPanel likeThingChoose;
	JTextField likeThingPayMoney;
	JTextField likeThingName;
	JLabel likeThingPay;
	JLabel likeThingTitle;
	boolean setOption;
	
	public ModelButton(RealTimeUI realTimeUI, JTextField goalTextField, JTextField hopeSaveMoneyTextField) {
		super();
		this.realTimeUI = realTimeUI;
		this.goalTextField = goalTextField;
		this.hopeSaveMoneyTextField = hopeSaveMoneyTextField;
	}

	public ModelButton(JPanel marrigeChoose,JRadioButton wishKid,
			JSpinner kid,JLabel kidUnit,JRadioButton noneChild,JRadioButton noneWedding,JPanel houseChoose,JRadioButton simpleHouse, JRadioButton familyHouse,
			JRadioButton richHouse,JPanel likeThingChoose,JLabel likeThingTitle, JTextField likeThingName,
			JLabel likeThingPay, JTextField likeThingPayMoney) {
		super();
		this.marrigeChoose = marrigeChoose;
		this.kidUnit = kidUnit;
		this.kid = kid;
		this.wishKid = wishKid;
		this.noneChild = noneChild;
		this.noneWedding = noneWedding;
		this.houseChoose = houseChoose;
		this.richHouse = richHouse;
		this.familyHouse = familyHouse;
		this.simpleHouse = simpleHouse;
		this.likeThingChoose = likeThingChoose;
		this.likeThingPayMoney = likeThingPayMoney;
		this.likeThingName = likeThingName;
		this.likeThingPay = likeThingPay;
		this.likeThingTitle = likeThingTitle;
	}

	public void marrigeOption(boolean setOption)
	{	
		marrigeChoose.setVisible(setOption);
		wishKid.setVisible(setOption);
		kid.setVisible(setOption);
		kidUnit.setVisible(setOption);
		noneChild.setVisible(setOption);
		noneWedding.setVisible(setOption);
	}
	
	public void houseOption(boolean setOption)
	{	
		houseChoose.setVisible(setOption);
		simpleHouse.setVisible(setOption);
		richHouse.setVisible(setOption);
		familyHouse.setVisible(setOption);
	}
	
	public void likeThingOption(boolean setOption)
	{	
		likeThingChoose.setVisible(setOption);
		likeThingPayMoney.setVisible(setOption);
		likeThingName.setVisible(setOption);
		likeThingPay.setVisible(setOption);
		likeThingTitle.setVisible(setOption);
	}
	
	public void clearOption(boolean setOption)
	{
		marrigeChoose.setVisible(setOption);
		wishKid.setVisible(setOption);
		kid.setVisible(setOption);
		kidUnit.setVisible(setOption);
		noneChild.setVisible(setOption);
		noneWedding.setVisible(setOption);
		houseChoose.setVisible(setOption);
		simpleHouse.setVisible(setOption);
		richHouse.setVisible(setOption);
		familyHouse.setVisible(setOption);
		likeThingChoose.setVisible(setOption);
		likeThingPayMoney.setVisible(setOption);
		likeThingName.setVisible(setOption);
		likeThingPay.setVisible(setOption);
		likeThingTitle.setVisible(setOption);
		
	}
	
	public void updateModelAndUI(AllModel model) {
        // 获取 UI 中的目标和存款金额
        String goal = goalTextField.getText();
        Integer hopeSaveMoney = Integer.parseInt(hopeSaveMoneyTextField.getText());

        // 更新模型中的目标和存款金额
        model.setGoal(goal);
        model.setSaveMoney(hopeSaveMoney);

        // 在 RealTime 中更新目标和存款金额显示
//        realTimeUI.updateRealTimeUI(goal, hopeSaveMoney);
    }
	
}
