package juanp.tictactoe.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ViewTicTacToeGame extends JFrame {

	public ViewTicTacToeGame() {
		setTitle("Tic Tac Toe");
		setSize(400, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setPreferredSize(new Dimension(400, 600));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(panelMenu);
		add(panelTicTacToeGame);
	}

	public PanelMenu panelMenu = new PanelMenu();
	public PanelTicTacToeGame panelTicTacToeGame = new PanelTicTacToeGame();
}
