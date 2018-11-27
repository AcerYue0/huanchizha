package huanchizha;

import java.net.URL;

public abstract class Card extends ImageButton {
	private int costPoint;
	private Id info;
	
	public abstract void CardEffect();
	public Card(){
		super();
	}
	public int getCostPoint() {
		return costPoint;
	}
	public void setCostPoint(int costPoint) {
		this.costPoint = costPoint;
	}
	public Id getInfo() {
		return info;
	}
	public void setInfo(Id info) {
		this.info = info;
	}
}
