package juanp.tictactoe.view;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTicTacToeGame extends JPanel {

	public PanelTicTacToeGame() {
		setSize(400, 400);
		setLocation(0, 200);
		setLayout(null);
		setBackground(Color.green);
		init();
	}

	private void init() {
		// Inicializando casillas (JButton)
		matrizCasillas = new JButton[3][3];

		for (var i = 0; i < matrizCasillas.length; i++) {
			for (var j = 0; j < matrizCasillas[0].length; j++) {
				matrizCasillas[i][j] = new JButton();
				matrizCasillas[i][j].setName(i + ":" + j);
				matrizCasillas[i][j].setSize(132, 132);
				matrizCasillas[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}

		matrizCasillas[0][0].setLocation(1, 1);
		matrizCasillas[0][1].setLocation(134, 1);
		matrizCasillas[0][2].setLocation(267, 1);
		matrizCasillas[1][0].setLocation(1, 134);
		matrizCasillas[1][1].setLocation(134, 134);
		matrizCasillas[1][2].setLocation(267, 134);
		matrizCasillas[2][0].setLocation(1, 267);
		matrizCasillas[2][1].setLocation(134, 267);
		matrizCasillas[2][2].setLocation(267, 267);

		for (var filaCasillas : matrizCasillas) {
			for (var casilla : filaCasillas) {
				add(casilla);
			}
		}

	}

	public JButton[][] matrizCasillas;
}
