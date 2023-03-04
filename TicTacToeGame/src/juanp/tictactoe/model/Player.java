package juanp.tictactoe.model;

public class Player {

	public static final int UNDEFINED = 0;
	public static final int DEFEAT = 1;
	public static final int DRAW = 2;
	public static final int WIN = 3;

	private String nickname;
	private int lastGameResult;

	public Player(String nickname) {
		this.nickname = nickname;
		this.lastGameResult = UNDEFINED;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLastGameResult() {
		return lastGameResult;
	}

	public void setLastGameResult(int lastGameResult) {
		this.lastGameResult = lastGameResult;
	}
}
