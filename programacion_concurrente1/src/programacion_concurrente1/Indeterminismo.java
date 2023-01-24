package programacion_concurrente1;

// Indeterminismo
// Sección crítica

public class Indeterminismo extends Thread {

	private static int cont = 0;

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) { // cont = 1000 * 1000 = 1000000
			cont++; // el indeterminismo sucede cuando dos o más hilos están escribiendo sobre
					// la misma variable compartida
			// se solucioa con exclusión mutua
		}
	}

	public static void main(String[] args) {
		var vec = new Indeterminismo[1000];

		for (var i = 0; i < vec.length; i++) {
			vec[i] = new Indeterminismo();
			vec[i].start();
		}

		try {
			for (Indeterminismo h : vec)
				h.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(cont);
	}
}

// https://www.youtube.com/watch?v=8yD0hHAz3cs&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=4