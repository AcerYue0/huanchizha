package game.card;

import game.Id;
import game.object.ImageButton;

@SuppressWarnings("serial")
public abstract class Card extends ImageButton {
	private int costPoint;
	private Id info;
	private boolean clicked;
	
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
	public boolean isClicked() {
		return clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
}
