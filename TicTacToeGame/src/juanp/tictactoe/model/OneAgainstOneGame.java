package juanp.tictactoe.model;

public abstract class OneAgainstOneGame extends Game {
	
	protected Player firstPlayer;
	protected Player secondPlayer;

	public OneAgainstOneGame(String firstPlayerName, String secondPlayerName) {
		this.firstPlayer = new Player(firstPlayerName);
		this.secondPlayer = new Player(secondPlayerName);
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}
}
