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
		setBounds(100, 100, 1200, 840);
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
	int mBPX = 538, mBPY = 591, CDSw = 120, CDSh = 180;
	int inhand = 10;
	Point midBtnPosition = new Point(538, 591);
	Integer[] ids = new Integer[] {
			0, 1, 3, 6, 
			1200, 1201, 1300, 1301, 1500, 1501, 
			200, 201, 202, 203, 
			300, 301, 302, 303, 
			400, 401, 402, 403, 404, 
			500, 501, 502, 503, 504, 
			600, 
			10402
	};
	Random ran = new Random();
	List<Integer> idStorage = Arrays.asList(ids);
	List<CardId> cardList = Arrays.asList(CardId.values());
	List<CardPath> cardPathList = Arrays.asList(CardPath.values());
	ArrayList<EngravedRune> Edeck = new ArrayList<EngravedRune>();
	ArrayList<Item> Ideck = new ArrayList<Item>();
	
	@SuppressWarnings("unlikely-arg-type")
	public void addNewCard() {
		int id = ran.nextInt(25) + 4;
		CardPath cardpath = null;
		if(cardList.contains(idStorage.get(id))) {
			cardpath = (CardPath) cardPathList.get((int)idStorage.indexOf(id));
		}
		if(id >= 4 && id <= 9) {
			Item temp = new Item(new Id((int)idStorage.get(id)), cardpath.path);
			Ideck.add(temp);
		}
		else{
			EngravedRune temp = new EngravedRune(new Id((int)idStorage.get(id)), cardpath.path);
			Edeck.add(temp);
		}
	}
	/**
	 * Create frame.
	 */
	public Main() {
		setMainFrame();
		int random_card = ran.nextInt(10) + 1;
		for(int i = 0; i < random_card; i++) {
			addNewCard();
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
	/**
	 * components attributes setting
	 */
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
	/**
	 * card motion in player's round
	 */
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
