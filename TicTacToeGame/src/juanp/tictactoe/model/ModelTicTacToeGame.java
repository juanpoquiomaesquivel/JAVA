package juanp.tictactoe.model;

import java.awt.Point;

public class ModelTicTacToeGame extends OneAgainstOneGame {

	private static final Point[][] solutions = { { new Point(0, 0), new Point(0, 1), new Point(0, 2) },
			{ new Point(0, 0), new Point(1, 0), new Point(2, 0) },
			{ new Point(0, 0), new Point(1, 1), new Point(2, 2) },
			{ new Point(1, 1), new Point(0, 1), new Point(2, 1) },
			{ new Point(1, 1), new Point(1, 0), new Point(1, 2) },
			{ new Point(1, 1), new Point(0, 2), new Point(2, 0) },
			{ new Point(2, 2), new Point(2, 0), new Point(2, 1) },
			{ new Point(2, 2), new Point(0, 2), new Point(1, 2) } };
	public static final char[] symbols = { 'x', 'o' };

	private char[][] board;
	private int numberOfMoves;
	private int movement;

	public ModelTicTacToeGame(String firstPlayerName, String secondPlayerName) {
		super(firstPlayerName, secondPlayerName);
		init();
	}

	@Override
	public void reset() {
		super.reset();
		init();
	}

	public boolean markSpot(Point spot) {
		boolean isPosible = !isTheGameOver() && board[spot.x][spot.y] == '_';

		if (isPosible) {
			board[spot.x][spot.y] = symbols[numberOfMoves % 2];
			numberOfMoves++;

			if (!isThereAWinner() && isTheGameOver()) {
				firstPlayer.setLastGameResult(Player.DRAW);
				secondPlayer.setLastGameResult(Player.DRAW);
				System.out.println("enbtraaaaaaaaaaaa");
				status = FINISHED;
			}
		}

		return isPosible;
	}

	private boolean isThereAWinner() {
		int len = solutions.length;

		for (int i = 0; i < len; i++) {
			Point[] sequence = solutions[i];
			Point firstSpot = sequence[0];
			char x = board[firstSpot.x][firstSpot.y];

			if (x == '_') {
				i += 2;
			} else {
				Point secondSpot = sequence[1];
				Point thirdSpot = sequence[2];
				int y = board[secondSpot.x][secondSpot.y];
				int z = board[thirdSpot.x][thirdSpot.y];

				if (x == y && y == z) {
					int winnerIndex = (numberOfMoves - 1) % 2;
					int winnerResult = winnerIndex == 0 ? Player.WIN : Player.DEFEAT;
					int loserResult = winnerIndex == 1 ? Player.WIN : Player.DEFEAT;

					firstPlayer.setLastGameResult(winnerResult);
					secondPlayer.setLastGameResult(loserResult);

					movement = i;
					status = FINISHED;

					return true;
				}
			}
		}

		return false;
	}

	public boolean isTheGameOver() {
		return status == FINISHED || numberOfMoves == 9;
	}

	public Point[] getWinnerMovement() {
		return (movement == -1 ? null : solutions[movement]);
	}

	private void init() {
		board = new char[][] { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
		numberOfMoves = 0;
		movement = -1;
	}

	public char[][] getBoard() {
		return board.clone();
	}

	public int getNumberOfMoves() {
		return numberOfMoves;
	}
}
