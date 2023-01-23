package programacion_concurrente1;

// Para lanzar hilos se hace desde objetos que heredan desde Thread
// .start() lanza los hilos
// los hilos no se tienen que ejecutar cuando se lanzan
// no sabemos el orden de ejecución de los hilos

public class LanzandoHilos extends Thread {
	
	private int id;
	
	public LanzandoHilos(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Soy el hilo: " + id);
	}

	public static void main(String[] args) {
		var h1 = new LanzandoHilos(1);
		var h2 = new LanzandoHilos(2);
		var h3 = new LanzandoHilos(3);
		
		h1.start(); // se crea un nuevo hilo
		h2.start();
		h3.start();
		
		System.out.println("Soy el hilo principal");
	}
}

// https://www.youtube.com/watch?v=dRCVPFe30WU&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=1
// https://www.youtube.com/watch?v=CkzG3ysYzFA&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=2
