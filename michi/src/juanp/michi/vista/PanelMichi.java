package juanp.michi.vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMichi extends JPanel {

	public PanelMichi() {
		setSize(300, 300);
		setLocation(0, 200);
		setLayout(null);
		setBackground(Color.red);
		init();
	}

	private void init() {
		// Inicializando casillas (JButton)
		matrizCasillas = new JButton[3][3];

		for (var i = 0; i < matrizCasillas.length; i++) {
			for (var j = 0; j < matrizCasillas[0].length; j++) {
				matrizCasillas[i][j] = new JButton();
				matrizCasillas[i][j].setName(i + ":" + j);
				matrizCasillas[i][j].setSize(100, 100);
				matrizCasillas[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}

		matrizCasillas[0][0].setLocation(0, 0);
		matrizCasillas[0][1].setLocation(100, 0);
		matrizCasillas[0][2].setLocation(200, 0);
		matrizCasillas[1][0].setLocation(0, 100);
		matrizCasillas[1][1].setLocation(100, 100);
		matrizCasillas[1][2].setLocation(200, 100);
		matrizCasillas[2][0].setLocation(0, 200);
		matrizCasillas[2][1].setLocation(100, 200);
		matrizCasillas[2][2].setLocation(200, 200);

		for (var filaCasillas : matrizCasillas) {
			for (var casilla : filaCasillas) {
				add(casilla);
			}
		}

	}

	public JButton[][] matrizCasillas;
}
