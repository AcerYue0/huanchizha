import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Main extends JFrame {
	//Variable declare
	static long levelUp, nLevel, nPercent, tLevel, score;
	static double sum, scoreRequire;
	static int errorBiggerThanZero, errorMessage;
	
	//Address URL string
	String address = "leeyuchin2618005@gmail.com";
	
	//Components declare
	static int languageCode = 1;
	private String[] languageString = { "中文", "English", "日本語" };
	static String[] languageLabelText = { "語言：", "Choose Language:", "言語：" };
	private JPanel MenuFrame;
	private JLabel languageLabel, levelLabel, expLabel, targetLabel, scoreLabel;
	private JTextArea resultLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox languageList;
	private JButton calcBtn;
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel targetLevelPanel = new JPanel();
	JPanel levelUpPanel = new JPanel();
	private JFormattedTextField nLevelInput, nExpInput, tLevelInput, scoreInput;
	
	//String declare {Chinese, English, Japanese}
	static String[] levelLabelText = { "當前等級：", "Current Level:", "現在のレベル：" };
	static String[] expLabelText = { "當前經驗(%)：", "Exp(%):", "現在の経験値(%)：" };
	static String[] targetLabelText = { "目標等級：", "Target Level:", "狙いレベル：" };
	static String[] scoreLabelText = { "分數：", "Score:", "スコア：" };
	static String[] calcBtnText = { "計算", "Calculate", "計算する" };
	static String[] targetLevelOutputString1 = { "總需求分數最少約", "Total demand score is about ", "総需要スコアは" };
	static String[] targetLevelOutputString2 = { "分", "pt.", "ptくらいです。" };
	static String[] targetPanelString = { "目標等級", "Target Level", "狙いレベル" };
	static String[] levelUpPanelString = { "提升等級", "Level Up", "レベル上がる" };
	static String[] levelUpOutputReachMaxLevel = { String.format("到達3001等！\n這是目前版本的最高重生等級囉"),
			String.format("Reach level 3001! \nThis is the highest rebirth level of the current version."),
			String.format("レベル3001に到着しました！\nこれは現在のバージョンの最高の再生レベルです") };
	static String[] levelUpOutputString1 = { "結算後提升", "Increase ", "決済後、" };
	static String[] levelUpOutputString2 = { String.format("等\n並距離下個等級約"),
			String.format(" levels after settlement,\nAnd about "), String.format("レベルを追加しました。\nつきのレベルとの差は") };
	static String[] levelUpOutputString3 = { String.format("%%"), String.format("%% to the next level."),
			String.format("%%くらいです。") };
	
	//TextBox format
	static NumberFormat format = NumberFormat.getNumberInstance();
	
	//Run application
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
	//Main frame setting
	public void setMainFrame() {
		setTitle("Dungeon Maker Exp Calculator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		MenuFrame = new JPanel();
		MenuFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		MenuFrame.setRequestFocusEnabled(false);
		MenuFrame.setBackground(Color.WHITE);
		MenuFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		MenuFrame.setLayout(null);
		tabbedPane.setBounds(0, 39, 584, 28);
		tabbedPane.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		MenuFrame.add(tabbedPane);
		setContentPane(MenuFrame);
	}

	/**
	 * Create the frame.
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Main() {
		
		setMainFrame();
		
		//TabbedPane setup
		targetLevelPanel.setLayout(null);
		targetLevelPanel.setRequestFocusEnabled(false);
		targetLevelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		targetLevelPanel.setBackground(Color.WHITE);

		levelUpPanel.setLayout(null);
		levelUpPanel.setRequestFocusEnabled(false);
		levelUpPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		levelUpPanel.setBackground(Color.WHITE);
		
		//TabbedPane setting
		tabbedPane.addTab(targetPanelString[languageCode], null, targetLevelPanel, null);
		tabbedPane.addTab(levelUpPanelString[languageCode], null, levelUpPanel, null);
		tabbedPane.setSelectedIndex(0);

		//Components setup
		languageList = new JComboBox(languageString);
		languageList.setBounds(248, 10, 108, 32);
		languageList.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		languageList.setSelectedIndex(1);

		languageLabel = new JLabel();
		languageLabel.setText(languageLabelText[languageCode]);
		languageLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		languageLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		languageLabel.setBounds(98, 10, 140, 32);

		levelLabel = new JLabel();
		expLabel = new JLabel();
		targetLabel = new JLabel();
		scoreLabel = new JLabel();

		levelLabel.setText(levelLabelText[languageCode]);
		levelLabel.setBounds(78, 77, 148, 24);
		levelLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		levelLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		expLabel.setText(expLabelText[languageCode]);
		expLabel.setBounds(78, 114, 148, 24);
		expLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		expLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		targetLabel.setText(targetLabelText[languageCode]);
		targetLabel.setBounds(78, 151, 148, 24);
		targetLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		targetLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		scoreLabel.setText(scoreLabelText[languageCode]);
		scoreLabel.setBounds(78, 151, 148, 24);
		scoreLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		resultLabel = new JTextArea(" ");
		resultLabel.setColumns(3);
		resultLabel.setEditable(false);
		resultLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		resultLabel.setBounds(54, 263, 477, 115);

		calcBtn = new JButton(calcBtnText[languageCode]);
		calcBtn.setBounds(235, 222, 115, 29);
		calcBtn.setFont(new Font("微軟正黑體", Font.PLAIN, 15));

		nExpInput = new JFormattedTextField(format);
		nExpInput.setBounds(236, 113, 234, 27);
		nExpInput.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		nExpInput.setHorizontalAlignment(SwingConstants.RIGHT);
		nExpInput.setColumns(1);

		nLevelInput = new JFormattedTextField(format);
		nLevelInput.setBounds(236, 76, 234, 27);
		nLevelInput.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		nLevelInput.setHorizontalAlignment(SwingConstants.RIGHT);
		nLevelInput.setColumns(1);

		scoreInput = new JFormattedTextField(format);
		scoreInput.setBounds(236, 151, 234, 27);
		scoreInput.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		scoreInput.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreInput.setColumns(1);

		tLevelInput = new JFormattedTextField(format);
		tLevelInput.setBounds(236, 151, 234, 27);
		tLevelInput.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		tLevelInput.setHorizontalAlignment(SwingConstants.RIGHT);
		tLevelInput.setColumns(1);
		
		JLabel lblReportBugsTo = new JLabel("<html><br><font size=2><a href=#>" + address + "</a></font></html>");
		lblReportBugsTo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblReportBugsTo.setText("Bugs report: leeyuchin2681005@gmail.com");
		lblReportBugsTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReportBugsTo.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblReportBugsTo.setBounds(308, 388, 276, 24);
		lblReportBugsTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReportBugsTo.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            Desktop.getDesktop().mail(new URI("mailto:" + address + "?subject=Bug%20report"));
		        } catch (URISyntaxException | IOException ex) {
		        }
		    }
		});
		//Components setting
		MenuFrame.add(languageList);
		MenuFrame.add(languageLabel);
		MenuFrame.add(levelLabel);
		MenuFrame.add(expLabel);
		MenuFrame.add(targetLabel);
		MenuFrame.add(scoreLabel);
		MenuFrame.add(resultLabel);
		MenuFrame.add(calcBtn);
		MenuFrame.add(nExpInput);
		MenuFrame.add(nLevelInput);
		MenuFrame.add(tLevelInput);
		MenuFrame.add(scoreInput);
		MenuFrame.add(lblReportBugsTo);

		scoreInput.setVisible(false);
		scoreLabel.setVisible(false);
		tLevelInput.setVisible(true);
		targetLabel.setVisible(true);
		//Tab change
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					tLevelInput.setText("");
					scoreInput.setText("");
					nLevelInput.setText("");
					nExpInput.setText("");
					scoreInput.setVisible(false);
					scoreLabel.setVisible(false);
					tLevelInput.setVisible(true);
					targetLabel.setVisible(true);
					break;
				case 1:
					tLevelInput.setText("");
					scoreInput.setText("");
					nLevelInput.setText("");
					nExpInput.setText("");
					tLevelInput.setVisible(false);
					targetLabel.setVisible(false);
					scoreInput.setVisible(true);
					scoreLabel.setVisible(true);
					break;
				}
			}
		});
		//Calculate button click
		calcBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag = 0;
				errorMessage = 0; 			//regular error message combine up
				errorBiggerThanZero = 0;	//negative number error message combine up
				levelUp = 0; 				//total level increase
				sum = 0; 					//total score require
				if (nLevelInput.getText().equals("")) {
					errorMessage += 1;
				} else {
					nLevel = Long.parseLong(nLevelInput.getText().replace(",", ""));
					if (nLevel < 0) {
						errorBiggerThanZero += 1;
					}
				}
				if (nExpInput.getText().equals("")) {
					errorMessage += 2;
				} else {
					nPercent = Long.parseLong(nExpInput.getText().replace(",", ""));
					if (nPercent < 0) {
						errorBiggerThanZero += 2;
					}
				}
				if (tLevelInput.getText().equals("") && scoreInput.getText().equals("")) {
					errorMessage += 4;
				} else {
					switch (tabbedPane.getSelectedIndex()) {
					case 0:
						tLevel = Long.parseLong(tLevelInput.getText().replace(",", ""));
						if (tLevel < 0) {
							errorBiggerThanZero += 4;
						}
						else if(tLevel > 3001) {
							flag = 1;
						}
						break;
					case 1:
						score = Long.parseLong(scoreInput.getText().replace(",", ""));
						if (score < 0) {
							errorBiggerThanZero += 4;
						}
						break;
					}

				}
				if (errorMessage != 0 || errorBiggerThanZero != 0) {
					result();
				} else {
					switch (tabbedPane.getSelectedIndex()) {
					case 0:
						if(flag == 0) {
							targetPanelActivity();
						} else {
							resultLabel.setText(languageCode == 0 ? "目標等級不能超過3001。" : languageCode == 1 ? "Target level cannot bigger than 3001." : "狙いレベル3001超えるには入力できません。");
						}
						break;
					case 1:
						levelUpPanelActivity();
						break;
					}
				}
			}
		});
		//Language change
		languageList.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				switch (languageList.getSelectedIndex()) {
				case 0:
					languageCode = 0;//Chinese
					break;
				case 1:
					languageCode = 1;//English
					break;
				case 2:
					languageCode = 2;//Japanese
					break;
				default:
				}
				languageChange(languageCode);//Execute language change
			}
		});
	}
	
	//Calculate for target level
	public void targetPanelActivity() {
		for (int i = (int) nLevel; i <= (int) tLevel; i++) {
			scoreRequire = (((75 * Math.pow(i - 1, 2)) + (250 * (i - 1)) + 250) * ((float)(100 - nPercent) / 100)); //Formula
			sum += scoreRequire;
			nPercent = 0;
		}
		//Output
		resultLabel.setText(targetLevelOutputString1[languageCode] + Math.round(sum) + targetLevelOutputString2[languageCode]);
	}

	//Calculate for leveling
	private void levelUpPanelActivity() {
		scoreRequire = (((75 * Math.pow(nLevel - 1, 2)) + (250 * (nLevel - 1)) + 250) 
				* ((100 - (float) nPercent) / 100));																//Formula
		while (scoreRequire - score <= 0) {
			score -= scoreRequire;
			levelUp++;
			nPercent = 0;
			scoreRequire = (((75 * Math.pow(nLevel + levelUp - 1, 2)) + (250 * (nLevel + levelUp - 1))
					+ 250) * ((float)(100 - nPercent) / 100));
		}
		//Output
		if (nLevel + levelUp >= 3001) {
			resultLabel.setText(levelUpOutputReachMaxLevel[languageCode]);
		} else {
			resultLabel.setText(levelUpOutputString1[languageCode] + levelUp + levelUpOutputString2[languageCode]
					+ Math.round((1 - ((double) score / scoreRequire)) * 100) + levelUpOutputString3[languageCode]);
		}
	}
	//Error message declare
	static String[][] targetError = { { "當前等級", "當前經驗", "目標等級", "不能為空。", "、" },
			{ "Current Level", "Exp", "Target Level", " cannot be empty.", ", " },
			{ "現在のレベル", "現在の経験値", "狙いレベル", "を空白にはできません。", "、" } };
	static String[][] levelError = { { "當前等級", "當前經驗", "分數", "不能為空。", "、" },
			{ "Current Level", "Exp", "Score", " cannot be empty.", ", " },
			{ "現在のレベル", "現在の経験値", "スコア", "を空白にはできません。", "、" } };
	static String[] biggerThanZero = { "應大於0。", " cannot enter a number less than 0.", "0未満は入力できません。" };

	//Error logic
	private void result() {
		switch (tabbedPane.getSelectedIndex()) {
		case 0:
			fLevelError();
			break;
		case 1:
			fScoreError();
			break;
		}
	}

	//Score error function
	private void fScoreError() {
		switch (errorMessage) {
		case 1:
			resultLabel.setText(levelError[languageCode][0] + levelError[languageCode][3] + "\n");
			break;
		case 2:
			resultLabel.setText(levelError[languageCode][1] + levelError[languageCode][3] + "\n");
			break;
		case 3:
			resultLabel.setText(levelError[languageCode][0] + levelError[languageCode][4] + levelError[languageCode][1]
					+ levelError[languageCode][3] + "\n");
			break;
		case 4:
			resultLabel.setText(levelError[languageCode][2] + levelError[languageCode][3] + "\n");
			break;
		case 5:
			resultLabel.setText(levelError[languageCode][0] + levelError[languageCode][4] + levelError[languageCode][2]
					+ levelError[languageCode][3] + "\n");
			break;
		case 6:
			resultLabel.setText(levelError[languageCode][1] + levelError[languageCode][4] + levelError[languageCode][2]
					+ levelError[languageCode][3] + "\n");
			break;
		case 7:
			resultLabel.setText(levelError[languageCode][0] + levelError[languageCode][4] + levelError[languageCode][1]
					+ levelError[languageCode][4] + levelError[languageCode][2] + levelError[languageCode][3] + "\n");
			break;
		}
		switch (errorBiggerThanZero) {
		case 1:
			resultLabel
					.setText(resultLabel.getText() + levelError[languageCode][0] + biggerThanZero[languageCode] + "\n");
			break;
		case 2:
			resultLabel
					.setText(resultLabel.getText() + levelError[languageCode][1] + biggerThanZero[languageCode] + "\n");
			break;
		case 3:
			resultLabel.setText(resultLabel.getText() + levelError[languageCode][0] + levelError[languageCode][4]
					+ levelError[languageCode][1] + biggerThanZero[languageCode] + "\n");
			break;
		case 4:
			resultLabel
					.setText(resultLabel.getText() + levelError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 5:
			resultLabel.setText(resultLabel.getText() + levelError[languageCode][0] + levelError[languageCode][4]
					+ levelError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 6:
			resultLabel.setText(resultLabel.getText() + levelError[languageCode][1] + levelError[languageCode][4]
					+ levelError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 7:
			resultLabel.setText(resultLabel.getText() + levelError[languageCode][0] + levelError[languageCode][4]
					+ levelError[languageCode][1] + levelError[languageCode][4] + levelError[languageCode][2]
					+ biggerThanZero[languageCode] + "\n");
			break;
		}
	}

	//Leveling error function
	private void fLevelError() {
		switch (errorMessage) {
		case 1:
			resultLabel.setText(targetError[languageCode][0] + targetError[languageCode][3] + "\n");
			break;
		case 2:
			resultLabel.setText(targetError[languageCode][1] + targetError[languageCode][3] + "\n");
			break;
		case 3:
			resultLabel.setText(targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][1] + targetError[languageCode][3] + "\n");
			break;
		case 4:
			resultLabel.setText(targetError[languageCode][2] + targetError[languageCode][3] + "\n");
			break;
		case 5:
			resultLabel.setText(targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][2] + targetError[languageCode][3] + "\n");
			break;
		case 6:
			resultLabel.setText(targetError[languageCode][1] + targetError[languageCode][4]
					+ targetError[languageCode][2] + targetError[languageCode][3] + "\n");
			break;
		case 7:
			resultLabel.setText(targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][1] + targetError[languageCode][4] + targetError[languageCode][2]
					+ targetError[languageCode][3] + "\n");
			break;
		}
		switch (errorBiggerThanZero) {
		case 1:
			resultLabel.setText(
					resultLabel.getText() + targetError[languageCode][0] + biggerThanZero[languageCode] + "\n");
			break;
		case 2:
			resultLabel.setText(
					resultLabel.getText() + targetError[languageCode][1] + biggerThanZero[languageCode] + "\n");
			break;
		case 3:
			resultLabel.setText(resultLabel.getText() + targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][1] + biggerThanZero[languageCode] + "\n");
			break;
		case 4:
			resultLabel.setText(
					resultLabel.getText() + targetError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 5:
			resultLabel.setText(resultLabel.getText() + targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 6:
			resultLabel.setText(resultLabel.getText() + targetError[languageCode][1] + targetError[languageCode][4]
					+ targetError[languageCode][2] + biggerThanZero[languageCode] + "\n");
			break;
		case 7:
			resultLabel.setText(resultLabel.getText() + targetError[languageCode][0] + targetError[languageCode][4]
					+ targetError[languageCode][1] + targetError[languageCode][4] + targetError[languageCode][2]
					+ biggerThanZero[languageCode] + "\n");
			break;
		}
	}
	
	//Language change with changing code
	protected void languageChange(int language) {
		languageLabel.setText(languageLabelText[language]);
		calcBtn.setText(calcBtnText[language]);
		levelLabel.setText(levelLabelText[language]);
		expLabel.setText(expLabelText[language]);
		targetLabel.setText(targetLabelText[language]);
		scoreLabel.setText(scoreLabelText[language]);
		tabbedPane.setTitleAt(0, targetPanelString[language]);
		tabbedPane.setTitleAt(1, levelUpPanelString[language]);
	}
}
