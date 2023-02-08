package juanp.michi;

import java.awt.Point;

public class Michi {

	/**
	 * Matriz que contiene todas las soluciones del juego.
	 */
	private static final Point[][] soluciones = { { new Point(0, 0), new Point(0, 1), new Point(0, 2) },
			{ new Point(0, 0), new Point(1, 0), new Point(2, 0) },
			{ new Point(0, 0), new Point(1, 1), new Point(2, 2) },
			{ new Point(1, 1), new Point(0, 1), new Point(2, 1) },
			{ new Point(1, 1), new Point(1, 0), new Point(1, 2) },
			{ new Point(1, 1), new Point(0, 2), new Point(2, 0) },
			{ new Point(2, 2), new Point(2, 0), new Point(2, 1) },
			{ new Point(2, 2), new Point(0, 2), new Point(1, 2) } };

	/**
	 * Arreglo que contiene los símbolos a usar por los jugadores.
	 */
	public static final char[] simbolos = { 'x', 'o' };

	/**
	 * Matriz que contiene el resultado actual del juego.
	 */
	private char[][] tablero;

	/**
	 * Caracter que indica el símbolo utilizado por el jugador.
	 */
	private char ganador;

	/**
	 * Contador que indica el número de jugadas realizadas.
	 */
	private int turnos;

	/**
	 * Índice de la jugada que decidió al actual ganador.
	 */
	private int jugada;

	public Michi() {
		init();
	}

	/**
	 * 
	 * @param simbolo Símbolo que se marcará en la casilla indicada.
	 * @param x       Índice en la posición 'i' de la matriz.
	 * @param y       Índice en la posición 'j' de la matriz.
	 * @return Valor que indica la completitud de la acción.
	 */
	public boolean marcarCasilla(int x, int y) {
		if (tablero[x][y] == '_') {
			tablero[x][y] = simbolos[turnos % 2];
			turnos++;
			buscarGanador();

			return true;
		}

		return false;
	}

	/**
	 * Realiza la búsqueda del ganador al culminar la última jugada.
	 */
	private void buscarGanador() {
		for (var i = 0; i < soluciones.length; i++) {
			var arr = soluciones[i];
			var px = arr[0];
			var x = tablero[px.x][px.y];

			if (x == '_') {
				i += 2;
			} else {
				var py = arr[1];
				var pz = arr[2];
				var y = tablero[py.x][py.y];
				var z = tablero[pz.x][pz.y];

				if (x == y && y == z) {
					ganador = x;
					jugada = i;

					break;
				}
			}
		}
	}

	/**
	 * En primer lugar, calcula si ya se ha decidido un ganador. Por último,
	 * verifica si aún existen turnos disponibles por ocupar.
	 * 
	 * @return Valor que indica la continuidad del juego.
	 */
	public boolean elJuegoContinua() {
		return ganador == '-' && turnos < 9;
	}

	/**
	 * Método que devuelve la secuencia de puntos de la jugada ganadora.
	 * 
	 * @return
	 */
	public Point[] obtenerJugadaGanadora() {
		return (jugada == -1 ? null : soluciones[jugada]);
	}

	/**
	 * Método que reinicia el juego.
	 */
	public void reiniciarJuego() {
		init();
	}

	/**
	 * Método que inicializa el juego.
	 */
	private void init() {
		this.tablero = new char[][] { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
		this.ganador = '-';
		this.turnos = 0;
		this.jugada = -1;
	}

	public char[][] getTablero() {
		return tablero; // debería retornar una copia del array para evitar la modificación externa del
						// array (CORREGIR)
	}

	public char getGanador() {
		return ganador;
	}
}
