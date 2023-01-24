package bloque2;

import java.util.Random;

// Realizar la multiplicación de todos los elementos de un vector de enteros por 10.

public class Bloque21 extends Thread {

	private static int tam = 8;
	private static int[] vec = new int[tam];
	
	private int ini, fin;
	
	public Bloque21(int ini, int fin) {
		this.ini = ini;
		this.fin = fin;
	}
	
	@Override
	public void run() {
		for (var i = ini; i < fin; i++) {
			vec[i] *= 10;
		}
	}
	
	public static void main(String[] args) {
		Random rand = new Random(System.nanoTime());
		
		for (int i = 0; i < vec.length; i++) {
			vec[i] = rand.nextInt(10);
		}
		
		var h1 = new Bloque21(0, 4);
		var h2 = new Bloque21(4, 8);
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int val : vec) {
			System.out.print(val + " ");
		}
	}
}

// https://www.youtube.com/watch?v=_Xwrknlyxo4&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=5