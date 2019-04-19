import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.net.URL;

import javax.swing.JSeparator;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class dungeonLayout extends JFrame {
	static Random rnd = new Random(System.currentTimeMillis());
	static URL imageXMarkGray = dungeonLayout.class.getResource("xMarkGray.png");
	static URL imageXMarkRed = dungeonLayout.class.getResource("xMarkRed.png");
	static BufferedImage buttonIcon;
	static int imageButtonState;
	static int normalRoomStartY;

	private static JPanel contentPane;
	private static JTextField bossRoom, heroValue;
	private static JTextField[][] normalRoom = new JTextField[5][6];
	private static JSeparator separator = new JSeparator();
	private static List<JButton> dungeonEntrance = new ArrayList<JButton>();
	private static JButton calculate = new JButton();

	static NumberFormat format = NumberFormat.getNumberInstance();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dungeonLayout frame = new dungeonLayout();
					frame.setTitle("Dungeon Maker Probability Simulator");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public dungeonLayout() throws IOException {
		componentsInitialize();
	}

	private void componentsInitialize() throws IOException {
		contentPaneInitialize();
		bossRoomInitialize();
		dungeonEntranceInitialize();
		normalRoomsInitialize();
		separatorInitialize();
		calculateButtonInitialize();
		heroValueTextBoxInitialize();
	}

	private void contentPaneInitialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		setContentPane(contentPane);
	}

	private void bossRoomInitialize() {
		bossRoom = new JTextField();
		bossRoom.setBackground(Color.LIGHT_GRAY);
		bossRoom.setBounds(40, 130, 200, 200);
		bossRoom.setFont(new Font("�L�n������", Font.PLAIN, 15));
		bossRoom.setEditable(false);
		bossRoom.setHorizontalAlignment(SwingConstants.CENTER);
		bossRoom.setText("Boss Room");
		bossRoom.setColumns(10);
		contentPane.add(bossRoom);
	}

	private void normalRoomsInitialize() {
		normalRoomStartY = 40;
		for(int i = 0; i < 5; i++) {
			int normalRoomStartX = 660;
			for(int j = 0; j < 6; j++) {
				normalRoom[i][j] = new JTextField();
				normalRoom[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				normalRoom[i][j].setEditable(false);
				normalRoom[i][j].setBounds(normalRoomStartX, normalRoomStartY, 60, 60);
				contentPane.add(normalRoom[i][j]);
				normalRoom[i][j].setColumns(10);
				normalRoomStartX -= 80;
			}
			normalRoomStartY += 80;
		}
	}

	private void dungeonEntranceInitialize() throws IOException {
		JButtonInitialize();
		normalRoomStartY = 40;
		for(JButton i : dungeonEntrance) {
			if(i == dungeonEntrance.get(2)) {
				setRedIcon(i);
			}
			else {
				setGrayIcon(i);
			}
			dungeonEntranceListener(i);
			i.setBounds(740, normalRoomStartY, 60, 60);
			i.setBorder(BorderFactory.createEmptyBorder());
			i.setContentAreaFilled(false);
			i.setFocusable(false);
			contentPane.add(i);
			normalRoomStartY += 80;
		}
	}

	private void separatorInitialize() {
		separator.setBounds(40, 450, 755, 2);
		contentPane.add(separator);
	}

	private void calculateButtonInitialize() {
		JButtonListener(calculate);
		calculate.setBounds(40, 490, 60, 25);
		calculate.setText("GO");
		calculate.setBorder(new EmptyBorder(0, 0, 0, 0));
		calculate.setBackground(Color.decode("#d6faff"));
		calculate.setFont(new Font("�L�n������", Font.PLAIN, 13));
		contentPane.add(calculate);
	}

	private void heroValueTextBoxInitialize() {
		heroValue = new JFormattedTextField(format);
		heroValue.setBackground(Color.WHITE);
		heroValue.setBounds(130, 490, 100, 25);
		heroValue.setFont(new Font("�L�n������", Font.PLAIN, 13));
		heroValue.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(heroValue);
	}

	private void JButtonInitialize() {
		for(int i = 0; i < 5; i++) {
			dungeonEntrance.add(new JButton());
		}
	}

	private void dungeonEntranceListener(final JButton Button) {
		Button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	try {
					changeIcon(Button);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		});
	}

	private void JButtonListener(JButton Button) {
		Button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	dungeonSimulation();
		    }
		});
	}
	
	private void dungeonSimulation() {
		
		//TODO logic emulation
	}

	protected void changeIcon(JButton Button) throws IOException {
		switch(imageButtonState) {
		case 0:
			setRedIcon(Button);
			break;
		case 1:
			setGrayIcon(Button);
			break;
		}
	}

	private void setGrayIcon(JButton Button) throws IOException {
		buttonIcon = ImageIO.read(imageXMarkGray);
		Button.setIcon(new ImageIcon(buttonIcon));
		imageButtonState = 0;
	}

	private void setRedIcon(JButton Button) throws IOException {
		buttonIcon = ImageIO.read(imageXMarkRed);
		Button.setIcon(new ImageIcon(buttonIcon));
		imageButtonState = 1;
	}
}