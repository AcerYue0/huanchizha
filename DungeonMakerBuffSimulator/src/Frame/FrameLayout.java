package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;

public class FrameLayout extends JFrame {

	private static JPanel main;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLayout frame = new FrameLayout();
					frame.setTitle("Dungeon Maker Buff Simulator");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameLayout() {
		contentPaneInitialize();
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
}
