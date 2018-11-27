package huanchizha;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class Main extends JFrame {
	private JPanel contentPane;
	
	/**
	 * Launch application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int mBPX = 538, mBPY = 591, CDSw = 120, CDSh = 180;
	Point midBtnPosition = new Point(538, 591);
	/**
	 * Create frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 840);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setRequestFocusEnabled(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int inhand = 10;
		ArrayList<EngravedRune> Edeck = new ArrayList<EngravedRune>();
		ArrayList<Item> Ideck = new ArrayList<Item>();
		for(int i = 0; i < inhand; i++) {
			Random ran = new Random();
			int id = ran.nextInt(22);
			if(id < 16) {
				EngravedRune temp = new EngravedRune(new Id(id), Main.class.getResource("/resources/icon.png"));
				Edeck.add(temp);
			}
			else{
				Item temp = new Item(new Id(id), Main.class.getResource("/resources/icon.png"));
				Ideck.add(temp);
			}
		}
		int card_value = 1;
		for(Card card : Edeck) {
			card_motion(card);
			components_setting(card, card_value);
			card_value++;
		}
		for(Card card : Ideck) {
			card_motion(card);
			components_setting(card, card_value);
			card_value++;
		}
	}
	/**components attributes setting**/
	public void components_setting(Card card, int num) {
		card.setBackground(Color.WHITE);
		if(num == 1) {
			card.setBounds(mBPX, mBPY, CDSw, CDSh);
			contentPane.add(card);
		}
		else {
			switch(num % 2) {
				case 0:
				    card.setBounds(mBPX - num * 40, mBPY, CDSw, CDSh);
				    contentPane.add(card);
				    break;
				case 1:
				    card.setBounds(mBPX + num * 40, mBPY, CDSw, CDSh);
				    contentPane.add(card);
				    break;
			}
		}
	}
	/**card motion in player's round**/
	public void card_motion(Card card) {
		card.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Point originPt = new Point(card.getX(), card.getY());
				Point coords = new Point(e.getX(), e.getY());
                Point newLocation = new Point(originPt.x + coords.x - card.getHeight() / 2, originPt.y + coords.y - card.getWidth() / 2);
				card.setLocation(newLocation);
                repaint();
			}
		});
		card.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point originPt = new Point(card.getX(), card.getY());
				Point coords = new Point(e.getX(), e.getY());
                Point newLocation = new Point(originPt.x + coords.x - card.getWidth() / 2, originPt.y + coords.y - card.getHeight() / 2);
				card.setLocation(newLocation);
                repaint();
			}
		});
		
	}
}
