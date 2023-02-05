package bloque4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bloque42 implements Runnable {

	private static int tam = 20000;
	private static int[][] matriz = new int[tam][tam];
	private int fila;

	public Bloque42(int fila) {
		this.fila = fila;
	}

	@Override
	public void run() {
		for (var i = 0; i < tam; i++) {
			matriz[fila][i] *= 10;
		}
	}

	public static void main(String[] args) {
		var ran = new Random(System.nanoTime());
		double t_inicio, t_final;

		for (var i = 0; i < matriz.length; i++) {
			for (var j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = ran.nextInt(10);
			}
		}

		t_inicio = System.nanoTime(); // Hora en nanosegundos

		ExecutorService pool = Executors.newFixedThreadPool(8);
		// ExecutorService pool = Executors.newCachedThreadPool();
		// ExecutorService pool = Executors.newSingleThreadExecutor();

		for (int i = 0; i < tam; i++) {
			var rn = new Bloque42(i);
			pool.execute(rn);
		}

		pool.shutdown(); // parecido a un join()
		while (!pool.isTerminated())
			;

		/*
		 * Thread[] hilos = new Thread[tam];
		 * 
		 * for (var i = 0; i < hilos.length; i++) { var rn = new Bloque42(i); hilos[i] =
		 * new Thread(rn); hilos[i].start(); }
		 * 
		 * for (var i = 0; i < hilos.length; i++) { try { hilos[i].join(); } catch
		 * (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */

		t_final = System.nanoTime() - t_inicio;
		System.out.println((t_final / 1000000) + " milisegundos");

		/*
		 * for (int[] val : matriz) { for (int v : val) { System.out.print(v + ","); }
		 * System.out.println(); }
		 */
	}
}

// https://www.youtube.com/watch?v=rzh2Cj40HA8&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=14