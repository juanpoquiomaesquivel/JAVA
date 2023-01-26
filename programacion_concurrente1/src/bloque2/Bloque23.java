package bloque2;

import java.util.Random;

// Multiplicar por 10 todos los elementos de una matriz de forma concurrente y medir el tiempo

public class Bloque23 extends Thread {

	private static int tam = 800;
	private static int[][] mat = new int[tam][tam];

	private int ini, fin;

	public Bloque23(int ini, int fin) {
		this.ini = ini;
		this.fin = fin;
	}

	@Override
	public void run() {
		for (var i = ini; i < fin; i++) {
			for (var j = 0; j < mat[0].length; j++) {
				mat[i][j] *= 10;
			}
		}
	}

	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());
		double tiempoInicio, tiempoFinal;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = rand.nextInt(10);
			}
		}

		tiempoInicio = System.nanoTime(); // hora en nanosegundos
		var h1 = new Bloque23(0, 400);
		var h2 = new Bloque23(400, 800);

		h1.start();
		h2.start();

		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tiempoFinal = System.nanoTime() - tiempoInicio; // 
		System.out.println("Tiempo: " + (tiempoFinal / 1000000) + " milisegundos");
				
		/*for (int[] val : mat) {
			for (int v : val) {
				System.out.print(v + ",");
			}
			System.out.println();
		}*/
	}
}

// https://www.youtube.com/watch?v=u0NMnFxNd-0&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=7