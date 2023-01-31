package bloque3;

import java.util.Random;

public class Bloque32 implements Runnable {
	
	private int id;
	private static Random cerrojo = new Random();
	private static int cont = 0;
	
	public Bloque32(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		synchronized(cerrojo) {
			while (id != cont) {
				try {
					cerrojo.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("Soy el hilo: " + id);
			cont++;
			cerrojo.notifyAll();
		}
	}

	public static void main(String[] args) {
		int n = Runtime.getRuntime().availableProcessors();
		Thread[] hilos = new Thread[n];
		
		for (int i = 0; i < hilos.length; i++) {
			var rn = new Bloque32(i);
			hilos[i] = new Thread(rn);
			hilos[i].start();
		}
		
		for (var i = 0; i < hilos.length; i++) {
			try {
				hilos[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Soy el hilo principal");
	}
}

// https://www.youtube.com/watch?v=2spoFK_9JEo&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=10