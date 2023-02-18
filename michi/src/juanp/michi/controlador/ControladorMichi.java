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
		var nombreJugador1 = JOptionPane.showInputDialog("Jugador 1:");
		var nombreJugador2 = JOptionPane.showInputDialog("Jugador 2:");
		modelo.getJugador1().setNickname(nombreJugador1);
		modelo.getJugador2().setNickname(nombreJugador2);
	}

	public void init() {
		// menu
		vista.panelMenu.btnIniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				modelo.jugar();
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
						System.out.println("ENCONTRAMOS UN GANADOR: " + modelo.getGanador());
					}
				}
			}
		}
	}
}
