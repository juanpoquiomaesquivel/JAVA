package programacion_concurrente1;

public class LHilos2 extends Thread {

	private int id;

	public LHilos2(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Soy el hilo: " + id);
	}

	public static void main(String[] args) {
		var vec = new LHilos2[5];

		for (int i = 0; i < vec.length; i++) {
			vec[i] = new LHilos2(i + 1);
			vec[i].start();
		}

		try {
			for (LHilos2 h : vec)
				h.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Soy el hilo principal");
	}
}

// https://www.youtube.com/watch?v=J6DEk8sNlKQ&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=3
