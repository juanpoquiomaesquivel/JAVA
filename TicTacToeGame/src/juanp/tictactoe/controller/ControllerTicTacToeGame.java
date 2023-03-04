package juanp.tictactoe.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import juanp.tictactoe.model.Game;
import juanp.tictactoe.model.ModelTicTacToeGame;
import juanp.tictactoe.model.Player;
import juanp.tictactoe.view.ViewTicTacToeGame;

public class ControllerTicTacToeGame {

	private final ModelTicTacToeGame model;
	private final ViewTicTacToeGame view;

	public ControllerTicTacToeGame(ModelTicTacToeGame model, ViewTicTacToeGame view) {
		this.model = model;
		this.view = view;
		init();
	}

	public void iniciar() {
		String firstPlayerName;
		String secondPlayerName;

		do {
			firstPlayerName = JOptionPane.showInputDialog("Player 1:");
		} while (firstPlayerName == null || firstPlayerName.isBlank() || firstPlayerName.isEmpty());

		do {
			secondPlayerName = JOptionPane.showInputDialog("Player 2:");
		} while (secondPlayerName == null || secondPlayerName.isBlank() || secondPlayerName.isEmpty());

		model.getFirstPlayer().setNickname(firstPlayerName);
		model.getSecondPlayer().setNickname(secondPlayerName);
		view.panelMenu.lblFirstPlayer.setText("x -> " + firstPlayerName);
		view.panelMenu.lblSecondPlayer.setText("o -> " + secondPlayerName);
	}

	private void init() {
		view.panelMenu.btnPlay.addActionListener(ae -> {

			int gameStatus = model.getStatus();

			if (gameStatus == Game.WAITING) {
				model.play();
				view.panelMenu.lblGameStatus.setText("PLAYING");
			}
		});

		view.panelMenu.btnStop.addActionListener(ae -> {

			int gameStatus = model.getStatus();

			if (gameStatus == Game.PLAYING) {
				model.stop();
				view.panelMenu.lblGameStatus.setText("STOPPED");
			}
		});

		view.panelMenu.btnResume.addActionListener(ae -> {

			int gameStatus = model.getStatus();

			if (gameStatus == Game.STOPPED) {
				model.resume();
				view.panelMenu.lblGameStatus.setText("PLAYING");
			}
		});

		view.panelMenu.btnReset.addActionListener(ae -> {

			int gameStatus = model.getStatus();

			if (gameStatus != Game.WAITING) {
				model.reset();
				cleanSpots(view.panelTicTacToeGame.matrizCasillas);
				view.panelMenu.lblGameStatus.setText("WAITING");
			}
		});

		view.panelMenu.btnFinish.addActionListener(ae -> {

			int gameStatus = model.getStatus();

			if (gameStatus != Game.WAITING && gameStatus != Game.FINISHED) {
				model.finish();
				view.panelMenu.lblGameStatus.setText("FINISHED");
			}
		});

		JButton[][] buttonSpots = view.panelTicTacToeGame.matrizCasillas;
		var cmichi = new ActionListenerTicTacToeGame();

		for (JButton[] buttonSpotsRow : buttonSpots) {
			for (JButton buttonSpot : buttonSpotsRow) {
				buttonSpot.addActionListener(cmichi);
			}
		}
	}

	private void cleanSpots(JButton[][] spots) {
		for (JButton[] spotsRow : spots) {
			for (JButton spot : spotsRow) {
				spot.setText("");
			}
		}
	}

	private class ActionListenerTicTacToeGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			int gameStatus = model.getStatus();

			if (gameStatus == Game.PLAYING) {
				String[] coordinates = ((JButton) ae.getSource()).getName().split(":");
				int x = Integer.parseInt(coordinates[0]);
				int y = Integer.parseInt(coordinates[1]);
				boolean isPosible = model.markSpot(new Point(x, y));

				if (isPosible) {
					int index = (model.getNumberOfMoves() - 1) % 2;
					String symbol = String.valueOf(ModelTicTacToeGame.symbols[index]);
					view.panelTicTacToeGame.matrizCasillas[x][y].setText(symbol);

					if (model.isTheGameOver()) {
						Player fp = model.getFirstPlayer();
						Player sp = model.getSecondPlayer();

						String gameResult = "First Player: " + fp.getNickname() + " -> " + fp.getLastGameResult();
						gameResult += "\nSecond Player: " + sp.getNickname() + " -> " + sp.getLastGameResult();

						JOptionPane.showMessageDialog(view, gameResult);
						view.panelMenu.lblGameStatus.setText("FINALIZADO");
					}
				}
			}
		}
	}
}
