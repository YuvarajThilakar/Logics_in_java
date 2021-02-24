import java.util.Scanner;


public class Game {

	private final Object[][] gameBoard;
	private final Ball ball;

	public Game(int size, int[] brickRowPositions, int[] brickCollumnPositions, Ball ball) {
		gameBoard = new Object[size][size];
		this.ball = ball;

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; j++) {
				if (i == 0 || j == 0 || i == size - 1 || j == size - 1) {
					gameBoard[i][j] = new Wall(i, j);
				}
			}
		}

		for (int i = 0; i < brickRowPositions.length; i++) {
			gameBoard[brickRowPositions[i]][brickCollumnPositions[i]] = new Brick(brickRowPositions[i],
					brickCollumnPositions[i]);
		}
		
	}

	public void moveStraight() {

		this.ball.moveStraight();

		if (this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Brick) {
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = ball;
			System.out.println(this.toString());
			rest(150);
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = null;
			ball.moveToGround(gameBoard.length - 1);

		} else if (gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Wall) {
			ball.moveToOriginalPosition();
		} else {
			rest(100);
			System.out.println(this.getGameBoardAsString());
			moveStraight();
		}

		return;
	}

	public void moveLeft() {

		this.ball.moveLeft();

		if (this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Brick) {
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = ball;
			System.out.println(this.toString());
			rest(150);
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = null;
			ball.moveToGround(gameBoard.length - 1);
			ball.changeOriginalPosition();
		} else if (gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Wall) {
			if (ball.getCurrentRowPosition() == 0) {
				ball.moveToOriginalPosition();
			} else {
				this.ball.backLeft();
				moveRight();
			}
		} else {
			rest(100);
			System.out.println(this.getGameBoardAsString());
			moveLeft();
		}
	}

	public void moveRight() {

		this.ball.moveRight();

		if (this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Brick) {
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = null;
			this.gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] = ball;
			System.out.println(this.toString());
			rest(150);
			ball.moveToGround(gameBoard.length - 1);
			ball.changeOriginalPosition();
		} else if (gameBoard[this.ball.getCurrentRowPosition()][this.ball.getCurrentColumnPosition()] instanceof Wall) {
			if (ball.getCurrentRowPosition() == 0) {
				ball.moveToOriginalPosition();
			} else {
				this.ball.backRight();
				moveLeft();
			}
		} else {
			rest(100);
			System.out.println(this.getGameBoardAsString());
			moveRight();
		}

	}
	
	private void rest(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getGameBoardAsString() {
		StringBuilder gameBoardAsString = new StringBuilder();
		int ballRowCurrentPosition = this.ball.getCurrentRowPosition();
		int ballColCurrentPosition = this.ball.getCurrentColumnPosition();

		for (int i = 0; i < this.gameBoard.length; i++) {
			for (int j = 0; j < this.gameBoard[0].length; j++) {
				if (ballRowCurrentPosition == i && ballColCurrentPosition == j) {
					gameBoardAsString.append("O  ");
				} else if (this.gameBoard[i][j] instanceof Wall) {
					gameBoardAsString.append("W  ");
				} else if (this.gameBoard[i][j] instanceof Brick) {
					gameBoardAsString.append("Br ");
				} else {
					gameBoardAsString.append("   ");
				}
			}
			gameBoardAsString.append("\n");
		}

		return gameBoardAsString.toString();
	}

	// Brick class
	private class Brick {

		private final int i;
		private final int j;

		public Brick(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Brick";
		}
	}

	// Wall class
	private class Wall{

		private final int i;
		private final int j;

		public Wall(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Wall";
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getGameBoardAsString();
	}

	public static void main(String[] args) {
		
		int size = Integer.parseInt(args[0]);
		int ballColPosition = Math.floorDiv(size, 2);
		int[] brickRowPositions = { 2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4};
		int[] brickCollumnPositions = {1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11,12 };

		Game game = new Game(size, brickRowPositions, brickCollumnPositions, new Ball(size - 1, ballColPosition));
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				int option;
				System.out.printf(game.toString());
				System.out.printf("\n1-Straight\n2-Left\n3-Right\n4-Exit\n");

				System.out.print("Enter your option: ");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					game.moveStraight();
					break;
				case 2:
					game.moveLeft();
					break;
				case 3:
					game.moveRight();
					break;
				case 4:
					return;

				default:
					System.out.println("Enter valid option...!");
					break;
				}
			}
		}

	}
}
