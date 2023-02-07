package bloque5;

import java.util.concurrent.atomic.AtomicInteger;

public class Bloque51 {

	public static void main(String[] args) {
		var rt = Runtime.getRuntime();
		var n = rt.availableProcessors();

		Thread[] vec = new Thread[n];

		lanzarSynchro(vec);
		esperarHilos(vec);

		System.out.println(Synchro.getCont());

		vec = new Thread[n];

		lanzarAtomic(vec);
		esperarHilos(vec);

		System.out.println(Atomic.getCont());
	}

	private static void lanzarSynchro(Thread[] vec) {
		for (int i = 0; i < vec.length; i++) {
			var run = new Synchro();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}

	private static void lanzarAtomic(Thread[] vec) {
		for (var i = 0; i < vec.length; i++) {
			var run = new Atomic();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}

	private static void esperarHilos(Thread[] vec) {
		try {
			for (int i = 0; i < vec.length; i++) {
				vec[i].join();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Synchro implements Runnable {

	private static int cont = 0;
	private static Object cerrojo = new Object();

	@Override
	public void run() {
		synchronized (cerrojo) {
			for (int i = 0; i < 100000; i++) {
				cont++;
			}
		}
	}

	public static int getCont() {
		return cont;
	}
}

class Atomic implements Runnable {

	private static AtomicInteger cont = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			cont.getAndIncrement();
		}
	}

	public static int getCont() {
		return cont.get();
	}
}

// https://www.youtube.com/watch?v=ZoTF5U-2GNA&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=17