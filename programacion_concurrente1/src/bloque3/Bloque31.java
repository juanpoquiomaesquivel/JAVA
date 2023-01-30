package bloque3;

public class Bloque31 implements Runnable {
	
	private static int cont = 0;
	private static Object object = new Object(); // obligatoriamente estático

	@Override
	public void run() {
		synchronized(object) { // los hilos se ponen a la espera
			for (var i = 0; i < 20000; i++) {
				cont++;
			}
		}
	}
	
	public static void main(String[] args) {
		int n = Runtime.getRuntime().availableProcessors();
		Thread[] hilos = new Thread[n];
		
		for (int i = 0; i < hilos.length; i++) {
			var rn = new Bloque31();
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
		
		System.out.println(cont);
	}
}

// https://www.youtube.com/watch?v=0vVhMJQYxpc&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=9