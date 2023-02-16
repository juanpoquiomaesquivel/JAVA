package bloque6;

import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Bloque61 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		var n = rt.availableProcessors();
		int cont = 0;

		ExecutorService es = Executors.newFixedThreadPool(n);
		Vector<Future<Integer>> vec = new Vector<>();

		for (var i = 0; i < n; i++) {
			Future<Integer> future = es.submit(new Hilo());
			vec.add(future);
		}

		es.shutdown();

		for (var i = 0; i < n; i++) {
			Future<Integer> future = vec.get(i);
			try {
				cont += future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(cont);
	}
}

class Hilo implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int cont = 0;

		for (var i = 0; i < 100000; i++) {
			cont++;
		}
		return cont;
	}
}