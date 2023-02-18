package juanp.michi.modelo;

public class Jugador {

	private String nickname;

	public Jugador(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Jugador(nickname=" + nickname + ")";
	}
}
