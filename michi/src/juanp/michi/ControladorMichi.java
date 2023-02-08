package juanp.michi;

import java.util.Scanner;

public class ControladorMichi {

	public static void jugar() {
		var scanner = new Scanner(System.in);
		var michi = new Michi();
		var turno = 0;
		int posx, posy;

		do {
			System.out.println("==============================================");
			System.out.println("Turno del jugador #" + (turno + 1) + "!");

			do {
				System.out.print("Ingrese la posición en el eje X elegida: ");
				posx = scanner.nextInt();
				System.out.print("Ingrese la posición en el eje Y elegida: ");
				posy = scanner.nextInt();
			} while (!michi.marcarCasilla(posx, posy));

			turno = (turno + 1) % 2;
			mostrarTablero(michi.getTablero());
			System.out.println("==============================================");
		} while (michi.elJuegoContinua());

		scanner.close();
		System.out.println("El ganador es: " + michi.getGanador());
	}

	private static void mostrarTablero(char[][] tablero) {
		System.out.println("--- TABLERO ---");
		for (var i = 0; i < 3; i++) {
			for (var j = 0; j < 3; j++) {
				System.out.print(tablero[i][j] + " ");
			}

			System.out.println();
		}
		System.out.println("--------------");
	}
}
