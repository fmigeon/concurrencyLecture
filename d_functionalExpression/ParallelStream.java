// author : Fred Migeon - IRIT - Université Toulouse 3
package d_functionalExpression;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

	public static void main(String[] args) {
		final int nbOfItems = 25;
		List<String> messagesList = new ArrayList<>(nbOfItems);

		for (int i = 0; i < nbOfItems; i++)
			messagesList.add("Hello R2D" + i);

		long startTime = System.currentTimeMillis();
		System.out.println("Sequentially :");
		messagesList.stream().forEach(System.out::println);
		long endTime = System.currentTimeMillis();
		double elapsedTime = (endTime - startTime);
		System.out.println("Execution time for sequential streaming : " + elapsedTime);

		startTime = System.currentTimeMillis();
		System.out.println("\nIn parallel :");
		messagesList.parallelStream().forEach(System.out::println);
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for parallel streaming : " + elapsedTime);

	}
}
