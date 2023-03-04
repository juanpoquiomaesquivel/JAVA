package juanp.tictactoe.model;

public abstract class Game {

	public static final int WAITING = 0;
	public static final int PLAYING = 1;
	public static final int STOPPED = 2;
	public static final int FINISHED = 3;

	protected int status;

	public void play() {
		status = PLAYING;
	}

	public void stop() {
		status = STOPPED;
	}

	public void resume() {
		status = PLAYING;
	}

	public void reset() {
		status = WAITING;
	}

	public void finish() {
		status = FINISHED;
	}

	public int getStatus() {
		return status;
	}
}
