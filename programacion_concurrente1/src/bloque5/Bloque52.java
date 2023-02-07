package bloque5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Bloque52 {

	public static void main(String[] args) {
		var rt = Runtime.getRuntime();
		var n = rt.availableProcessors();

		// Synchronized
		Thread[] vec = new Thread[n];

		lanzarSynchro(vec);
		esperarHilos(vec);

		System.out.println(SynchroX.getCont());

		// Atomic
		vec = new Thread[n];

		lanzarAtomic(vec);
		esperarHilos(vec);

		System.out.println(AtomicX.getCont());

		// Reentrant
		vec = new Thread[n];

		lanzarReentrant(vec);
		esperarHilos(vec);

		System.out.println(Reentrant.getCont());
	}

	private static void lanzarSynchro(Thread[] vec) {
		for (int i = 0; i < vec.length; i++) {
			var run = new SynchroX();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}

	private static void lanzarAtomic(Thread[] vec) {
		for (var i = 0; i < vec.length; i++) {
			var run = new AtomicX();
			vec[i] = new Thread(run);
			vec[i].start();
		}
	}

	private static void lanzarReentrant(Thread[] vec) {
		for (var i = 0; i < vec.length; i++) {
			var run = new Reentrant();
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

class SynchroX implements Runnable {

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

class AtomicX implements Runnable {

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

class Reentrant implements Runnable { // es más complejo que un synchronized

	private static ReentrantLock cerrojo = new ReentrantLock();
	private static int cont = 0;
	private boolean condicion = false;

	@Override
	public void run() {
		cerrojo.lock();
		if (condicion)
			cerrojo.unlock();
		for (int i = 0; i < 100000; i++) {
			cont++;
		}
		cerrojo.unlock(); // nosotros decidimos donde acaba la seccion critica
	}

	public static int getCont() {
		return cont;
	}
}

// https://www.youtube.com/watch?v=_0lE5gCf5NM&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=18