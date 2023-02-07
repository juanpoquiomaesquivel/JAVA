package bloque5;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bloque54 {

	public static void main(String[] args) {
		var rand = new Random(System.nanoTime());
		var vec = new Thread[30];

		for (int i = 0; i < vec.length; i++) {
			int intencion = rand.nextInt(5);
			Avion avion = new Avion(i, intencion);

			Runnable rn = new Aeropuerto(avion);
			vec[i] = new Thread(rn);
			vec[i].start();
		}

		try {
			for (Thread t : vec) {
				t.join();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Avion {

	private int id;
	private int intencion; // intencion = 0; quiere despegar
	// intencion=1; esta volando
	// intencion != 0 o 1; esta aparcado
	// ultima intencion posible = 4

	public Avion(int id, int intencion) {
		this.id = id;
		this.intencion = intencion;
	}

	public int getIntencion() {
		return intencion;
	}

	public int getId() {
		return id;
	}

	public int nextIntencion() {
		intencion = ++intencion % 5;
		return intencion;
	}
}

class Aeropuerto implements Runnable {
	private Avion avion;
	private static int contDespegar = 0;

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition despegar = lock.newCondition();
	private static Condition aparcamiento = lock.newCondition();

	public Aeropuerto(Avion avion) {
		this.avion = avion;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int intencion = avion.getIntencion();

		while (true) {
			lock.lock();

			switch (intencion) {
			case 0:
				intencion = avion.nextIntencion();// intencion 1
				System.out.println("El avion " + avion.getId() + " está volando!");
				contDespegar--;
				despegar.signal();
				aparcamiento.signalAll();
				break;
			case 1:
				intencion = avion.nextIntencion();// intecion 2
				System.out.println("El avion " + avion.getId() + " va a aterrizar!");

				await(aparcamiento);
				break;
			case 4:
				intencion = avion.nextIntencion(); // intecion 0

				while (contDespegar >= 2) {
					await(aparcamiento);
					System.out
							.println("El avion " + avion.getId() + " ha intentado despegar pero está llena la cola!!");
				}

				System.out.println("El avion " + avion.getId() + " va a pasar a la cola de despegue!");
				contDespegar++;
				await(despegar);
				break;
			default:
				intencion = avion.nextIntencion(); // intecion 3 o 4
				System.out.println("El avion " + avion.getId() + " está en el parking!");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			lock.unlock();
		}
	}

	private void await(Condition condicion) {
		try {
			condicion.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

// https://www.youtube.com/watch?v=WGT_ETM740Q&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=20