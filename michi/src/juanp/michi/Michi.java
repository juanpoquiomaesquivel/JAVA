package juanp.michi;

public class Michi {

	private char[][] tablero;

	public Michi() {
		this.tablero = new char[3][3];

		for (var i = 0; i < 3; i++) {
			for (var j = 0; j < 3; j++) {
				this.tablero[i][j] = '_';
			}
		}
	}

	public boolean marcarCasilla(char simbolo, int x, int y) {
		if (tablero[x][y] == '_') {
			tablero[x][y] = simbolo;

			return true;
		}

		return false;
	}

	public char hayGanador() {
		var e = tablero[0][0];

		if (e != '_') {
			if ((tablero[0][1] == e && tablero[0][2] == e) || (tablero[1][0] == e && tablero[2][0] == e)
					|| (tablero[1][1] == e && tablero[2][2] == e))
				return e;
		}

		e = tablero[1][1];

		if (e != '_') {
			if ((tablero[0][1] == e && tablero[2][1] == e) || (tablero[1][0] == e && tablero[1][2] == e)
					|| (tablero[0][2] == e && tablero[2][0] == e))
				return e;
		}

		e = tablero[2][2];

		if (e != '_') {
			if ((tablero[2][0] == e && tablero[2][1] == e) || (tablero[0][2] == e && tablero[1][2] == e))
				return e;
		}

		return '-';
	}

	public boolean seAcabo() {
		for (var E : tablero) {
			for (var e : E) {
				if (e == '_') {
					return false;
				}
			}
		}

		return true;
	}

	public char[][] getTablero() {
		return tablero;
	}
}
