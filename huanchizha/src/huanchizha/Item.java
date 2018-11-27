package huanchizha;

import java.net.URL;

import javax.swing.ImageIcon;

public class Item extends Card{
	boolean status;
	
	public void CardEffect() {
		
	}
	public Item(Id id, URL filename){
		super();
		ImageIcon icon = new ImageIcon(filename);
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
