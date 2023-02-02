package bloque3;

import java.util.Iterator;
import java.util.Random;

public class Bloque34 implements Runnable {
	
	private boolean consumidor;
	
	private static int tarta = 0;
	private static Object lock = new Object();
	
	public Bloque34(boolean consumidor) {
		this.consumidor = consumidor;
	}
	
	@Override
	public void run() {
		while (true) {
			if (consumidor) {
				consumiendo();
			} else {
				cocinando();
			}
		}
	}
	
	private void consumiendo() {
		synchronized(lock) {
			if (tarta > 0) {
				tarta--;
				System.out.println("Quedan " + tarta + " porciones de tarta.");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				lock.notifyAll();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void cocinando() {
		synchronized(lock) {
			if (tarta == 0) {
				tarta = 10;
				System.out.println("Soy el cocinero y quedan más tartas: " + tarta);
				lock.notifyAll();
			}
			try {
				lock.wait();
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		int n = 11;
		Thread[] hilos = new Thread[n];
		
		for (int i = 0; i < hilos.length; i++) {
			var rn = new Bloque34(i == 0);
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

// https://www.youtube.com/watch?v=v-Y2ctd0oJA&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=11