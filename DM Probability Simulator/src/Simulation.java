import java.awt.Point;
import java.util.Random;

import javax.swing.JTextField;

public class Simulation {
	
	static Random rnd = new Random(System.currentTimeMillis());
	private int entranceState;
	private int relicState;
	private int dungeonX;
	private int dungeonY;
	private int hero;
	int dungeon[][];
	
	Simulation(int entranceState, int relicState, Point dungeonState, int heroCount){
		this.entranceState = entranceState;
		this.relicState = relicState;
		this.dungeonX = dungeonState.x;
		this.dungeonY = dungeonState.y;
		this.hero = heroCount;
	}
	
	void startDungeonSimulating() {
		if(entranceState == 1) {
			if(relicState == 1) {
				simulateOneEntrance();
			} else {
				simulateOneEntranceWithFakeMap();
			}
		} else if(entranceState == 3) {
			if(relicState == 1) {
				simulateThreeEntrance();
			} else {
				simulateThreeEntranceWithFakeMap();
			}
		}
	}
	
	private void NextBlock(int fromX, int fromY, int toX, int toY) {
		int k;
		switch(relicState) {
		case 0:
			k = rnd.nextInt(4);//no relic 1, 1, 1, 1
			break;
		case 1:
			k = rnd.nextInt(20);//fake map 5, 6, 6, 3
			break;
		case 2:
			k = rnd.nextInt(200);//real map 0, 75, 75, 50
			break;
		}
	}

	void simulateOneEntrance() {
		
	}
	
	void simulateOneEntranceWithFakeMap() {
		
	}
	
	void simulateOneEntranceWithRealMap() {
		
	}
	
	void simulateThreeEntrance() {
		
	}
	
	void simulateThreeEntranceWithFakeMap() {
		
	}
	
	void simulateThreeEntranceWithRealMap() {
		
	}

	void replaceProbebilityOf(JTextField[][] normalRoom) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dungeonY; i++) {
			for(int j = 0; j < dungeonX; j++) {
				normalRoom[i][j].setText(String.valueOf(dungeon[i][j]));
			}
		}
	}
}
