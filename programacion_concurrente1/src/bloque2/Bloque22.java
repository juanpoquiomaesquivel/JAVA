package bloque2;

import java.util.Random;

// Paralelismo y concurrencia a la vez

public class Bloque22 extends Thread {

	private static int cont = 0;

	@Override
	public void run() {
		for (var i = 0; i < 1000; i++) {
			cont++;
		}
	}

	public static void main(String[] args) {
		var h1 = new Bloque22();
		var h2 = new Bloque22();
		var h3 = new Bloque22();
		var h4 = new Bloque22();

		h1.start();
		h2.start();
		h3.start();
		h4.start();

		try {
			h1.join();
			h2.join();
			h3.join();
			h4.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(cont);
	}
}

// https://www.youtube.com/watch?v=4ddpOH0oZNI&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=6