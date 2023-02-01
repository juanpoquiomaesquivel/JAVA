package bloque3;

import java.util.Iterator;
import java.util.Random;

public class Bloque33 implements Runnable {
	
	private int id;
	private static Random cerrojoA = new Random();
	private static Thread cerrojoB = new Thread();
	
	private int cont_private = 0;
	private static int cont = 0;
	
	public Bloque33(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		// Interbloqueo
		/*if (id % 2 == 0) {
			synchronized(cerrojoA) { // Activo: h1 Cola: h0
				mostrarA();
			}
		} else {
			synchronized(cerrojoB) { // Activo: h0 Cola: h2 h1
				mostrarB();
			}
		}*/
		
		// Estrategia buffer
		for (var i = 0; i < 20000; i++) {
			cont_private++;
		}
		
		synchronized(cerrojoA) {
			cont += cont_private;
		}
	}
	
	private void mostrarA() {
		synchronized(cerrojoB) {
			System.out.println("Soy el hilo: " + id);
		}
	}
	
	private void mostrarB() {
		synchronized(cerrojoA) {
			System.out.println("Soy el hilo: " + id);
		}
	}

	public static void main(String[] args) {
		int n = Runtime.getRuntime().availableProcessors();
		Thread[] hilos = new Thread[n];
		
		for (int i = 0; i < hilos.length; i++) {
			var rn = new Bloque33(i);
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
		System.out.println(cont);
	}
}

// https://www.youtube.com/watch?v=v-Y2ctd0oJA&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=11