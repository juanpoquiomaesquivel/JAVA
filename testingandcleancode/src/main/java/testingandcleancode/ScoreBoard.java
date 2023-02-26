package testingandcleancode;

public class ScoreBoard {

	private Integer ties;
	private Integer wins;
	private Integer loses;
	
	public ScoreBoard() {
		ties = 0;
		wins = 0;
		loses = 0;
	}

	public Integer getTies() {
		return ties;
	}

	public void incrementTies() {
		this.ties++;
	}

	public Integer getWins() {
		return wins;
	}

	public void incrementWins() {
		this.wins++;
	}

	public Integer getLoses() {
		return loses;
	}

	public void incrementLoses() {
		this.loses++;
	}
}
