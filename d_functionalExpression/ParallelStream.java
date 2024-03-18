// author : Fred Migeon - IRIT - Université Toulouse 3
package d_functionalExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStream {
	private static final int NB_OF_NAMES = 25;
	static final int NB_OF_INT = 250000;
	private static final int BOUND = 1000;

	public static void main(String[] args) {
		List<Integer> messagesList = new ArrayList<>(NB_OF_INT);
		Random rnd = new Random();

		for (int i = 0; i < NB_OF_INT; i++)
			messagesList.add(rnd.nextInt(BOUND));

		long startTime = System.currentTimeMillis();
		System.out.println("Sequentially :");
		int sum = messagesList.stream().filter(nb -> nb % 2 == 0).mapToInt(nb -> nb / 2).sum();
		long endTime = System.currentTimeMillis();
		double elapsedTime = (endTime - startTime);
		System.out.println("Execution time for sequential computation pipeline : sum = "+sum +" in "+elapsedTime);

		startTime = System.currentTimeMillis();
		System.out.println("\nIn parallel :");
		sum = messagesList.parallelStream().filter(nb -> nb % 2 == 0).mapToInt(nb -> nb / 2).sum();
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for parallel streaming : sum = "+sum +" in "+elapsedTime+"\n");
		
		startTime = System.currentTimeMillis();
		System.out.println("\nWith For-Each loops :");
		List<Integer> intermediate = new ArrayList<>(NB_OF_INT);
		for(int nb : messagesList)
			if (nb % 2 == 0) intermediate.add(nb);
		List<Integer> doubleList = new ArrayList<>(NB_OF_INT);
		for(int nb : intermediate)
			doubleList.add(nb/2);
		sum = 0;
		for (int nb : doubleList) sum+=nb;
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime);
		System.out.println("Execution time for loop : sum = "+sum +" in "+elapsedTime+"\n");
		

//		List<String> nameList = new ArrayList<>(NB_OF_NAMES);
//
//		for (int i = 0; i < NB_OF_NAMES; i++)
//			nameList.add("Hello R2D" + i);
//
//		startTime = System.currentTimeMillis();
//		System.out.println("Sequentially :");
//		nameList.stream().forEach(System.out::println);
//		endTime = System.currentTimeMillis();
//		elapsedTime = (endTime - startTime);
//		System.out.println("Execution time for sequential streaming : " + elapsedTime);
//
//		startTime = System.currentTimeMillis();
//		System.out.println("\nIn parallel :");
//		nameList.parallelStream().forEach(System.out::println);
//		endTime = System.currentTimeMillis();
//		elapsedTime = (endTime - startTime);
//		System.out.println("Execution time for parallel streaming : " + elapsedTime);

	}
}
