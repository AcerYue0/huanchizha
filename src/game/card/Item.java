package game.card;

import java.net.URL;

import javax.swing.ImageIcon;

import game.Id;

@SuppressWarnings("serial")
public class Item extends Card{
	boolean status;
	
	public void CardEffect() {
		
	}
	public Item(Id id){
		super();
		ImageIcon icon = new ImageIcon(id.getPath());
	    image = icon.getImage();
	    imageObserver = icon.getImageObserver();
		setInfo(id);
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
