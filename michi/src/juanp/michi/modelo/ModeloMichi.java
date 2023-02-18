package juanp.michi.modelo;

import java.awt.Point;

public class ModeloMichi extends Juego {

	private static final Point[][] soluciones = { { new Point(0, 0), new Point(0, 1), new Point(0, 2) },
			{ new Point(0, 0), new Point(1, 0), new Point(2, 0) },
			{ new Point(0, 0), new Point(1, 1), new Point(2, 2) },
			{ new Point(1, 1), new Point(0, 1), new Point(2, 1) },
			{ new Point(1, 1), new Point(1, 0), new Point(1, 2) },
			{ new Point(1, 1), new Point(0, 2), new Point(2, 0) },
			{ new Point(2, 2), new Point(2, 0), new Point(2, 1) },
			{ new Point(2, 2), new Point(0, 2), new Point(1, 2) } };
	public static final char[] simbolos = { 'x', 'o' };

	private char[][] tablero;
	private int turnos;
	private int jugadaGanadora;

	public ModeloMichi(String nombreJugador1, String nombreJugador2) {
		super(nombreJugador1, nombreJugador2);
		init();
	}

	@Override
	public void reiniciar() {
		super.reiniciar();
		init();
	}

	public boolean marcarCasilla(Point punto) {
		if (tablero[punto.x][punto.y] == '_') {
			tablero[punto.x][punto.y] = simbolos[turnos % 2];
			turnos++;
			buscarGanador();

			return true;
		}

		return false;
	}

	private void buscarGanador() {
		for (var i = 0; i < soluciones.length; i++) {
			var solucion = soluciones[i];
			var px = solucion[0];
			var x = tablero[px.x][px.y];

			if (x == '_') {
				i += 2;
			} else {
				var py = solucion[1];
				var pz = solucion[2];
				var y = tablero[py.x][py.y];
				var z = tablero[pz.x][pz.y];

				if (x == y && y == z) {
					var winner = (turnos - 1) % 2;
					ganador = (winner == 0 ? jugador1 : jugador2);
					jugadaGanadora = i;
					estado = FINALIZADO;

					break;
				}
			}
		}
	}

	public boolean elJuegoContinua() {
		return estado != FINALIZADO && turnos < 9;
	}

	public Point[] obtenerJugadaGanadora() {
		return (jugadaGanadora == -1 ? null : soluciones[jugadaGanadora]);
	}

	private void init() {
		tablero = new char[][] { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
		turnos = 0;
		jugadaGanadora = -1;
	}

	public char[][] getTablero() {
		return tablero.clone();
	}

	public int getTurnos() {
		return turnos;
	}
}
