package h_introductionToExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	private static final int MEDIUM_WAITING_DURATION = 10;
	private static final int LONG_WAITING_DURATION = 45;
	public static void main(String[] args) {
		Runnable taskDeclaration;
		Callable<String> computationDeclaration;
		ExecutorService service;
		
		System.out.println("Preparation to submit a task");
		service = Executors.newCachedThreadPool();
		taskDeclaration = () -> System.out.println("Execution of Runnable task from submit operation\n");
		service.submit(taskDeclaration);
		System.out.println("Task submitted...");
		
		System.out.println("\nPreparation to submit a calculation");
		computationDeclaration = () -> "Execution of Callable<String> computation which value is obtained by a Future";
		Future<String> resultingString = service.submit(computationDeclaration);
		System.out.println("Calculation submitted...");
		try {
			System.out.println("Result requested...");
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
		Future<Long> simpleLongResult = service.submit(()-> fib(MEDIUM_WAITING_DURATION));
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
		fib(LONG_WAITING_DURATION);
	}
	private static long fib(int n) {
		if (n < 2) return 1;
		else return fib(n-1)+fib(n-2);
	}

}
