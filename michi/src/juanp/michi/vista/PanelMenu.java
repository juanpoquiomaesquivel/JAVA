package juanp.michi.vista;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {

	public PanelMenu() {
		setSize(300, 200);
		setLocation(0, 0);
		setLayout(null);
		setBackground(Color.blue);
		init();
	}

	private void init() {
		// Inicializando boton Iniciar
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setSize(100, 40);
		btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciar.setLocation(10, 10);

		add(btnIniciar);
	}

	public JButton btnIniciar;
}
