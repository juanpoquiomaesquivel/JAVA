package bloque6;

import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Bloque62 {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		var n = rt.availableProcessors();
		int cont = 0;

		ExecutorService es = Executors.newFixedThreadPool(n);
		Vector<FutureTask<Integer>> vec = new Vector<>(); // tiene métodos más avanzados que Future
//ver RunnableFuture
		for (var i = 0; i < n; i++) {
			vec.add(new FutureTask<Integer>(new Hilo2()));
			es.execute(vec.get(i));
		}

		es.shutdown();

		for (var i = 0; i < n; i++) {
			FutureTask<Integer> future = vec.get(i);
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

class Hilo2 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int cont = 0;

		for (var i = 0; i < 100000; i++) {
			cont++;
		}
		return cont;
	}
}

// https://www.youtube.com/watch?v=ShfDrvemb9o&list=PLw8RQJQ8K1ySGcb3ZP66peK4Za0LKf728&index=22