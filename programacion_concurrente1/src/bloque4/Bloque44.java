package bloque4;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Bloque44 implements Runnable {

	private int id;
	private static Buffer buf = new Buffer();

	public Bloque44(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (id == 0) {
			int elemento;
			while (true) {
				elemento = buf.leer();
				System.out.println("El elemento extraído del buffer es: " + elemento);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			while (true) {
				buf.escribir();

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		int n = rt.availableProcessors();

		ExecutorService poolLector = Executors.newFixedThreadPool(n);

		for (var i = 0; i < n; i++) {
			var rn = new Bloque44(0);
			poolLector.execute(rn);
		}

		poolLector.shutdown();

		ExecutorService poolEscritor = Executors.newFixedThreadPool(2);

		for (var i = 0; i < 2; i++) {
			var rn = new Bloque44(1);
			poolEscritor.execute(rn);
		}

		poolEscritor.shutdown();

		while (!poolLector.isTerminated())
			;
	}
}

class Buffer {

	private Random random = new Random(System.nanoTime());

	private int tam = 10;
	private int pos = -1; // vacio
	private Vector<Integer> cola = new Vector();

	public synchronized int leer() {
		int elemento = -1;

		while (pos < 0) {
			try {
				System.out.println("El vector está vacío y el consumidor se va a dormir.");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elemento = cola.get(pos);
		cola.remove(pos);
		pos--;

		return elemento;
	}

	public synchronized void escribir() { // los monitores tienen reentrancia
		pos++;

		if (pos >= tam) {
			System.out.println("El vector está lleno.");
			pos--;
		} else {
			cola.add(generar());
			notifyAll();
		}
	}

	public synchronized int generar() {
		return random.nextInt(10);
	}
}

// https://www.youtube.com/watch?v=a41xUjlp7HY&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=16