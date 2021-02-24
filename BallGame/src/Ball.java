
public class Ball {

	private int currentRowPosition;
	private int currentColumnPosition;
	
	private int originalRowPosition;
	private int originalColumnPosition;
	
	public Ball(int originalI, int originalJ) {
		super();
		this.originalRowPosition = originalI;
		this.originalColumnPosition = originalJ;
		
		this.currentRowPosition = originalI;
		this.currentColumnPosition = originalJ;
	}
	
	public void setCurrentPosition(int i, int j){
		this.currentRowPosition = i;
		this.currentColumnPosition = j;
	}
	
	public void setOriginalPosition(int i, int j){
		this.originalRowPosition = i;
		this.originalColumnPosition = j;
	}

	public int getCurrentRowPosition() {
		return currentRowPosition;
	}

	public int getCurrentColumnPosition() {
		return currentColumnPosition;
	}

	public int getOriginalRowPosition() {
		return originalRowPosition;
	}

	public int getOriginalColumnPosition() {
		return originalColumnPosition;
	}
	
	public void moveStraight() {
		this.currentRowPosition -= 1;
	}
	
	public void moveLeft() {
		this.currentRowPosition -= 1;
		this.currentColumnPosition -= 1;
	}
	
	public void backLeft() {
		this.currentRowPosition += 1;
		this.currentColumnPosition += 1;
	}
	
	public void moveRight() {
		this.currentRowPosition -= 1;
		this.currentColumnPosition += 1;
	}
	
	public void backRight() {
		this.currentRowPosition += 1;
		this.currentColumnPosition -= 1;
	}
	
	public void moveToOriginalPosition() {
		this.currentRowPosition = this.originalRowPosition;
		this.currentColumnPosition = this.originalColumnPosition;
	}
	
	public void moveToGround(int j) {
		this.currentRowPosition = j;
	}
	
	public void changeOriginalPosition() {
		this.originalRowPosition = this.currentRowPosition;
		this.originalColumnPosition = this.currentColumnPosition;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ball";
	}
}
