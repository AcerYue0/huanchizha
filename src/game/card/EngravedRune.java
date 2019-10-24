package game.card;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Id;

@SuppressWarnings("serial")
public class EngravedRune extends Card{
	int evadePoint;
	int accuracyPoint;
	int valuePoint;
	public void CardEffect() {
		
	}
	public EngravedRune(Id id){
		super();
		ImageIcon icon = new ImageIcon(id.getPath());
		image = icon.getImage();
		imageObserver = icon.getImageObserver();
		setInfo(id);
	}
	
	public int getEvadePoint() {
		return evadePoint;
	}
	public void setEvadePoint(int evadePoint) {
		this.evadePoint = evadePoint;
	}
	public int getAccuracyPoint() {
		return accuracyPoint;
	}
	public void setAccuracyPoint(int accuracyPoint) {
		this.accuracyPoint = accuracyPoint;
	}
	public int getValuePoint() {
		return valuePoint;
	}
	public void setValuePoint(int valuePoint) {
		this.valuePoint = valuePoint;
	}
}
