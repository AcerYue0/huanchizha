package game.object;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.*;

@SuppressWarnings("serial")
public class ImageButton extends JButton {
	protected Image image;
    protected ImageObserver imageObserver;
    protected ImageButton() {
        super();
    }

    public void paint( Graphics g ) {
        super.paint( g );
        g.drawImage(image,  0 , 0 , getWidth() , getHeight() , imageObserver);
    }
    
}
