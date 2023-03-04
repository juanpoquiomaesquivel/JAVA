package juanp.tictactoe;

import juanp.tictactoe.controller.ControllerTicTacToeGame;
import juanp.tictactoe.model.ModelTicTacToeGame;
import juanp.tictactoe.view.ViewTicTacToeGame;

public class Main {

	public static void main(String[] args) {
		ModelTicTacToeGame modelTicTacToeGame = new ModelTicTacToeGame(null, null);
		ViewTicTacToeGame viewTicTacToeGame = new ViewTicTacToeGame();
		ControllerTicTacToeGame controllerTicTacToeGame = new ControllerTicTacToeGame(modelTicTacToeGame, viewTicTacToeGame);
		controllerTicTacToeGame.iniciar();
		viewTicTacToeGame.setVisible(true);
	}
}
