public class DungeonState {
	private int depthX;
	private int widthY;
	private char position;
	private RelicState relicState; 
	
	public DungeonState(int depthX, int widthY, char position, RelicState relicState) {
		this.depthX = depthX;
		this.widthY = widthY;
		this.position = position;
		this.relicState = relicState;
	}
	
	public RelicState getRelicState() {
		return relicState;
	}

	public void setRelicState(RelicState relicState) {
		this.relicState = relicState;
	}

	public int getDepthX() {
		return depthX;
	}
	public void setDepthX(int depthX) {
		this.depthX = depthX;
	}
	public int getWidthY() {
		return widthY;
	}
	public void setWidthY(int widthY) {
		this.widthY = widthY;
	}
	public char getPosition() {
		return position;
	}
	public void setPosition(char position) {
		this.position = position;
	}
	
}
