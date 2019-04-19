import java.util.Random;

public class Simulation {

	static Random rnd = new Random(System.currentTimeMillis());
	private int entranceState;
	private int relicState;
	Simulation(int entranceState, int relicState){
		this.entranceState = entranceState;
		this.relicState = relicState;
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

	void simulateOneEntrance() {
		
	}
	
	void simulateOneEntranceWithFakeMap() {
		
	}
	
	void simulateThreeEntrance() {
		
	}
	
	void simulateThreeEntranceWithFakeMap() {
		
	}
}
