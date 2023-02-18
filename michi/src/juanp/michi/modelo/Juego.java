package juanp.michi.modelo;

public abstract class Juego {

	public static final int ESPERANDO = 1;
	public static final int JUGANDO = 2;
	public static final int DETENIDO = 3;
	public static final int FINALIZADO = 4;

	protected int estado;
	protected Jugador jugador1;
	protected Jugador jugador2;
	protected Jugador ganador;

	public Juego(String nombreJugador1, String nombreJugador2) {
		estado = ESPERANDO;
		jugador1 = new Jugador(nombreJugador1);
		jugador2 = new Jugador(nombreJugador2);
		ganador = null;
	}

	public void jugar() {
		estado = JUGANDO;
	}

	public void detener() {
		estado = DETENIDO;
	}

	public void reiniciar() {
		estado = ESPERANDO;
	}

	public void terminar() {
		estado = FINALIZADO;
	}

	public int getEstado() {
		return estado;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Jugador getGanador() {
		return ganador;
	}

	public void setGanador(Jugador ganador) {
		this.ganador = ganador;
	}
}
