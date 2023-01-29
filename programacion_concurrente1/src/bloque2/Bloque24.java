package bloque2;

import java.util.Random;

public class Bloque24 extends Thread {
	private static int tam = 15;
	private static int[][] matriz = new int[tam][tam];

	private int inicio, fin;

	public Bloque24(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
	}

	public void run() {
		for (int i = inicio; i < fin; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] *= 10;
			}
		}
	}

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		int nucleos = rt.availableProcessors();

		// Iniciar matriz
		Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = rand.nextInt(10);
			}
		}

		Thread[] hilos = new Thread[nucleos];
		int rango = tam / nucleos;
		int start = 0;
		int finish = rango;

		for (var i = 0; i < nucleos; i++) {
			if (i != nucleos - 1) {
				hilos[i] = new Bloque24(start, finish);
				hilos[i].start();
				start = finish;
				finish += rango;
			} else {
				hilos[i] = new Bloque24(start, tam);
				hilos[i].start();
			}
		}

		for (var i = 0; i < nucleos; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Mostrar resultaod por pantalla
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}

// https://www.youtube.com/watch?v=BdoimCB0Bf4&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=8
