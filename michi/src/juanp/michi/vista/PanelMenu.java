package juanp.michi.vista;

import java.awt.Color;
import java.awt.Cursor;

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
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

		estado = new JLabel("-", JLabel.CENTER);
		estado.setBackground(Color.red);
		estado.setOpaque(true);
		estado.setSize(300, 40);
		estado.setLocation(50, 10);

		// Inicializando boton Iniciar
		btnJugar = new JButton("Jugar");
		btnJugar.setSize(110, 40);
		btnJugar.setCursor(cursor);
		btnJugar.setLocation(60, 60);

		// Inicializando boton Pausar
		btnDetener = new JButton("Detener");
		btnDetener.setSize(110, 40);
		btnDetener.setCursor(cursor);
		btnDetener.setLocation(230, 60);

		// Inicializando boton Reanudar
		btnReanudar = new JButton("Reanudar");
		btnReanudar.setSize(100, 40);
		btnReanudar.setCursor(cursor);
		btnReanudar.setLocation(25, 120);

		// Inicializando boton Reiniciar
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setSize(100, 40);
		btnReiniciar.setCursor(cursor);
		btnReiniciar.setLocation(150, 120);

		// Inicializando boton Terminar
		btnTerminar = new JButton("Terminar");
		btnTerminar.setSize(100, 40);
		btnTerminar.setCursor(cursor);
		btnTerminar.setLocation(275, 120);

		// Inicializando labels
		player1 = new JLabel("-", JLabel.CENTER);
		player1.setBackground(Color.blue);
		player1.setForeground(Color.white);
		player1.setOpaque(true);
		player1.setSize(110, 30);
		player1.setLocation(60, 165);

		player2 = new JLabel("-", JLabel.CENTER);
		player2.setBackground(Color.blue);
		player2.setForeground(Color.white);
		player2.setOpaque(true);
		player2.setSize(110, 30);
		player2.setLocation(230, 165);

		add(btnJugar);
		add(btnDetener);
		add(btnReanudar);
		add(btnReiniciar);
		add(btnTerminar);
		add(estado);
		add(player1);
		add(player2);
	}

	public JLabel estado;
	public JButton btnJugar;
	public JButton btnDetener;
	public JButton btnReanudar;
	public JButton btnReiniciar;
	public JButton btnTerminar;
	public JLabel player1, player2;
}
