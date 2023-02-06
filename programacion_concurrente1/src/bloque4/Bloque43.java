package bloque4;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * En una carrera ciclistica con 100 participantes hay 3 etapas, antes de 
 * comenzar una etapa hay que esperar a que lleguen todos los participantes,
 * una vez que lleguen se dará la salida a la siguiente etapa.
 * El ganador de la prueba, será el que mejor tiempo haga en total y también 
 * se requiere saber el ganador de cada una de las etapas individuales.
 */
public class Bloque43 {

	public static void main(String[] args) {
		int participantes = 100;
		Carrera.setCarrera(participantes);
		Runtime rt = Runtime.getRuntime();
		int n = rt.availableProcessors();

		ExecutorService pool = Executors.newCachedThreadPool();

		for (var i = 0; i < participantes; i++) {
			var rn = new Carrera(i);
			pool.execute(rn);
		}

		pool.shutdown();
		while (!pool.isTerminated())
			;

		double[][] tiempos = Carrera.getTiempos();

		int idGanador = 0;
		double ganadorTiempo = tiempos[0][3];

		int idGanador1 = 0;
		double ganadorTiempo1 = tiempos[0][0];

		int idGanador2 = 0;
		double ganadorTiempo2 = tiempos[0][1];

		int idGanador3 = 0;
		double ganadorTiempo3 = tiempos[0][2];

		for (int i = 0; i < tiempos.length; i++) {
			if (tiempos[i][3] < ganadorTiempo) {
				ganadorTiempo = tiempos[i][3];
				idGanador = i;
			}
			if (tiempos[i][0] < ganadorTiempo1) {
				ganadorTiempo1 = tiempos[i][0];
				idGanador1 = i;
			}
			if (tiempos[i][1] < ganadorTiempo2) {
				ganadorTiempo2 = tiempos[i][1];
				idGanador2 = i;
			}
			if (tiempos[i][2] < ganadorTiempo3) {
				ganadorTiempo3 = tiempos[i][2];
				idGanador3 = i;
			}
		}

		System.out.println("El ganador es el hilo: " + idGanador);
		System.out.println("El ganador de la etapa 1 es: " + idGanador1);
		System.out.println("El ganador de la etapa 2 es: " + idGanador2);
		System.out.println("El ganador de la etapa 3 es: " + idGanador3);
	}
}

class Carrera implements Runnable {

	private int id;

	private double inicio, total;
	private Random ran = new Random(System.nanoTime());

	private static double[][] tiempos;
	private static CyclicBarrier barrera;

	public Carrera(int id) {
		this.id = id;
	}

	public static void setCarrera(int participantes) {
		tiempos = new double[participantes][4];
		barrera = new CyclicBarrier(participantes);
	}

	@Override
	public void run() {
		// Etapa 1
		etapa(0);
		etapa(1);
		etapa(2);
		tiempos[id][3] = tiempos[id][0] + tiempos[id][1] + tiempos[id][2];
	}

	public void etapa(int numEtapa) {
		inicio = System.nanoTime();
		try {
			Thread.sleep(ran.nextInt(100) + 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		total = System.nanoTime() - inicio;
		tiempos[id][numEtapa] = total;

		try {
			barrera.await();
			barrera.reset();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static double[][] getTiempos() {
		return tiempos;
	}
}

// https://www.youtube.com/watch?v=viXPI5p3Wx8&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=15