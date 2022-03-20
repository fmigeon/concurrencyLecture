package h_introductionToExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable taskDeclaration;
		Callable computationDeclaration;
		Executor executor;
		ExecutorService service;
		
		service = Executors.newCachedThreadPool();
		service.submit(() -> {System.out.println("Execution of Runnable task from submit operation");});
		
		Future<String> resultingString = service.submit(() -> "Execution of Callable<String> computation which value is obtained by a Future");
		try {
			System.out.println(resultingString.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("\nExecution of a long Callable<String> computation...");
		Future<String> waitingResultingString = service.submit(() -> { Main.veryLongComputation(); return "...which value is obtained by a Future";});
		try {
			System.out.println(waitingResultingString.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nExecution of another medium-size Callable<String> computation...");
		Future<Long> simpleLongResult = service.submit(()-> fib(10));
		while(!simpleLongResult.isDone()) System.out.println("Waiting...");
		try {
			System.out.println("Result : "+simpleLongResult.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void veryLongComputation() {
		fib(43);
	}
	private static long fib(int n) {
		if (n < 2) return 1;
		else return fib(n-1)+fib(n-2);
	}

}
