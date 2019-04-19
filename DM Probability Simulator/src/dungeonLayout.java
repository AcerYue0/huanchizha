import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class dungeonLayout extends JFrame {
	static URL imageXMarkGray = dungeonLayout.class.getResource("xMarkGray.png");
	static URL imageXMarkRed = dungeonLayout.class.getResource("xMarkRed.png");
	static BufferedImage buttonIcon;
	static int componentsSetNormalRoomStartY, componentsSetNormalRoomStartX;
	static int dungeonSizeY = 0, dungeonSizeX = 0, entranceState = 1, relicState = 1;
	static String dungeonSizeString[] = { 
			" 3x3", " 3x4(U)", " 3x4(D)", " 3x5",
			" 4x3", " 4x4(U)", " 4x4(D)", " 4x5",
			" 5x3", " 5x4(U)", " 5x4(D)", " 5x5",
			" 6x3", " 6x4(U)", " 6x4(D)", " 6x5" 
	};
	static String entranceCountString[] = {" 1", " 3"};

	private static JPanel main;
	private static JTextField bossRoom, heroValue;
	private static JLabel heroValueLabel, dungeonSizeLabel, errorLabel, entranceCountLabel;
	private static JTextField[][] normalRoom = new JTextField[5][6];
	private static JSeparator separator = new JSeparator();
	private static List<JLabel> dungeonEntrance = new ArrayList<JLabel>();
	private static JButton calculate = new JButton();
	private static JComboBox<String> dungeonSize = new JComboBox<String>();
	private static JComboBox<String> entranceCount = new JComboBox<String>();
	private static JCheckBox relicStateCheck = new JCheckBox();

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
		normalRoomsInitialize(5, 6, 660, 40);
		separatorInitialize();
		calculateButtonInitialize();
		heroValueTextBoxInitialize();
		heroValueLabelInitialize();
		errorLabelInitialize();
		dungeonSizeInitialize();
		dungeonSizeLabelInitialize();
		entranceCountInitialize();
		entranceCountLabelInitialize();
		relicStateCheckInitialize();
	}

	private void contentPaneInitialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 600);
		main = new JPanel();
		main.setBackground(Color.WHITE);
		main.setBorder(new EmptyBorder(0, 0, 0, 0));
		main.setLayout(null);
		setContentPane(main);
	}

	private void dungeonSizeLabelInitialize() {
		dungeonSizeLabel = new JLabel();
		dungeonSizeLabel.setBounds(40, 40, 150, 25);
		dungeonSizeLabel.setText("地宮大小(高x深)：");
		dungeonSizeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dungeonSizeLabel.setVerticalAlignment(SwingConstants.CENTER);
		dungeonSizeLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		main.add(dungeonSizeLabel);
	}

	private void dungeonSizeInitialize() {
		for (String s : dungeonSizeString) {
			dungeonSize.addItem(s);
		}
		dungeonSizeListener(dungeonSize);
		dungeonSize.setBounds(40, 70, 100, 25);
		dungeonSize.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		dungeonSize.setAlignmentX(RIGHT_ALIGNMENT);
		dungeonSize.setSelectedIndex(15);
		main.add(dungeonSize);
	}

	private void entranceCountLabelInitialize() {
		entranceCountLabel = new JLabel();
		entranceCountLabel.setBounds(40, 335, 100, 25);
		entranceCountLabel.setText("入口數量：");
		entranceCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		entranceCountLabel.setVerticalAlignment(SwingConstants.CENTER);
		entranceCountLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		main.add(entranceCountLabel);
	}
	
	private void entranceCountInitialize() {
		for (String s : entranceCountString) {
			entranceCount.addItem(s);
		}
		entranceCountListener(entranceCount);
		entranceCount.setBounds(40, 365, 80, 25);
		entranceCount.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		entranceCount.setAlignmentX(RIGHT_ALIGNMENT);
		entranceCount.setSelectedIndex(0);
		main.add(entranceCount);
	}
	
	private void relicStateCheckInitialize() {
		relicStateCheckListener(relicStateCheck);
		relicStateCheck.setBounds(40, 400, 100, 25);
		relicStateCheck.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		relicStateCheck.setAlignmentX(RIGHT_ALIGNMENT);
		relicStateCheck.setText("偽造地宮?");
		relicStateCheck.setBackground(Color.WHITE);
		main.add(relicStateCheck);
	}

	private void bossRoomInitialize() {
		bossRoom = new JTextField();
		bossRoom.setBackground(Color.LIGHT_GRAY);
		bossRoom.setBounds(40, 130, 200, 200);
		bossRoom.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		bossRoom.setEditable(false);
		bossRoom.setHorizontalAlignment(SwingConstants.CENTER);
		bossRoom.setText("Boss Room");
		bossRoom.setColumns(10);
		main.add(bossRoom);
	}

	private void normalRoomsInitialize(int newDungeonHeight, int newDungeonDeep, int startX, int startY) {
		removeRooms();
		dungeonSizeY = newDungeonHeight;
		dungeonSizeX = newDungeonDeep;
		componentsSetNormalRoomStartY = startY;
		for (int i = 0; i < newDungeonHeight; i++) {
			componentsSetNormalRoomStartX = startX;
			for (int j = 0; j < newDungeonDeep; j++) {
				normalRoom[i][j] = new JTextField();
				normalRoom[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				normalRoom[i][j].setEditable(false);
				normalRoom[i][j].setBounds(componentsSetNormalRoomStartX, componentsSetNormalRoomStartY, 60, 60);
				normalRoom[i][j].setColumns(10);
				normalRoom[i][j].setText("0");
				main.add(normalRoom[i][j]);
				componentsSetNormalRoomStartX -= 80;
			}
			componentsSetNormalRoomStartY += 80;
		}
		dungeonEntranceInitialize(startX + 80, startY, newDungeonHeight);
	}

	private void dungeonEntranceInitialize(int x, int y, int value) {
		main.repaint();
		JLabelInitialize(value);
		componentsSetNormalRoomStartY = y;
		for (JLabel i : dungeonEntrance) {
			if (componentsSetNormalRoomStartY == 200) {
				setRedIcon(i);
			} else {
				setGrayIcon(i);
			}
			i.setBounds(x, componentsSetNormalRoomStartY, 60, 60);
			i.setBorder(BorderFactory.createEmptyBorder());
			i.setFocusable(false);
			main.add(i);
			componentsSetNormalRoomStartY += 80;
		}
	}

	private void removeRooms() {
		for (int i = 0; i < dungeonSizeY; i++) {
			for (int j = 0; j < dungeonSizeX; j++) {
				main.remove(normalRoom[i][j]);
			}
		}
		for(JLabel Label : dungeonEntrance) {
			main.remove(Label);
		}
		main.repaint();
	}

	private void separatorInitialize() {
		separator.setBounds(40, 450, 755, 2);
		main.add(separator);
	}

	private void calculateButtonInitialize() {
		JButtonListener(calculate);
		calculate.setBounds(40, 490, 60, 25);
		calculate.setText("GO");
		calculate.setBorder(new EmptyBorder(0, 0, 0, 0));
		calculate.setBackground(Color.decode("#d6faff"));
		calculate.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		main.add(calculate);
	}

	private void heroValueTextBoxInitialize() {
		heroValue = new JFormattedTextField(format);
		heroValue.setBackground(Color.WHITE);
		heroValue.setBounds(240, 490, 100, 25);
		heroValue.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		heroValue.setHorizontalAlignment(SwingConstants.RIGHT);
		main.add(heroValue);
	}

	private void heroValueLabelInitialize() {
		heroValueLabel = new JLabel();
		heroValueLabel.setBounds(130, 490, 100, 25);
		heroValueLabel.setText("勇士數量：");
		heroValueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		heroValueLabel.setVerticalAlignment(SwingConstants.CENTER);
		heroValueLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		main.add(heroValueLabel);
	}
	
	private void errorLabelInitialize() {
		errorLabel = new JLabel();
		errorLabel.setBounds(40, 520, 300, 25);
		errorLabel.setText("");
		errorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		errorLabel.setVerticalAlignment(SwingConstants.CENTER);
		errorLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		main.add(errorLabel);
	}

	private void JLabelInitialize(int value) {
		dungeonEntrance.removeAll(dungeonEntrance);
		for (int i = 0; i < value; i++) {
			dungeonEntrance.add(new JLabel());
		}
	}

	private void JButtonListener(JButton Button) {
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dungeonSimulation();
			}
		});
	}

	private void dungeonSizeListener(JComboBox<String> comboBox) {
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = comboBox.getSelectedItem().toString();
					int newH = Character.getNumericValue(item.charAt(3));
					int newV = Character.getNumericValue(item.charAt(1));
					char position = (item.length() > 5) ? item.charAt(5) : 'M';
					componentsSetNormalRoomStartX = 260 + (newV - 1) * 80;
					componentsSetNormalRoomStartY = (newH == 3 || position == 'D'? 120 : 40);
					normalRoomsInitialize(newH, newV, componentsSetNormalRoomStartX, componentsSetNormalRoomStartY);
			    }
			}
		});
	}

	private void entranceCountListener(JComboBox<String> comboBox) {
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int item = Integer.parseInt(comboBox.getSelectedItem().toString().trim());
					switch(item) {
					case 1:
						for(JLabel Label : dungeonEntrance) {
							if (Label.getY() == 200) {
								setRedIcon(Label);
							} else {
								setGrayIcon(Label);
							}
						}
						entranceState = 1;
						break;
					case 3:
						for(JLabel Label : dungeonEntrance) {
							if (dungeonEntrance.indexOf(Label) == 0 || dungeonEntrance.indexOf(Label) == dungeonEntrance.size() - 1) {
								setRedIcon(Label);
							} else if (Label.getY() == 200) {
								setRedIcon(Label);
							} else {
								setGrayIcon(Label);
							}
						}
						entranceState = 3;
						break;
					}
			    }
			}
		});
	}

	private void relicStateCheckListener(JCheckBox checkBox) {
		relicStateCheck.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					relicState = 0;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					relicState = 1;
				}
				System.out.println(relicState);
			}
		});
	}

	private void dungeonSimulation() {
		Simulation sim = new Simulation(entranceState, relicState);
		sim.startDungeonSimulating();
	}

	private void setGrayIcon(JLabel Label) {
		setIcon(imageXMarkGray);
		Label.setIcon(new ImageIcon(buttonIcon));
	}

	private void setRedIcon(JLabel Label) {
		setIcon(imageXMarkRed);
		Label.setIcon(new ImageIcon(buttonIcon));
	}

	private void setIcon(URL image) {
		try {
			buttonIcon = ImageIO.read(image);
		} catch (IOException e1) {
			System.out.println("No such file found, please contact us to fix out.");
		}
	}
}
