package bloque4;

public class Bloque41 implements Runnable {
	
	private static Monitor41 mon = new Monitor41();
	private int id;
	
	public Bloque41(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int cont = mon.inc(20000);
		System.out.println(cont);
		mon.ordenar(id);
	}

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		int n = rt.availableProcessors();
		
		Thread[] hilos = new Thread[n];
		
		for (var i = 0; i < n; i++) {
			var rn = new Bloque41(i);
			hilos[i] = new Thread(rn);
			hilos[i].start();
		}
		
		for (var i = 0; i < n; i++) {
			try {
				hilos[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Monitor41 {
	private int order = 0;
	private int cont = 0;
	
	public synchronized int inc(int param) {
		for (var i = 0; i < param; i++) {
			cont++;
		}
		
		return cont;
	}
	
	/*
	 * Cada vez que se ejecuta un método "synchronized" ningún otro hilo puede
	 * acceder a otro método definido de la misma manera.
	 */
	
	/*public synchronized int getCont() {
		return cont;
	}*/
	
	public synchronized void ordenar(int id) {
		while (id != order) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Soy el hilo: " + id);
		order++;
		this.notifyAll();
	}
}

// https://www.youtube.com/watch?v=1lmNSi_AuYI&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=13