package game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class setSettingView extends JFrame{
	private JPanel SettingFrame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setGameView frame = new setGameView();
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
		SettingFrame = new JPanel();
		SettingFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		SettingFrame.setRequestFocusEnabled(false);
		SettingFrame.setBackground(Color.WHITE);
		SettingFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(SettingFrame);
		SettingFrame.setLayout(null);
	}
	public setSettingView() {
		setMainFrame();
		setUI();
	}
	private void setUI() {
		
	}
}
