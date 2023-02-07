package bloque5;

import java.util.Random;
import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bloque53 {

	public static void main(String[] args) {
		var rand = new Random(System.nanoTime());
		var vec = new Thread[30];

		for (int i = 0; i < vec.length; i++) {
			int orden = rand.nextInt(2);
			Runnable rn = new Buffer(orden, i);
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

class Buffer implements Runnable {
	private int orden, valor;

	private static Vector<Integer> elementos = new Vector();

	private static ReentrantLock lock = new ReentrantLock();
	private static Condition restar = lock.newCondition();
	private static Condition sumar = lock.newCondition();

	public Buffer(int orden, int valor) {
		this.orden = orden;
		this.valor = valor;
	}

	@Override
	public void run() {
		while (true) {
			lock.lock();

			// restar al vector un elemento
			if (orden == 0) {
				restarElemento();
			}
			// sumar al vector un elemento
			else {
				sumarElemento();
			}

			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}

			lock.unlock();
		}
	}

	private void restarElemento() {
		while (elementos.isEmpty()) {
			await(restar);
		}

		System.out.println("Se ha extraido el elemento: " + elementos.get(0));
		elementos.remove(0);

		sumar.signal();
		await(restar);
	}

	private void sumarElemento() {
		while (elementos.size() > 20) {
			await(sumar);
		}

		elementos.add(valor);
		System.out.println("Se ha añadido el elemento: " + elementos.lastElement());

		restar.signal();
		await(sumar);
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

// https://www.youtube.com/watch?v=jpDnzfvY0es&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=19