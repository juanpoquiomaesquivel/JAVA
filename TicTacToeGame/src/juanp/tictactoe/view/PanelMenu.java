package juanp.tictactoe.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	public PanelMenu() {
		setSize(400, 200);
		setLocation(0, 0);
		setLayout(null);
		setBackground(Color.green);
		init();
	}

	private void init() {

		lblGameStatus = new JLabel("-", JLabel.CENTER);
		lblGameStatus.setBackground(Color.red);
		lblGameStatus.setOpaque(true);
		lblGameStatus.setSize(300, 40);
		lblGameStatus.setLocation(50, 10);

		btnPlay = putMenuJButton("Play", new Point(60, 60));
		btnStop = putMenuJButton("Stop", new Point(230, 60));
		btnResume = putMenuJButton("Resume", new Point(25, 120));
		btnReset = putMenuJButton("Reset", new Point(150, 120));
		btnFinish = putMenuJButton("Finish", new Point(275, 120));

		lblFirstPlayer = new JLabel("-", JLabel.CENTER);
		lblFirstPlayer.setBackground(Color.blue);
		lblFirstPlayer.setForeground(Color.white);
		lblFirstPlayer.setOpaque(true);
		lblFirstPlayer.setSize(110, 30);
		lblFirstPlayer.setLocation(60, 165);

		lblSecondPlayer = new JLabel("-", JLabel.CENTER);
		lblSecondPlayer.setBackground(Color.blue);
		lblSecondPlayer.setForeground(Color.white);
		lblSecondPlayer.setOpaque(true);
		lblSecondPlayer.setSize(110, 30);
		lblSecondPlayer.setLocation(230, 165);

		add(btnPlay);
		add(btnStop);
		add(btnResume);
		add(btnReset);
		add(btnFinish);
		add(lblGameStatus);
		add(lblFirstPlayer);
		add(lblSecondPlayer);
	}

	public JLabel lblGameStatus;
	public JButton btnPlay;
	public JButton btnStop;
	public JButton btnResume;
	public JButton btnReset;
	public JButton btnFinish;
	public JLabel lblFirstPlayer, lblSecondPlayer;

	private JButton putMenuJButton(String label, Point location) {
		JButton menuButton = new JButton(label);
		menuButton.setSize(110, 40);
		menuButton.setCursor(menuButtonCursor);
		menuButton.setLocation(location);

		return menuButton;
	}
	
	private static final Cursor menuButtonCursor = new Cursor(Cursor.HAND_CURSOR);
}
