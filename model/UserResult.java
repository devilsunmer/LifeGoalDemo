package model;

public class UserResult {
	public String goal;
	public Integer saveMoney;
	
	public UserResult(String goal, Integer saveMoney) {
		super();
		this.goal = goal;
		this.saveMoney = saveMoney;
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
	
	
}
