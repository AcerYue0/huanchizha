package huanchizha;

import java.awt.*;
import java.util.*;
import java.util.List;
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
	public void setMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setRequestFocusEnabled(false);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	/**
	 * Card deck constructing
	 */
	int mBPX = 30, mBPY = 630, CDSw = 120, CDSh = 180;
	int inhand = 10;
	Point firstBtnPosition = new Point(30, 630);
	Random ran = new Random();
	ArrayList<EngravedRune> Edeck = new ArrayList<EngravedRune>();
	ArrayList<Item> Ideck = new ArrayList<Item>();
	Id idTemp;
	public void addNewCard() {
		int id = ran.nextInt(25) + 4;
		idTemp = new Id(id);
		if(id >= 4 && id <= 9) {
			Item temp = new Item(idTemp, idTemp.getPath());
			Ideck.add(temp);
		}
		else{
			EngravedRune temp = new EngravedRune(idTemp, idTemp.getPath());
			Edeck.add(temp);
		}
	}
	/**
	 * Create frame.
	 */
	public Main() {
		setMainFrame();
		int random_card = ran.nextInt(1) + 9;
		for(int i = 0; i < random_card; i++) {
			addNewCard();
		}
		int card_value = 0;
		for(Card card : Edeck) {
			components_setting(card, card_value);
			card_motion(card);
			card_value++;
		}
		for(Card card : Ideck) {
			components_setting(card, card_value);
			card_motion(card);
			card_value++;
		}
	}
	/**
	 * components attributes setting
	 */
	public void components_setting(Card card, int num) {
		card.setBackground(Color.WHITE);
		if(num == 0) {
			card.setBounds(mBPX, mBPY, CDSw, CDSh);
			contentPane.add(card);
		}
		else {
			card.setBounds(mBPX + num * 125, mBPY, CDSw, CDSh);
		    contentPane.add(card);
		}
	}
	/**
	 * card motion in player's round
	 */
	public void card_motion(Card card) {
		/*card.addMouseListener(new MouseAdapter() {
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
		});*/
		card.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Point originPt = new Point(card.getX(), card.getY());
				Point newLocation;
				if(!card.isClicked()) {
					newLocation = new Point(originPt.x, originPt.y - 20);
					card.setClicked(true);
				}
				else {
					newLocation = new Point(originPt.x, originPt.y + 20);
					card.setClicked(false);
				}
				card.setLocation(newLocation);
                repaint();
			}
		});
	}
}
