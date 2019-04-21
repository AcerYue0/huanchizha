import java.util.Random;

import javax.swing.JTextField;

public class Simulation {
	
	static Random rnd = new Random(System.currentTimeMillis());
	private int entranceState;
	private RelicState relicState;
	private int dungeonX;
	private int dungeonY;
	private int bossEntranceX;
	private int bossEntranceY = 5;
	private int hero;
	private int dungeon[][];
	
	Simulation(int entranceState, DungeonState dungeonState, int heroCount){
		this.entranceState = entranceState;
		this.dungeonX = dungeonState.getDepthX();
		this.dungeonY = dungeonState.getWidthY();
		this.hero = heroCount;
		setBossEntrance(dungeonState);
	}
	
	private void setBossEntrance(DungeonState dungeonState) {
		switch(dungeonState.getPosition()) {
		case 'U':
			this.bossEntranceX = 2;
			break;
		case 'D':
			this.bossEntranceX = 1;
			break;
		}
		switch(dungeonState.getWidthY()) {
		case 3:
			this.bossEntranceX = 1;
			break;
		case 5:
			this.bossEntranceX = 2;
			break;
		}
	}

	void startDungeonSimulating() {
		if(entranceState == 1) {
			switch(relicState) {
			case NoRelic:
				simulateOneEntrance();
				break;
			case FakeMap:
				simulateOneEntranceWithFakeMap();
				break;
			case RealMap:
				simulateOneEntranceWithRealMap();
				break;
			}
		} else if(entranceState == 3) {
			switch(relicState) {
			case NoRelic:
				simulateThreeEntrance();
				break;
			case FakeMap:
				simulateThreeEntranceWithFakeMap();
				break;
			case RealMap:
				simulateThreeEntranceWithRealMap();
				break;
			}
		}
	}
	
	private void NextBlock(int fromX, int fromY, int toX, int toY) {
		int k;
		int NewX = toX;
	    int NewY = toY;
		switch(relicState) {
		case NoRelic:
			k = rnd.nextInt(4);//no relic 1, 1, 1, 1 (backward, left, forward, right)
			//edge test
			if(toX == 2 && toY == 0) {
				dungeon[bossEntranceX][bossEntranceY]++;
		    } else if(toX == 0 && k == 0) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == 0 && k == 3) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toX == (dungeonX - 1) && k == 2) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == (dungeonY - 1) && k == 1) {
		        NextBlock(fromX, fromY, toX, toY);
		    } 
			//try go to next room
		    else {
		        switch(k)
		        {
		            case 0:
		                NewX--;
		                break;
		            case 1:
		                NewY++;
		                break;
		            case 2:
		                NewX++;
		                break;
		            case 3:
		                NewY--;
		                break;
		        }
		        if(NewX == fromX && NewY == fromY) {
		            NextBlock(fromX, fromY, toX, toY);
		        } else {
		        	dungeon[toX][toY]++;
		            NextBlock(toX, toY, NewX, NewY);
		        }
		    }
			break;
		case FakeMap:
			k = rnd.nextInt(20);//fake map 5, 6, 3, 6 (backward, left, right, forward)
			if(toX == 2 && toY == 0) {
				dungeon[2][0]++;
		    } else if(toX == 0 && k >= 0 && k <= 4) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == 0 && k >= 5 && k <= 10) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toX == (dungeonX - 1) && k >= 11 && k <= 13) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == (dungeonY - 1) && k >= 14 && k <= 20) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else {
		    	if(inRange(k, 0, 4)) {
	                NewX--;
		    	} else if (inRange(k, 5, 10)) {
	                NewY++;
		    	} else if (inRange(k, 11, 13)) {
	                NewX++;
		    	} else if (inRange(k, 14, 20)) {
	                NewY--;
		    	}
		        if(NewX == fromX && NewY == fromY) {
		            NextBlock(fromX, fromY, toX, toY);
		        } else {
		        	dungeon[toX][toY]++;
		            NextBlock(toX, toY, NewX, NewY);
		        }
		    }
			break;
		case RealMap:
			k = rnd.nextInt(200);//real map 0, 75, 50 , 75(backward, left, right, forward)
			if(toX == 2 && toY == 0) {
				dungeon[2][0]++;
		    } else if(toX == 0 && k >= 0 && k <= 4) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == 0 && k >= 5 && k <= 10) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toX == (dungeonX - 1) && k >= 11 && k <= 16) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else if(toY == (dungeonY - 1) && k >= 17 && k <= 20) {
		        NextBlock(fromX, fromY, toX, toY);
		    } else {
		    	if(inRange(k, 0, 4)) {
	                NewX--;
		    	} else if (inRange(k, 5, 10)) {
	                NewY++;
		    	} else if (inRange(k, 11, 16)) {
	                NewX++;
		    	} else if (inRange(k, 17, 20)) {
	                NewY--;
		    	}
		        if(NewX == fromX && NewY == fromY) {
		            NextBlock(fromX, fromY, toX, toY);
		        } else {
		        	dungeon[toX][toY]++;
		            NextBlock(toX, toY, NewX, NewY);
		        }
		    }
			break;
		}
	}

	private void simulateOneEntrance() {
		
	}
	
	private void simulateOneEntranceWithFakeMap() {
		
	}
	
	private void simulateOneEntranceWithRealMap() {
		
	}
	
	private void simulateThreeEntrance() {
		
	}
	
	private void simulateThreeEntranceWithFakeMap() {
		
	}
	
	private void simulateThreeEntranceWithRealMap() {
		
	}

	void replaceProbebilityOf(JTextField[][] normalRoom) {
		for(int i = 0; i < dungeonY; i++) {
			for(int j = 0; j < dungeonX; j++) {
				normalRoom[i][j].setText(String.valueOf((double)dungeon[i][j] / hero));
			}
		}
	}
	
	private boolean inRange(int num, int min, int max) {
		return num <= max && num >= min;
	}
}
