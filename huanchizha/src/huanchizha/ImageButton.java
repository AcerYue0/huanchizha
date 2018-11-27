package huanchizha;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.*;

@SuppressWarnings("serial")
public class ImageButton extends JButton {
	Image image;
    ImageObserver imageObserver;
    ImageButton() {
        super();
    }

    public void paint( Graphics g ) {
        super.paint( g );
        g.drawImage(image,  0 , 0 , getWidth() , getHeight() , imageObserver);
    }
    
}
