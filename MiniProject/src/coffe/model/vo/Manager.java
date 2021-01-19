package coffe.model.vo;


public class Manager{
	
	private String coffeName;
	private int water;
	private int bean;
	private int time;
	
	public Manager() {
		
	}

	public Manager(String coffeName, int water, int bean, int time) {
		this.coffeName = coffeName;
		this.water = water;
		this.bean = bean;
		this.time = time;
	}

	public String getCoffeName() {
		return coffeName;
	}

	public void setCoffeName(String coffeName) {
		this.coffeName = coffeName;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getBean() {
		return bean;
	}

	public void setBean(int bean) {
		this.bean = bean;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "커피이름 : " + coffeName + " 물양 : " + water + " 커피양 : " + bean + " 시간 : " + time + "\n";
	}
	
	
}
	
	
	