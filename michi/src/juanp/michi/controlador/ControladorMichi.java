package juanp.michi.controlador;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import juanp.michi.modelo.Juego;
import juanp.michi.modelo.ModeloMichi;
import juanp.michi.vista.VistaMichi;

public class ControladorMichi {

	private final ModeloMichi modelo;
	private final VistaMichi vista;

	public ControladorMichi(ModeloMichi modelo, VistaMichi vista) {
		this.modelo = modelo;
		this.vista = vista;
		init();
	}

	public void iniciar() {
		String nombreJugador1, nombreJugador2;

		do {
			nombreJugador1 = JOptionPane.showInputDialog("Jugador 1:");
		} while (nombreJugador1 == null || nombreJugador1.isBlank() || nombreJugador1.isEmpty());

		do {
			nombreJugador2 = JOptionPane.showInputDialog("Jugador 1:");
		} while (nombreJugador2 == null || nombreJugador2.isBlank() || nombreJugador2.isEmpty());

		modelo.getJugador1().setNickname(nombreJugador1);
		modelo.getJugador2().setNickname(nombreJugador2);
		vista.panelMenu.player1.setText("x -> " + nombreJugador1);
		vista.panelMenu.player2.setText("o -> " + nombreJugador2);
	}

	public void init() {
		// menu
		vista.panelMenu.btnJugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var estado = modelo.getEstado();

				if (estado == Juego.ESPERANDO) {
					modelo.jugar();
					vista.panelMenu.estado.setText("JUGANDO");
				}
			}
		});

		vista.panelMenu.btnDetener.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var estado = modelo.getEstado();

				if (estado == Juego.JUGANDO) {
					modelo.detener();
					vista.panelMenu.estado.setText("DETENIDO");
				}
			}
		});

		vista.panelMenu.btnReanudar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var estado = modelo.getEstado();

				if (estado == Juego.DETENIDO) {
					modelo.reanudar();
					vista.panelMenu.estado.setText("JUGANDO");
				}
			}
		});

		vista.panelMenu.btnReiniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var estado = modelo.getEstado();

				if (estado != Juego.ESPERANDO) {
					modelo.reiniciar();
					limpiar(vista.panelMichi.matrizCasillas);
					vista.panelMenu.estado.setText("ESPERANDO");
				}
			}
		});

		vista.panelMenu.btnTerminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				var estado = modelo.getEstado();

				if (estado != Juego.ESPERANDO && estado != Juego.FINALIZADO) {
					modelo.terminar();
					vista.panelMenu.estado.setText("FINALIZADO");
				}
			}
		});

		// juego
		var casillas = vista.panelMichi.matrizCasillas;
		var cmichi = new CMichi();

		for (var arrCasillas : casillas) {
			for (var casilla : arrCasillas) {
				casilla.addActionListener(cmichi);
			}
		}
	}

	private void limpiar(JButton[][] casillas) {
		for (JButton[] filaCasillas : casillas) {
			for (JButton casilla : filaCasillas) {
				casilla.setText("");
			}
		}
	}

	private class CMichi implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
			var estadoDelJuego = modelo.getEstado();

			if (estadoDelJuego == Juego.JUGANDO) {
				var coordenadas = ((JButton) ae.getSource()).getName().split(":");
				var x = Integer.parseInt(coordenadas[0]);
				var y = Integer.parseInt(coordenadas[1]);
				var posible = modelo.marcarCasilla(new Point(x, y));

				if (posible == true) {
					var index = (modelo.getTurnos() - 1) % 2;
					var marca = String.valueOf(ModeloMichi.simbolos[index]);
					vista.panelMichi.matrizCasillas[x][y].setText(marca);

					if (!modelo.elJuegoContinua()) {
						var winner = modelo.getGanador();
						JOptionPane.showMessageDialog(vista,
								"Ganador: " + (winner == null ? "EMPATE" : winner.getNickname()));
						vista.panelMenu.estado.setText("FINALIZADO");
					}
				}
			}
		}
	}
}
